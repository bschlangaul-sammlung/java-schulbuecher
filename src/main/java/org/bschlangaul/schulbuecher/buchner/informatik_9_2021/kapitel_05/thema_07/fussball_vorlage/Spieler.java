package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_05.thema_07.fussball_vorlage;

import greenfoot.Actor;

public class Spieler extends Actor
{
    int geschwindigkeit;

    Spieler(int startGeschwindigkeit, String bild)
    {
        setImage(bild);
        // Todo: Vervollständige die Methode
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
