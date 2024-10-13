package org.bschlangaul.schulbuecher.buchner.informatik_11_2023.kapitel_04.thema_03.qr_code;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse Pixel.
 *
 * @author H. Vogel
 *
 * @version v0.1 10.10.2022
 */
public class Pixel extends Actor
{
    GreenfootImage white, black, red, lightGray;

    MyWorld thisWorld;

    int isDark = -1;

    boolean clickable = false;

    public void act()
    {
        if (Greenfoot.mouseClicked(this) && clickable)
        {
            if (Greenfoot.getMouseInfo().getButton() == 1 && isDark < 1)
                setIsDark(1);
            else if (Greenfoot.getMouseInfo().getButton() == 3
                    && (isDark == -1 || isDark == 1))
                setIsDark(0);
            else
                setIsDark(-1);
        }
    }

    public Pixel(int _isDark, boolean _clickable, MyWorld _thisWorld,
            int pixelsize)
    {
        white = new GreenfootImage(pixelsize, pixelsize);
        white.setColor(Color.WHITE);
        white.fill();
        black = new GreenfootImage(pixelsize, pixelsize);
        black.setColor(Color.BLACK);
        black.fill();
        red = new GreenfootImage(pixelsize, pixelsize);
        red.setColor(Color.RED);
        red.fill();
        lightGray = new GreenfootImage(pixelsize, pixelsize);
        lightGray.setColor(Color.LIGHT_GRAY);
        lightGray.fill();
        isDark = _isDark;
        clickable = _clickable;
        thisWorld = _thisWorld;
        setImageByDarkness();
    }

    private void setImageByDarkness()
    {
        switch (isDark)
        {
        case -1:
            setImage(lightGray);
            break;

        case 1:
            setImage(black);
            break;

        case 0:
            setImage(white);
            break;
        }
    }

    public void flip()
    {
        if (isDark == 1)
            isDark = 0;
        else if (isDark == 0)
            isDark = 1;
        setImageByDarkness();
    }

    public void click()
    {
        if (clickable)
        {
            isDark++;
            if (isDark == 2)
                isDark = -1;
            setImageByDarkness();
        }
    }

    public void setIsDark(int _isDark)
    {
        isDark = _isDark;
        setImageByDarkness();
    }

    public void setIsClickable(boolean _clickable)
    {
        clickable = _clickable;
    }

    public void setWhite()
    {
        setImage(white);
        isDark = 0;
    }

    public void setBlack()
    {
        setImage(black);
        isDark = 1;
    }

    public void setGray()
    {
        setImage(lightGray);
        isDark = -1;
    }

    public int getInfo()
    {
        return isDark;
    }

    public void clear()
    {
        clickable = true;
        isDark = -1;
        setImageByDarkness();
    }
}
