package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_07.thema_05.licht_vorlage;

import greenfoot.World;

/**
 * Projekt zu Kap. 7.5 <br>
 *
 * Aufgaben 1-3
 */
public class Welt extends World
{
    Dauerlicht dauerlicht;

    Blinklicht blinklicht;

    Kurzzeitlicht kurzzeitlicht;

    public Welt()
    {
        super(600, 400, 1);
        dauerlicht = new Dauerlicht();
        addObject(dauerlicht, 100, 100);
        blinklicht = new Blinklicht();
        addObject(blinklicht, 300, 100);
        kurzzeitlicht = new Kurzzeitlicht();
        addObject(kurzzeitlicht, 500, 100);
    }
}
