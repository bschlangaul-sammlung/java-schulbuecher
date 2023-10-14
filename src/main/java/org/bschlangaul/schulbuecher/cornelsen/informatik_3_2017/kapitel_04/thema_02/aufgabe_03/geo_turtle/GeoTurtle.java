package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_02.aufgabe_03.geo_turtle;

/**
 * Ergänzt die Turtle um Methoden zum Zeichnen geometrischer Figuren
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
class GeoTurtle extends Turtle
{

    /**
     * Zeichnet ein Rechteck mit fester Breite und Höhe
     */
    void RechteckZeichnen()
    {
        this.Gehen(100);
        this.Drehen(90);
        this.Gehen(30);
        this.Drehen(90);
        this.Gehen(100);
        this.Drehen(90);
        this.Gehen(30);
        this.Drehen(90);
    }

    /**
     * Zeichnet ein Rechteck mit angebbarer Breite und Höhe
     *
     * @param breite Breite des Rechtecks
     * @param höhe Höhe des Rechtecks
     */
    void RechteckZeichnen(int breite, int höhe)
    {
        this.Gehen(breite);
        this.Drehen(90);
        this.Gehen(höhe);
        this.Drehen(90);
        this.Gehen(breite);
        this.Drehen(90);
        this.Gehen(höhe);
        this.Drehen(90);
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
        this.FarbeSetzen(farbe);
        this.Gehen(breite);
        this.Drehen(90);
        this.Gehen(höhe);
        this.Drehen(90);
        this.Gehen(breite);
        this.Drehen(90);
        this.Gehen(höhe);
        this.Drehen(90);
        this.FarbeSetzen("schwarz");
    }

    /**
     * Zeichnet ein gleichseitiges Dreieck mit angebbarer Seitenlänge und Farbe
     *
     * @param länge Seitenlänge des Dreiecks
     * @param farbe Farbe des Dreiecks
     */
    void GleichseitigesDreieckZeichnen(int länge, String farbe)
    {
        this.FarbeSetzen(farbe);
        this.Gehen(länge);
        this.Drehen(120);
        this.Gehen(länge);
        this.Drehen(120);
        this.Gehen(länge);
        this.Drehen(120);
        this.FarbeSetzen("schwarz");
    }

    /**
     * Zeichnet ein Parallelogramms mit angebbarer Breite, Höhe, Winkel und Farbe
     *
     * @param breite Breite des Parallelogramms
     * @param höhe Höhe des Parallelogramms
     * @param alpha Winkel bei A
     * @param farbe Farbe des Parallelogramms
     */
    void ParallelogrammZeichnen(int breite, int höhe, int alpha, String farbe)
    {
        this.FarbeSetzen(farbe);
        this.Gehen(breite);
        this.Drehen(alpha);
        this.Gehen(höhe);
        this.Drehen(180 - alpha);
        this.Gehen(breite);
        this.Drehen(alpha);
        this.Gehen(höhe);
        this.Drehen(180 - alpha);
        this.FarbeSetzen("schwarz");
    }
}
