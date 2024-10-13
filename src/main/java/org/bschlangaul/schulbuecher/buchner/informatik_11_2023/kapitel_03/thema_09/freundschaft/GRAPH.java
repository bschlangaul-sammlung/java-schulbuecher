package org.bschlangaul.schulbuecher.buchner.informatik_11_2023.kapitel_03.thema_09.freundschaft;

/**
 * Beschreiben Sie hier die Klasse Graph.
 *
 * @author Anja Stube
 *
 * @version 2023-07-08
 */
public class GRAPH
{
    // TO-DO: Deklarieren der Adjazenzmatrix und des Knotenfeldes.
    private KNOTEN[] knotennamen;

    private double[][] adja;

    private int aktAnzahl, maxAnzahl;

    public GRAPH(int anzKnoten)
    {
        adja = new double[anzKnoten][anzKnoten];
        knotennamen = new KNOTEN[anzKnoten];
        maxAnzahl = anzKnoten;
        alleKantenEntfernen();
    }

    public void knotenHinzufuegen(KNOTEN k)
    {
        if (aktAnzahl < maxAnzahl)
        {
            knotennamen[aktAnzahl] = k;
            aktAnzahl++;
        }
        else
        {
            System.out.println("Ein Einfügen ist leider nicht möglich.");
        }
    }

    public void kanteHinzufuegen(int start, int ende, double wert)
    {
        if ((start > maxAnzahl) || (ende > maxAnzahl))
        {
            System.out.println("Ein Einfügen ist leider nicht möglich.");
        }
        else
        {
            adja[start][ende] = wert;
            adja[ende][start] = wert;
        }
    }

    public void existierenDickeFreunde()
    {
        System.out.println("Folgende dicke Freundschaften existieren:");
        for (int start = 0; start < maxAnzahl; start++)
        {
            for (int ende = 0; ende < maxAnzahl; ende++)
            {
                if ((adja[start][ende] >= 0) && (adja[start][ende] <= 1))
                {
                    System.out.println(knotennamen[start].bezeichnerGeben()
                            + " und " + knotennamen[ende].bezeichnerGeben());
                }
            }
        }
    }
    // Die folgenden Methoden sind für dich nicht relevant.

    public void adjaAusgeben()
    {
        System.out.print("        ");
        for (int i = 0; i < maxAnzahl; i++)
        {
            System.out.print(knotennamen[i].bezeichnerGeben() + " ");
        }
        System.out.println(" ");
        for (int i = 0; i < maxAnzahl; i++)
        {
            System.out.print(knotennamen[i].bezeichnerGeben() + "     ");
            for (int j = 0; j < maxAnzahl; j++)
            {
                if (adja[i][j] >= 0)
                {
                    System.out.print(adja[i][j] + "   ");
                }
                else
                {
                    System.out.print("-     ");
                }
            }
            System.out.println();
        }
    }

    public int knotenNummerGeben(String wert)
    {
        int position = -1;
        for (int i = 0; i < aktAnzahl; i++)
        {
            if (knotennamen[i].bezeichnerIstGleich(wert))
                ;
            {
                position = i;
            }
        }
        return position;
    }

    public void alleKantenEntfernen()
    {
        for (int i = 0; i < maxAnzahl; i++)
        {
            for (int j = 0; j < maxAnzahl; j++)
            {
                adja[i][j] = -1;
            }
        }
    }
}
