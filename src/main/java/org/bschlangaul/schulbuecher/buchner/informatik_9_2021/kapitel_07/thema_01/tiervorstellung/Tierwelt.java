package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_07.thema_01.tiervorstellung;

import greenfoot.World;

/**
 * Projekt zu 7.1 <br>
 *
 * Klasse Tierwelt <br>
 * Hier müssen die Objekte erzeugt und in die Welt eingefügt werden, um sichtbar
 * zu sein.
 */
public class Tierwelt extends World
{
    public Tierwelt()
    {
        super(10, 6, 60);
        // erzeugt ein Objekt der Klasse Tier und fügt es an der Stelle (1|1)
        // ein
        addObject(new Tier(), 1, 1);
        // erzeugt ein Objekt der Klasse Biene und fügt es an der Stelle (3|3)
        // ein
        addObject(new Biene(), 3, 3);
        // erzeugt ein Objekt der Klasse Eisbaer und fügt es an der Stelle (5|2)
        // ein
        addObject(new Eisbaer(), 5, 2);
    }
}
