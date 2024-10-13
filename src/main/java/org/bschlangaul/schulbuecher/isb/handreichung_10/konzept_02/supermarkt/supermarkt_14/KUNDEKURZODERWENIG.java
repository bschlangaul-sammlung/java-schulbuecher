package org.bschlangaul.schulbuecher.isb.handreichung_10.konzept_02.supermarkt.supermarkt_14;

/**
 * Verwaltet einen Kunden, der sich an der krzesten Schlange anstellt.
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
import java.util.Random;

class KUNDEKURZODERWENIG extends KUNDE
{
    private Random zufall;

    /**
     * Konstruktor des Kunden. Setzt eine zufällige Farbe und die Größe gemäß
     * der Artikelanzahl
     */
    KUNDEKURZODERWENIG(int artikel)
    {
        super(artikel);
        zufall = new Random();
    }

    /**
     * Entscheidet, an welche Schlange sich der Kunde anstellt. Hier ist die
     * Strategie: krzeste Schlange pre: es gibt mindestens eine offene Kasse
     *
     * @param kassen Feld der im Markt vorhandenen Kassen
     */
    void Anstellen(KASSE[] kassen)
    {
        WARTESCHLANGE beste;
        WARTESCHLANGE w;
        beste = null;
        if (zufall.nextFloat() < 0.5f)
        {
            for (int i = 0; i < kassen.length; i++)
            {
                w = kassen[i].WarteschlangeHolen();
                if ((kassen[i].IstOffen()) && ((beste == null)
                        || (w.LaengeHolen() < beste.LaengeHolen())))
                {
                    beste = w;
                }
            }
        }
        else
        {
            for (int i = 0; i < kassen.length; i++)
            {
                w = kassen[i].WarteschlangeHolen();
                if ((kassen[i].IstOffen()) && ((beste == null)
                        || (w.ArtikelanzahlGesamtHolen() < beste
                                .ArtikelanzahlGesamtHolen())))
                {
                    beste = w;
                }
            }
        }
        beste.Anfuegen(this);
    }
}
