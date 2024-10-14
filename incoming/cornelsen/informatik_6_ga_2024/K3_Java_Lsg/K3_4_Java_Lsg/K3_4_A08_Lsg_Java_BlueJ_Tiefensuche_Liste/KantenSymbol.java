
/**
 * Verwaltet ein Kantensymbol in einem Graph
 * 
 * @author Albert Wiedemann
 * @version 1.0
 */
class KantenSymbol
{
    /** Außenrechteck des Darstellungssymbols */
    private Rechteck außen;
    /** Innenrechteck des Darstellungssymbols */
    private Rechteck innen;
    /** Richtungspfeil des Darstellungssymbols */
    private Dreieck pfeil;
    /** Gewichtsangabe des Darstellungssymbols */
    private Text text;
    /** Breite des Darstellungssymbols */
    private int breite;
    /** Gerichtete Kante */
    private boolean gerichtet;
    /** Gewicht der Kante */
    private String gewicht;
    /** Farbe */
    private String farbe;
    /** Startknoten */
    private KnotenSymbol von;
    /** Endknoten */
    private KnotenSymbol nach;

    /**
     * Legt das Symbol an und besetzt die Attribute.
     * @param start Startknoten
     * @param ende Endknoten
     * @param gerichtet wenn wahr, ist der Weg gerichtet
     * @param gewicht Kantengewicht
     * @param breite Breite der Linie
     * @param farbe Farbe der Linie
     */
    KantenSymbol (KnotenSymbol start, KnotenSymbol ende, boolean gerichtet, String gewicht, int breite, String farbe)
    {
        von = start;
        nach = ende;
        this.farbe = farbe;
        this.breite = breite;
        this.gerichtet = gerichtet;
        this.gewicht = gewicht;
        außen = new Rechteck();
        innen = new Rechteck();
        pfeil = new Dreieck();
        pfeil.FarbeSetzen("schwarz");
        text = new Text();
        text.SichtbarkeitSetzen(! "".equals(gewicht));
        text.TextSetzen(gewicht);
        DarstellungAktualisieren();
    }
    
    /**
     * Aktualisiert das Symbol
     */
    void DarstellungAktualisieren()
    {
        double x1 = von.XGeben();
        double y1 = von.YGeben();
        double x2 = nach.XGeben();
        double y2 = nach.YGeben();
        int länge = (int) Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        int xm = (int) ((x1 + x2) / 2.0);
        int ym = (int) ((y1 + y2) / 2.0);
        int x = xm - länge / 2;
        int y = ym - breite / 2;
        außen.PositionSetzen(x, y);
        außen.GrößeSetzen(länge, breite);
        if (breite < 4)
        {
            int größe = breite * 4;
            innen.SichtbarkeitSetzen(false);
            außen.FarbeSetzen(farbe);
            pfeil.SichtbarkeitSetzen(gerichtet);
            pfeil.PositionSetzen(xm, ym - größe / 2);
            pfeil.GrößeSetzen(größe, größe);
            pfeil.WinkelSetzen(270);
        }
        else
        {
            int delta = breite <= 8 ? 2 : 4;
            innen.SichtbarkeitSetzen(true);
            innen.PositionSetzen(x, y + delta / 2);
            innen.GrößeSetzen(länge, breite - delta);
            innen.FarbeSetzen(farbe);
            außen.FarbeSetzen("schwarz");
            pfeil.SichtbarkeitSetzen(gerichtet);
            pfeil.PositionSetzen(xm, ym - breite / 2);
            pfeil.GrößeSetzen(breite - delta, breite);
            pfeil.WinkelSetzen(270);
        }
        
        double winkel = 0;
        if (x1 == x2)
        {
            if (y2 > y1)
            {
                winkel = -90;
            }
            else
            {
                winkel = 90;
            }
        }
        else if (x1 < x2)
        {
            winkel = - Math.atan((y2 - y1) / (x2 - x1)) / Math.PI * 180.0;
        }
        else
        {
            winkel = 180 - Math.atan((y2 - y1) / (x2 - x1)) / Math.PI * 180.0;
        }
        pfeil.WinkelSetzen((int) winkel + 270);
        innen.WinkelSetzen((int) winkel);
        außen.WinkelSetzen((int) winkel);
        pfeil.GanzNachHintenBringen();
        innen.GanzNachHintenBringen();
        außen.GanzNachHintenBringen();
        double w = ((double) (winkel + 90)) / 180.0 * Math.PI;
        double delta = (double) (breite);
        if ((-90 <= winkel) && (winkel <= 0))
        {
            text.PositionSetzen(xm + (int) (delta * Math.cos(w)), ym - (int) (delta * Math.sin(w)));
        }
        else if ((0 < winkel) && (winkel <= 90))
        {
            text.PositionSetzen(xm - (int) (delta * Math.cos(w)), ym + (int) (delta * Math.sin(w)) + 7);
        }
        else if ((90 < winkel) && (winkel <= 180))
        {
            text.PositionSetzen(xm - (int) (delta * Math.cos(w)), ym + (int) (delta * Math.sin(w)));
        }
        else
        {
            text.PositionSetzen(xm + (int) (delta * Math.cos(w)), ym - (int) (delta * Math.sin(w)) + 10);
        }
    }
    
    /**
     * Entfernt das Kantensymbol aus der Anzeige
     */
    void Entfernen()
    {
        außen.Entfernen();
        innen.Entfernen();
        pfeil.Entfernen();
        text.Entfernen();
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
     * Meldet den Startknoten
     * @return Startknoten
     */
    KnotenSymbol StartsymbolGeben()
    {
        return von;
    }
    
    /**
     * Meldet den Zielknoten
     * @return Zielknoten
     */
    KnotenSymbol ZielsymbolGeben()
    {
        return nach;
    }
}
