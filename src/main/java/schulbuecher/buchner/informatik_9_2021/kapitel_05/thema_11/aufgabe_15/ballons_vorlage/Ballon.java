package schulbuecher.buchner.informatik_9_2021.kapitel_05.thema_11.aufgabe_15.ballons_vorlage;

import greenfoot.Actor;

/**
 * Projekt zu Kap. 5.10 Aufgabe 9 <br>
 * Teilaufgaben d), e)
 */
public class Ballon extends Actor
{
    public void act() // wird regelmäßig automatisch aufgerufen
    {
        steige();
    }

    void steige() // sorgt für die Bewegung der Ballons
    {
        if (getY() > 0) // wenn oberer Bildrand noch nicht erreicht ...
        {
            setLocation(this.getX(), this.getY() - 1); // ... dann bewege den
                                                       // Ballon um eine Zelle
                                                       // nach oben
        }
        else
        {
            getWorld().removeObject(this); // ... sonst entferne den Ballon
        }
    }
}
