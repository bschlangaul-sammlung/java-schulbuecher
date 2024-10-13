package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_05.thema_07.fussball;

import greenfoot.Actor;

public class Spieler extends Actor
{
    int geschwindigkeit;

    Spieler(int startGeschwindigkeit, String bild)
    {
        // geschwindigkeit = startGeschwindigkeit; // A3b)
        setzeStartwerte(startGeschwindigkeit, bild); // Aufgabe 1b)
        // Todo: Vervollständige die Methode
    }

    Spieler(String bild) // Aufgabe 1c)
    {
        setzeStartwerte(7, bild);
    }

    void setzeStartwerte(int startGeschwindigkeit, String bild) // Aufgabe 1b)
    {
        setImage(bild);
        geschwindigkeit = startGeschwindigkeit;
    }

    /**
     * Der Programmtext an hier braucht für die Bearbeitung der Arbeitsaufträge
     * und Aufgaben weder gelesen noch verstanden zu werden.
     */
    public void act()
    {
        Ball ball = getWorld().getObjects(Ball.class).get(0);
        if (ball.gibGeschwindigkeit() == 0)
        {
            return;
        }
        if (ball.gibRichtung().equals("links"))
        {
            move(geschwindigkeit);
        }
        else
        {
            move(-geschwindigkeit);
        }
    }
}
