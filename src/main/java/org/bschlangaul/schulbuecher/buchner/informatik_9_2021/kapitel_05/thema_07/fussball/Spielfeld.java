package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_05.thema_07.fussball;

import greenfoot.World;

public class Spielfeld extends World
{
    Ball ball;

    Spieler spielerLinks;

    Spieler spielerRechts;

    public Spielfeld()
    {
        super(800, 500, 1);
        ball = new Ball("rechts", 10); // Aufgabe 1a)
        addObject(ball, 400, 250);
        spielerLinks = new Spieler(1, "Spieler_Blau.png");
        addObject(spielerLinks, 150, 250);
        spielerRechts = new Spieler(3, "Spieler_Rot.png");
        addObject(spielerRechts, 650, 250);
    }
}
