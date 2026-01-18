package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_03.aufgabe_00.einstieg;

import schulbuecher.cornelsen.shared.graphics_and_games.Rechteck;

/**
 * Der Zaum als Hindernis.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class ZaunNord extends Rechteck
{
    /**
     * Plaziert den Zaun
     */
    ZaunNord()
    {
        super();
        FarbeSetzen("braun");
        PositionSetzen(0, 0);
        GrößeSetzen(600, 10);
    }
}
