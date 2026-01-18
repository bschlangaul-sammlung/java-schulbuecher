package schulbuecher.cornelsen.shared.graphen_aufbau_tool;

import java.awt.*;

/**
 * Verwaltet ein Knotensymbol in einem Graph
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class GezogenerKnotenSymbol extends GraphenSymbol
{
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
     * Legt das Symbol an und besetzt die Attribute.
     *
     * @param x x-Koordinate
     * @param y y-Koordinate
     * @param radius Radius
     * @param o die zugeordnete Oberfläche
     */
    GezogenerKnotenSymbol(int x, int y, int radius, Oberflaeche o)
    {
        super(o);
        this.x = x;
        this.y = y;
        this.r = radius;
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
        g.setColor(new Color(255, 255, 255, 100));
        g.fillOval(x - r, y - r, r * 2, r * 2);
        g.setColor(new Color(0, 0, 0, 100));
        g.drawOval(x - r, y - r, r * 2, r * 2);
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
}
