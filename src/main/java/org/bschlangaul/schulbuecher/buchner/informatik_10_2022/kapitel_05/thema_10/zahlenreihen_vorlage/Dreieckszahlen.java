package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_10.zahlenreihen_vorlage;

/**
 * Projekt 5-10_Zahlenreihen (ÜuV Aufgabe 22)
 *
 * @author Julia Kronawitter
 *
 * @version 2022-09-12
 */
public class Dreieckszahlen extends Zahlenreihe
{
    public Dreieckszahlen(int laenge)
    {
        super(laenge);
        dreiecksfolge();
    }

    public void dreiecksfolge()
    {
        zahlenfolge[0] = 1;
        int i = 1;
        while (i < zahlenfolge.length)
        {
            zahlenfolge[i] = zahlenfolge[i - 1] + (i + 1);
            i++;
        }
    }

    public int berechneDreieckszahl(int n)
    {
        return -1;
    }
}
