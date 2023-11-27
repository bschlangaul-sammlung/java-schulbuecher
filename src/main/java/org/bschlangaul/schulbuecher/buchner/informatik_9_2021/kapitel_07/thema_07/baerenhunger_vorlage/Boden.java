package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_07.thema_07.baerenhunger_vorlage;

import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.GreenfootImage;

/**
 * Klasse Boden <br>
 *
 * Der Boden ist am unteren Rad der Welt.
 */
public class Boden extends Actor
{
    Boden()
    {
        /*
         * Der Boden besteht aus einer blauen Leiste am unteren Rand de3r Welt.
         */
        GreenfootImage leiste = new GreenfootImage(800, 20);
        leiste.setColor(Color.BLUE);
        leiste.fill();
        setImage(leiste);
    }

    public void act()
    {
        removeTouching(Essen.class); // Wenn ein Objekt der Klasse Essen den
                                     // Boden beruehrt,
                                     // entferne es.
    }
}
