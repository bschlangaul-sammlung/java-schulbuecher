package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_03.aufgabe_00.einstieg;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Rechteck;

/**
 * Der Zaum als Hindernis.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class ZaunSued extends Rechteck
{
    /**
     * Plaziert den Zaun
     */
    ZaunSued()
    {
        super();
        FarbeSetzen("braun");
        PositionSetzen(0, 490);
        GrößeSetzen(600, 10);
    }
}
