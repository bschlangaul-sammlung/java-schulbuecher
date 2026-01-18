package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_02.aufgabe_03.geo_turtle;

import schulbuecher.cornelsen.shared.graphics_and_games.Turtle;

/**
 * Ergänzt die Turtle um Methoden zum Zeichnen geometrischer Figuren
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class GeoTurtle extends Turtle
{
    /**
     * Zeichnet ein Rechteck mit fester Breite und Höhe
     */
    void RechteckZeichnen()
    {
        Gehen(100);
        Drehen(90);
        Gehen(30);
        Drehen(90);
        Gehen(100);
        Drehen(90);
        Gehen(30);
        Drehen(90);
    }

    /**
     * Zeichnet ein Rechteck mit angebbarer Breite und Höhe
     *
     * @param breite Breite des Rechtecks
     * @param höhe Höhe des Rechtecks
     */
    void RechteckZeichnen(int breite, int höhe)
    {
        Gehen(breite);
        Drehen(90);
        Gehen(höhe);
        Drehen(90);
        Gehen(breite);
        Drehen(90);
        Gehen(höhe);
        Drehen(90);
    }

    /**
     * Zeichnet ein Rechteck mit angebbarer Breite, Höhe und Farbe
     *
     * @param breite Breite des Rechtecks
     * @param höhe Höhe des Rechtecks
     * @param farbe Farbe des Rechtecks
     */
    void RechteckZeichnen(int breite, int höhe, String farbe)
    {
        FarbeSetzen(farbe);
        Gehen(breite);
        Drehen(90);
        Gehen(höhe);
        Drehen(90);
        Gehen(breite);
        Drehen(90);
        Gehen(höhe);
        Drehen(90);
        FarbeSetzen("schwarz");
    }

    /**
     * Zeichnet ein gleichseitiges Dreieck mit angebbarer Seitenlänge und Farbe
     *
     * @param länge Seitenlänge des Dreiecks
     * @param farbe Farbe des Dreiecks
     */
    void GleichseitigesDreieckZeichnen(int länge, String farbe)
    {
        FarbeSetzen(farbe);
        Gehen(länge);
        Drehen(120);
        Gehen(länge);
        Drehen(120);
        Gehen(länge);
        Drehen(120);
        FarbeSetzen("schwarz");
    }

    /**
     * Zeichnet ein Parallelogramms mit angebbarer Breite, Höhe, Winkel und
     * Farbe
     *
     * @param breite Breite des Parallelogramms
     * @param höhe Höhe des Parallelogramms
     * @param alpha Winkel bei A
     * @param farbe Farbe des Parallelogramms
     */
    void ParallelogrammZeichnen(int breite, int höhe, int alpha, String farbe)
    {
        FarbeSetzen(farbe);
        Gehen(breite);
        Drehen(alpha);
        Gehen(höhe);
        Drehen(180 - alpha);
        Gehen(breite);
        Drehen(alpha);
        Gehen(höhe);
        Drehen(180 - alpha);
        FarbeSetzen("schwarz");
    }

    public static void main(String[] args)
    {
        GeoTurtle turtle = new GeoTurtle();
        turtle.RechteckZeichnen();
    }
}
