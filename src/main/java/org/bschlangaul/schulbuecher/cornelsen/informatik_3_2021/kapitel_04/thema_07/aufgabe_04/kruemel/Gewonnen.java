package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_07.aufgabe_04.kruemel;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Text;

/**
 * Stellt den Gewinntext dar
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Gewonnen extends Text
{
    /**
     * Legt Position und Text fest
     */
    Gewonnen()
    {
        super();
        TextSetzen("Du hast das Spiel gewonnen");
        PositionSetzen(10, 20);
    }
}
