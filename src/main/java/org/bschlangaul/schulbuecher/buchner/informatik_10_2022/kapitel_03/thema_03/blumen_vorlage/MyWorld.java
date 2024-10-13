package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_03.thema_03.blumen_vorlage;

import greenfoot.World;

/**
 * Projekt 3-3_Blumen
 *
 * @author Wolfgang Riffelmacher
 *
 * @version 2022-09-12
 */
public class MyWorld extends World
{
    public MyWorld()
    {
        super(1000, 600, 1);
        addObject(new Sonnenblume(), 300, 400);
    }

    public void bluehen()
    {
        addObject(new Sonnenblume(), 350, 400);
    }
}
