package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_03.thema_01.simulation_vorlage;

import greenfoot.Actor;

/**
 * Projekt 3-1_Simulation
 *
 * @author Wolfgang Riffelmacher
 *
 * @version 2022-09-12
 */
@SuppressWarnings("unused")
public class Auto extends Actor
{
    private int gang;

    private int ps;

    private String farbe;

    public Auto(String farbe, int ps)
    {
        this.farbe = farbe;
        this.ps = ps;
    }

    public Auto()
    {
        farbe = "blau";
        gang = 1;
        ps = 163;
    }

    public void act()
    {
        anfahren();
    }

    public void anfahren()
    {
        move(gang);
        if (this.isAtEdge())
        {
            getY();
            setLocation(10, getY());
            if (gang <= 6)
            {
                gang = gang + 1;
            }
        }
    }

    public void fahren()
    {
        // Aufgaben 1
    }
}
