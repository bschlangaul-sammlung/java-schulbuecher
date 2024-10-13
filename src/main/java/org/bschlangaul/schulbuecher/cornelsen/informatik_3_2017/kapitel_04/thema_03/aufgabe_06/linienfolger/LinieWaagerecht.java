package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_03.aufgabe_06.linienfolger;

/**
 * Ertellt eine waagrechte Line.
 *
 * @author Franz Jetzinger
 *
 * @version 1.0
 */
class LinieWaagerecht extends Rechteck
{
    /**
     * Setzt Größe und Position der Linie, negative Längen werden korrigiert
     *
     * @param x x-Positon der Linie
     * @param y y-Positon der Linie
     * @param laenge Länge der Linie
     * @param breite Breite der Linie
     */
    LinieWaagerecht(int x, int y, int laenge, int breite)
    {
        super();
        if (laenge < 0)
        {
            laenge = laenge * (-1);
            x = x - laenge + breite;
        }
        PositionSetzen(x, y);
        GrößeSetzen(laenge, breite);
        FarbeSetzen("schwarz");
    }
}
