package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_03.thema_08.hotel_vorlage;

import greenfoot.Actor;

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
