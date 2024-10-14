package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_08.aufgabe_05.kruemel;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Text;

/**
 * Sellt den Verlusttext dar
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Verloren extends Text
{
    /**
     * Legt Position und Text fest
     */
    Verloren()
    {
        super();
        TextSetzen("Du hast verloren");
        PositionSetzen(700, 20);
    }
}
