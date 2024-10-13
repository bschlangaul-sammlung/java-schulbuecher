package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_05.aufgabe_05c.tastatur_turtle;

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
    void SonderTasteGedrückt(int taste)
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

    /**
     * Die Aktionsmethode für einen Mausklick. <br>
     * Setz die Turtle an die Position der Maus.
     *
     * @param x x-Position des Mausklicks
     * @param y y-Position des Mausklicks
     * @param anzahl Anzahl der aufeinanderfolgenden Mausklicks
     */
    @Override
    void MausGeklickt(int x, int y, int anzahl)
    {
        PositionSetzen(x, y);
    }
}
