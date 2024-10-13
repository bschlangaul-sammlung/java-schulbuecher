package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_03.thema_08.hotel_vorlage;

import greenfoot.*;

/**
 * Projekt 3-8_Hotel
 *
 * @author Wolfgang Riffelmacher
 *
 * @version 2022-09-12
 */
public class Gast extends Actor
{
    private String name;

    private boolean zufrieden;

    public Gast(String name, boolean zufrieden)
    {
        this.name = name;
        this.zufrieden = zufrieden;
    }

    public void setzeName(String nameNeu)
    {
        name = nameNeu;
    }

    public String nenneName()
    {
        return name;
    }

    public void unzufriedenWerden()
    {
        zufrieden = false;
    }

    public void zufriedenWerden()
    {
        zufrieden = true;
    }
}
