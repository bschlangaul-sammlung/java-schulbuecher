package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_06.thema_05.random_walk_a1;

import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.GreenfootImage;

/**
 * Klasse Zelle <br>
 * Der Programmtext in dieser Klasse braucht für die Bearbeitung der Aufgaben
 * weder gelesen noch verstanden zu werden.
 */
public class Zelle extends Actor
{
    void erstelleBild()
    {
        int cellSize;
        cellSize = getWorld().getCellSize();
        GreenfootImage img = new GreenfootImage(cellSize, cellSize);
        img.setColor(Color.RED);
        img.fillRect(0, 0, cellSize, cellSize);
        setImage(img);
    }
}
