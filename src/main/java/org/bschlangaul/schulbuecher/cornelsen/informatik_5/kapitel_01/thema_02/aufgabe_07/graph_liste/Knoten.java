package org.bschlangaul.schulbuecher.cornelsen.informatik_5.kapitel_01.thema_02.aufgabe_07.graph_liste;

import java.util.ArrayList;

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
    // Zu ergänzen

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
        // Initialisierung der Adjazenzliste ergänzen
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
        // wirklichen Rückabewert ergänzen
        return null;
    }
}
