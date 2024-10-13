package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_07.thema_03.fahrspass_2;

import greenfoot.Actor;

/**
 * Klasse Fahrzeug <br>
 *
 * Kap. 7.3 Arbeitsauftrag 3, Aufgabe 1
 */
public class Fahrzeug extends Actor
{
    int hoechstgeschwindigkeit;

    String farbe;

    // Alter Konstruktor muss deaktiviert sein
    /*
     * public Fahrzeug() { farbe = "schwarz"; }
     */
    /*
     * Kap. 7.3 Aufgabe 1d - der andere Konstruktor muss durch diesen ersetzt
     * werden, um den angesprochenen Fehler zu erzeugen.
     */
    public Fahrzeug(String startfarbe)
    {
        farbe = startfarbe;
    }

    void gibLaut()
    {
    }

    public void act()
    {
        fahre();
    }

    void fahre()
    {
    }
}
