package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_03.thema_03.blumen_vorlage;

import greenfoot.Actor;

/**
 * Projekt 3-3_Blumen
 *
 * @author Wolfgang Riffelmacher
 *
 * @version 2022-09-12
 */
public class Sonnenblume extends Actor
{
    public void act()
    {
        wachsen();
        // Mögliche Bilder findest du im Projektordner!
    }

    public void wachsen()
    {
        this.turn(90);
        this.move(-2);
        this.turn(-90);
    }
}
