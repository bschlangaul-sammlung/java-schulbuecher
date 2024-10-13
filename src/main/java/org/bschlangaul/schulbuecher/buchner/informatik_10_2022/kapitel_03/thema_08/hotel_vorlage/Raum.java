package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_03.thema_08.hotel_vorlage;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse Raum.
 *
 * @author (Ihr Name)
 *
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Raum extends Actor
{
    private int raumnr;

    private boolean sauber;

    public Raum(int raumnr, boolean sauber)
    {
        this.raumnr = raumnr;
        this.sauber = sauber;
    }

    public boolean istSauber()
    {
        return sauber;
    }
}
