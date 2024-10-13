package org.bschlangaul.schulbuecher.isb.handreichung_10.konzept_02.supermarkt.supermarkt_03;

/**
 * Verwaltet einen Kunden.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class KUNDE
{
    KREIS darstellung;

    int artikelmenge;

    int groesse;

    /**
     * Konstruktor des Kunden. Setzt eine zufällige Farbe und die Größe gemäß
     * der Artikelanzahl
     *
     * @param artikel Anzahl der Artikel im Warenkorb
     */
    KUNDE(int artikel)
    {
        artikelmenge = artikel;
        groesse = 2 * artikelmenge + 2;
        darstellung = new KREIS();
        darstellung.PositionSetzen(200, 100);
        darstellung.FarbeSetzen("zufall");
        darstellung.GroesseSetzen(groesse);
    }

    /**
     * Setzt die Position des Kunden.
     *
     * @param x x-Position des Mittelpunkts
     * @param y y-Position des Mittelpunkts
     */
    void PositionSetzen(int x, int y)
    {
        darstellung.PositionSetzen(x - groesse / 2, y - groesse / 2);
    }
}
