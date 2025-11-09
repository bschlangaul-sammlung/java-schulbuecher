package org.bschlangaul.schulbuecher.isb.abitur.pruefung_2014.inf1.aufgabe_i.teilaufgabe_01;

public class FirmenGraph
{
    private String[] firmen;

    private int[][] matrix;

    private boolean[] besucht;

    public FirmenGraph()
    {
        firmen = new String[7];
        firmen[0] = "A";
        firmen[1] = "B";
        firmen[2] = "C";
        firmen[3] = "D";
        firmen[4] = "E";
        firmen[5] = "F";
        firmen[6] = "G";
        matrix = new int[][] {
                //
                new int[]
                { 0, 49, 12, -1, -1, -1, -1 },
                //
                new int[]
                { -1, 0, -1, -1, 7, -1, -1 },
                //
                new int[]
                { 3, -1, 0, -1, -1, -1, -1 },
                //
                new int[]
                { -1, -1, -1, 0, -1, 33, -1 },
                //
                new int[]
                { -1, 7, -1, -1, 0, -1, 25 },
                //
                new int[]
                { -1, -1, -1, 10, -1, 0, 25 },
                //
                new int[]
                { -1, -1, 84, -1, -1, -1, 0 }, };

        besucht = new boolean[matrix.length];
    }

    void starteTiefensuche(int knotenIndex)
    {
        for (int i = 0; i < matrix.length; i++)
        {
            besucht[i] = false;
        }
        besuche(knotenIndex);
    }

    void besuche(int knotenIndex)
    {
        besucht[knotenIndex] = true;
        System.out.println(firmen[knotenIndex]);
        for (int i = 0; i < matrix.length; i++)
        {
            if (matrix[knotenIndex][i] > 0 && !besucht[i])
            {
                besuche(i);
            }
        }
    }

    public static void main(String[] args)
    {
        FirmenGraph graph = new FirmenGraph();
        graph.starteTiefensuche(0);
    }
}
