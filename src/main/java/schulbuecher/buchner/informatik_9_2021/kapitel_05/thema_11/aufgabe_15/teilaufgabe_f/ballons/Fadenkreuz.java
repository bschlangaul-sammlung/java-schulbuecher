package schulbuecher.buchner.informatik_9_2021.kapitel_05.thema_11.aufgabe_15.teilaufgabe_f.ballons;

import greenfoot.Actor;
import greenfoot.Greenfoot;

/**
 * Projekt zu Kap. 5.10 Aufgabe 9 <br>
 * Der Programmtext dieser Klasse braucht für die Bearbeitung der
 * Arbeitsaufträge und Aufgaben weder gelesen noch verstanden zu werden.
 */
public class Fadenkreuz extends Actor
{
    Himmel meinHimmel;

    Fadenkreuz(Himmel himmel)
    {
        meinHimmel = himmel;
    }

    public void act()
    {
        if (Greenfoot.getMouseInfo() != null)
        {
            setLocation(Greenfoot.getMouseInfo().getX(),
                    Greenfoot.getMouseInfo().getY());
        }
    }
}
