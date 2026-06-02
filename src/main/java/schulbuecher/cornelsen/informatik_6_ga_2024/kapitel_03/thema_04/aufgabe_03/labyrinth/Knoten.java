package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_03.thema_04.aufgabe_03.labyrinth;

import schulbuecher.cornelsen.shared.graph_visualisierung.KnotenSymbol;

/**
 * Beschreibt einen Knoten
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Knoten extends schulbuecher.cornelsen.shared.graph_visualisierung.Knoten
{
    /**
     * x-Koordinate des Knotens
     */
    private int x;

    /**
     * y-Koordinate des Knotens
     */
    private int y;

    /**
     * Das Darstellungssymbol des Knotens
     */
    private KnotenSymbol symbol;

    /**
     * Vorgänger für die Wegesuche
     */
    private Knoten vorgänger;

    /**
     * Besetzt die Attribute und legt das Knotensymbol an.
     *
     * @param x x-Koordinate
     * @param y y-Koordinate
     */
    Knoten(int x, int y)
    {
        super(null, x, y);
        this.x = x;
        this.y = y;
        symbol = new KnotenSymbol(
                x * LabyrinthElement.seitenlänge
                        + LabyrinthElement.seitenlänge / 2,
                y * LabyrinthElement.seitenlänge
                        + LabyrinthElement.seitenlänge / 2,
                (LabyrinthElement.seitenlänge - 4) / 2, "weiß", "");
        vorgänger = null;
    }

    /**
     * Meldet die x-Koordinate des Knotens zurück.
     *
     * @return x-Koordinate
     */
    public int XGeben()
    {
        return x;
    }

    /**
     * Meldet die y-Koordinate des Knotens zurück.
     *
     * @return y-Koordinate
     */
    public int YGeben()
    {
        return y;
    }

    /**
     * Meldet das Symbol des Knotens zurück.
     *
     * @return Knotensymbol
     */
    public KnotenSymbol SymbolGeben()
    {
        return symbol;
    }

    /**
     * Meldet den Vorgänger des Knotens zurück.
     *
     * @return Vorgänger
     */
    public Knoten VorgängerGeben()
    {
        return vorgänger;
    }

    /**
     * Setzt den Vorgänger für den Weg zum Ausgang
     *
     * @param v der Vorgänger
     */
    public void VorgängerSetzen(Knoten v)
    {
        vorgänger = v;
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
}
