package schulbuecher.isb.handreichung_10_2008.konzept_02.supermarkt.supermarkt_02;

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
}
