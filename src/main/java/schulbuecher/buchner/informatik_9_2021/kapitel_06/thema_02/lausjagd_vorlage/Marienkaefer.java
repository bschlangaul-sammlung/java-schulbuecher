package schulbuecher.buchner.informatik_9_2021.kapitel_06.thema_02.lausjagd_vorlage;

import greenfoot.Actor;
import greenfoot.Greenfoot;

/**
 * Klasse Marienkäfer <br>
 * Enthält unter anderem die Steuerung des Merienkäfer-Objekts. <br>
 */
public class Marienkaefer extends Actor
{
    Spielwelt welt;

    Marienkaefer(Spielwelt neueWelt)
    {
        welt = neueWelt;
    }
    // Kap. 6.8 Aufgabe 2

    void dreheNachRechts()
    {
        setRotation(getRotation() + 5);
    }

    void dreheNachLinks()
    {
        setRotation(getRotation() - 5);
    }

    void geheNachVorne()
    {
        move(3);
    }

    /**
     * Der Programmtext ab hier braucht für die Bearbeitung der Arbeitsaufträge
     * und Aufgaben weder gelesen noch verstanden zu werden.
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("left"))
        {
            dreheNachLinks();
        }
        if (Greenfoot.isKeyDown("right"))
        {
            dreheNachRechts();
        }
        if (Greenfoot.isKeyDown("up"))
        {
            geheNachVorne();
        }
        if (getX() < 100)
        {
            setLocation(100, getY());
        }
        if (getX() > 700)
        {
            setLocation(700, getY());
        }
        if (isTouching(Blattlaus.class))
        {
            this.removeTouching(Blattlaus.class);
            welt.anzahlGefresseneLaeuse = welt.anzahlGefresseneLaeuse + 1;
        }
    }
}
