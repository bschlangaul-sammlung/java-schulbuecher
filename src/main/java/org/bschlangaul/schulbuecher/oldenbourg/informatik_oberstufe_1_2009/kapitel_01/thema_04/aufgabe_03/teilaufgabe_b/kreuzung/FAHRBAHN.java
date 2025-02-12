package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_04.aufgabe_03.teilaufgabe_b.kreuzung;

/**
 * Verwaltet die Fahrzeuge auf einer Fahrbahn.
 *
 * @author Ali Chwarizmi, Heidrun Namweiden
 *
 * @version V1.0
 */
class FAHRBAHN
{
    private int x;

    private int y;

    private float start;

    private float end;

    private float rand;

    private char ausrichtung;

    private LISTE liste;

    private FAHRBAHNSYMBOL darstellung;

    private AMPEL ampel;

    /**
     * Erzeugt eine leere FAHRBAHN ab dem linken Rand unterhalb der
     * Fenstermitte.
     *
     * @param a für diese Richtung zuständige Ampel
     */
    FAHRBAHN(AMPEL a)
    {
        x = 0;
        y = 0;
        ausrichtung = 'O';
        ampel = a;
        liste = new LISTE();
        darstellung = new FAHRBAHNSYMBOL();
        darstellung.PositionSetzen(x, y);
        darstellung.AusrichtungSetzen(ausrichtung);
        start = darstellung.EintrittsPositionGeben();
        end = darstellung.AustrittsPositionGeben();
        rand = darstellung.RandAbstandGeben();
    }

    /**
     * Reiht ein neues Fahrzeug an der Startposition in die Fahrbahn ein. Das
     * Fahrzeug wird nicht eingereiht, wenn kein Platz vorhanden ist.
     *
     * @param f das neue Fahrzeug
     */
    void FahrzeugEinreihen(FAHRZEUG f)
    {
        liste.HintenEinfuegen(f);
        f.AusrichtungSetzen(ausrichtung);
        if ((ausrichtung == 'O') || (ausrichtung == 'W'))
        {
            f.PositionSetzen(start, rand);
        }
        else
        {
            f.PositionSetzen(rand, start);
        }
    }

    /**
     * Ermittelt, ob ein Fahrzeug entfernt werden muss
     *
     * @param f das in Frage kommende Fahrzeug
     */
    private boolean IstDraussen(FAHRZEUG f)
    {
        switch (ausrichtung)
        {
        case 'O':
            return f.XKoordinateGeben() > end;

        case 'W':
            return f.XKoordinateGeben() < end;

        case 'N':
            return f.YKoordinateGeben() < end;

        case 'S':
            return f.YKoordinateGeben() > end;

        default:
            return false;
        }
    }

    /**
     * Ermittelt, ob das Fahrzeug sich nach dem Vorgänger richten oder die Ampel
     * beachten muss.
     *
     * @return true, wenn der Vorgänger wichtig ist, false, wenn die Ampel zählt
     */
    private boolean VorgaengerZaehlt(float ampelabstand,
            float vorgaengerabstand, FAHRZEUG f)
    {
        return (ampelabstand < 0.0f) || (ampelabstand > vorgaengerabstand)
                || ampel.IstGruen()
                || ampel.IstGelb()
                        && (ampelabstand < f.GeschwindigkeitGeben() * 1.8f)
                        && (3.0f < f.GeschwindigkeitGeben());
    }

    /**
     * Bewegt alle Fahrzeuge der Fahrbahn für eine Sekunde.
     */
    void FahrzeugeBewegen()
    {
        float vvorg;
        float wegmax;
        float ampelAbstand;
        FAHRZEUG fahrzeug, vorgaenger, anfang;
        LISTENELEMENT k;
        k = liste.AnfangGeben();
        fahrzeug = null;
        if (k != null)
        {
            fahrzeug = (FAHRZEUG) k.DatenelementGeben();
        }
        anfang = fahrzeug;
        vorgaenger = null;
        while (fahrzeug != null)
        {
            if (fahrzeug == anfang)
            {
                wegmax = 100000;
                vvorg = 100;
            }
            else
            {
                vvorg = vorgaenger.GeschwindigkeitGeben();
                switch (ausrichtung)
                {
                case 'O':
                    wegmax = vorgaenger.XKoordinateGeben()
                            - fahrzeug.XKoordinateGeben()
                            - fahrzeug.LaengeGeben() - vvorg * 1.8f;
                    break;

                case 'W':
                    wegmax = fahrzeug.XKoordinateGeben()
                            - vorgaenger.XKoordinateGeben()
                            - vorgaenger.LaengeGeben() - vvorg * 1.8f;
                    break;

                case 'N':
                    wegmax = fahrzeug.YKoordinateGeben()
                            - vorgaenger.YKoordinateGeben()
                            - vorgaenger.LaengeGeben() - vvorg * 1.8f;
                    break;

                case 'S':
                    wegmax = vorgaenger.YKoordinateGeben()
                            - fahrzeug.YKoordinateGeben()
                            - fahrzeug.LaengeGeben() - vvorg * 1.8f;
                    break;

                default:
                    wegmax = 100000;
                }
            }
            switch (ausrichtung)
            {
            case 'O':
                ampelAbstand = darstellung.HaltelinienPositionGeben()
                        - fahrzeug.XKoordinateGeben() - fahrzeug.LaengeGeben();
                break;

            case 'W':
                ampelAbstand = fahrzeug.XKoordinateGeben()
                        - darstellung.HaltelinienPositionGeben();
                break;

            case 'N':
                ampelAbstand = fahrzeug.YKoordinateGeben()
                        - darstellung.HaltelinienPositionGeben();
                break;

            case 'S':
                ampelAbstand = darstellung.HaltelinienPositionGeben()
                        - fahrzeug.YKoordinateGeben() - fahrzeug.LaengeGeben();
                break;

            default:
                ampelAbstand = 100000;
            }
            if (VorgaengerZaehlt(ampelAbstand, wegmax, fahrzeug))
            {
                fahrzeug.Fahren(wegmax, vvorg);
            }
            else
            {
                fahrzeug.Fahren(ampelAbstand, 0.0f);
            }
            vorgaenger = fahrzeug;
            k = k.NachfolgerGeben();
            if (k != null)
            {
                fahrzeug = (FAHRZEUG) k.DatenelementGeben();
            }
            else
            {
                fahrzeug = null;
            }
        }
        if ((anfang != null) && IstDraussen(anfang))
        {
            anfang.Entfernen();
        }
    }

    /**
     * Setzt die Position der Fahrbahn.
     *
     * @param x x-Position
     * @param y y-Position
     */
    void PositionSetzen(int x, int y)
    {
        this.x = x;
        this.y = y;
        darstellung.PositionSetzen(x, y);
        rand = darstellung.RandAbstandGeben();
    }

    /**
     * Setzt die Ausrichtung des Fahrzeugs.
     *
     * @param ausrichtung neue Ausrichtung
     */
    void AusrichtungSetzen(char ausrichtung)
    {
        this.ausrichtung = ausrichtung;
        darstellung.AusrichtungSetzen(ausrichtung);
        start = darstellung.EintrittsPositionGeben();
        end = darstellung.AustrittsPositionGeben();
        rand = darstellung.RandAbstandGeben();
    }
}
