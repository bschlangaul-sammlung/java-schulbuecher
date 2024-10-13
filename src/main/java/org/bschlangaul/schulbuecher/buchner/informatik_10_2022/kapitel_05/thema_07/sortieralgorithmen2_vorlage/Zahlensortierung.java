package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_07.sortieralgorithmen2_vorlage;

/**
 * Projekt 5-7_Sortieralgorithmen2
 *
 * @author Julia Kronawitter
 *
 * @version 2022-09-12
 */
public class Zahlensortierung
{
    private int[] zahlen;

    public Zahlensortierung()
    {
        zahlen = new int[7];
        zahlen[0] = 3;
        zahlen[1] = 7;
        zahlen[2] = 1;
        zahlen[3] = 0;
        zahlen[4] = 30;
        zahlen[5] = 5;
        zahlen[6] = 4;
    }

    public Zahlensortierung(int length)
    {
        this.zahlen = new int[length];
        int i = 0;
        while (i < zahlen.length)
        {
            zahlen[i] = length - i;
            i = i + 1;
        }
    }

    public void bubble()
    {
        int i = 0;
        while (i < zahlen.length - 1)
        {
            if (zahlen[i] < zahlen[i + 1])
            {
                int h = zahlen[i];
                zahlen[i] = zahlen[i + 1];
                zahlen[i + 1] = h;
            }
            i = i + 1;
        }
    }

    public void bubblesort()
    {
        int i = 0;
        while (i < zahlen.length - 1)
        {
            bubble();
            // System.out.println("Schreibe Array auf Konsole:");
            System.out.println(zahlen[0] + " " + zahlen[1] + " " + zahlen[2]
                    + " " + zahlen[3] + " " + zahlen[4] + " " + zahlen[5] + " "
                    + zahlen[6]);
            i = i + 1;
        }
    }
}
