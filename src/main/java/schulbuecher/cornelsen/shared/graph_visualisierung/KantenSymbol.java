package schulbuecher.cornelsen.shared.graph_visualisierung;

import schulbuecher.cornelsen.shared.graphics_and_games.Dreieck;
import schulbuecher.cornelsen.shared.graphics_and_games.Rechteck;
import schulbuecher.cornelsen.shared.graphics_and_games.Text;

/**
 * Verwaltet ein Kantensymbol in einem Graph.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
public class KantenSymbol
{
    /**
     * Das Außenrechteck des Darstellungssymbols.
     */
    private Rechteck außen;

    /**
     * Das Innenrechteck des Darstellungssymbols.
     */
    private Rechteck innen;

    /**
     * Der Richtungspfeil des Darstellungssymbols.
     */
    private Dreieck pfeil;

    /**
     * Die Gewichtsangabe des Darstellungssymbols.
     */
    private Text text;

    /**
     * Die Breite des Darstellungssymbols.
     */
    private int breite;

    /**
     * Handelt es sich um eine gerichtete Kante.
     */
    private boolean gerichtet;

    /**
     * Das Gewicht der Kante.
     */
    @SuppressWarnings("unused")
    private String gewicht;

    /**
     * Die Farbe der Kante.
     */
    private String farbe;

    /**
     * Der Startknoten.
     */
    private KnotenSymbol von;

    /**
     * Der Endknoten.
     */
    private KnotenSymbol nach;

    /**
     * Legt das Symbol an und besetzt die Attribute.
     *
     * @param start Startknoten
     * @param ende Endknoten
     * @param gerichtet wenn wahr, ist der Weg gerichtet
     * @param gewicht Kantengewicht
     * @param breite Breite der Linie
     * @param farbe Farbe der Linie
     */
    public KantenSymbol(KnotenSymbol start, KnotenSymbol ende,
            boolean gerichtet, String gewicht, int breite, String farbe)
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
        text.SichtbarkeitSetzen(!"".equals(gewicht));
        text.TextSetzen(gewicht);
        DarstellungAktualisieren();
    }

    /**
     * Aktualisiert das Symbol
     */
    public void DarstellungAktualisieren()
    {
        double x1 = von.XGeben();
        double y1 = von.YGeben();
        double x2 = nach.XGeben();
        double y2 = nach.YGeben();
        int länge = (int) Math
                .sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
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
            winkel = -Math.atan((y2 - y1) / (x2 - x1)) / Math.PI * 180.0;
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
            text.PositionSetzen(xm + (int) (delta * Math.cos(w)),
                    ym - (int) (delta * Math.sin(w)));
        }
        else if ((0 < winkel) && (winkel <= 90))
        {
            text.PositionSetzen(xm - (int) (delta * Math.cos(w)),
                    ym + (int) (delta * Math.sin(w)) + 7);
        }
        else if ((90 < winkel) && (winkel <= 180))
        {
            text.PositionSetzen(xm - (int) (delta * Math.cos(w)),
                    ym + (int) (delta * Math.sin(w)));
        }
        else
        {
            text.PositionSetzen(xm + (int) (delta * Math.cos(w)),
                    ym - (int) (delta * Math.sin(w)) + 10);
        }
    }

    /**
     * Entfernt das Kantensymbol aus der Anzeige
     */
    public void Entfernen()
    {
        außen.Entfernen();
        innen.Entfernen();
        pfeil.Entfernen();
        text.Entfernen();
    }

    /**
     * Setzt die Farbe der Darstellung
     *
     * @param f die (neue) Farbe
     */
    public void FarbeSetzen(String f)
    {
        farbe = f;
        DarstellungAktualisieren();
    }

    /**
     * Meldet den Startknoten
     *
     * @return Startknoten
     */
    public KnotenSymbol StartsymbolGeben()
    {
        return von;
    }

    /**
     * Meldet den Zielknoten
     *
     * @return Zielknoten
     */
    public KnotenSymbol ZielsymbolGeben()
    {
        return nach;
    }

    /**
     * <p>
     * Diese Methode wurde nachträglich hinzugefügt. Sie ist nicht im originalen
     * Projekt zu finden.
     * </p>
     */
    public void JavaCodeAusgeben()
    {
        double g = Double.parseDouble(gewicht);
        if (!gerichtet && g != 1)
        {
            System.out.println(String.format("g.addEdge(\"%s\", \"%s\", %s);",
                    von.BezeichnerGeben(), nach.BezeichnerGeben(), gewicht));
        }
        else if (!gerichtet && g == 1)
        {
            System.out.println(String.format("g.addEdge(\"%s\", \"%s\");",
                    von.BezeichnerGeben(), nach.BezeichnerGeben()));
        }
        else
        {
            System.out.println(String.format(
                    "g.addEdge(\"%s\", \"%s\", %s, %b);", von.BezeichnerGeben(),
                    nach.BezeichnerGeben(), gewicht, gerichtet));
        }
    }
}
