package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_03.thema_05.caesar_vorlage;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Projekt 3-5_Caesar
 *
 * @author André Greubel
 *
 * @version 2022-09-21
 */
public class SchluesselAnzeige extends Actor
{
    private int schluessel = 3;

    private KryptoWorld world;

    public SchluesselAnzeige(KryptoWorld w, int initSchluessel)
    {
        world = w;
        setSchluessel(initSchluessel);
    }

    public int gibSchluessel()
    {
        return schluessel;
    }

    public void setSchluessel(int nr)
    {
        while (nr < 0)
        {
            nr = nr + 26;
        }
        if (nr >= 26)
        {
            nr = nr % 26; // Rest bei Teilen mit 26 (Schlüssel 3 == 29)
        }
        schluessel = nr;
        update();
    }

    public void act()
    {
        setSchluessel(schluessel + 1);
    }

    public void update()
    {
        setImage(createImage());
        world.update();
    }

    private GreenfootImage createImage()
    {
        GreenfootImage img = new GreenfootImage(80, 150);
        img.setColor(Color.LIGHT_GRAY);
        img.fillRect(0, 0, 150, 100);
        img.setFont(new Font("Courier", false, false, 60));
        if (schluessel == 0)
        {
            img.setColor(Color.GREEN);
            img.drawString("---", 5, 75);
        }
        else
        {
            img.setColor(Color.BLUE);
            img.drawString(schluessel + "", 5, 75);
        }
        return img;
    }
}
