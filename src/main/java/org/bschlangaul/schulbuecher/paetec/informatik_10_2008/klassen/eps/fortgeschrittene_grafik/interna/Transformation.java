package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.interna;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

/**
 * Implementiert eine abstrakte Transformation
 *
 * @author Florian Prager, Universität Passau
 *
 * @version 02.2008
 */
public abstract class Transformation
{
    /**
     * Die interne AWT-Transformation
     */
    protected AffineTransform af;

    /**
     * Erzeugt eine Transformation
     */
    public Transformation()
    {
        af = new AffineTransform();
    }

    /**
     * Wendet die Transformation an
     */
    public void anwenden(Graphics2D g)
    {
        g.transform(af);
    }

    /**
     * Liefert die interne Transformation
     */
    public AffineTransform transformationGeben()
    {
        return af;
    }
}
