package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_03.thema_08.schweineputzen_vorlage;

import greenfoot.*;

/**
 * Projekt 3-8_Schweineputzen
 *
 * @author Ulrich Schneider
 * @version 2022-09-12
 */

public class Schwein extends Actor
{
    private boolean dreckig;

    // Zwei Greenfoot-Bilder des Schweins in sauber und dreckig
    private GreenfootImage Schweindreckig;
    private GreenfootImage Schweinsauber;

    public Schwein()
    {
        Schweindreckig = new GreenfootImage("pig.png");
        Schweinsauber = new GreenfootImage("pig2.png");
        dreckig = true;
        setImage(Schweindreckig);
    }

    public void act()
    {
        // Aufgabe c: Schweine rennen gerne herum und wälzen sich im Matsch

    }

    public void herumRennen()
    {
        // Bewegen
        move(1);
        // Wenn Schein am Rand der Welt angekommen, um 180 Grad drehen
        if (isAtEdge())
        {
            turn(180);
        }
        // Zufallszahl zwischen 0 und 100 erzeugen
        // Wenn diese Zufallszahl kleiner als 10 ist dreht sich das Schwein
        // um einen zufällig erzeugten Winkel zwischen -45 und 45 Grad
        if (Greenfoot.getRandomNumber(100) < 10)
        {
            turn(Greenfoot.getRandomNumber(90) - 45);
        }
    }

    public void putzen()
    {
        // Variable dreckig auf falsch setzen
        dreckig = false;
        // Image wechseln von dreckig auf sauber
        setImage(Schweinsauber);
    }


    public boolean gibDreckig()
    {
        return dreckig;
    }

    public void imMatschWaelzen()
    {
        // Wenn Matsch vorhanden, dann drin wälzen
        if (isTouching(Matsch.class) && !dreckig)
        {
            // Variable dreckig auf true setzen
            dreckig = true;
            // Image wechseln von sauber auf dreckig
            setImage(Schweindreckig);
            // System.out.println("Schwein wälzt sich im Matsch!");
        }
    }
}
