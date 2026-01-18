package schulbuecher.buchner.informatik_9_2021.kapitel_05.thema_04.hasenjagd;

import greenfoot.Color;
import greenfoot.GreenfootImage;
import greenfoot.World;

/**
 * Projekt zu Kap. 5.2 Der Programmtext in dieser Klasse braucht für die
 * Bearbeitung der Arbeitsaufträge und Aufgaben weder gelesen noch verstanden zu
 * werden.
 */
public class SpielWelt extends World
{
    public SpielWelt()
    {
        super(20, 10, 64);
        GreenfootImage back = getBackground();
        back.setColor(Color.GREEN.darker());
        back.fill();
        for (int i = 0; i < 20; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                Gitter g = new Gitter();
                addObject(g, i, j);
            }
        }
        Hase hase = new Hase();
        addObject(hase, 15, 6);
        Fuchs fuchs = new Fuchs(hase);
        addObject(fuchs, 5, 3);
    }
}
