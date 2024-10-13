package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_02.aufgabe_06.spielwelt_2d;

/**
 * Blume, die darauf wartet gesammelt zu werden
 *
 * @author Peter Brichzin
 *
 * @version 1.0
 */
public class Blume extends Figur
{
    /**
     * Der Konstruktor1 erzeugt eine Blume an der Pixel-Position (225/125).
     */
    Blume()
    {
        super();
        this.FigurteilFestlegenEllipse(0, 0, 25, 25, "gelb");
        this.FigurteilFestlegenEllipse(0, -20, 20, 20, "weiss");
        this.FigurteilFestlegenEllipse(20, -10, 20, 20, "weiss");
        this.FigurteilFestlegenEllipse(20, 10, 20, 20, "weiss");
        this.FigurteilFestlegenEllipse(0, 20, 20, 20, "weiss");
        this.FigurteilFestlegenEllipse(-20, -10, 20, 20, "weiss");
        this.FigurteilFestlegenEllipse(-20, 10, 20, 20, "weiss");
        this.PositionSetzen(225, 125);
        this.GanzNachVornBringen();
    }

    /**
     * Der Konstruktor2 erzeugt eine Blume in einem Spielfeld mit 10x10 Zellen.
     *
     * @param xNeu x-Position der Blume
     * @param yNeu y-Position der Blume
     *
     */
    Blume(int xNeu, int yNeu)
    {
        super();
        this.FigurteilFestlegenEllipse(0, 0, 25, 25, "gelb");
        this.FigurteilFestlegenEllipse(0, -20, 20, 20, "weiss");
        this.FigurteilFestlegenEllipse(20, -10, 20, 20, "weiss");
        this.FigurteilFestlegenEllipse(20, 10, 20, 20, "weiss");
        this.FigurteilFestlegenEllipse(0, 20, 20, 20, "weiss");
        this.FigurteilFestlegenEllipse(-20, -10, 20, 20, "weiss");
        this.FigurteilFestlegenEllipse(-20, 10, 20, 20, "weiss");
        this.GanzNachVornBringen();
        if (xNeu < 10 && xNeu >= 0 && yNeu < 10 && yNeu >= 0)
        {
            this.PositionSetzen(xNeu * 50 + 25, yNeu * 50 + 25);
        }
    }
}
