package schulbuecher.isb.handreichung_10_2008.konzept_01.petrus_16_mit_aufgaben;

import schulbuecher.isb.handreichung_10_2008.konzept_01.ZeichenFenster;

public class Hagelkorn extends Niederschlag
{
    public Hagelkorn(double xStart, double yStart)
    {
        super(xStart, yStart);
        vy = 25;
    }

    public void zeichne()
    {
        ZeichenFenster.gibFenster().fuelleRechteck((int) x - 5, (int) y - 5, 10,
                10, 7);
    }
}
