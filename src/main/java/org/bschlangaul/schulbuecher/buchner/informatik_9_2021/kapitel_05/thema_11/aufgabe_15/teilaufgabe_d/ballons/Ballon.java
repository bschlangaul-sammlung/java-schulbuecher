package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_05.thema_11.aufgabe_15.teilaufgabe_d.ballons;

import greenfoot.Actor;

/**
 * Projekt zu Kap. 5.11 Aufgabe 15 <br>
 * Teilaufgaben d), e)
 */
public class Ballon extends Actor
{
    int wind = 1; // Aufgabe 15 d)

    public void act() // wird regelmäßig automatisch aufgerufen
    {
        steige();
    }

    void steige() // sorgt für die Bewegung der Ballons
    {
        if (getY() > 0) // wenn oberer Bildrand noch nicht erreicht ...
        {
            setLocation(this.getX() + wind, this.getY() - 1); // ... dann bewege
                                                              // den Ballon um
                                                              // eine
                                                              // Zelle nach oben
                                                              // Aufgabe 15 d):
                                                              // ... und um eine
                                                              // Zelle nach
                                                              // rechts
        }
        else
        {
            getWorld().removeObject(this); // ... sonst entferne den Ballon
        }
    }
}
