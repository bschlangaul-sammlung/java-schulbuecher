package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_05.aufgabe_03.turtle_breit;

/**
 * Turtle für breite Linien.
 *
 * @author Albert Wiedemann
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
    void Gehen(double länge)
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
