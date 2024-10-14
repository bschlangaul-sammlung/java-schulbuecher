package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_03.aufgabe_05.rennate;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Turtle;

/**
 * Beschreibt eine Turtle, die auf einer Verkehrsinsel lebt.
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class TurtleRennate extends Turtle
{
    /**
     * Lässt die Turtle eine Rechtskurve laufen.
     */
    void RechtskurveLaufen()
    {
        Gehen(10);
        Drehen(-10);
    }

    /**
     * Lässt die Turtle eine Linkskurve laufen.
     */
    void LinkskurveLaufen()
    {
        Gehen(10);
        Drehen(5);
    }

    /**
     * Lässt die Turtle auf der Verkehrsinsel spazieren gehen.
     */
    void SpazierenGehen()
    {
        while (true)
        {
            while (Berührt("grau") && !Berührt("grün") && !Berührt("rot"))
            {
                RechtskurveLaufen();
            }
            while (Berührt("grün") && !Berührt("rot"))
            {
                Gehen(1);
            }
            while (Berührt("rot"))
            {
                LinkskurveLaufen();
            }
        }
    }
}
