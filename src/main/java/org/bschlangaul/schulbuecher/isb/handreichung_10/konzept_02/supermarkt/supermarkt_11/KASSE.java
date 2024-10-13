package org.bschlangaul.schulbuecher.isb.handreichung_10.konzept_02.supermarkt.supermarkt_11;

/**
 * Kasse des Supermarkts.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class KASSE
{
    enum Zustaende
    {
        offen, schliessend, geschlossen
    };

    RECHTECK darstellung;

    KUNDE kunde;

    WARTESCHLANGE warteschlange;

    int x;

    int y;

    Zustaende zustand;

    int wartezeit;

    /**
     * Baut die Kasse auf und trägt as zugehörige Darstellungssymbol ein.
     */
    KASSE(WARTESCHLANGE w)
    {
        darstellung = new RECHTECK();
        kunde = null;
        x = 400;
        y = 150;
        darstellung.PositionSetzen(x, y);
        darstellung.GroesseSetzen(100, 50);
        darstellung.FarbeSetzen("gruen");
        zustand = Zustaende.offen;
        warteschlange = w;
        wartezeit = 0;
    }

    /**
     * Setzt die Position der Kasse.
     *
     * @param xNeu x-Position
     * @param yNeu y-Position
     */
    void PositionSetzen(int xNeu, int yNeu)
    {
        x = xNeu;
        y = yNeu;
        darstellung.PositionSetzen(x, y);
        if (kunde != null)
        {
            kunde.PositionSetzen(x + 50, y + 25);
        }
    }

    /**
     * Setzt einen Kunden zur Bedienung
     *
     * @param k der zu bedienende Kunde
     */
    void KundeSetzen(KUNDE k)
    {
        if (kunde != null)
        {
            kunde.Entfernen();
        }
        kunde = k;
        if (kunde != null)
        {
            kunde.PositionSetzen(x + 50, y + 25);
        }
    }

    /**
     * öffnet die Kasse.
     */
    void OffenSetzen()
    {
        zustand = Zustaende.offen;
        darstellung.FarbeSetzen("gruen");
    }

    /**
     * Bereitet das Schließen der Kasse vor.
     */
    void SchliessendSetzen()
    {
        zustand = Zustaende.schliessend;
        darstellung.FarbeSetzen("gelb");
    }

    /**
     * Wird aufgerufen, wenn der aktuelle Kunde bedient ist.
     */
    void BedienvorgangAbschliessen()
    {
        if (zustand == Zustaende.schliessend)
        {
            if (warteschlange.IstKundeVorhanden())
            {
                KundeSetzen(warteschlange.KundeUebergeben());
            }
            else
            {
                zustand = Zustaende.geschlossen;
                darstellung.FarbeSetzen("rot");
                if (kunde != null)
                {
                    kunde.Entfernen();
                }
            }
        }
        else
        {
            if (zustand == Zustaende.offen)
            {
                KundeSetzen(warteschlange.KundeUebergeben());
            }
        }
    }

    /**
     * Meldet, ob die Kasse offen ist
     *
     * @return wahr, wenn die Kasse offen ist
     */
    boolean IstOffen()
    {
        return zustand == Zustaende.offen;
    }

    /**
     * Gibt die zu dieser Kasse gehörende arteschlange zurück
     *
     * @return Warteschlange
     */
    WARTESCHLANGE WarteschlangeHolen()
    {
        return warteschlange;
    }

    /**
     * Empfngt die Impulse des Taktgebers.
     */
    void TaktImpulsAusfuehren()
    {
        if (wartezeit == 0)
        {
            BedienvorgangAbschliessen();
            if (kunde == null)
            {
                wartezeit = 0;
            }
            else
            {
                wartezeit = 70 + kunde.ArtikelAnzahlHolen() * 10;
            }
        }
        else
        {
            wartezeit = wartezeit - 1;
        }
    }
}
