package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_05.aufgabe_00.einstieg;

/**
 * Klasse Schlagbaum
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Schlagbaum extends Hindernis
{
    /**
     * Legt das Aussehen und die Startposition fest
     *
     * @param x x-Koordinate des Hindernisses
     * @param y y-Koordinate des Hindernisses
     * @param richtungNeu Blickrichtung des Hindernisses
     */
    Schlagbaum(int x, int y, char richtungNeu)
    {
        super(x, y, richtungNeu);
        Zeichnen();
        RichtungSetzen(richtungNeu);
        PositionSetzen(x, y);
    }

    /**
     * Lässt das Hindernis um 5 Einheiten gehen
     */
    @Override
    void Bewegen()
    {
        Gehen(5);
        EntfernenWennAußerhalb();
    }

    /**
     * Legt Form und Größe des Hindernisses fest
     */
    @Override
    void Zeichnen()
    {
        EigeneFigurLöschen();
        int i;
        i = 0;
        while (i < 5)
        {
            FigurteilFestlegenRechteck(i * 20 - 50, -5, 10, 10, "rot");
            FigurteilFestlegenRechteck(10 + i * 20 - 50, -5, 10, 10, "weiß");
            GrößeSetzen(100);
            i = i + 1;
        }
    }
}
