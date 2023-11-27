package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.fahrplan_auskunft;

/**
 * Stellt den Linienplan dar.
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
import java.awt.*;
import java.util.*;

class PLANANZEIGE extends Canvas
{
    static final int breite = 400;

    static final int hoehe = 500;

    private BAHNHOFSLISTE b;

    private ArrayList<PLANABSCHNITT> abschnitte;

    private int faktorx, faktory;

    private int offsetx, offsety;

    private BAHNHOF startBahnhof, zielBahnhof;

    /**
     * Baut das Anzeigeelement auf.
     *
     * @param b Liste der Bahnhöfe
     * @param a Liste der Abschnitte
     */
    PLANANZEIGE(BAHNHOFSLISTE b, ABSCHNITTSLISTE a)
    {
        int minx, miny, maxx, maxy;
        int index;
        BAHNHOF bhf;
        ABSCHNITT ab;
        PLANABSCHNITT neu;
        this.b = b;
        startBahnhof = null;
        zielBahnhof = null;
        abschnitte = new ArrayList<PLANABSCHNITT>();
        minx = Integer.MAX_VALUE;
        maxx = Integer.MIN_VALUE;
        miny = Integer.MAX_VALUE;
        maxy = Integer.MIN_VALUE;
        b.VorErstesPositionieren();
        while (b.AufNaechstesPositionieren())
        {
            bhf = (BAHNHOF) b.DatenGeben();
            if (bhf.XGeben() > maxx)
            {
                maxx = bhf.XGeben();
            }
            if (bhf.XGeben() < minx)
            {
                minx = bhf.XGeben();
            }
            if (bhf.YGeben() > maxy)
            {
                maxy = bhf.YGeben();
            }
            if (bhf.YGeben() < miny)
            {
                miny = bhf.YGeben();
            }
        }
        faktorx = (breite - 20) / (maxx - minx);
        faktory = (hoehe - 10) / (maxy - miny);
        offsetx = -minx * faktorx + 5;
        offsety = -miny * faktory + 5;
        setSize(breite, hoehe);
        a.VorErstesPositionieren();
        while (a.AufNaechstesPositionieren())
        {
            ab = (ABSCHNITT) a.DatenGeben();
            bhf = b.Suchen(ab.Bahnhof1Geben());
            minx = bhf.XGeben() * faktorx + offsetx;
            miny = bhf.YGeben() * faktory + offsety;
            bhf = b.Suchen(ab.Bahnhof2Geben());
            maxx = bhf.XGeben() * faktorx + offsetx;
            maxy = bhf.YGeben() * faktory + offsety;
            neu = new PLANABSCHNITT(minx, miny, maxx, maxy);
            index = abschnitte.indexOf(neu);
            if (index == -1)
            {
                neu.LinieSetzen(ab.LinieGeben());
                abschnitte.add(neu);
            }
            else
            {
                abschnitte.get(index).LinieSetzen(ab.LinieGeben());
            }
        }
    }

    /**
     * Setzt den Startbahnhof der Route.
     *
     * @param start Startbahnhof
     */
    void StartbahnhofSetzen(BAHNHOF start)
    {
        startBahnhof = start;
        invalidate();
        repaint();
    }

    /**
     * Setzt den Zielbahnhof der Route.
     *
     * @param ziel Zielbahnhof
     */
    void ZielbahnhofSetzen(BAHNHOF ziel)
    {
        zielBahnhof = ziel;
        invalidate();
        repaint();
    }

    /**
     * Wird zum Darstellen der Komponente aufgerufen.
     *
     * @param g Graphikobjekt zum Zeichnen der Komponente
     */
    public void paint(Graphics g)
    {
        BAHNHOF bhf;
        int x, y;
        b.VorErstesPositionieren();
        while (b.AufNaechstesPositionieren())
        {
            bhf = (BAHNHOF) b.DatenGeben();
            x = bhf.XGeben() * faktorx + offsetx;
            y = bhf.YGeben() * faktory + offsety;
            if (bhf == startBahnhof)
            {
                g.setColor(Color.GREEN);
            }
            else if (bhf == zielBahnhof)
            {
                g.setColor(Color.RED);
            }
            else
            {
                g.setColor(Color.BLACK);
            }
            g.fillOval(x - 5, y - 5, 10, 10);
        }
        g.setColor(Color.BLACK);
        for (PLANABSCHNITT a : abschnitte)
        {
            a.Zeichnen(g);
        }
    }
}
