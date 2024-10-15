package org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_04.modell;

import java.util.Random;
import org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_04.modell.dijkstra.DIJKSTRA;

/**
 * Führt die gewünschten Laufzeittests durch.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class TESTSUCHEN
{
    /* Anzahl der Datenelemente im Graphen */
    private int anzahl;

    /* Die Laufzeitsummen */
    private long zeitTiefe, zeitDijkstra;

    /* Die Adjazenzmatrix */
    private int[][] matrix;

    /* Startort */
    private int start;

    /* Zielort */
    private int ziel;

    /**
     * Legt die benötigten Objekte an und besetzt die Attributwerte.
     *
     * @param anzahl Anzahl der zu sortierenden Datenelemente
     */
    public TESTSUCHEN(int anzahl)
    {
        this.anzahl = anzahl;
        matrix = new GENERIEREN(anzahl)
                .AdjazenzmatrixGenerieren((anzahl - 1) * 2);
    }

    /**
     * Bestimmt die durschnittlichen Knotenbesuche.
     *
     * @param tiefe gibt an, ob mit Tiefensuche gesucht werden soll
     * @param dijkstra gibt an, ob nach Dikstra gesucht werden soll
     */
    public void DurchschnittsTest(boolean tiefe, boolean dijkstra)
    {
        Random zufall;
        long zeit1, zeit2;
        long start, ende;
        zufall = new Random();
        zeitTiefe = Long.MAX_VALUE;
        zeitDijkstra = Long.MAX_VALUE;
        for (int j = 0; j < 10; j++)
        {
            zeit1 = 0;
            zeit2 = 0;
            for (int i = 0; i < 10; i++)
            {
                start = zufall.nextInt(anzahl);
                do
                {
                    ziel = zufall.nextInt(anzahl);
                }
                while (start == ziel);
                if (tiefe)
                {
                    TIEFENSUCHE t;
                    t = new TIEFENSUCHE(matrix);
                    start = System.nanoTime();
                    t.WegSuchen(this.start, this.ziel);
                    ende = System.nanoTime();
                    zeit1 += ende - start;
                }
                if (dijkstra)
                {
                    DIJKSTRA t;
                    t = new DIJKSTRA(matrix);
                    start = System.nanoTime();
                    t.WegSuchen(this.start, this.ziel);
                    ende = System.nanoTime();
                    zeit2 += ende - start;
                }
            }
            zeit1 /= 10;
            zeit2 /= 10;
            zeitTiefe = Math.min(zeitTiefe, zeit1);
            zeitDijkstra = Math.min(zeitDijkstra, zeit2);
        }
    }

    /**
     * Meldet die durchschnittliche Zeit für die Tiefensuche.
     *
     * @return Suchzeit
     */
    public long ZeitFuerTiefensucheGeben()
    {
        return zeitTiefe;
    }

    /**
     * Meldet die durchschnittliche Zeit für die Suche nach Dijkstra.
     *
     * @return Suchzeit
     */
    public long ZeitFuerDijkstraGeben()
    {
        return zeitDijkstra;
    }
}
