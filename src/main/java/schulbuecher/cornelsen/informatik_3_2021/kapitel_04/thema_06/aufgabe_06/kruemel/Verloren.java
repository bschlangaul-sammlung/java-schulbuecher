package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_06.aufgabe_06.kruemel;

import schulbuecher.cornelsen.shared.graphics_and_games.Text;

/**
 * Stellt den Verlusttext dar
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
