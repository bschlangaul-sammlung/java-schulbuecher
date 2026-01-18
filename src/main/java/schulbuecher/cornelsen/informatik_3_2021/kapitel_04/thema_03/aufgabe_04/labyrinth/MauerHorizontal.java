package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_03.aufgabe_04.labyrinth;

import schulbuecher.cornelsen.shared.graphics_and_games.Rechteck;

/**
 * Eine horizontale Mauer
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class MauerHorizontal extends Rechteck
{
    /**
     * Konstruktor
     *
     * @param x 0&lt;=x&lt;=15
     * @param y 0&lt;=y&lt;=9
     * @param breite x+breite &lt;=15
     */
    MauerHorizontal(int x, int y, int breite)
    {
        super();
        PositionSetzen(x * 50 + 15 - 1, y * 50 + 20 - 1);
        GrößeSetzen(breite * 50 + 2, 2);
        FarbeSetzen("schwarz");
    }
}
