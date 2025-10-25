package org.bschlangaul.schulbuecher.cornelsen.shared.graph_visualisierung;

/**
 * Beschreibt einen Knoten
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
public class Knoten
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
     * Die x-Koordinate in Pixel.
     *
     * <p>
     * Dieses Attribut wurde nachträglich hinzugefügt, es ist nicht im
     * originalen Projekt zu finden.
     * </p>
     */
    private int x;

    /**
     * Die y-Koordinate in Pixel.
     *
     * <p>
     * Dieses Attribut wurde nachträglich hinzugefügt, es ist nicht im
     * originalen Projekt zu finden.
     * </p>
     */
    private int y;

    /**
     * Besetzt die Attribute und legt das Knotensymbol an.
     *
     * @param bezeichner Bezeichner
     * @param x x-Koordinate
     * @param y y-Koordinate
     */
    public Knoten(String bezeichner, int x, int y)
    {
        this.bezeichner = bezeichner;
        this.x = x;
        this.y = y;
        symbol = new KnotenSymbol(x, y, 20, "weiß", bezeichner);
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
     * <p>
     * Diese Methode wurde nachträglich hinzugefügt. Sie ist nicht im originalen
     * Projekt zu finden.
     * </p>
     */
    public int XGeben()
    {
        return x;
    }

    /**
     * <p>
     * Diese Methode wurde nachträglich hinzugefügt. Sie ist nicht im originalen
     * Projekt zu finden.
     * </p>
     */
    public int YGeben()
    {
        return y;
    }

    /**
     * Gibt Java-Code aus, um den Graphen über ein andere Implementation der
     * Graphmatrix darstellen zu können. So kann die sqlite-Datenbank umgangen
     * werden.
     *
     * <p>
     * Diese Methode wurde nachträglich hinzugefügt. Sie ist nicht im originalen
     * Projekt zu finden.
     * </p>
     */
    public void JavaCodeAusgeben(GraphMatrix graph)
    {
        Abmessungen abmessungen = graph.AbmessungenAusgeben();
        // In der Engine Pi misst ein Meter standardmäßig 32 Pixel.
        System.out.println(String.format("graph.addNode(\"%s\", %s, %s)", bezeichner,
                (x - abmessungen.minX()) / 32.0,
                (y - abmessungen.minY()) / 32.0));
    }
}
