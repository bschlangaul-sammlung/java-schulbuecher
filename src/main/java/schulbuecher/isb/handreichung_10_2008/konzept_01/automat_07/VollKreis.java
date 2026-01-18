package schulbuecher.isb.handreichung_10_2008.konzept_01.automat_07;

import schulbuecher.isb.handreichung_10_2008.konzept_01.ZeichenFenster;

public class VollKreis
{
    private int xMitte, yMitte, radius, farbnr;

    public VollKreis(int xStart, int yStart, int radiusStart, int farbnrStart)
    {
        xMitte = xStart;
        yMitte = yStart;
        radius = radiusStart;
        farbnr = farbnrStart;
    }

    public void setzeMitte(int xNeu, int yNeu)
    {
        xMitte = xNeu;
        yMitte = yNeu;
    }

    public void zeichne()
    {
        ZeichenFenster.gibFenster().fuelleKreis(xMitte, yMitte, radius, farbnr);
    }

    public void setzeFarbe(int farbnrNeu)
    {
        farbnr = farbnrNeu;
    }

    public void verschiebe(int nachRechts, int nachUnten)
    {
        xMitte = xMitte + nachRechts;
        yMitte = yMitte + nachUnten;
    }
}
