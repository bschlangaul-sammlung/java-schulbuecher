package schulbuecher.buchner.informatik_9_2021.kapitel_05.thema_04.hasenjagd;

import greenfoot.Actor;
import greenfoot.Greenfoot;

/**
 * Klasse Hase <br>
 * Kap. 5.2 Arbeitsaufträge 1-4, Aufgabe 1
 */
public class Hase extends Actor
{
    void geheNachRechts() // bewegt den Hasen um eine Zelle nach rechts
    {
        setRotation(0);
        move(1);
        setRotation(0);
    }

    void geheNachLinks() // bewegt den Hasen um eine Zelle nach links
    {
        setRotation(180);
        move(1);
        setRotation(0);
    }

    void geheNachOben() // bewegt den Hasen um eine Zelle nach oben
    {
        setRotation(270);
        move(1);
        setRotation(0);
    }

    void geheNachUnten() // bewegt den Hasen um eine Zelle nach unten
    {
        setRotation(90);
        move(1);
        setRotation(0);
    }

    /*
     * Der Programmtext ab hier braucht für die Bearbeitung der Arbeitsaufträge
     * und Aufgaben weder gelesen noch verstanden zu werden.
     */
    Hase() // erzeugt einen Hasen
    {
        setImage("Hase.png");
    }

    public void act() // realsiert die Möglichkeit den Hasen mithilfe der
                      // Pfeiltasten zu bewegen
    {
        if (Greenfoot.isKeyDown("left"))
        {
            geheNachLinks();
        }
        if (Greenfoot.isKeyDown("right"))
        {
            geheNachRechts();
        }
        if (Greenfoot.isKeyDown("up"))
        {
            geheNachOben();
        }
        if (Greenfoot.isKeyDown("down"))
        {
            geheNachUnten();
        }
    }
}
