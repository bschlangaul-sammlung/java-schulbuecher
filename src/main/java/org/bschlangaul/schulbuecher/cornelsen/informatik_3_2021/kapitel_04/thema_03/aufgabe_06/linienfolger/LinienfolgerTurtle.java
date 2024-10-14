package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_03.aufgabe_06.linienfolger;

/**
 * Die Turtle folgt einer gegebenen Linie
 *
 * @author Franz Jetzinger
 *
 * @version 1.0
 */
class LinienfolgerTurtle extends Turtle
{
    /**
     * Legt die Position der Turtle fest
     */
    LinienfolgerTurtle()
    {
        super();
        PositionSetzen(0, 160);
        StiftHeben();
    }

    /**
     * Folgt der gegebenen Linie
     */
    void LinieFolgen()
    {
        while (!Berührt("blau"))
        {
            while (Berührt("schwarz"))
            {
                Gehen(1);
            }
            Drehen(90);
            Gehen(1);
        }
    }
}
