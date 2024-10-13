package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_08.aufgabe_A10b.spielwelt_2d;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Figur;

/**
 * Fliegenpilz, der darauf wartet gesammelt zu werden
 *
 * @author Peter Brichzin
 *
 * @version 1.0
 */
class Fliegenpilz extends Figur
{
    /**
     * Der Konstruktor erzeugt die Form.
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
     * Der Konstruktor erzeugt die Form und setzt die Psoition.
     *
     * @param xNeu x-Position des Pilzes
     * @param yNeu y-Position des Pilzes
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
     * Prüfen auf Berührung
     */
    @Override
    public void AktionAusführen()
    {
        GepflücktWerden();
    }
}
