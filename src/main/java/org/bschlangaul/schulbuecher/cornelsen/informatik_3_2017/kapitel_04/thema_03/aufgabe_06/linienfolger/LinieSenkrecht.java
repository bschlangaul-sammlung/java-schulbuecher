package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_03.aufgabe_06.linienfolger;

/**
 * Ertellt eine senkrechte Line.
 *
 * @author Franz Jetzinger
 *
 * @version 1.0
 */
class LinieSenkrecht extends Rechteck
{
    /**
     * Setzt Größe und Position der Linie, negative Längen werden korrigiert
     *
     * @param x x-Positon der Linie
     * @param y y-Positon der Linie
     * @param laenge Länge der Linie
     * @param breite Breite der Linie
     */
    LinieSenkrecht(int x, int y, int laenge, int breite)
    {
        super();
        if (laenge < 0)
        {
            y = y - (laenge * (-1)) + breite;
            laenge = -laenge;
        }
        PositionSetzen(x, y);
        GrößeSetzen(breite, laenge);
        FarbeSetzen("schwarz");
    }
}
