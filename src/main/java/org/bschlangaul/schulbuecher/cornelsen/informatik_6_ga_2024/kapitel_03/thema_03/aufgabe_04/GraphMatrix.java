package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_03.thema_03.aufgabe_04;

import java.util.ArrayList;

import org.bschlangaul.schulbuecher.cornelsen.shared.graph_visualisierung.KantenSymbol;
import org.bschlangaul.schulbuecher.cornelsen.shared.graph_visualisierung.Knoten;

/**
 * Verwaltet einen ungerichteten, gewichteten Graphen mittels Adjazenzmatrix
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class GraphMatrix extends
        org.bschlangaul.schulbuecher.cornelsen.shared.graph_visualisierung.GraphMatrix
{

    /**
     * Markierung für die besuchten Knoten
     */
    private ArrayList<Integer> besuchteKnoten;

    /**
     * Baut die Datenstruktur auf
     */
    GraphMatrix()
    {
        super();
        besuchteKnoten = new ArrayList<Integer>();
    }

    /**
     * Löscht die Kanten und Knoten des Graphen Die Anzeige wird auch gelöscht
     */
    void ZurückSetzen()
    {
        for (KantenSymbol k : kanten)
        {
            k.Entfernen();
        }
        for (Knoten k : knoten)
        {
            k.SymbolGeben().Entfernen();
        }
        knoten.clear();
        kanten.clear();
        matrix.clear();
    }

    /**
     * Setzt den Rekursionsschritt bei einem Knoten um.
     *
     * @param aktuell die Nummer des aktuell zu besuchenden Knotens
     */
    void KnotenBesuchen(int aktuell)
    {
        System.out.println("Knoten: " + knoten.get(aktuell).BezeichnerGeben());
        besuchteKnoten.add(aktuell);
        for (int nummer = 0; nummer < knoten.size(); nummer += 1)
        {
            if ((matrix.get(aktuell).get(nummer) > 0)
                    && (!besuchteKnoten.contains(nummer)))
            {
                KnotenBesuchen(nummer);
                System.out.println("Zurück nach: "
                        + knoten.get(aktuell).BezeichnerGeben());
            }
        }
        knoten.get(aktuell).FarbeSetzen("grün");
    }

    /**
     * Führt die Tiefensuche vom Startknoten aus durch
     *
     * @param startKnoten die Nummer des Startknotens
     */
    void TiefensucheAusführen(int startKnoten)
    {
        besuchteKnoten.clear();
        KnotenBesuchen(startKnoten);
    }

    /**
     * Testet, ob der Graph zusammenhängend ist.
     *
     * @return wahr, wenn der Graph zusammenhängend ist
     */
    boolean ZusammenhangTesten()
    {
        besuchteKnoten.clear();
        KnotenBesuchen(0);
        return besuchteKnoten.size() == knoten.size();
    }
}
