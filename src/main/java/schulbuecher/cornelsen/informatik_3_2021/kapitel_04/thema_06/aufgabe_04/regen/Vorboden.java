package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_06.aufgabe_04.regen;

import schulbuecher.cornelsen.shared.graphics_and_games.Rechteck;

/**
 * Simuliert die Information, dass der Boden gleich erreicht ist.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Vorboden extends Rechteck
{
    /**
     * Setzt Position, Größe und Farbe
     */
    Vorboden()
    {
        super();
        GrößeSetzen(800, 15);
        FarbeSetzen("weiß");
        PositionSetzen(0, 501);
    }
}
