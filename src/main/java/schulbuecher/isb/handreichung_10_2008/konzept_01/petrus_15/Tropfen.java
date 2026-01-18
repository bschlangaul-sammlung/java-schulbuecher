package schulbuecher.isb.handreichung_10_2008.konzept_01.petrus_15;

import schulbuecher.isb.handreichung_10_2008.konzept_01.ZeichenFenster;

public class Tropfen extends Niederschlag
{
    private int radius;

    public Tropfen(double xStart, double yStart, int rStart)
    {
        super(xStart, yStart);
        radius = rStart;
    }

    public void zeichne()
    {
        ZeichenFenster.gibFenster().fuelleKreis((int) x, (int) y, radius, 1);
    }
}
