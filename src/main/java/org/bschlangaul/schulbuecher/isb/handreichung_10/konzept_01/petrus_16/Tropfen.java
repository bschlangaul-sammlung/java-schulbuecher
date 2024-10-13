package org.bschlangaul.schulbuecher.isb.handreichung_10.konzept_01.petrus_16;

import org.bschlangaul.schulbuecher.isb.handreichung_10.konzept_01.ZeichenFenster;

public class Tropfen extends Niederschlag
{
    private int radius;

    private Wolke meineWolke;

    public Tropfen(double xStart, double yStart, int rStart, Wolke w)
    {
        super(xStart, yStart);
        radius = rStart;
        meineWolke = w;
    }

    public void zeichne()
    {
        ZeichenFenster.gibFenster().fuelleKreis((int) x, (int) y, radius, 1);
    }

    public void bewege(double zeit)
    {
        if (y < Niederschlag.gibBoden())
        {
            super.bewege(zeit);
        }
        else
        {
            meineWolke.entferne(this);
        }
    }
}
