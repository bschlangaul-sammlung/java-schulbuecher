package schulbuecher.cornelsen.shared.graphen_aufbau_tool;

import java.awt.*;

/**
 * Verwaltet ein Knotensymbol in einem Graph
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class KnotenSymbol extends GraphenSymbol
{
    /**
     * Der Bezeichner
     */
    private String bezeichner;

    /**
     * Radius
     */
    private int r;

    /**
     * x-Koordinate
     */
    private int x;

    /**
     * y-Koordinate
     */
    private int y;

    /**
     * Farbe
     */
    private String farbe;

    /**
     * Legt das Symbol an und besetzt die Attribute.
     *
     * @param x x-Koordinate
     * @param y y-Koordinate
     * @param radius Radius
     * @param farbe Farbe
     * @param bezeichner Bezeichner
     * @param o die zugeordnete Oberfläche
     */
    KnotenSymbol(int x, int y, int radius, String farbe, String bezeichner,
            Oberflaeche o)
    {
        super(o);
        this.x = x;
        this.y = y;
        this.r = radius;
        this.farbe = farbe;
        this.bezeichner = bezeichner;
        o.Eintragen(this);
    }

    /**
     * Stellt das Symbol dar.
     *
     * @param g der Grafport zum Zeichnen
     */
    @Override
    void Zeichnen(Graphics2D g)
    {
        g.setColor(FarbeCodieren(farbe));
        g.fillOval(x - r, y - r, r * 2, r * 2);
        g.setColor(Color.black);
        g.drawOval(x - r, y - r, r * 2, r * 2);
        FontMetrics metrics = g.getFontMetrics();
        g.drawString(bezeichner, x - metrics.stringWidth(bezeichner) / 2,
                y + (metrics.getAscent() - metrics.getDescent()) / 2);
    }

    /**
     * Setzt die Farbe der Darstellung
     *
     * @param f die (neue) Farbe
     */
    void FarbeSetzen(String f)
    {
        farbe = f;
        oberfläche.Aktualisieren();
    }

    /**
     * Setzt die Position der Darstellung
     *
     * @param x x-Koordinate
     * @param y y-Koordinate
     */
    void PositionSetzen(int x, int y)
    {
        this.x = x;
        this.y = y;
        oberfläche.Aktualisieren();
    }

    /**
     * Setzt die Farbe der Darstellung
     *
     * @param bezeichner der (neue) Bezeichner
     */
    void BezeichnerSetzen(String bezeichner)
    {
        this.bezeichner = bezeichner;
        oberfläche.Aktualisieren();
    }

    /**
     * Meldet die x-Koordinate des Symbols zurück.
     *
     * @return x-Koordinate
     */
    int XGeben()
    {
        return x;
    }

    /**
     * Meldet die y-Koordinate des Symbols zurück.
     *
     * @return y-Koordinate
     */
    int YGeben()
    {
        return y;
    }

    /**
     * Meldet den Radius des Symbols zurück.
     *
     * @return Radius
     */
    int RadiusGeben()
    {
        return r;
    }

    /**
     * Meldet den Bezeichner des Symbols zurück.
     *
     * @return Bezeichner
     */
    String BezeichnerGeben()
    {
        return bezeichner;
    }
}
