package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_05.aufgabe_00.einstieg;

/**
 * Klasse Quadrat
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Quadrat extends Hindernis
{
    /**
     * Legt das Aussehen und die Startposition fest
     *
     * @param x x-Koordinate des Hindernisses
     * @param y y-Koordinate des Hindernisses
     * @param richtungNeu Blickrichtung des Hindernisses
     */
    Quadrat(int x, int y, char richtungNeu)
    {
        super(x, y, richtungNeu);
        Zeichnen();
    }

    /**
     * Lässt das Hindernis um 20 Einheiten gehen
     */
    @Override
    void Bewegen()
    {
        Gehen(20);
        EntfernenWennAußerhalb();
    }

    /**
     * Legt Form und Größe des Hindernisses fest
     */
    @Override
    void Zeichnen()
    {
        super.EigeneFigurLöschen();
        FigurteilFestlegenRechteck(-50, -50, 100, 100, "magenta");
        FigurteilFestlegenRechteck(-40, -40, 80, 80, "hellgrün");
        FigurteilFestlegenRechteck(-30, -30, 60, 60, "gelb");
        FigurteilFestlegenRechteck(-20, -20, 40, 40, "blau");
        FigurteilFestlegenRechteck(-10, -10, 20, 20, "orange");
    }
}
