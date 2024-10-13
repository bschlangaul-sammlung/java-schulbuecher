package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_07.thema_07.baerenhunger_vorlage;

import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;

/**
 * Projekt zu 7.7 Aufgabe 11
 */
public class Baerenwelt extends World
{
    Baer baer;

    Boden boden;

    /*
     * Erzeugt die Welt, färbt den Hintergrund und platziert ein Bären-Objekt
     * unten in die Mitte.
     */
    public Baerenwelt()
    {
        super(800, 600, 1);
        /* erzeugt den Hintergrund und färbt ihn vollstaendig türkis */
        GreenfootImage hintergrund = getBackground();
        hintergrund.setColor(Color.CYAN);
        hintergrund.fill();
        /* erzeugt den Boden am unteren Rand der Welt */
        boden = new Boden();
        int bodenHoehe = boden.getImage().getHeight();
        addObject(boden, 400, 600 - bodenHoehe / 2);
        /* erzeugt den Bären und platziert ihn mittig oberhalb des Bodens */
        baer = new Baer();
        int baerHoehe = baer.getImage().getHeight();
        addObject(baer, 400, 600 - bodenHoehe - baerHoehe / 2);
    }

    public void act()
    {
        erzeugeMitWahrscheinlichkeit(0.01, new Essen()); // erzeugt mit der
                                                         // Wahrscheinlichkeit
                                                         // 0,01
                                                         // ein Essen-Objekt
    }

    /*
     * Erzeugt mit Wahrscheinlichkeit p (zwischen 0 und 1) den angegebenen
     * Akteur.
     */
    void erzeugeMitWahrscheinlichkeit(double p, Actor akteur)
    {
        double zufallszahl = Math.random();
        if (zufallszahl <= p)
        {
            platziereZufaellig(akteur);
        }
    }

    /*
     * Platziert das Objekt gegenstand an zufälliger Stelle am oberen Rand der
     * Welt.
     */
    void platziereZufaellig(Actor gegenstand)
    {
        int x = 50 + Greenfoot.getRandomNumber(700); // zwischen 50 und 749
        int y = Greenfoot.getRandomNumber(50); // zwischen 0 und 49
        addObject(gegenstand, x, y); // platziert das Objekt gegenstand an der
                                     // Stelle (x|y)
    }
}
