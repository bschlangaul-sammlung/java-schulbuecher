package org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_04.modell.dijkstra;

/**
 * Sucht im Graph nach dem Alorithmus von Dijkstra.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class DIJKSTRA
{
    /* Adjazenzmatrix des Graphen */
    private int[][] matrix;

    /* Liste der abgearbeiteten Knoten */
    private LISTE fertig;

    /* Liste der unbearbeiteten Knoten */
    private LISTE rest;

    /* Liste der erreichten Knoten */
    private LISTE inarbeit;

    /**
     * Legt die Hilfsdaten an.
     *
     * @param m Adjazenzmatrix
     */
    public DIJKSTRA(int[][] m)
    {
        matrix = m;
        fertig = new LISTE();
        rest = new LISTE();
        inarbeit = new LISTE();
    }

    /**
     * Führ die Suche aus.
     *
     * @param von Startknoten
     * @param nach Zielknoten
     *
     * @return Weglänge
     */
    public int WegSuchen(int von, int nach)
    {
        int akt;
        int laenge;
        KNOTENINFO info;
        for (int i = 0; i < matrix.length; i++)
        {
            if (i == von)
            {
                fertig.Einfuegen(new KNOTENINFO(i));
            }
            else
            {
                rest.Einfuegen(new KNOTENINFO(i));
            }
        }
        akt = von;
        laenge = 0;
        info = null;
        while (akt != nach)
        {
            for (int i = 0; i < matrix.length; i++)
            {
                if (matrix[akt][i] > 0)
                {
                    info = rest.KnotenSuchen(i);
                    if (info != null)
                    {
                        info.LaengeSetzen(laenge + matrix[akt][i]);
                        rest.KnotenEntfernen(info);
                        inarbeit.Einfuegen(info);
                    }
                    else
                    {
                        info = inarbeit.KnotenSuchen(i);
                        if (info != null)
                        {
                            if (laenge + matrix[akt][i] < info.LaengeGeben())
                            {
                                info.LaengeSetzen(laenge + matrix[akt][i]);
                            }
                        }
                    }
                }
            }
            info = inarbeit.MinimumSuchen();
            inarbeit.KnotenEntfernen(info);
            fertig.Einfuegen(info);
            laenge = info.LaengeGeben();
            akt = info.NummerGeben();
        }
        return laenge;
    }
}
