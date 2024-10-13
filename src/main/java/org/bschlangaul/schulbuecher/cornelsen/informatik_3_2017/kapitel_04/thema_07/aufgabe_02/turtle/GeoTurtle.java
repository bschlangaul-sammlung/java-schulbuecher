package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_07.aufgabe_02.turtle;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Turtle;

/**
 * Turtle mit Geometriekenntnissen.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class GeoTurtle extends Turtle
{
    /**
     * Zeichnet ein Sechseck
     */
    void Sechseck()
    {
        for (int zähler = 1; zähler <= 6; zähler = zähler + 1)
        {
            Gehen(100);
            Drehen(60);
        }
    }

    /**
     * Zeichnet ein Achteck
     */
    void Achteck()
    {
        for (int zähler = 1; zähler <= 8; zähler = zähler + 1)
        {
            Gehen(75);
            Drehen(45);
        }
    }

    /**
     * Zeichnet ein Hundertzwanzigeck
     */
    void Hundertzwanzigeck()
    {
        for (int zähler = 1; zähler <= 120; zähler = zähler + 1)
        {
            Gehen(5);
            Drehen(3);
        }
    }

    public static void main(String[] args)
    {
        GeoTurtle turtle = new GeoTurtle();
        turtle.Sechseck();
        turtle.Achteck();
        turtle.Hundertzwanzigeck();
    }
}
