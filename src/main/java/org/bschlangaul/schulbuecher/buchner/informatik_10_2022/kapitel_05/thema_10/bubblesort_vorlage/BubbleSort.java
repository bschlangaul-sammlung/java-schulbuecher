package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_10.bubblesort_vorlage;

/**
 * Projekt 5-10_Bubblesort (ÜuV Aufgabe 21)
 * <p>
 * Die Klasse beschreibt ein Zahlen-Array, das mithilfe des
 * BubbleSort-Algorithmus sortiert werden kann.
 *
 * @author Julia Kronawitter
 *
 * @version 2022-09-12
 */
public class BubbleSort
{
    int[] zahlen;

    public BubbleSort()
    {
        zahlen = new int[6];
        zahlen[0] = 12;
        zahlen[1] = 4;
        zahlen[2] = 2;
        zahlen[3] = 5;
        zahlen[4] = 8;
        zahlen[5] = 10;
    }

    public void sortiere()
    {
        int j = 0;
        while (j < zahlen.length - 1)
        {
            int i = 0;
            while (i < zahlen.length - 1)
            {
                if (zahlen[i] > zahlen[i + 1])
                {
                    tausche(i, i + 1);
                }
                i = i + 1;
            }
            int x = 0;
            while (x < zahlen.length)
            {
                // System.out.print(zahlen[x] + " ");
                x = x + 1;
            }
            // System.out.println(" ");
            j = j + 1;
        }
    }

    public void sortiereOptimiert()
    {
        // Hier kannst du eine optimierte Variante programmieren
        // Alternativ kannst du auch oben stehende Methode abändern
    }

    public void tausche(int i, int j)
    {
        int temp = zahlen[i];
        zahlen[i] = zahlen[j];
        zahlen[j] = temp;
    }
}
