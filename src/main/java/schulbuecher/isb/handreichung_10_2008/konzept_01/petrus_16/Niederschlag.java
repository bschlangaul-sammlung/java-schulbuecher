package schulbuecher.isb.handreichung_10_2008.konzept_01.petrus_16;

public abstract class Niederschlag
{
    protected double x, y, vx, vy;

    private static int boden = 480;

    public Niederschlag(double xStart, double yStart)
    {
        x = xStart;
        y = yStart;
        vx = 1;
        vy = 12;
    }

    public abstract void zeichne();
    // akstrakte Methoden haben keinen Rumpf

    public void bewege(double zeit)
    {
        x = x + vx * zeit;
        y = y + vy * zeit;
    }

    protected static int gibBoden()
    {
        return boden;
    }
}
