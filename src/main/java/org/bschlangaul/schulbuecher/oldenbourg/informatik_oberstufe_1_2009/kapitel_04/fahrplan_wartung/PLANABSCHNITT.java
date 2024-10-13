package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.fahrplan_wartung;

import java.awt.Graphics;
import java.awt.Polygon;
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

    private ArrayList<ABSCHNITT> originale;

    private BAHNHOFSLISTE b;

    /**
     * Legt die Attribute fest.
     *
     * @param b Liste der Bahnhöfe
     */
    PLANABSCHNITT(BAHNHOFSLISTE b)
    {
        originale = new ArrayList<ABSCHNITT>();
        this.b = b;
    }

    /**
     * Setzt einen Originaleintrag.
     *
     * @param o neuer Originaleintrag
     */
    void OriginalSetzen(ABSCHNITT o)
    {
        originale.add(o);
    }

    /**
     * Setzt die Zeichenkoordinaten.
     *
     * @param faktorx Skalierungsfaktor in x-Richtung
     * @param faktory Skalierungsfaktor in y-Richtung
     * @param offsetx Versatz in x-Richtung
     * @param offsety Versatz in y-Richtung
     */
    void NeuBerechnen(int faktorx, int faktory, int offsetx, int offsety)
    {
        BAHNHOF bhf;
        bhf = b.Suchen(originale.get(0).Bahnhof1Geben());
        x1 = bhf.XGeben() * faktorx + offsetx;
        y1 = bhf.YGeben() * faktory + offsety;
        bhf = b.Suchen(originale.get(0).Bahnhof2Geben());
        x2 = bhf.XGeben() * faktorx + offsetx;
        y2 = bhf.YGeben() * faktory + offsety;
    }

    /**
     * Zeichnet den Linienabschnitt und die Beschriftung.
     *
     * @param g Zeichenobjekt zum Zeichnen der Komponente
     */
    void Zeichnen(Graphics g)
    {
        int xs, ys;
        String beschriftung;
        g.drawLine(x1, y1, x2, y2);
        beschriftung = "";
        for (int i = 0; i < originale.size(); i++)
        {
            if (i == 0)
            {
                beschriftung = beschriftung + originale.get(i).LinieGeben();
            }
            else
            {
                beschriftung = beschriftung + ", "
                        + originale.get(i).LinieGeben();
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
     * Bestimmt das Trefferrechteck für den Mausklick. Ersetzt durch
     * Trefferpolygon.
     *
     * @return Rechteck mit Breite 6 um die Linie
     */
    /*
     * Rectangle TrefferRechteckGeben () { if (x1 == x2) { return new Rectangle
     * (x1 - 3, Math. min (y1, y2), 6, Math. abs (y2 - y1)); } else if (y1 ==
     * y2) { return new Rectangle (Math. min (x1, x2), y1 - 3, Math. abs (x2 -
     * x1), 6); } return null; }
     */

    /**
     * Bestimmt das Trefferpolygon für den Mausklick.
     *
     * @return Rechteck mit Breite 6 um die Linie
     */
    Polygon TrefferRechteckGeben()
    {
        Polygon res;
        int xs, ys, len;
        res = new Polygon();
        xs = y2 - y1;
        ys = x1 - x2;
        len = (int) Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        xs = xs * 3 / len;
        ys = ys * 3 / len;
        res.addPoint(x1 + xs, y1 + ys);
        res.addPoint(x2 + xs, y2 + ys);
        res.addPoint(x2 - xs, y2 - ys);
        res.addPoint(x1 - xs, y1 - ys);
        return res;
    }

    /**
     * Meldet das Feld der Originale zurück.
     *
     * @return Originalabschnitte
     */
    ArrayList<ABSCHNITT> OriginaleGeben()
    {
        return originale;
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
