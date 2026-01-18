package schulbuecher.buchner.informatik_9_2021.kapitel_05.thema_06.tanz;

import greenfoot.World;

/**
 * Projekt zu Kap. 5.6 <br>
 * Der Programmtext dieser Klasse braucht für die Bearbeitung der
 * Arbeitsaufträge und Aufgaben weder gelesen noch verstanden zu werden.
 */
public class Tanzflaeche extends World
{
    public Tanzflaeche()
    {
        super(800, 600, 1);
        int i = 0;
        while (i < 8)
        {
            Taenzer t = new Taenzer(i);
            addObject(t, 50 + i * 100, 50);
            i = i + 1;
        }
    }
}
