package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.interna;

/**
 * Implementiert eine Translationstransformation
 *
 * @author Florian Prager, Universität Passau
 *
 * @version 02.2008
 */
public class Translation extends Transformation
{
    private double xVerschiebung;

    private double yVerschiebung;

    public Translation(double xVerschiebung, double yVerschiebung)
    {
        this.xVerschiebung = xVerschiebung;
        this.yVerschiebung = yVerschiebung;
        transformationGeben().translate(xVerschiebung, yVerschiebung);
    }

    public double xVerschiebungGeben()
    {
        return xVerschiebung;
    }

    public double yVerschiebungGeben()
    {
        return yVerschiebung;
    }
}
