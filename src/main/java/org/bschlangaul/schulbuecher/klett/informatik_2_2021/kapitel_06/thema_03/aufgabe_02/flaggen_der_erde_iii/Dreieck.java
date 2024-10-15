package org.bschlangaul.schulbuecher.klett.informatik_2_2021.kapitel_06.thema_03.aufgabe_02.flaggen_der_erde_iii;

import java.awt.Polygon;
import java.awt.geom.Rectangle2D;

import org.bschlangaul.schulbuecher.klett.shared.figures.Canvas;

class Dreieck
{
    int eckeAx;

    int eckeAy;

    int eckeBx;

    int eckeBy;

    int eckeCx;

    int eckeCy;

    String farbe;

    /**
     * @param f Mögliche Werte für Farben sind rot, schwarz, blau, gelb, grün,
     *     weiss oder magenta.
     */
    Dreieck(int ax, int ay, int bx, int by, int cx, int cy, String f)
    {
        eckeAx = ax;
        eckeAy = ay;
        eckeBx = bx;
        eckeBy = by;
        eckeCx = cx;
        eckeCy = cy;
        farbe = f;
        zeichnen();
    }

    void eckeSetzen(char ecke, int x, int y)
    {
        auswischen();
        if (ecke == 'A')
        {
            eckeAx = x;
            eckeAy = y;
        }
        else if (ecke == 'B')
        {
            eckeBx = x;
            eckeBy = y;
        }
        else if (ecke == 'C')
        {
            eckeCx = x;
            eckeCy = y;
        }
        zeichnen();
    }

    void nachRechtsBewegen()
    {

    }

    // Vorgegebene Methoden:
    void zeichnen()
    {
        Canvas canvas = Canvas.getCanvas();
        int[] xpoints = { eckeAx, eckeBx, eckeCx };
        int[] ypoints = { eckeAy, eckeBy, eckeCy };
        canvas.draw(this, farbe, new Polygon(xpoints, ypoints, 3));
        canvas.wait(10);
    }

    void auswischen()
    {
        Canvas canvas = Canvas.getCanvas();
        canvas.draw(this, "weiss", new Rectangle2D.Double(0, 0, 800, 600));
    }
}
