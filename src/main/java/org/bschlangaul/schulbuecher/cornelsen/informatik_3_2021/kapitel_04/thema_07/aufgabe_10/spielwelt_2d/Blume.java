package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_07.aufgabe_10.spielwelt_2d;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Figur;

/**
 * Blume, die darauf wartet gesammelt zu werden
 *
 * @author Peter Brichzin
 *
 * @version 1.0
 */
class Blume extends Figur
{
    /**
     * Dieser Konstruktor erzeugt eine Blume an der Pixel-Position (225/125).
     */
    Blume()
    {
        super();
        FigurteilFestlegenEllipse(0, 0, 25, 25, "gelb");
        FigurteilFestlegenEllipse(0, -20, 20, 20, "blau");
        FigurteilFestlegenEllipse(20, -10, 20, 20, "blau");
        FigurteilFestlegenEllipse(20, 10, 20, 20, "blau");
        FigurteilFestlegenEllipse(0, 20, 20, 20, "blau");
        FigurteilFestlegenEllipse(-20, -10, 20, 20, "blau");
        FigurteilFestlegenEllipse(-20, 10, 20, 20, "blau");
        PositionSetzen(225, 125);
        GanzNachVornBringen();
    }

    /**
     * Dieser Konstruktor erzeugt eine Blume bei der die Position wählbar ist.
     * Die Position ist KEINE Pixelangabe, sondern die Koordinaten in einer
     * 10x10 Zellen großen Welt.
     *
     * @param xNeu x-Position der Blume
     * @param yNeu y-Position der Blume
     */
    Blume(int xNeu, int yNeu)
    {
        super();
        FigurteilFestlegenEllipse(0, 0, 25, 25, "gelb");
        FigurteilFestlegenEllipse(0, -20, 20, 20, "blau");
        FigurteilFestlegenEllipse(20, -10, 20, 20, "blau");
        FigurteilFestlegenEllipse(20, 10, 20, 20, "blau");
        FigurteilFestlegenEllipse(0, 20, 20, 20, "blau");
        FigurteilFestlegenEllipse(-20, -10, 20, 20, "blau");
        FigurteilFestlegenEllipse(-20, 10, 20, 20, "blau");
        GanzNachVornBringen();
        if (xNeu < 10 && xNeu >= 0 && yNeu < 10 && yNeu >= 0)
        {
            PositionSetzen(xNeu * 50 + 25, yNeu * 50 + 25);
        }
        else
        {
            System.out.println(
                    "Die Koordinaten liegen außerhalb der Welt. Bitte Positionen im Bereichs [0;10] eingeben!");
        }
    }

    /**
     * Die Blume verschwindet, wenn sie gepflückt wurde.
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
    public void AktionAusführen()
    {
        GepflücktWerden();
    }
}
