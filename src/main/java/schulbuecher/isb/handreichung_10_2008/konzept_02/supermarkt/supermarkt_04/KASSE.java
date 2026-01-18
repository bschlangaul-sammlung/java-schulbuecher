package schulbuecher.isb.handreichung_10_2008.konzept_02.supermarkt.supermarkt_04;

/**
 * Kasse des Supermarkts.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class KASSE
{
    RECHTECK darstellung;

    KUNDE kunde;

    int x;

    int y;

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
}
