
/**
 * Beschreibt einen Knoten
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
class Knoten
{
    /**
     * x-Koordinate des Knotens */
    private int x;
    /**
     * y-Koordinate des Knotens */
    private int y;
    /**
     * Das Darstellungssymbol des Knotens */
    private KnotenSymbol symbol;
    /**
     * Vorgänger für die Wegesuche */
    private Knoten vorgänger;

    /**
     * Besetzt die Attribute und legt das Knotensymbol an.
     * @param x x-Koordinate
     * @param y y-Koordinate
     */
    Knoten (int x, int y)
    {
        this.x = x;
        this.y = y;
        symbol = new KnotenSymbol(x * LabyrinthElement.seitenlänge + LabyrinthElement.seitenlänge / 2, y * LabyrinthElement.seitenlänge + LabyrinthElement.seitenlänge / 2, (LabyrinthElement.seitenlänge - 4) / 2, "weiß", "");
        vorgänger = null;
    }

    /**
     * Meldet die x-Koordinate des Knotens zurück.
     * @return x-Koordinate
     */
    int XGeben()
    {
        return x;
    }

    /**
     * Meldet die y-Koordinate des Knotens zurück.
     * @return y-Koordinate
     */
    int YGeben()
    {
        return y;
    }

    /**
     * Meldet das Symbol des Knotens zurück.
     * @return Knotensymbol
     */
    KnotenSymbol SymbolGeben()
    {
        return symbol;
    }

    /**
     * Meldet den Vorgänger des Knotens zurück.
     * @return Vorgänger
     */
    Knoten VorgängerGeben()
    {
        return vorgänger;
    }

    /**
     * Setzt den Vorgänger für den Weg zum Ausgang
     * @param v der Vorgänger
     */
    void VorgängerSetzen(Knoten v)
    {
        vorgänger = v;
    }

    /**
     * Setzt die Farbe der Darstellung
     * @param f die (neue) Farbe
     */
    void FarbeSetzen(String f)
    {
        symbol.FarbeSetzen(f);
    }
}
