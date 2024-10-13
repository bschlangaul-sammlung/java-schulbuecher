package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.gesicht;

import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.gesicht.interna.Schauspieler;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.einfache_grafik.*;
import static org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.werkzeuge.Pause.*;

/**
 * Die Klasse Hut zeichnet und animiert einen Hut.
 *
 * @author Florian Prager, Ute Heuer, Universität Passau
 *
 * @version 02.2008
 */
public class Hut implements Schauspieler
{
    private Rechteck hutMitte;

    private Ellipse hutOben;

    private Ellipse hutUnten;

    /**
     * Der Konstruktor erzeugt einen neuen Hut.
     */
    public Hut()
    {
        hutMitte = new Rechteck();
        hutMitte.farbeSetzen("schwarz");
        hutMitte.groesseSetzen(200, 150);
        hutMitte.positionSetzen(300, 50);
        hutOben = new Ellipse();
        hutOben.farbeSetzen("grau");
        hutOben.groesseSetzen(200, 32);
        hutOben.positionSetzen(300, 34);
        hutUnten = new Ellipse();
        hutUnten.farbeSetzen("schwarz");
        hutUnten.groesseSetzen(300, 50);
        hutUnten.positionSetzen(250, 175);
        hutMitte.anzeigen();
        hutOben.anzeigen();
        hutUnten.anzeigen();
    }

    /**
     * Die Methode agieren fuehrt eine fuer das Schauspielerobjekt typische
     * Bewegung aus.
     */
    public void agieren()
    {
        hutUnten.verschieben(0, -25);
        hutMitte.verschieben(0, -25);
        hutOben.verschieben(0, -25);
        warten(1);
        hutOben.verschieben(0, 25);
        hutMitte.verschieben(0, 25);
        hutUnten.verschieben(0, 25);
    }
}
