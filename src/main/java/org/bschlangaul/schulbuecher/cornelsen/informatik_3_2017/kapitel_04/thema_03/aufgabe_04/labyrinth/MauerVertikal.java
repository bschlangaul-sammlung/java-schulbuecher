package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_03.aufgabe_04.labyrinth;

/**
 * Eine vertikale Mauer
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class MauerVertikal extends Rechteck
{
    /**
     * Konstruktor
     *
     * @param x 0&lt;=x&lt;=15
     * @param y 0&lt;=y&lt;=9
     * @param höhe x+höhe &lt;=9
     */
    MauerVertikal(int x, int y, int höhe)
    {
        super();
        PositionSetzen(x * 50 + 15 - 1, y * 50 + 20 - 1);
        GrößeSetzen(2, 2 + höhe * 50);
        FarbeSetzen("schwarz");
    }
}
