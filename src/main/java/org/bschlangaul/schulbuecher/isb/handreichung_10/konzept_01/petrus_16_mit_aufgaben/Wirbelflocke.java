package org.bschlangaul.schulbuecher.isb.handreichung_10.konzept_01.petrus_16_mit_aufgaben;

import java.util.Random;

public class Wirbelflocke extends Schneeflocke
{
    private Random zufall;

    /**
     * Constructor for objects of class WIRBELFLOCKE
     */
    public Wirbelflocke(int xStart, int yStart)
    {
        // initialise instance variables
        super(xStart, yStart);
        zufall = new Random();
    }

    public void bewege(double zeit)
    {
        vx = vx + (zufall.nextFloat() - 0.5) * 20;
        vy = vy + (zufall.nextFloat() - 0.5) * 20;
        if (vy < 0)
        {
            vy = 0;
        }
        // vx = (zufall.nextFloat()-0.5)*30;
        // vy = zufall.nextFloat()*10;
        super.bewege(zeit);
    }
}
