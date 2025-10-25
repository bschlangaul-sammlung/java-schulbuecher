package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_03.thema_03.aufgabe_06;

import java.util.ArrayList;

import org.bschlangaul.schulbuecher.cornelsen.shared.graph_visualisierung.KnotenSymbol;

/**
 * Beschreibt einen Knoten
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Knoten extends
        org.bschlangaul.schulbuecher.cornelsen.shared.graph_visualisierung.Knoten
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
     * Die Blätter für den Tiefensuchebaum
     */
    private ArrayList<Knoten> blätter;

    /**
     * Besetzt die Attribute und legt das Knotensymbol an.
     *
     * @param bezeichner Bezeichner
     * @param x x-Koordinate
     * @param y y-Koordinate
     */
    Knoten(String bezeichner, int x, int y)
    {
        super(bezeichner, x, y);
        this.bezeichner = bezeichner;
        symbol = new KnotenSymbol(x, y, 20, "weiß", bezeichner);
        blätter = new ArrayList<Knoten>();
    }

    /**
     * Meldet den Bezeichner des Knotens zurück.
     *
     * @return Bezeichner
     */
    public String BezeichnerGeben()
    {
        return bezeichner;
    }

    /**
     * Meldet das Symbol des Knotens zurück.
     *
     * @return Bezeichner
     */
    public KnotenSymbol SymbolGeben()
    {
        return symbol;
    }

    /**
     * Setzt die Farbe der Darstellung
     *
     * @param f die (neue) Farbe
     */
    public void FarbeSetzen(String f)
    {
        symbol.FarbeSetzen(f);
    }

    /**
     * Fügt eine neues Blatt für den Tiefensuchebaum an
     *
     * @param blatt das neue Blatt
     */
    void NeuesBlattAnfügen(Knoten blatt)
    {
        blätter.add(blatt);
    }

    /**
     * Meldet die Blätter des Tiefensuchebaums zurück.
     *
     * @return Blätter
     */
    ArrayList<Knoten> BlätterGeben()
    {
        return blätter;
    }
}
