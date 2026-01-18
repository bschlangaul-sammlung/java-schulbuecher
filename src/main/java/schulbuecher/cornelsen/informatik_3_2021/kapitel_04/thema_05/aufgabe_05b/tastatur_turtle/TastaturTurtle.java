package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_05.aufgabe_05b.tastatur_turtle;

import schulbuecher.cornelsen.shared.graphics_and_games.Turtle;

/**
 * Durch die Tastatur gesteuerte Turtle
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class TastaturTurtle extends Turtle
{
    /**
     * Die Methode für gedrückte Sondertasten.
     *
     * @param taste KeyCode der gedrückten Taste
     */
    @Override
    public void SonderTasteGedrückt(int taste)
    {
        if (taste == 37)
        {
            Drehen(90);
        }
        else
        {
            if (taste == 38)
            {
                Gehen(10);
            }
            else
            {
                if (taste == 39)
                {
                    Drehen(-90);
                }
                else
                {
                    if (taste == 40)
                    {
                        Drehen(180);
                    }
                }
            }
        }
    }
}
