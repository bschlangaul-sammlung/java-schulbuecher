package org.bschlangaul.schulbuecher.isb.handreichung_10.konzept_02.supermarkt.supermarkt_09;

/**
 * Kontrolle des Supermarkts.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class SUPERMARKT
{
    KASSE[] kassen;

    /**
     * Legt die Kassen und ihre Warteschlangen an.
     */
    SUPERMARKT()
    {
        kassen = new KASSE[3];
        for (int i = 0; i < kassen.length; i++)
        {
            WARTESCHLANGE schlange = new WARTESCHLANGE();
            schlange.PositionSetzen(375, 75 + i * 100);
            kassen[i] = new KASSE(schlange);
            kassen[i].PositionSetzen(400, 50 + i * 100);
        }
    }

    /**
     * Erzeugt einen neuen Kunden und lässt ihn anstellen
     */
    void KundeErzeugen()
    {
        KUNDE k = new KUNDE(7);
        k.Anstellen(kassen);
    }
}
