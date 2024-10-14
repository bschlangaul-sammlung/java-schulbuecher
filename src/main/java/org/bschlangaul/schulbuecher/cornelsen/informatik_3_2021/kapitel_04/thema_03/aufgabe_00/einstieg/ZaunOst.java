package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_03.aufgabe_00.einstieg;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Rechteck;

/**
 * Der Zaum als Hindernis.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class ZaunOst extends Rechteck
{
    /**
     * Plaziert den Zaun
     */
    ZaunOst()
    {
        super();
        FarbeSetzen("braun");
        PositionSetzen(590, 0);
        GrößeSetzen(10, 500);
    }
}
