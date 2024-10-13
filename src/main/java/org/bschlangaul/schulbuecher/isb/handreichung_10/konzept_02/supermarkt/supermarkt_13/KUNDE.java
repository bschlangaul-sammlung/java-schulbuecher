package org.bschlangaul.schulbuecher.isb.handreichung_10.konzept_02.supermarkt.supermarkt_13;

/**
 * Verwaltet einen Kunden.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
abstract class KUNDE
{
    protected KREIS darstellung;

    protected int artikelmenge;

    protected int groesse;

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

    /**
     * Entfernt die Figur aus der Anzeige
     */
    void Entfernen()
    {
        darstellung.Entfernen();
    }

    /**
     * Entscheidet, an welche Schlange sich der Kunde anstellt. Hier ist die
     * Strategie: noch nicht implementiert pre: es gibt mindestens eine offene
     * Kasse
     *
     * @param kassen Feld der im Markt vorhandenen Kassen
     */
    abstract void Anstellen(KASSE[] kassen);

    /**
     * Gibt die artikelanzahl des Kunden
     *
     * @return Artikelanzahl
     */
    int ArtikelAnzahlHolen()
    {
        return artikelmenge;
    }
}
