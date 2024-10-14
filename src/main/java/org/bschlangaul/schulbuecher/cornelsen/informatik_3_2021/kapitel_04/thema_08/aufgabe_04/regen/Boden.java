package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_08.aufgabe_04.regen;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Rechteck;

/**
 * Stellt den Boden dar.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Boden extends Rechteck
{
    /**
     * Setzt Position, Größe und Farbe
     */
    Boden()
    {
        super();
        GrößeSetzen(800, 5);
        FarbeSetzen("schwarz");
        PositionSetzen(0, 516);
    }
}
