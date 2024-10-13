package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_12.snake;

/**
 * Klasse zur Verwaltung der Snake-Schlange Am Kopf des Snake-Objekts werden
 * Objekte eingefügt; er entspricht deshalb dem Ende einer Warteschlange!
 *
 * @author Klaus van Dijkstran
 *
 * @version 1.0
 */
class SNAKE
{
    /** Referenz auf Warteschlange */
    private LISTE l;

    /** momentane Ausrichtung ('O';'W';'N';'S') der Snake */
    private char ausrichtung;

    /** Referenz auf das Spiel-Objekt */
    private SPIEL spiel;

    /** Referenz auf den Kopf */
    private ZELLE kopf;

    /**
     * Konstruktor für das Objekt der Klasse SNAKE. Schlange schaut zu Beginn
     * nach Osten und besteht aus drei Zellen.
     *
     */
    SNAKE(SPIEL s)
    {
        l = new LISTE();
        spiel = s;
        ZELLE zelle1, zelle2, zelle3;
        ausrichtung = 'O';
        zelle3 = new ZELLE(2, 0);
        l.VorneEinfuegen(zelle3);
        zelle3.FeldBelegen(spiel);
        zelle2 = new ZELLE(3, 0);
        l.VorneEinfuegen(zelle2);
        zelle2.FeldBelegen(spiel);
        zelle1 = new ZELLE(4, 0);
        l.VorneEinfuegen(zelle1);
        zelle1.FeldBelegen(spiel);
        kopf = zelle1;
    }

    /**
     * Methode zum Einfügen einer Zelle. Achtung: Der Anfang (im Sinne der
     * Warteschlange) entspricht dem Schwanz der Schlange und umgekehrt. Legt
     * das neue Ende fest und informiert das bisherige Ende darüber. Das Spiel
     * muss informiert werden, dass das Feld nicht mehr belegt ist.
     *
     * @param z einzufügende Zelle am Ende der Datenstruktur (entspricht dem
     *     Kopf der Schlange!).
     */
    void Einfuegen(ZELLE z)
    {
        l.VorneEinfuegen(z);
        z.FeldBelegen(spiel);
        kopf = z;
    }

    /**
     * Methode zum Entfernen einer Zelle. Achtung: Der Anfang (im Sinne der
     * Warteschlange) entspricht dem Schwanz der Schlange und umgekehrt. Fordert
     * die anfang-Zelle auf, ihr Feld beim Spiel freizugeben. Setzt den Anfang
     * auf den bisherigen Nachfolger des Anfangs.
     */
    void Entfernen()
    {
        DATENELEMENT anfang;
        anfang = l.EndeEntfernen();
        ZELLE z;
        z = (ZELLE) anfang;
        if (z != null)
        {
            z.FeldFreigeben();
        }
    }

    /**
     * Bewegt Schlange um einen Schritt nach vorne. Holt sich dazu die
     * Koordinaten des Kopfes (Ende!) Wenn auf der Nachbarzelle des Kopfes
     * (Ende!) ein Futter liegt, wir dieses gefressen (d.h. der Anfang
     * (Schwanz!) nicht entfernt), die Schlange wird um ein Glied länger.
     * Ansonsten wird der Schwanz entfernt. Die Nachbarzelle wird eingefügt.
     */
    void SchrittVor()
    {
        int xkopf, ykopf;
        xkopf = kopf.XGeben();
        ykopf = kopf.YGeben();
        int xneu, yneu;
        xneu = spiel.Nachbarzelle_XBerechnen(xkopf, ausrichtung);
        yneu = spiel.Nachbarzelle_YBerechnen(ykopf, ausrichtung);
        if (l.Suchen(xneu + "," + yneu) != null || spiel.IstAuto(xneu, yneu))
        {
            spiel.BeendetSetzen(true);
        }
        if (spiel.IstMaus(xneu, yneu))
        {
            spiel.MausFressen();
        }
        else
        {
            Entfernen();
        }
        Einfuegen(new ZELLE(xneu, yneu));
        WennMoeglichZuschnappen();
    }

    /**
     * Methode zur Richtungsänderung Je nach momentaner Ausrichtung
     * ('O';'W';'N';'S') und änderungsrichtung ('l';'r') wird die neue Richtung
     * ermittelt.
     *
     * @param richtung änderungsrichtung ('l';'r')
     */
    void RichtungAendern(char richtung)
    {
        if (richtung == 'l')
        {
            switch (ausrichtung)
            {
            case 'O':
                ausrichtung = 'N';
                break;

            case 'N':
                ausrichtung = 'W';
                break;

            case 'W':
                ausrichtung = 'S';
                break;

            default:
                ausrichtung = 'O';
            }
        }
        else
        {
            switch (ausrichtung)
            {
            case 'O':
                ausrichtung = 'S';
                break;

            case 'S':
                ausrichtung = 'W';
                break;

            case 'W':
                ausrichtung = 'N';
                break;

            default:
                ausrichtung = 'O';
            }
        }
    }

    /**
     * Sucht eine bestimmte Zelle in der Liste
     *
     * @param s Schlüssel
     *
     * @return gesuchtes Datenelement
     */
    DATENELEMENT Suchen(String s)
    {
        return l.Suchen(s);
    }

    /**
     * Fressen einer Maus
     */
    void MausFressen()
    {
        ZELLE z;
        z = new ZELLE(spiel.Nachbarzelle_XBerechnen(kopf.XGeben(), ausrichtung),
                spiel.Nachbarzelle_YBerechnen(kopf.YGeben(), ausrichtung));
        Einfuegen(z);
    }

    /**
     * Entfernt das Ende der Schlange ab den in der Form "x,y" übergebenen
     * Koordinaten.
     */
    void RestEntfernen(String koordinaten)
    {
        l.KnotenAbHierEntfernen(koordinaten);
    }

    /**
     * Frisst eine Maus im Feld voraus.
     */
    void WennMoeglichZuschnappen()
    {
        int xkopf, ykopf;
        xkopf = kopf.XGeben();
        ykopf = kopf.YGeben();
        int xneu, yneu;
        xneu = spiel.Nachbarzelle_XBerechnen(xkopf, ausrichtung);
        yneu = spiel.Nachbarzelle_YBerechnen(ykopf, ausrichtung);
        if (spiel.IstMaus(xneu, yneu))
        {
            spiel.MausFressen();
            spiel.FeldBelegen(xneu, yneu, 's');
        }
    }

    /**
     * Gibt an, ob der Kopf der Schlange gefunden ist
     *
     * @param x x-Koordinate
     * @param y y-Koordinate
     *
     * @return Wahrheitswert
     */
    boolean IstAnfang(int x, int y)
    {
        return ((kopf.XGeben() == x) && (kopf.YGeben() == y));
    }
}
