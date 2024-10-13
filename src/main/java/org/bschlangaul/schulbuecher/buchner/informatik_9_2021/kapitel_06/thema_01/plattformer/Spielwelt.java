package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_06.thema_01.plattformer;

import greenfoot.World;

/**
 * Projekt zu Kap. 6.1
 * <p>
 * Der Programmtext in dieser Klasse braucht für die Bearbeitung der
 * Arbeitsaufträge und Aufgaben weder gelesen noch verstanden zu werden.
 */
public class Spielwelt extends World
{
    public Spielwelt()
    {
        super(900, 200, 1);
        Spielfigur figur = new Spielfigur();
        addObject(figur, 24, 155);
        addObject(new Boden(), 0, 185);
        addObject(new Boden(), 50, 185);
        addObject(new Boden(), 150, 185);
        addObject(new Boden(), 200, 185);
        addObject(new Boden(), 300, 185);
        addObject(new Boden(), 350, 185);
        addObject(new Boden(), 400, 185);
        addObject(new Boden(), 550, 185);
        addObject(new Boden(), 600, 185);
        addObject(new Boden(), 780, 185);
        addObject(new Boden(), 830, 185);
        addObject(new Boden(), 880, 185);
        addObject(new Auftriebzone(), 500, 150);
        addObject(new Auftriebzone(), 700, 150);
    }
}
