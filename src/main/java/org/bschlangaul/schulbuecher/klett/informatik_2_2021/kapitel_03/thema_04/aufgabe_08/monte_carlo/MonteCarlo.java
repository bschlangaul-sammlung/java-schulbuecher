package org.bschlangaul.schulbuecher.klett.informatik_2_2021.kapitel_03.thema_04.aufgabe_08.monte_carlo;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import org.bschlangaul.schulbuecher.klett.shared.figures.Canvas;

class MonteCarlo
{
    double xPosition;

    double yPosition;

    String farbe;

    int linienstaerke;

    int winkel;

    boolean istAbgesetzt;

    MonteCarlo()
    {
        xPosition = 0;
        yPosition = 0;
        farbe = "schwarz";
        linienstaerke = 2;
        winkel = 0;
        istAbgesetzt = true;
    }

    // Platz für Programmcode der Aufgaben.

    // Vorgegebene Methoden:
    void absetzen()
    {
        istAbgesetzt = true;
    }

    void anheben()
    {
        istAbgesetzt = false;
    }

    void rechtsDrehen(int grad)
    {
        winkel = (winkel - grad + 360) % 360;
    }

    void linksDrehen(int grad)
    {
        winkel = (winkel + grad) % 360;
    }

    void winkelSetzen(int grad)
    {
        winkel = grad;
    }

    void positionSetzen(double x, double y)
    {
        anheben();
        xPosition = x;
        yPosition = y;
        absetzen();
    }

    /**
     * @param f Mögliche Werte für Farben sind rot, schwarz, blau, gelb, grün,
     *     weiss oder magenta.
     */
    void farbeSetzen(String f)
    {
        if (f == "rot" || f == "blau" || f == "gelb" || f == "grün"
                || f == "weiss" || f == "magenta")
        {
            farbe = f;
        }
        else
        {
            farbe = "schwarz";
        }
    }

    void linienstaerkeSetzen(int d)
    {
        if (d < 2)
        {
            linienstaerke = 2;
            System.out.println("Die Linienstärke muss mindestens 2 betragen.");
        }
        else
        {
            linienstaerke = d;
        }
    }

    double xPositionGeben()
    {
        return xPosition;
    }

    double yPositionGeben()
    {
        return yPosition;
    }

    String farbeGeben()
    {
        return farbe;
    }

    int linienstaerkeGeben()
    {
        return linienstaerke;
    }

    int winkelGeben()
    {
        return winkel;
    }

    boolean istAbgesetztGeben()
    {
        return istAbgesetzt;
    }

    void vorwaerts(int laenge)
    {
        if (istAbgesetzt)
        {
            Canvas canvas = Canvas.getCanvas();
            double neuX = xPosition;
            double neuY = yPosition;
            for (int i = 0; i < laenge; i++)
            {
                canvas.draw(this, farbe, new Ellipse2D.Double(neuX, neuY,
                        linienstaerke, linienstaerke));
                canvas.wait(3);
                neuX = neuX + Math.cos(winkel * Math.PI / 180);
                neuY = neuY - Math.sin(winkel * Math.PI / 180);
            }
        }
        xPosition = Math
                .round(xPosition + Math.cos(winkel * Math.PI / 180) * laenge);
        yPosition = Math
                .round(yPosition - Math.sin(winkel * Math.PI / 180) * laenge);
    }

    void auswischen()
    {
        Canvas canvas = Canvas.getCanvas();
        canvas.draw(this, "weiss", new Rectangle2D.Double(0, 0, 200, 200));
    }
}
