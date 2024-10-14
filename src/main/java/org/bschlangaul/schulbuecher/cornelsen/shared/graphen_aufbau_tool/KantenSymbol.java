package org.bschlangaul.schulbuecher.cornelsen.shared.graphen_aufbau_tool;

import java.awt.*;

/**
 * Verwaltet ein Kantensymbol in einem Graph
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class KantenSymbol extends GraphenSymbol
{
    /**
     * Breite des Darstellungssymbols
     */
    private int breite;

    /**
     * Gerichtete Kante
     */
    private boolean gerichtet;

    /**
     * Gewicht der Kante
     */
    private String gewicht;

    /**
     * Farbe
     */
    private String farbe;

    /**
     * Startknoten
     */
    private KnotenSymbol von;

    /**
     * Endknoten
     */
    private KnotenSymbol nach;

    /**
     * Legt das Symbol an und besetzt die Attribute.
     *
     * @param start: Startknoten
     * @param ende: Endknoten
     * @param gerichtet: wenn wahr, ist der Weg gerichtet
     * @param gewicht: Kantengewicht
     * @param breite: Breite der Linie
     * @param farbe: Farbe der Linie
     * @param o die zugeordnete Oberfläche
     */
    KantenSymbol(KnotenSymbol start, KnotenSymbol ende, boolean gerichtet,
            String gewicht, int breite, String farbe, Oberflaeche o)
    {
        super(o);
        von = start;
        nach = ende;
        this.farbe = farbe;
        this.breite = breite;
        this.gerichtet = gerichtet;
        this.gewicht = gewicht;
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
        double x1 = von.XGeben();
        double y1 = von.YGeben();
        double x2 = nach.XGeben();
        double y2 = nach.YGeben();
        double länge = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
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

        double r = von.RadiusGeben();
        int x1neu = (int) (x1 + (x2 - x1) / länge * r);
        int y1neu = (int) (y1 + (y2 - y1) / länge * r);
        r = nach.RadiusGeben();
        int x2neu = (int) (x2 - (x2 - x1) / länge * r);
        int y2neu = (int) (y2 - (y2 - y1) / länge * r);
        g.setColor(FarbeCodieren(farbe));
        Stroke sichern = g.getStroke();
        g.setStroke(new BasicStroke(breite));
        g.drawLine(x1neu, y1neu, x2neu, y2neu);

        if (gerichtet)
        {
            g.drawLine(
                    x2neu + (int) (10.0
                            * Math.cos((-winkel + 135) / 180.0 * Math.PI)),
                    y2neu + (int) (10.0
                            * Math.sin((-winkel + 135) / 180.0 * Math.PI)),
                    x2neu, y2neu);
            g.drawLine(
                    x2neu + (int) (10.0
                            * Math.cos((-winkel - 135) / 180.0 * Math.PI)),
                    y2neu + (int) (10.0
                            * Math.sin((-winkel - 135) / 180.0 * Math.PI)),
                    x2neu, y2neu);
        }

        g.setStroke(sichern);

        int xm = (x1neu + x2neu) / 2;
        int ym = (y1neu + y2neu) / 2;
        if ((-90 <= winkel) && (winkel <= 0))
        {
            double w = ((double) (winkel + 90)) / 180.0 * Math.PI;
            double delta = (double) (breite);
            g.drawString(gewicht, xm + (int) (delta * Math.cos(w)),
                    ym - (int) (delta * Math.sin(w)));
        }
        else if ((0 < winkel) && (winkel <= 90))
        {
            double w = ((double) (winkel + 90)) / 180.0 * Math.PI;
            double delta = (double) (breite);
            g.drawString(gewicht, xm - (int) (delta * Math.cos(w)),
                    ym + (int) (delta * Math.sin(w) + 10));
        }
        else if ((90 < winkel) && (winkel <= 180))
        {
            double w = ((double) (winkel + 90)) / 180.0 * Math.PI;
            double delta = (double) (breite);
            g.drawString(gewicht, xm - (int) (delta * Math.cos(w)),
                    ym + (int) (delta * Math.sin(w)));
        }
        else
        {
            double w = ((double) (winkel + 90)) / 180.0 * Math.PI;
            double delta = (double) (breite);
            g.drawString(gewicht, xm + (int) (delta * Math.cos(w)),
                    ym - (int) (delta * Math.sin(w) - 10));
        }
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
     * Setzt das Gewicht der Darstellung
     *
     * @param g das (neue) Gewicht
     */
    void GewichtSetzen(String g)
    {
        gewicht = g;
        oberfläche.Aktualisieren();
    }

    /**
     * Setzt, ob die Kante gerichtet ist.
     *
     * @param gerichtet die Kante ist gerichtet bei wahr
     */
    void GerichtetSetzen(boolean gerichtet)
    {
        this.gerichtet = gerichtet;
        oberfläche.Aktualisieren();
    }

    /**
     * Meldet den Startknoten
     *
     * @return Startknoten
     */
    KnotenSymbol StartsymbolGeben()
    {
        return von;
    }

    /**
     * Meldet den Zielknoten
     *
     * @return Zielknoten
     */
    KnotenSymbol ZielsymbolGeben()
    {
        return nach;
    }

    /**
     * Meldet das Gewicht
     *
     * @return Gewicht
     */
    String GewichtGeben()
    {
        return gewicht;
    }

    /**
     * Meldet das Gewicht
     *
     * @return Gewicht
     */
    boolean IstGerichtet()
    {
        return gerichtet;
    }
}
