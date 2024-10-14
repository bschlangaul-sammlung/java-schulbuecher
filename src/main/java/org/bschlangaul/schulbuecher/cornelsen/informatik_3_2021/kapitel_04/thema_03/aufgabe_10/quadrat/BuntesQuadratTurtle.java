package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_03.aufgabe_10.quadrat;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Turtle;

/**
 * Beschreibt eine Turtle, die ein bunt umrandetes Quadrat zeichnet.
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class BuntesQuadratTurtle extends Turtle
{
    /**
     * Lässt die Turtle das bunte Quadrat zeichnen.
     */
    void FigurBuntZeichnen()
    {
        PositionSetzen(100, 200);
        while (XPositionGeben() < 400)
        {
            FarbeSetzen("schwarz");
            Gehen(5);
            FarbeSetzen("rot");
            Gehen(5);
        }
        Drehen(-90);
        while (YPositionGeben() < 500)
        {
            FarbeSetzen("schwarz");
            Gehen(5);
            FarbeSetzen("rot");
            Gehen(5);
        }
        Drehen(-90);
        while (XPositionGeben() > 100)
        {
            FarbeSetzen("schwarz");
            Gehen(5);
            FarbeSetzen("rot");
            Gehen(5);
        }
        Drehen(-90);
        while (YPositionGeben() > 200)
        {
            FarbeSetzen("schwarz");
            Gehen(5);
            FarbeSetzen("rot");
            Gehen(5);
        }
    }
}
