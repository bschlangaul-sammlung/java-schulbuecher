
/**
 * Verwaltet ein Knotensymbol in einem Graph
 * 
 * @author Albert Wiedemann
 * @version 1.0
 */
class KnotenSymbol
{
    /** Außenkreis des Darstellungssymbols */
    private Kreis außen;
    /** Innenkreis des Darstellungssymbols */
    private Kreis innen;
    /** Text des Darstellungssymbols */
    private Text text;
    /** Der Bezeichner */
    private String bezeichner;
    /** Radius */
    private int r;
    /** x-Koordinate */
    private int x;
    /** y-Koordinate */
    private int y;
    /** Farbe */
    private String farbe;
    
    /**
     * Legt das Symbol an und besetzt die Attribute.
     * @param x x-Koordinate
     * @param y y-Koordinate
     * @param radius Radius
     * @param farbe Farbe
     * @param bezeichner Bezeichner
     */
    KnotenSymbol(int x, int y, int radius, String farbe, String bezeichner)
    {
        this.x = x;
        this.y = y;
        this.r = radius;
        this.farbe = farbe;
        this.bezeichner = bezeichner;
        außen = new Kreis();
        außen.FarbeSetzen("schwarz");
        innen = new Kreis();
        text = new Text();
        text.TextGrößeSetzen(18);
        DarstellungAktualisieren();
    }
    
    /**
     * Aktualisiert das Symbol
     */
    private void DarstellungAktualisieren()
    {
        außen.PositionSetzen(x, y);
        außen.RadiusSetzen(r);
        innen.PositionSetzen(x, y);
        innen.RadiusSetzen(r - 2);
        innen.FarbeSetzen(farbe);
        text.PositionSetzen(x - bezeichner.length() / 2 * 10 - bezeichner.length() % 2 * 5, y + 6);
        text.TextSetzen(bezeichner);
    }
    
    /**
     * Setzt die Farbe der Darstellung
     * @param f die (neue) Farbe
     */
    void FarbeSetzen(String f)
    {
        farbe = f;
        DarstellungAktualisieren();
    }
    
    /**
     * Setzt die Position der Darstellung
     * @param x x-Koordinate
     * @param y y-Koordinate
     */
    void PositionSetzen(int x, int y)
    {
        this.x = x;
        this.y = y;
        DarstellungAktualisieren();
    }
    
    /**
     * Setzt den Bezeichner des Symbols
     * @param bezeichner der (neue) Bezeichner
     */
    void BezeichnerSetzen(String bezeichner)
    {
        this.bezeichner = bezeichner;
        DarstellungAktualisieren();
    }
    
    /**
     * Meldet die x-Koordinate des Symbols zurück.
     * @return x-Koordinate
     */
    int XGeben()
    {
        return x;
    }
    
    /**
     * Meldet die y-Koordinate des Symbols zurück.
     * @return y-Koordinate
     */
    int YGeben()
    {
        return y;
    }
    
    /**
     * Meldet den Bezeichner des Symbols zurück.
     * @return Bezeichner
     */
    String BezeichnerGeben()
    {
        return bezeichner;
    }
    
    /**
     * Entfernt das Knotensymbol aus der Anzeige
     */
    void Entfernen()
    {
        außen.Entfernen();
        innen.Entfernen();
        text.Entfernen();
    }
    
    /**
     * Setzt die Sichtbarkeit des Symbols
     * @param sichtbar wenn wahr, ist das Symbol sichtbar
     */
    void SichtbarkeitSetzen(boolean sichtbar)
    {
        außen.SichtbarkeitSetzen(sichtbar);
        innen.SichtbarkeitSetzen(sichtbar);
        text.SichtbarkeitSetzen(sichtbar);
    }
}
