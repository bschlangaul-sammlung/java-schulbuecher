package org.bschlangaul.schulbuecher.isb.handreichung_10_2008.konzept_01.petrus_16_mit_aufgaben;

import org.bschlangaul.schulbuecher.isb.handreichung_10_2008.konzept_01.ZeichenFenster;

public class Schneeflocke extends Niederschlag
{
    public Schneeflocke(int xStart, int yStart)
    {
        super(xStart, yStart);
        vx = 1;
        vy = 3;
    }

    public void zeichne()
    {
        ZeichenFenster.gibFenster().fuelleKreis((int) x, (int) y, 20, 6);
    }

    public void bewege(double zeit)
    {
        if (y < Niederschlag.gibBoden())
        {
            super.bewege(zeit);
        }
    }
}
