package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_06.thema_05.random_walk_a3;

import greenfoot.Greenfoot;
import greenfoot.World;

/**
 * Kompetenzerwerb Aufgabe 3
 */
public class Zufallsweg extends World
{
    public Zufallsweg()
    {
        super(199, 199, 3);
        gehe();
    }

    void gehe()
    {
        int x = 100;
        int y = 100;
        int t = 0;
        int zz;
        while (t < 3000)
        {
            faerbeZelle(x, y);
            zz = gibZufallszahl();
            if (zz <= 50)
            {
                x = x - 1;
            }
            else
            {
                x = x + 1;
            }
            zz = gibZufallszahl();
            if (zz <= 50)
            {
                y = y - 1;
            }
            else
            {
                y = y + 1;
            }
            t = t + 1;
            if (x < 0 || x > 199 || y < 0 || y > 199)
            {
                t = 3000;
            }
        }
    }

    /**
     * gibZufallsZahl() Liefert eine Zufallszahl zwischen 1 und 100
     */
    int gibZufallszahl()
    {
        return Greenfoot.getRandomNumber(100) + 1;
    }

    void faerbeZelle(int x, int y)
    {
        Zelle zelle = new Zelle();
        addObject(zelle, x, y);
        zelle.erstelleBild();
    }
}
