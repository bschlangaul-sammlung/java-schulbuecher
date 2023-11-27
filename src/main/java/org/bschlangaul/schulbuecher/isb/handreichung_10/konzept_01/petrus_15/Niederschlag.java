package org.bschlangaul.schulbuecher.isb.handreichung_10.konzept_01.petrus_15;

import org.bschlangaul.schulbuecher.isb.handreichung_10.konzept_01.ZeichenFenster;

public class Niederschlag
{
    protected double x, y, vx, vy;

    public Niederschlag(double xStart, double yStart)
    {
        x = xStart;
        y = yStart;
        vx = 1;
        vy = 12;
    }

    public void zeichne()
    {
        ZeichenFenster.gibFenster().zeichneKreis((int) x, (int) y, 10);
    }

    public void bewege(double zeit)
    {
        x = x + vx * zeit;
        y = y + vy * zeit;
    }
}
