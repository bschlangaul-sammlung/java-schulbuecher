
/**
 * Beschreibt einen Knoten
 * 
 * @author Albert Wiedemann
 * @version 1.0
 */
class Knoten
{
    /** Der Bezeichner des Knotens */
    private String bezeichner;
    /** Das Darstellungssymbol des Knotens */
    private KnotenSymbol symbol;
    /** Markierung, dass der Knoten bei der Tiefensuche besucht wurde */
    private boolean besucht;
    
    /**
     * Besetzt die Attribute und legt das Knotensymbol an.
     * @param bezeichner Bezeichner
     * @param x x-Koordinate
     * @param y y-Koordinate
     */
    Knoten (String bezeichner, int x, int y)
    {
        this.bezeichner = bezeichner;
        symbol = new KnotenSymbol(x, y, 20, "weiß", bezeichner);
        besucht = false;
    }
    
    /**
     * Meldet den Bezeichner des Knotens zurück.
     * @return Bezeichner
     */
    String BezeichnerGeben()
    {
        return bezeichner;
    }
    
    /**
     * Meldet das Symbol des Knotens zurück.
     * @return Bezeichner
     */
    KnotenSymbol SymbolGeben()
    {
        return symbol;
    }
    
    /**
     * Setzt die Farbe der Darstellung
     * @param f die (neue) Farbe
     */
    void FarbeSetzen(String f)
    {
        symbol.FarbeSetzen(f);
    }
    
    /**
     * Meldet zurück, ob der Knoten besucht wurde
     * @return besucht
     */
    boolean BesuchtGeben()
    {
        return besucht;
    }
    
    /**
     * Setzt das Attribut besucht auf den gegebenen Wert
     * @param besucht der neue Wert des Attributs besucht
     */
    void BesuchtSetzen(boolean besucht)
    {
        this.besucht = besucht;
    }
}
