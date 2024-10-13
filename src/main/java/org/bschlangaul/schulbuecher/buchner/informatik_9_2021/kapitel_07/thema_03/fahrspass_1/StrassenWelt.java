package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_07.thema_03.fahrspass_1;

import greenfoot.World;

/**
 * Projekt zu Kap. 7.3. <br>
 *
 * Klasse StrassenWelt <br>
 * Der Programmtext dieser Klasse braucht für die Bearbeitung der
 * Arbeitsaufträge und Aufgaben weder gelesen noch verstanden zu werden.
 */
public class StrassenWelt extends World
{
    public StrassenWelt()
    {
        super(1000, 400, 1);
        Fahrrad fahrrad1 = new Fahrrad();
        addObject(fahrrad1, 129, 162);
        Fahrrad fahrrad2 = new Fahrrad();
        addObject(fahrrad2, 241, 84);
        Fahrrad fahrrad3 = new Fahrrad();
        addObject(fahrrad3, 197, 266);
        PKW pkw1 = new PKW();
        addObject(pkw1, 334, 253);
        PKW pkw2 = new PKW();
        addObject(pkw2, 342, 184);
        PKW pkw3 = new PKW();
        addObject(pkw3, 77, 36);
    }
}
