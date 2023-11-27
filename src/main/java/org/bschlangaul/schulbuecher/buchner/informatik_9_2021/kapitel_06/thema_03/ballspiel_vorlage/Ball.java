package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_06.thema_03.ballspiel_vorlage;

import greenfoot.Actor;

/**
 * Klasse Ball <br>
 *
 * Kap. 6.3 Arbeitsauftrag 2
 */
public class Ball extends Actor
{
    int radius = 13;

    int dx;

    int dy;

    Ball()
    {
        dx = 3;
        dy = 2;
        setzeAnStartposition();
    }

    public void act()
    {
        // Kapitel 6-3 Arbeitsauftrag 2
        bewege(dx, dy);
    }
    /*
     * Die folgenden Methoden können zur Lösung der Aufgaben verwendet werden.
     * Dazu sollten die Kommentare ausreichend sein, ihre genaue Arbeitsweise
     * muss nicht verstanden werden.
     */

    void bewege(int dx, int dy) // bewegt den Ball um dx in waagrechter und dy
                                // in senkrechter
                                // Richtung
    {
        setLocation(getX() + dx, getY() + dy);
    }

    void setzeAnStartposition() // setzt den Ball in die Zelle mit den
                                // Koordianten (300|200)
    {
        setLocation(300, 200);
    }

    boolean beruehrtSchlaeger() // liefert true, wenn der Ball einen Schläger
                                // berührt
    {
        return isTouching(Schlaeger.class);
    }

    boolean beruehrtWandOben() // liefert true, wenn der Ball den oberen Rand
                               // der Welt berührt
    {
        return getY() < radius;
    }

    boolean beruehrtWandLinks() // liefert true, wenn der Ball den linken Rand
                                // der Welt berührt
    {
        return getX() < radius;
    }

    boolean beruehrtWandUnten() // liefert true, wenn der Ball den unteren Rand
                                // der Welt berührt
    {
        return getY() > getWorld().getHeight() - radius;
    }

    boolean beruehrtWandRechts() // liefert true, wenn der Ball den rechten Rand
                                 // der Welt berührt
    {
        return getX() > getWorld().getWidth() - radius;
    }
}
