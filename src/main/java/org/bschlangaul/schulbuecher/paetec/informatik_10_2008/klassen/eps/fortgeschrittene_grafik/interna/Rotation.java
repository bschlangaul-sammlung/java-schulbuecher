package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.interna;

/**
 * Implementiert eine Rotationstransformation
 *
 * @author Florian Prager, Universität Passau
 *
 * @version 02.2008
 */
public class Rotation extends Transformation
{
    private double xDrehpunkt;

    private double yDrehpunkt;

    private int winkel;

    public Rotation(double xDrehpunkt, double yDrehpunkt, int winkel)
    {
        this.xDrehpunkt = xDrehpunkt;
        this.yDrehpunkt = yDrehpunkt;
        this.winkel = winkel;
        transformationGeben().rotate(Math.toRadians(-winkel), xDrehpunkt,
                yDrehpunkt);
    }

    public double xDrehpunktGeben()
    {
        return xDrehpunkt;
    }

    public double yDrehpunktGeben()
    {
        return yDrehpunkt;
    }

    public int winkelGeben()
    {
        return winkel;
    }
}
