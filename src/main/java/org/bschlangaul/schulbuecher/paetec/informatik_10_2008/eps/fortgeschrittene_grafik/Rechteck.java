package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.interna.Form;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.interna.Zeichenfenster;

/**
 * Objekte der Klasse Rechteck stellen einige einfache Dienste zum Darstellen
 * von Rechtecken auf dem Zeichenfenster bereit.
 *
 * @author Florian Prager, Universität Passau
 *
 * @version 02.2008
 */
public class Rechteck extends Form
{
    /**
     * Erzeugt ein Rechteck mit Standardwerten auf dem Standardfenster
     */
    public Rechteck()
    {
        this(null);
    }

    public Rechteck(boolean anmelden, Zeichenfenster fenster)
    {
        super(anmelden, fenster);
    }

    /**
     * Es wird ein neues Rechteck mit den Standardeinstellungen erzeugt. Dieses
     * kann mit einem Zeichenfenster verbunden werden. Wird null eingegeben,
     * wird das Standardfenster verwendet. Das Rechteck ist gefuellt.
     */
    public Rechteck(Zeichenfenster fenster)
    {
        this(true, fenster);
    }

    /**
     * Technische Methode, die Zeichenfensterobjekte nutzen.
     */
    protected Shape formFuerFensterErzeugen()
    {
        return new Rectangle2D.Double(0, 0, standardBreite, standardHoehe);
    }
}
