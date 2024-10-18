package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.fahrplan_wartung;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Stellt den Linienplan dar.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class PLANANZEIGE extends Canvas
{
    static final int breite = 400;

    static final int hoehe = 500;

    private BAHNHOFSLISTE b;

    private ArrayList<PLANABSCHNITT> abschnitte;

    private int faktorx, faktory;

    private int offsetx, offsety;

    private BAHNHOF aktBahnhof, altBahnhof, zielBahnhof;

    private PLANABSCHNITT aktAbschnitt, altAbschnitt;

    /**
     * Baut die Struktur der Komponente auf.
     *
     * @param b Liste der Bahnhöfe
     * @param a Liste der Abschnitte
     */
    PLANANZEIGE(BAHNHOFSLISTE b, ABSCHNITTSLISTE a)
    {
        this.b = b;
        aktBahnhof = null;
        aktAbschnitt = null;
        altBahnhof = null;
        altAbschnitt = null;
        zielBahnhof = null;
        UmrechnungErmittlen();
        setSize(breite, hoehe);
        PlanabschnitteErstellen(a);
        addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                PlanMousePressed(e);
            };

            public void mouseReleased(MouseEvent e)
            {
                PlanMouseReleased(e);
            };
        });
    }

    /**
     * Wird beim Mousedown-Event aufgerufen.
     *
     * @param e Eventinformation
     */
    private void PlanMousePressed(MouseEvent e)
    {
        altBahnhof = aktBahnhof;
        altAbschnitt = aktAbschnitt;
        aktAbschnitt = null;
        aktBahnhof = PointToBahnhof(e.getPoint());
        if (aktBahnhof == null)
        {
            aktAbschnitt = PointToAbschnitt(e.getPoint());
            if (aktAbschnitt != null)
            {
                // Abschnitt auf Zwischenfarbe ?
            }
        }
        else
        {
            // Bahnhof auf Zwischenfarbe
        }
    }

    /**
     * Wird beim Mouseup-Event aufgerufen.
     *
     * @param e Eventinformation
     */
    private void PlanMouseReleased(MouseEvent e)
    {
        if ((aktBahnhof != null)
                && (aktBahnhof == PointToBahnhof(e.getPoint())))
        {
            aktAbschnitt = null;
            // kom. KommandoEintragen (new Kommando (KommandoTyp. gehen, raeume
            // [lastDown].
            // nummer));
        }
        else
        {
            aktBahnhof = null;
            if ((aktAbschnitt != null)
                    && (aktAbschnitt == PointToAbschnitt(e.getPoint())))
            {
                // kom. KommandoEintragen (new Kommando (KommandoTyp. gehen,
                // raeume [lastDown].
                // nummer));
            }
            else
            {
                aktAbschnitt = null;
            }
        }
        if (aktBahnhof != altBahnhof)
        {
            firePropertyChange("Bahnhof", altBahnhof, aktBahnhof);
        }
        if (aktAbschnitt != altAbschnitt)
        {
            firePropertyChange("Abschnitt", altAbschnitt, aktAbschnitt);
        }
        invalidate();
        repaint();
    }

    /**
     * Untersucht, ob der Punkt einen Bahnhof bezeichnet.
     *
     * @param wo Zu untersuchender Punkt
     *
     * @return Bahnhofsreferenz oder null
     */
    private BAHNHOF PointToBahnhof(Point wo)
    {
        BAHNHOF bhf;
        int x;
        int y;
        b.VorErstesPositionieren();
        while (b.AufNaechstesPositionieren())
        {
            bhf = (BAHNHOF) b.DatenGeben();
            x = bhf.XGeben() * faktorx + offsetx;
            y = bhf.YGeben() * faktory + offsety;
            Rectangle r = new Rectangle(x - 5, y - 5, 10, 10);
            if (r.contains(wo))
            {
                return bhf;
            } ;
        }
        return null;
    }

    /**
     * Untersucht, ob der Punkt einen Bahnhof bezeichnet.
     *
     * @param wo Zu untersuchender Punkt
     *
     * @return Abschnittsreferenz oder null
     */
    private PLANABSCHNITT PointToAbschnitt(Point wo)
    {
        for (PLANABSCHNITT ab : abschnitte)
        {
            if (ab.TrefferRechteckGeben().contains(wo))
            {
                return ab;
            } ;
        }
        return null;
    }

    /**
     * Berechnet die Koordinatenumrechnungen.
     */
    void UmrechnungErmittlen()
    {
        int minx, miny, maxx, maxy;
        BAHNHOF bhf;
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
        if (aktBahnhof != null)
        {
            firePropertyChange("Bahnhof", aktBahnhof, null);
            aktBahnhof = null;
        }
        if (aktAbschnitt != null)
        {
            firePropertyChange("Abschnitt", aktAbschnitt, null);
            aktBahnhof = null;
        }
    }

    /**
     * Erstellt das Feld der Planabschnitte.
     *
     * @param a Abschnittsliste
     */
    void PlanabschnitteErstellen(ABSCHNITTSLISTE a)
    {
        ABSCHNITT ab;
        PLANABSCHNITT neu;
        int index;
        abschnitte = new ArrayList<PLANABSCHNITT>();
        a.VorErstesPositionieren();
        while (a.AufNaechstesPositionieren())
        {
            ab = (ABSCHNITT) a.DatenGeben();
            neu = new PLANABSCHNITT(b);
            neu.OriginalSetzen(ab);
            neu.NeuBerechnen(faktorx, faktory, offsetx, offsety);
            index = abschnitte.indexOf(neu);
            if (index == -1)
            {
                abschnitte.add(neu);
            }
            else
            {
                abschnitte.get(index).OriginalSetzen(ab);
            }
        }
        aktAbschnitt = null;
        invalidate();
        repaint();
    }

    /**
     * Berechnet die Zeichenkoordinaten der Planabschnitte.
     */
    void AbschnitteNeuBerechnen()
    {
        for (PLANABSCHNITT ab : abschnitte)
        {
            ab.NeuBerechnen(faktorx, faktory, offsetx, offsety);
        }
    }

    /**
     * Meldet den aktuellen Bahnhof.
     *
     * @return aktueller Bahnhof
     */
    BAHNHOF AktBahnhofGeben()
    {
        return aktBahnhof;
    }

    /**
     * Meldet den für das Anlegen eines neuen Abschnitts markierten Zielbahnhof.
     *
     * @return Zielbahnhof
     */
    BAHNHOF ZielbahnhofGeben()
    {
        return zielBahnhof;
    }

    /**
     * Setzt den für das Anlegen eines neuen Abschnitts markierten Zielbahnhof.
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
     * Meldet den aktuellen Abschnitt
     *
     * @return aktueller Abschnitt
     */
    PLANABSCHNITT AktAbschnittGeben()
    {
        return aktAbschnitt;
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
            if (bhf == aktBahnhof)
            {
                g.setColor(Color.RED);
            }
            else if ((bhf == zielBahnhof) && (aktBahnhof != null))
            {
                g.setColor(Color.YELLOW);
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
            if (a == aktAbschnitt)
            {
                g.setColor(Color.BLUE);
            }
            else
            {
                g.setColor(Color.BLACK);
            }
            a.Zeichnen(g);
        }
        g.setColor(Color.BLACK);
    }
}
