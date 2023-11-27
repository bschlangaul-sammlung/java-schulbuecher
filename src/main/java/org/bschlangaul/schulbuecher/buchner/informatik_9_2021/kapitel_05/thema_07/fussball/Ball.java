package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_05.thema_07.fussball;

import greenfoot.Actor;

public class Ball extends Actor
{
    String richtung = "";

    int geschwindigkeit;

    Ball()
    {
        setImage("ball.png");
        richtung = "links"; // A3a)
        geschwindigkeit = 10; // A3a)
    }

    Ball(String startRichtung, int startGeschwindigkeit) // Aufgabe 1a)
    {
        setImage("ball.png");
        richtung = startRichtung;
        geschwindigkeit = startGeschwindigkeit;
    }

    void zeigeBall() // zeigt das Bild des Balles an
    {
        setImage("ball.png");
    }

    /**
     * Der Programmtext an hier braucht für die Bearbeitung der Arbeitsaufträge
     * und Aufgaben weder gelesen noch verstanden zu werden.
     */
    void wechsleRichtung()
    {
        if (gibRichtung().equals("links") == true)
        {
            richtung = "rechts";
        }
        else
        {
            richtung = "links";
        }
    }

    public void act()
    {
        if (gibRichtung().equals("links") == true)
        {
            move(-geschwindigkeit);
            if (istLinksVonAllenSpielern() == true)
            {
                richtung = "rechts";
            }
        }
        else
        {
            move(geschwindigkeit);
            if (istRechtsVonAllenSpielern() == true)
            {
                richtung = "links";
            }
        }
    }

    boolean istLinksVonAllenSpielern()
    {
        for (Spieler s : getWorld().getObjects(Spieler.class))
        {
            if (s.getX() < this.getX())
            {
                return false;
            }
        }
        return true;
    }

    boolean istRechtsVonAllenSpielern()
    {
        for (Spieler s : getWorld().getObjects(Spieler.class))
        {
            if (s.getX() > this.getX())
            {
                return false;
            }
        }
        return true;
    }

    String gibRichtung()
    {
        return richtung;
    }

    int gibGeschwindigkeit()
    {
        return geschwindigkeit;
    }
}
