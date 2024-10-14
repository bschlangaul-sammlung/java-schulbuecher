package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_02.aufgabe_00.einstieg;

/**
 * Lasercutter-Turtle mit mehr Methoden
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class LasercutterTurtle extends Turtle
{
    /**
     * Zeichnet ein reguläres Sechseck mit 50 Einheiten Kantenlänge
     */
    void SechseckZeichnen()
    {
        this.Gehen(50);
        this.Drehen(60);
        this.Gehen(50);
        this.Drehen(60);
        this.Gehen(50);
        this.Drehen(60);
        this.Gehen(50);
        this.Drehen(60);
        this.Gehen(50);
        this.Drehen(60);
        this.Gehen(50);
        this.Drehen(60);
    }

    /**
     * Zeichnet ein reguläres Sechseck mit angebbarer Kantenlänge
     */
    void SechseckZeichnen(int kantenlänge)
    {
        this.Gehen(kantenlänge);
        this.Drehen(60);
        this.Gehen(kantenlänge);
        this.Drehen(60);
        this.Gehen(kantenlänge);
        this.Drehen(60);
        this.Gehen(kantenlänge);
        this.Drehen(60);
        this.Gehen(kantenlänge);
        this.Drehen(60);
        this.Gehen(kantenlänge);
        this.Drehen(60);
    }

    /**
     * Zeichnet ein Rechteck mit 100 Einheiten Breite und 50 Einheiten Höhe
     */
    void RechteckZeichnen()
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
     * Zeichnet einen 5-eckigen Stern
     */
    void SternZeichnen()
    {
        this.Gehen(100);
        this.Drehen(-144);
        this.Gehen(100);
        this.Drehen(-144);
        this.Gehen(100);
        this.Drehen(-144);
        this.Gehen(100);
        this.Drehen(-144);
        this.Gehen(100);
        this.Drehen(-144);
    }
}
