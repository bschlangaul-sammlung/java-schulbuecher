package org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_04.modell;

import java.util.Random;

/**
 * Generiert zufällige Bezeichner vom Typ String gegebener Länge.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class GENERATOR
{
    /**
     * Der Zufallsgenerator
     */
    private Random zufall;

    /**
     * Der Zeichenvorrat für die Bezeichner
     */
    private char[] zeichen = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j' };

    /**
     * Die Länge der zu generierenden Bezeichner
     */
    private int laenge;

    /**
     * Initialisiert den Zufallsgenerattor.
     *
     * @param laenge Die Länge der zu generierenden Bezeichner
     */
    public GENERATOR(int laenge)
    {
        zufall = new Random();
        this.laenge = laenge;
    }

    /**
     * erzeugt einen neuen Bezeichner.
     *
     * @return der neue Bezeichner
     */
    public String BezeichnerGenerieren()
    {
        String resultat;
        resultat = "";
        for (int i = 1; i <= laenge; i++)
        {
            resultat = resultat + zeichen[zufall.nextInt(zeichen.length)];
        }
        return resultat;
    }
}
