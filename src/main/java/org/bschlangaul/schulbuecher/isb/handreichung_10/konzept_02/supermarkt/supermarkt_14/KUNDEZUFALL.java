package org.bschlangaul.schulbuecher.isb.handreichung_10.konzept_02.supermarkt.supermarkt_14;

/**
 * Verwaltet einen Kunden, der sich zufllig anstellt.
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
import java.util.Random;

class KUNDEZUFALL extends KUNDE
{
    private Random zufall;

    /**
     * Konstruktor des Kunden. Setzt eine zufällige Farbe und die Größe gemäß
     * der Artikelanzahl
     */
    KUNDEZUFALL(int artikel)
    {
        super(artikel);
        zufall = new Random();
    }

    /**
     * Entscheidet, an welche Schlange sich der Kunde anstellt. Hier ist die
     * Strategie: zufllige Schlange pre: es gibt mindestens eine offene Kasse
     *
     * @param kassen Feld der im Markt vorhandenen Kassen
     */
    void Anstellen(KASSE[] kassen)
    {
        int anzahl, nummer;
        anzahl = 0;
        for (int i = 0; i < kassen.length; i++)
        {
            if (kassen[i].IstOffen())
            {
                anzahl = anzahl + 1;
            }
        }
        nummer = zufall.nextInt(anzahl);
        for (int i = 0; i < kassen.length; i++)
        {
            if (kassen[i].IstOffen())
            {
                if (nummer == 0)
                {
                    (kassen[i].WarteschlangeHolen()).Anfuegen(this);
                    return;
                }
                else
                {
                    nummer = nummer - 1;
                }
            }
        }
    }
}
