package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_03.thema_01.simulation_vorlage;

import greenfoot.World;

/**
 * Projekt 3-1_Simulation
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
        addObject(new Auto(), 100, 100);
    }
}
