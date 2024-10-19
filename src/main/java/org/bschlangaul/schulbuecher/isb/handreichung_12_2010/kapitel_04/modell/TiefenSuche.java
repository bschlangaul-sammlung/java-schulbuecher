package org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_04.modell;

/**
 * Sucht im gegeben Graph mittels wiederholter Tiefensuche nach dem kürzersten
 * Weg..
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
class TiefenSuche
{
    /**
     * Adjazenzmatrix des Graphen
     */
    int[][] matrix;

    /**
     * Merker für die besuchten Knoten
     */
    boolean[] besucht;

    /* Länge des (bisher gefundenen) kürzesten Wegs */
    int laenge;

    /**
     * Legt die Hilfsdaten an.
     *
     * @param m Adjazenzmatrix
     */
    TiefenSuche(int[][] m)
    {
        matrix = m;
        besucht = new boolean[m.length];
        for (int i = 0; i < besucht.length; i++)
        {
            besucht[i] = false;
        }
        laenge = Integer.MAX_VALUE;
    }

    /**
     * Führ die Suche aus.
     *
     * @param von Startknoten
     * @param nach Zielknoten
     *
     * @return Weglänge
     */
    int WegSuchen(int von, int nach)
    {
        Suchen(von, nach, 0);
        return laenge;
    }

    /**
     * Rekursive Durchführung der Suche.
     *
     * @param akt aktueller Knoten
     * @param nach Zielknoten
     * @param laenge Länge des aktuellen Wegs
     */
    private void Suchen(int akt, int nach, int laenge)
    {
        besucht[akt] = true;
        if (akt == nach)
        {
            if (laenge < this.laenge)
            {
                this.laenge = laenge;
            }
        }
        else
        {
            for (int i = 0; i < matrix.length; i++)
            {
                if ((i != akt) && (matrix[akt][i] > 0) && (!besucht[i]))
                {
                    Suchen(i, nach, laenge + matrix[akt][i]);
                }
            }
        }
        besucht[akt] = false;
    }
}
