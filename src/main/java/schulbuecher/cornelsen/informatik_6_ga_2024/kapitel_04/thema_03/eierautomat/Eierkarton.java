package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_03.eierautomat;

import schulbuecher.cornelsen.shared.graphics_and_games.Rechteck;

/**
 * Eierkarton
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
class Eierkarton extends Rechteck
{

    /**
     * Legt das Aussehen des Kartons fest
     */
    Eierkarton()
    {
        GrößeSetzen(50, 15);
        FarbeSetzen("grün");
    }
}
