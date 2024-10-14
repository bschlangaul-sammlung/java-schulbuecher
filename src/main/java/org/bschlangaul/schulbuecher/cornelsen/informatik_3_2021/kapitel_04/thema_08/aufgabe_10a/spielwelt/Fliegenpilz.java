package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_08.aufgabe_10a.spielwelt;

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
    void AktionAusführen()
    {
        GepflücktWerden();
    }
}
