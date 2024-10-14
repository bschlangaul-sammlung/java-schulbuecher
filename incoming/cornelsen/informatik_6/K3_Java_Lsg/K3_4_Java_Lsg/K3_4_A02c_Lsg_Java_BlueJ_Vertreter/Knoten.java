
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
    /** Wahr, wenn an diesem Knoten ein Kunde vorhanden ist */
    private boolean kundeVorhanden;
    /** Wahr, wenn an diesem Knoten ein Geschäft vorhanden ist */
    private boolean ladenVorhanden;
    
    /**
     * Besetzt die Attribute und legt das Knotensymbol an.
     * @param bezeichner Bezeichner
     * @param x x-Koordinate
     * @param y y-Koordinate
     * @param kunde gibt an, ob an diesem Knoten eine Kunde vorhanden ist
     * @param laden gibt an, ob an diesem Knoten eine Geschäft vorhanden ist
     */
    Knoten (String bezeichner, int x, int y, boolean kunde, boolean laden)
    {
        this.bezeichner = bezeichner;
        symbol = new KnotenSymbol(x, y, 20, "weiß", bezeichner);
        kundeVorhanden = kunde;
        ladenVorhanden = laden;
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
     * Meldet zurück, ob an diesem Knoten ein Kunde vorhanden ist
     * @return wahr, wenn an diesem Knoten ein Kunde vorhanden ist
     */
    boolean IstKundeVorhanden()
    {
        return kundeVorhanden;
    }
    
    /**
     * Meldet zurück, ob an diesem Knoten ein Laden vorhanden ist
     * @return wahr, wenn an diesem Knoten ein Laden vorhanden ist
     */
    boolean IstLadenVorhanden()
    {
        return ladenVorhanden;
    }
}
