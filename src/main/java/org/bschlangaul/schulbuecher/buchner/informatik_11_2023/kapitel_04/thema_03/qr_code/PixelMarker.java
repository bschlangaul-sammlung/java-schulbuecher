package org.bschlangaul.schulbuecher.buchner.informatik_11_2023.kapitel_04.thema_03.qr_code;

import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.GreenfootImage;

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse PixelMarker.
 *
 * @author H. Vogel
 *
 * @version v0.1 10.10.2022
 */
public class PixelMarker extends Actor
{
    GreenfootImage red;

    MyWorld thisWorld;

    boolean run = false;

    int i = 0;

    int speed = 0;

    public void act()
    {
    }

    public PixelMarker(MyWorld _thisWorld, int pixelsize)
    {
        red = new GreenfootImage(pixelsize, pixelsize);
        red.setColor(Color.RED);
        red.fill();
        thisWorld = _thisWorld;
        setImage(red);
        setVisible(false);
    }

    public void setVisible(boolean visible)
    {
        if (visible)
            getImage().setTransparency(255);
        else
            getImage().setTransparency(0);
    }
}
