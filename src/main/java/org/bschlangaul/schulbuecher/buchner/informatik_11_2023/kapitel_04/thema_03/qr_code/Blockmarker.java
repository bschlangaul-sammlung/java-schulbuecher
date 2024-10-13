package org.bschlangaul.schulbuecher.buchner.informatik_11_2023.kapitel_04.thema_03.qr_code;

import greenfoot.Actor;

public class Blockmarker extends Actor
{
    int timer = 0;

    Blockmarker()
    {
        setImage("blockmarker.png");
    }

    /**
     * Act - tut, was auch immer Blockmarker tun will. Diese Methode wird
     * aufgerufen, sobald der 'Act' oder 'Run' Button in der Umgebung angeklickt
     * werden.
     */
    public void act()
    {
        if (timer > 0)
            timer--;
        if (timer == 0)
        {
            setImage("blockmarker.png");
            timer = -1;
        }
    }

    public void show()
    {
        setImage("blockmarkerb.png");
        timer = 500;
    }
}
