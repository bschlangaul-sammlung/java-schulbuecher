package org.bschlangaul.schulbuecher.isb.handreichung_10.konzept_01.petrus_16_mit_aufgaben;

import java.util.Random;

public class Nebeltropfen extends Tropfen
{
    private Random zufall;

    public Nebeltropfen(double xStart, double yStart, int rStart, Wolke w)
    {
        super(xStart, yStart, rStart, w);
        vx = 0;
        vy = 0;
        zufall = new Random();
    }

    public void bewege(double zeit)
    {
        if (zufall.nextFloat() < zeit)
        {
            radius = radius - 1;
        }
        if (radius <= 0)
        {
            meineWolke.entferne(this);
        }
    }
}
