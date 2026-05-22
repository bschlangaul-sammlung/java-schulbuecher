package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_03.thema_04.aufgabe_08.tiefensuche_liste;

import java.util.*;

import schulbuecher.cornelsen.shared.graph_visualisierung.KnotenSymbol;

/**
 * Beschreibt einen Knoten für die Graphendarstellung mit Adjazenzlisten
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Knoten
{
    /**
     * Der Bezeichner des Knotens
     */
    private String bezeichner;

    /**
     * Das Darstellungssymbol des Knotens
     */
    private KnotenSymbol symbol;

    /**
     * Die Adjazenzliste
     */
    private ArrayList<Kante> adjazenzliste;

    /**
     * Besetzt die Attribute und legt das Knotensymbol an.
     *
     * @param bezeichner Bezeichner
     * @param x x-Koordinate
     * @param y y-Koordinate
     */
    Knoten(String bezeichner, int x, int y)
    {
        this.bezeichner = bezeichner;
        symbol = new KnotenSymbol(x, y, 20, "weiß", bezeichner);
        adjazenzliste = new ArrayList<>();
    }

    /**
     * Meldet den Bezeichner des Knotens zurück.
     *
     * @return Bezeichner
     */
    String BezeichnerGeben()
    {
        return bezeichner;
    }

    /**
     * Meldet das Symbol des Knotens zurück.
     *
     * @return Bezeichner
     */
    KnotenSymbol SymbolGeben()
    {
        return symbol;
    }

    /**
     * Setzt die Farbe der Darstellung
     *
     * @param f die (neue) Farbe
     */
    void FarbeSetzen(String f)
    {
        symbol.FarbeSetzen(f);
    }

    /**
     * Meldet die Adjazenzliste des Knotens zurück.
     *
     * @return Adjazenzliste
     */
    ArrayList<Kante> AdjazenzlisteGeben()
    {
        return adjazenzliste;
    }
}
