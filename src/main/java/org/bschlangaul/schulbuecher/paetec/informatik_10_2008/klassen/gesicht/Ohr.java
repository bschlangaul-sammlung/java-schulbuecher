package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.gesicht;

import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.gesicht.interna.Schauspieler;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.einfache_grafik.*;
import static org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.werkzeuge.Pause.*;

/**
 * Die Klasse Ohr zeichnet und animiert ein Ohr.
 *
 * @author Florian Prager, Ute Heuer, Universität Passau
 *
 * @version 02.2008
 */
public class Ohr implements Schauspieler
{
    private Ellipse ohrInnen;

    private Ellipse ohrAussen;

    /**
     * Der Konstruktor erzeugt ein neues Ohr an der uebergebenen Position.
     */
    public Ohr(int xPosition, int yPosition)
    {
        ohrAussen = new Ellipse();
        ohrAussen.farbeSetzen("gelb");
        ohrAussen.groesseSetzen(50, 150);
        ohrAussen.positionSetzen(xPosition, yPosition);
        ohrInnen = new Ellipse();
        ohrInnen.farbeSetzen("orange");
        ohrInnen.groesseSetzen(30, 80);
        ohrInnen.positionSetzen(xPosition + 10, yPosition + 20);
        ohrAussen.anzeigen();
        ohrInnen.anzeigen();
    }

    /**
     * Die Methode agieren fuehrt eine fuer das Schauspielerobjekt typische
     * Bewegung aus.
     */
    public void agieren()
    {
        ohrInnen.groesseSetzen(35, 100);
        warten(1);
        ohrInnen.groesseSetzen(30, 80);
    }
}
