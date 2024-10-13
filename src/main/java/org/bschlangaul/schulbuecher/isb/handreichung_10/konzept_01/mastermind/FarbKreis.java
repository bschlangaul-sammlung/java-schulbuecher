package org.bschlangaul.schulbuecher.isb.handreichung_10.konzept_01.mastermind;

import org.bschlangaul.schulbuecher.isb.handreichung_10.konzept_01.ZeichenFenster;

public class FarbKreis
{
    private int xMitte, yMitte, radius, farbnr;

    public FarbKreis(int xStart, int yStart, int radiusStart, int farbnrStart)
    {
        xMitte = xStart;
        yMitte = yStart;
        radius = radiusStart;
        farbnr = farbnrStart;
    }

    public void zeichneRa()
    {
        ZeichenFenster.gibFenster().zeichneKreis(xMitte, yMitte, radius);
    }

    public void setzeMitte(int xNeu, int yNeu)
    {
        xMitte = xNeu;
        yMitte = yNeu;
    }

    public void setzeRadius(int radiusNeu)
    {
        radius = radiusNeu;
    }

    public void fuelle()
    {
        ZeichenFenster.gibFenster().fuelleKreis(xMitte, yMitte, radius, farbnr);
    }

    public void setzeFarbe(int farbnrNeu)
    {
        farbnr = farbnrNeu;
        fuelle();
    }

    public void verschiebe(int nachRechts, int nachUnten)
    {
        xMitte = xMitte + nachRechts;
        yMitte = yMitte + nachUnten;
    }
}
