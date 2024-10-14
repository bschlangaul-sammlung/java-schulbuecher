package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_06.aufgabe_05.hausbau;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Dreieck;

/**
 * Erzeugt das Dreieck für das Dach des Hauses.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Dach extends Dreieck
{
    /**
     * Legt Position, Größe und Farbe fest
     */
    Dach()
    {
        super();
        PositionSetzen(90, 40);
        GrößeSetzen(140, 80);
        FarbeSetzen("rot");
    }
}
