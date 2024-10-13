package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_07.aufgabe_10.spielwelt_2d;

/**
 * Fliegenpilz, der darauf wartet gesammelt zu werden
 *
 * @author Peter Brichzin
 *
 * @version 1.0
 */
public class Fliegenpilz extends Figur
{
    /**
     * Dieser Konstruktor erzeugt einen Fliegenpilz an der Pixel-Position
     * (325/125).
     */
    Fliegenpilz()
    {
        super();
        FigurteilFestlegenRechteck(-10, 10, 20, 40, "weiss");
        FigurteilFestlegenEllipse(-45, -10, 90, 30, "rot");
        PositionSetzen(325, 125);
        GanzNachVornBringen();
    }

    /**
     * Dieser Konstruktor erzeugt einen Fliegenpilz bei dem die Position wählbar
     * ist. Die Position ist KEINE Pixelangabe, sondern die Koordinaten in einer
     * 10x10 Zellen großen Welt.
     *
     * @param xNeu x-Position des Fliegenpilzes
     * @param yNeu y-Position des Fliegenpilzes
     */
    Fliegenpilz(int xNeu, int yNeu)
    {
        super();
        FigurteilFestlegenRechteck(-10, 10, 20, 40, "weiss");
        FigurteilFestlegenEllipse(-45, -10, 90, 30, "rot");
        PositionSetzen(325, 125);
        GanzNachVornBringen();
        if (xNeu < 10 && xNeu >= 0 && yNeu < 10 && yNeu >= 0)
        {
            PositionSetzen(xNeu * 50 + 25, yNeu * 50 + 25);
        }
    }

    /**
     * Der Fliegenpilz verschwindet, wenn er berührt wurde.
     */
    void GepflücktWerden()
    {
        if (Berührt("orange"))
        {
            Entfernen();
        }
    }

    /**
     * Aktion zur Überprüfung des Gepflücktwerdens
     */
    @Override
    void AktionAusführen()
    {
        GepflücktWerden();
    }
}
