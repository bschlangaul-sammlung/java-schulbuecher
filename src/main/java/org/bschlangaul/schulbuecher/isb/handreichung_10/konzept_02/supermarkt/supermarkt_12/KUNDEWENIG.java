package org.bschlangaul.schulbuecher.isb.handreichung_10.konzept_02.supermarkt.supermarkt_12;

/**
 * Verwaltet einen Kunden.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class KUNDEWENIG extends KUNDE
{
    /**
     * Konstruktor des Kunden. Alle notwenigen Arbeiten werden vom
     * Oberklassenkonstruktor erledigt.
     *
     * @param artikel Anzahl der Artikel im Warenkorb
     */
    KUNDEWENIG(int artikel)
    {
        super(artikel);
    }

    /**
     * Entscheidet, an welche Schlange sich der Kunde anstellt. Hier ist die
     * Strategie: Schlange mit den insgesamt wenigsten Artikeln pre: es gibt
     * mindestens eine offene Kasse
     *
     * @param kassen Feld der im Markt vorhandenen Kassen
     */
    void Anstellen(KASSE[] kassen)
    {
        WARTESCHLANGE beste;
        WARTESCHLANGE w;
        beste = null;
        for (int i = 0; i < kassen.length; i++)
        {
            w = kassen[i].WarteschlangeHolen();
            if ((kassen[i].IstOffen())
                    && ((beste == null) || (w.ArtikelanzahlGesamtHolen() < beste
                            .ArtikelanzahlGesamtHolen())))
            {
                beste = w;
            }
        }
        beste.Anfuegen(this);
    }
}
