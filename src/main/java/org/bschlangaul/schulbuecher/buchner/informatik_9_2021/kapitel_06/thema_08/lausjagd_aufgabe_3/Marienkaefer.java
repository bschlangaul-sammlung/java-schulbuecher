package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_06.thema_08.lausjagd_aufgabe_3;

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
    // 2a
    void dreheUm90GradNachRechts()
    {
        int i = 0;
        while (i < 18)
        {
            dreheNachRechts();
            i = i + 1;
        }
    }

    void dreheUm90GradNachLinks()
    {
        int i = 0;
        while (i < 18)
        {
            dreheNachLinks();
            i = i + 1;
        }
    }

    // 2b
    void geheZumOberenBildschrimrand()
    {
        while (getY() > 0)
        {
            geheNachVorne();
        }
    }

    // 3a
    void geheQuadrat()
    {
        int i = 0;
        while (i < 4)
        {
            int j = 0;
            while (j < 100)
            {
                geheNachVorne();
                j = j + 1;
                Greenfoot.delay(2);
            }
            dreheUm90GradNachRechts();
            i = i + 1;
        }
    }

    // 3b
    void laufe300Schritte()
    {
        int i = 0;
        while (i < 100)
        {
            geheNachVorne();
            if (getX() > 500)
            {
                dreheUm90GradNachLinks();
                dreheUm90GradNachLinks();
            }
            Greenfoot.delay(2);
            i = i + 1;
        }
    }

    // 3c
    void laufe1000Schritte()
    {
        int i = 0;
        while (i < 333)
        {
            geheNachVorne();
            if (getX() > 500 || getX() < 200)
            {
                dreheUm90GradNachLinks();
                dreheUm90GradNachLinks();
            }
            Greenfoot.delay(2);
            i = i + 1;
        }
    }

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
