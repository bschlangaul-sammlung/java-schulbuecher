package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_02.aufgabe_02.motten;

/**
 * "Bessere" Turtle, die ein Haus zeichnen kann.
 *
 * @author Olga
 *
 * @version 1.0
 */
class HausbauTurtle extends Turtle
{
    /**
     * Zeichnet ein Quadrat mit Seitenlänge 50
     */
    void QuadratZeichnen()
    {
        this.Gehen(100);
        this.Drehen(90);
        this.Gehen(50);
        this.Drehen(90);
        this.Gehen(100);
        this.Drehen(90);
        this.Gehen(50);
        this.Drehen(90);
    }

    /**
     * Zeichnet ein gleichseitiges Dreieck mit beliebiger Größe
     *
     * @param s Seitenlänge
     */
    void DreieckZeichnen(int s)
    {
        this.Gehen(s);
        this.Drehen(120);
        this.Gehen(s);
        this.Drehen(120);
        this.Gehen(s);
        this.Drehen(120);
    }

    /**
     * Baut ein Haus aus einem Quadrat und einem Dreieck
     */
    void HausZeichnen()
    {
        this.QuadratZeichnen();
        this.Drehen(90);
        this.Gehen(50);
        this.Drehen(-90);
        this.DreieckZeichnen(100);
    }
}
