package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_06.thema_06.kunst_a1a;

import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.GreenfootImage;

/**
 * Write a description of class Zelle here.
 *
 * @author (your name)
 *
 * @version (a version number or a date)
 */
public class Zelle extends Actor
{
    static int zaehler = 0; // Some serious magic happening right here!

    int zahl;

    public Zelle()
    {
        zahl = zaehler;
        zaehler = zaehler + 1;
    }

    Color berechneFarbe()
    {
        while (zahl < 0)
        {
            zahl = zahl + 4;
        }
        switch (zahl % 4)
        {
        case 0:
            return Color.ORANGE;

        case 1:
            return Color.RED;

        case 2:
            return Color.BLUE;

        case 3:
            return Color.GREEN;

        default:
            return Color.BLACK;
        }
    }

    void speichereAufFestplatte(String dateiname)
    {
        Kunstwelt world = (Kunstwelt) getWorld();
        world.speichereAufFestplatte(dateiname);
    }

    void erstelleBild()
    {
        int cellSize;
        cellSize = getWorld().getCellSize();
        GreenfootImage img;
        img = new GreenfootImage(cellSize, cellSize);
        img.setColor(berechneFarbe());
        img.fillRect(0, 0, cellSize, cellSize);
        setImage(img);
    }
}
