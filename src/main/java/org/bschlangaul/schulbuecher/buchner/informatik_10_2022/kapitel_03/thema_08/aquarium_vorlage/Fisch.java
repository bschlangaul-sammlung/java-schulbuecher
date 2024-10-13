package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_03.thema_08.aquarium_vorlage;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Projekt 3-8_Aquarium
 *
 * @author Wolfgang Riffelmacher
 *
 * @version 2022-09-12
 */
public class Fisch extends Actor
{
    private String name;

    private String art;

    private boolean tarnung;

    public Fisch(String name, String art)
    {
        this.name = name;
        this.art = art;
        this.tarnung = false;
    }

    public String nenneName()
    {
        return name;
    }

    public void setzeName(String nameNeu)
    {
        name = nameNeu;
    }

    public String nenneArt()
    {
        return art;
    }

    public boolean unterHai()
    {
        return isTouching(Hai.class);
    }

    public void act()
    {
    }
}
