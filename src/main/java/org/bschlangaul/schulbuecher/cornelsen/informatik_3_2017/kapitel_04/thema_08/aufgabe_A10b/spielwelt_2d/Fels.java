package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_08.aufgabe_A10b.spielwelt_2d;

import org.bschlangaul.schulbuecher.cornelsen.zeichen_flaeche.Figur;

/**
 * Fels - ein Hindernis, das Florian nicht überwinden kann
 *
 * @author Peter Brichzin
 *
 * @version 1.0
 */
class Fels extends Figur
{
    /**
     * Dieser Konstruktor erzeugt einen Fels bei der die Position wählbar ist.
     * Die Position ist KEINE Pixelangabe, sondern die Koordinaten in einer
     * 10x10 Zellen großen Welt.
     *
     * @param xNeu x-Position des Felses
     * @param yNeu y-Position des Felses
     */
    Fels(int xNeu, int yNeu)
    {
        super();
        FigurteilFestlegenEllipse(-20, -40, 50, 90, "grau");
        GanzNachVornBringen();
        if (xNeu < 10 && xNeu >= 0 && yNeu < 10 && yNeu >= 0)
        {
            PositionSetzen(xNeu * 50 + 25, yNeu * 50 + 25);
        }
        // Es macht keinen Sinn, dass ein Fels auf einer Blume oder einen Pilz
        // steht.
        // Sollte dies zufällig passieren, wird der Fels sofort wieder gelöscht.
        if (Berührt("rot") || Berührt("blau"))
        {
            Entfernen();
        }
    }
}
