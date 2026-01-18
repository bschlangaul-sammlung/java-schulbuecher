package schulbuecher.buchner.informatik_11_2023.kapitel_03.thema_02.aufgabe1;

/**
 * Beschreiben Sie hier die Klasse Graph.
 *
 * @author Anja Stube
 *
 * @version 2022-04-28
 */
public class GRAPH_ungerichtet
{
    // TO-DO: Deklarieren der Adjazenzmatrix und des Knotenfeldes.
    private KNOTEN[] knotennamen;

    private int[][] adja;

    private int aktAnzahl, maxAnzahl;

    public GRAPH_ungerichtet(int anzKnoten)
    {
        // TO-DO: Initialisieren der Adjazenzmatrix und des Knotenfeldes.
        adja = new int[anzKnoten][anzKnoten];
        maxAnzahl = anzKnoten;
        alleKantenEntfernen(); // damit werden alle Kanteneinträge auf -1000
                               // gesetzt
        knotennamen = new KNOTEN[anzKnoten];
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

    public void kanteHinzufuegen(int start, int ende, int gewicht)
    {
        if ((start > maxAnzahl) || (ende > maxAnzahl))
        {
            System.out.println("Ein Einfügen ist leider nicht möglich.");
        }
        else
        {
            adja[start][ende] = gewicht;
            adja[ende][start] = gewicht;
        }
    }
    // Die folgenden Methoden sind für dich nicht relevant.

    public void adjaAusgeben()
    {
        System.out.print("      ");
        for (int i = 0; i < maxAnzahl; i++)
        {
            System.out.print(knotennamen[i].bezeichnerGeben() + " ");
        }
        System.out.println(" ");
        for (int i = 0; i < maxAnzahl; i++)
        {
            System.out.print(knotennamen[i].bezeichnerGeben() + "    ");
            for (int j = 0; j < maxAnzahl; j++)
            {
                if (adja[i][j] != -1000)
                {
                    System.out.print(adja[i][j] + "  ");
                }
                else
                {
                    System.out.print("-  ");
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
                adja[i][j] = -1000;
            }
        }
    }
}
