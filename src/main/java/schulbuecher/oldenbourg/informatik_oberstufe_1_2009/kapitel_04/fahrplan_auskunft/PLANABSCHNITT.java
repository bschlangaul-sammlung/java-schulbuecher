package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.fahrplan_auskunft;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Beschreibt einen Abschnitt für die Darstellung im Linienplan.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class PLANABSCHNITT
{
    private static final int abst = 5;

    private static final int dy = 10;

    private int x1, y1, x2, y2;

    private ArrayList<Integer> linien;

    /**
     * Legt die Attribute fest.
     *
     * @param x1 X-Koordinate ein Ende
     * @param y1 Y-Koordinate ein Ende
     * @param x2 X-Koordinate anderes Ende
     * @param y2 Y-Koordinate anderes Ende
     */
    PLANABSCHNITT(int x1, int y1, int x2, int y2)
    {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        linien = new ArrayList<Integer>();
    }

    /**
     * Setzt einen Linieneintrag.
     *
     * @param linie neue Linie
     */
    void LinieSetzen(int linie)
    {
        linien.add(linie);
    }

    /**
     * Zeichnet den Linienabschnitt und die Beschriftung.
     *
     * @param g Graphport
     */
    void Zeichnen(Graphics g)
    {
        int xs, ys;
        String beschriftung;
        g.drawLine(x1, y1, x2, y2);
        beschriftung = "";
        for (int i = 0; i < linien.size(); i++)
        {
            if (i == 0)
            {
                beschriftung = beschriftung + linien.get(i);
            }
            else
            {
                beschriftung = beschriftung + ", " + linien.get(i);
            }
        }
        xs = 0;
        ys = dy;
        if (x1 == x2)
        {
            xs = x1 + abst;
            ys = (y1 + y2) / 2 + dy;
        }
        else if (y1 == y2)
        {
            xs = (x1 + x2) / 2;
            ys = y1 + abst + dy;
        }
        else if (Math.abs(x1 - x2) >= Math.abs(y1 - y2))
        {
            xs = (x1 + x2) / 2;
            ys = (y1 + y2) / 2;
            if ((x1 - x2) * (y1 - y2) > 0)
            {
                ys = ys + abst + dy;
                xs = xs - abst / 2;
            }
            else
            {
                ys = ys - dy;
                xs = xs - abst / 2;
            }
        }
        else
        {
            xs = (x1 + x2) / 2;
            ys = (y1 + y2) / 2;
            if ((x1 - x2) * (y1 - y2) > 0)
            {
                xs = xs + abst;
            }
            else
            {
                ys = ys + abst + dy;
                xs = xs + abst / 2;
            }
        }
        g.drawString(beschriftung, xs, ys);
    }

    /**
     * Vergleich zum Suchen in der Liste.
     *
     * @param o Vergleichsobject
     *
     * @return Vergleichsergebnis
     */
    public boolean equals(Object o)
    {
        PLANABSCHNITT a;
        a = (PLANABSCHNITT) o;
        return (x1 == a.x1) && (x2 == a.x2) && (y1 == a.y1) && (y2 == a.y2)
                || (x1 == a.x2) && (x2 == a.x1) && (y1 == a.y2) && (y2 == a.y1);
    }
}
