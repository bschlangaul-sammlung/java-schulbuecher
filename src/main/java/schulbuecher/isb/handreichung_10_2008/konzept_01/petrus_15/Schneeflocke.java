package schulbuecher.isb.handreichung_10_2008.konzept_01.petrus_15;

import schulbuecher.isb.handreichung_10_2008.konzept_01.ZeichenFenster;

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
}
