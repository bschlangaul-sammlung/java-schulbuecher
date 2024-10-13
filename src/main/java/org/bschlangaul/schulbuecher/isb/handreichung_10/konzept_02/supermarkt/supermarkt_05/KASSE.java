package org.bschlangaul.schulbuecher.isb.handreichung_10.konzept_02.supermarkt.supermarkt_05;

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

    int x;

    int y;

    Zustaende zustand;

    /**
     * Baut die Kasse auf und trägt as zugehörige Darstellungssymbol ein.
     */
    KASSE()
    {
        darstellung = new RECHTECK();
        kunde = null;
        x = 400;
        y = 150;
        darstellung.PositionSetzen(x, y);
        darstellung.GroesseSetzen(100, 50);
        darstellung.FarbeSetzen("gruen");
        zustand = Zustaende.offen;
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
            // Wenn die Warteschange leer ist, dann
            zustand = Zustaende.geschlossen;
            darstellung.FarbeSetzen("rot");
            // sonst hole den nchsten Kunden
        }
        else
        {
            if (zustand == Zustaende.offen)
            {
                // Hole den nchsten Kunden
            }
        }
    }
}
