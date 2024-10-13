package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_03.aufgabe_10.quadrat;

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
