package org.bschlangaul.schulbuecher.klett.informatik_2_2021.kapitel_06.thema_03.aufgabe_02.flaggen_der_erde_iii;

import java.awt.geom.Rectangle2D;

import org.bschlangaul.schulbuecher.klett.shared.figures.Canvas;

class Rechteck
{
    int linksObenX;

    int linksObenY;

    int laenge;

    int breite;

    String farbe;

    /**
     * @param f Mögliche Werte für Farben sind rot, schwarz, blau, gelb, grün,
     *     weiss oder magenta.
     */
    Rechteck(int loX, int loY, int l, int b, String f)
    {
        linksObenX = loX;
        linksObenY = loY;
        laenge = l;
        breite = b;
        farbe = f;
        zeichnen();
    }

    void größeSetzen(int laengeNeu, int breiteNeu)
    {
        laenge = laengeNeu;
        breite = breiteNeu;
    }

    void eckeLinksObenSetzen(int linksObenXneu, int linksObenYneu)
    {
        linksObenX = linksObenXneu;
        linksObenY = linksObenYneu;
    }

    void verschieben(int dx, int dy)
    {
        linksObenX = linksObenX + dx;
        linksObenY = linksObenY + dy;
    }

    // Vorgegebene Methoden:
    void zeichnen()
    {
        Canvas canvas = Canvas.getCanvas();
        canvas.draw(this, farbe,
                new Rectangle2D.Double(linksObenX, linksObenY, laenge, breite));
        canvas.wait(10);
    }

    void auswischen()
    {
        Canvas canvas = Canvas.getCanvas();
        canvas.draw(this, "weiss", new Rectangle2D.Double(0, 0, 800, 600));
    }
}
