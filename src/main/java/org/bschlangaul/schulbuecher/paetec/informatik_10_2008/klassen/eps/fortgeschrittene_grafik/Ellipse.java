package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.interna.Form;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.interna.Zeichenfenster;

/**
 * Objekte der Klasse Ellipse stellen einige einfache Dienste zum Darstellen von
 * Ellipsen auf dem Zeichenfenster bereit.
 *
 * @author Florian Prager, Universität Passau
 *
 * @version 02.2008
 */
public class Ellipse extends Form
{
    /**
     * Erzeugt eine Ellipse mit Standardwerten auf dem Standardfenster
     */
    public Ellipse()
    {
        this(null);
    }

    public Ellipse(boolean anmelden, Zeichenfenster fenster)
    {
        super(anmelden, fenster);
    }

    /**
     * Es wird eine neue Ellipse mit den Standardeinstellungen erzeugt. Diese
     * kann mit einem Zeichenfenster verbunden werden. Wird null eingegeben,
     * wird das Standardfenster verwendet. Die Ellipse ist gefuellt.
     */
    public Ellipse(Zeichenfenster fenster)
    {
        this(true, fenster);
    }

    /**
     * Technische Methode, die Zeichenfensterobjekte nutzen
     */
    protected Shape formFuerFensterErzeugen()
    {
        return new Ellipse2D.Double(0, 0, standardBreite, standardHoehe);
    }

    /**
     * Unsere einfache "Visitenkarte": unser Klassenname gefolgt von
     * interessanten Attributwerten.
     */
    public String toString()
    {
        return "eine " + getClass().getSimpleName() + " - Aufpunkt: ("
                + xPositionGeben() + ", " + yPositionGeben() + ")"
                + " - Groesse: " + breiteGeben() + " X " + hoeheGeben()
                + " - Farbe: " + farbeGeben();
    }
}
