package schulbuecher.cornelsen.shared.graphen_aufbau_tool;

import java.awt.*;

/**
 * Oberklasse der Symbole des Graphen
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
abstract class GraphenSymbol
{
    /**
     * Farbe Hellgelb.
     */
    protected final Color hellgelb = new Color(255, 255, 128);

    /**
     * Farbe Hellgrün.
     */
    protected final Color hellgrün = new Color(128, 255, 128);

    /**
     * Farbe Orange.
     */
    protected final Color orange = new Color(255, 128, 0);

    /**
     * Farbe Braun.
     */
    protected final Color braun = new Color(128, 64, 0);

    /**
     * Die Oberfläche, die das Symbol verwaltet
     */
    protected Oberflaeche oberfläche;

    /**
     * Setzt die zugeordnete Oberfläche
     *
     * @param o die zugeordnete Oberfläche
     */
    GraphenSymbol(Oberflaeche o)
    {
        oberfläche = o;
    }

    /**
     * Stellt das Symbol dar.
     *
     * @param g der Grafport zum Zeichnen
     */
    abstract void Zeichnen(Graphics2D g);

    /**
     * Bestimmt die RGB-Farbe für den gegeben String.
     *
     * @param farbe die Farbe als String
     *
     * @return die Farbe als RGB-Farbe
     */

    Color FarbeCodieren(String farbe)
    {
        farbe = farbe.toLowerCase();
        switch (farbe)
        {
        case "weiß":
        case "weiss":
            return Color.WHITE;

        case "rot":
            return Color.RED;

        case "grün":
        case "gruen":
            return Color.GREEN;

        case "blau":
            return Color.BLUE;

        case "gelb":
            return Color.YELLOW;

        case "magenta":
            return Color.MAGENTA;

        case "cyan":
            return Color.CYAN;

        case "hellgelb":
            return hellgelb;

        case "hellgrün":
        case "hellgruen":
            return hellgrün;

        case "orange":
            return orange;

        case "braun":
            return braun;

        case "grau":
            return Color.GRAY;

        case "schwarz":
            return Color.BLACK;

        default:
            return Color.BLACK;
        }
    }
}
