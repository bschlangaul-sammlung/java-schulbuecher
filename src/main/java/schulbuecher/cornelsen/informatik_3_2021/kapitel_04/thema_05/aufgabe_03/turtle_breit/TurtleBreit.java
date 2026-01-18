package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_05.aufgabe_03.turtle_breit;

import schulbuecher.cornelsen.shared.graphics_and_games.Turtle;

/**
 * Turtle für breite Linien.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class TurtleBreit extends Turtle
{
    /**
     * Bewegt die Turtle nach vorne. Die gezeichnete Linie ist 3 Einheiten breit
     *
     * @param länge Anzahl der Längeneinheiten
     */
    @Override
    public void Gehen(double länge)
    {
        super.Gehen(länge);
        this.Drehen(90);
        super.Gehen(1);
        this.Drehen(90);
        super.Gehen(länge);
        this.Drehen(90);
        super.Gehen(2);
        this.Drehen(90);
        super.Gehen(länge);
        this.Drehen(90);
        super.Gehen(1);
        this.Drehen(-90);
    }
}
