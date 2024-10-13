package org.bschlangaul.schulbuecher.isb.handreichung_10.konzept_01.petrus_16_mit_aufgaben;

import org.bschlangaul.schulbuecher.isb.handreichung_10.konzept_01.ZeichenFenster;

public class Luftblase extends Tropfen
{
    public Luftblase(double xStart, double yStart, int rStart, Wolke w)
    {
        super(xStart, yStart, rStart, w);
        vx = 0;
        vy = -15;
    }

    public void zeichne()
    {
        ZeichenFenster.gibFenster().zeichneKreis((int) x, (int) y, radius);
    }

    public void bewege(double zeit)
    {
        if (y > radius)
        {
            super.bewege(zeit);
        }
        else
        {
            meineWolke.entferne(this);
        }
    }
}
