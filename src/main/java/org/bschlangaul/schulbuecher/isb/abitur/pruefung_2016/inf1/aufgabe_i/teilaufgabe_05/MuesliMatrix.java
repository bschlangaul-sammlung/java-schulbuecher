package org.bschlangaul.schulbuecher.isb.abitur.pruefung_2016.inf1.aufgabe_i.teilaufgabe_05;

public class MuesliMatrix
{
    private String[] zutatenliste;

    private int[][] matrix;

    private boolean[] besucht;

    public MuesliMatrix()
    {
        zutatenliste = new String[6];
        zutatenliste[0] = "Bananen";
        zutatenliste[1] = "Dinkelflocken";
        zutatenliste[2] = "Haferflocken";
        zutatenliste[3] = "Mandeln";
        zutatenliste[4] = "Rosinen";
        zutatenliste[5] = "Schokolade";

        matrix = new int[zutatenliste.length][zutatenliste.length];
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix.length; j++)
            {
                matrix[i][j] = 0;
            }
        }

        matrix = new int[][] {
                //
                new int[]
                { 0, 0, 0, 0, 0, 0 },
                //
                new int[]
                { 0, 0, 1, 0, 0, 0 },
                //
                new int[]
                { 0, 1, 0, 3, 1, 2 },
                //
                new int[]
                { 0, 0, 3, 0, 1, 2 },
                //
                new int[]
                { 0, 0, 1, 1, 0, 0 },
                //
                new int[]
                { 0, 0, 2, 2, 0, 0 } };

        // Für die Tiefensuche
        besucht = new boolean[matrix.length];
    }

    void dazuEmpfehlen(int knotenIndex)
    {
        for (int i = 0; i < matrix.length; i++)
        {
            if (matrix[knotenIndex][i] > 1)
            {
                System.out.println("Viele Kunden haben zu Ihrer Zutat noch "
                        + zutatenliste[i] + " gewählt.");
            }
        }
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
        System.out.println(zutatenliste[knotenIndex]);
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
        MuesliMatrix graph = new MuesliMatrix();
        // 3 = Mandeln
        graph.dazuEmpfehlen(3);

        System.out.println(0);
        graph.starteTiefensuche(0);
        // Banane

        System.out.println(1);
        graph.starteTiefensuche(1);
        // Dinkelflocken
        // Haferflocken
        // Mandeln
        // Rosinen
        // Schokolade

        System.out.println(2);
        graph.starteTiefensuche(2);
        // Haferflocken
        // Dinkelflocken
        // Mandeln
        // Rosinen
        // Schokolade
    }
}
