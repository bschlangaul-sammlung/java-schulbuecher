package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_03.thema_03.aufgabe_00;

import java.util.ArrayList;

import org.bschlangaul.schulbuecher.cornelsen.shared.graph_visualisierung.Knoten;

/**
 * Verwaltet einen ungerichteten, gewichteten Graphen mittels Adjazenzmatrix
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
public class GraphMatrix extends
        org.bschlangaul.schulbuecher.cornelsen.shared.graph_visualisierung.GraphMatrix
{

    /**
     * Markierung für die besuchten Knoten
     */
    private ArrayList<Knoten> besuchteKnoten;

    /**
     * Signal für gedrückte Taste
     */
    private boolean weiter;

    /**
     * Baut die Datenstruktur auf
     */
    public GraphMatrix()
    {
        super();
        besuchteKnoten = new ArrayList<Knoten>();
        weiter = false;
    }

    /**
     * Die Aktionsmethode für gedrückte Tasten.
     *
     * @param taste die gedrückte Taste
     */
    @Override
    public void TasteGedrückt(char taste)
    {
        weiter = true;
    }

    /**
     * Die Aktionsmethode für gedrückte Sondertasten.
     *
     * @param taste KeyCode der gedrückten Taste
     */
    @Override
    public void SonderTasteGedrückt(int taste)
    {
        weiter = true;
    }

    /**
     * Wartet auf einen Tastendruck
     */
    void AufTasteWarten()
    {
        while (!weiter)
        {
            try
            {
                wait(100);
            }
            catch (Exception e)
            {
                // nix
            }
        }
        weiter = false;
    }

    /**
     * Löscht die Kanten und Knoten des Graphen Die Anzeige wird auch gelöscht
     */
    public void ZurückSetzen()
    {
        besuchteKnoten.clear();
    }

    /**
     * Setzt den Rekursionsschritt bei einem Knoten um.
     *
     * @param aktuell die Nummer des aktuell zu besuchenden Knotens
     */
    public void KnotenBesuchen(int aktuell)
    {
        besuchteKnoten.add(knoten.get(aktuell));
        knoten.get(aktuell).FarbeSetzen("gelb");
        AufTasteWarten();
        for (int nummer = knoten.size() - 1; nummer >= 0; nummer -= 1)
        {
            if ((matrix.get(aktuell).get(nummer) > 0)
                    && (!besuchteKnoten.contains(knoten.get(nummer))))
            {
                KnotenBesuchen(nummer);
            }
        }
        knoten.get(aktuell).FarbeSetzen("blau");
        AufTasteWarten();
    }
}
