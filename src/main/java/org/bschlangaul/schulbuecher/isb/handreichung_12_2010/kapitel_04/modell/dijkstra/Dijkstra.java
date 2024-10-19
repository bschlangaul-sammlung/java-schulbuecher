package org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_04.modell.dijkstra;

/**
 * Sucht im Graph nach dem Alorithmus von Dijkstra.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class Dijkstra
{
    /**
     * Adjazenzmatrix des Graphen
     */
    private int[][] matrix;

    /**
     * Liste der abgearbeiteten Knoten
     */
    private Liste fertig;

    /**
     * Liste der unbearbeiteten Knoten
     */
    private Liste rest;

    /**
     * Liste der erreichten Knoten
     */
    private Liste inarbeit;

    /**
     * Legt die Hilfsdaten an.
     *
     * @param m Adjazenzmatrix
     */
    public Dijkstra(int[][] m)
    {
        matrix = m;
        fertig = new Liste();
        rest = new Liste();
        inarbeit = new Liste();
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
        KnotenInfo info;
        for (int i = 0; i < matrix.length; i++)
        {
            if (i == von)
            {
                fertig.Einfuegen(new KnotenInfo(i));
            }
            else
            {
                rest.Einfuegen(new KnotenInfo(i));
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
