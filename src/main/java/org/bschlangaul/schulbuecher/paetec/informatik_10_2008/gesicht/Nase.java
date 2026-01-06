package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.gesicht;

import static org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.werkzeuge.Pause.warten;

import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.einfache_grafik.Ellipse;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.gesicht.interna.Schauspieler;

/**
 * Die Klasse Nase zeichnet und animiert eine Nase.
 *
 * @author Florian Prager, Ute Heuer, Universität Passau
 *
 * @version 02.2008
 */
public class Nase implements Schauspieler
{
    private Ellipse lochLinks;

    private Ellipse lochRechts;

    private Ellipse ruecken;

    /**
     * Der Konstruktor erzeugt eine neue Nase.
     */
    public Nase()
    {
        ruecken = new Ellipse();
        ruecken.farbeSetzen("orange");
        ruecken.groesseSetzen(75, 125);
        ruecken.positionSetzen(375, 275);
        lochLinks = new Ellipse();
        lochLinks.farbeSetzen("schwarz");
        lochLinks.groesseSetzen(20, 20);
        lochLinks.positionSetzen(380, 350);
        lochRechts = new Ellipse();
        lochRechts.farbeSetzen("schwarz");
        lochRechts.groesseSetzen(20, 20);
        lochRechts.positionSetzen(425, 350);
        ruecken.anzeigen();
        lochRechts.anzeigen();
        lochLinks.anzeigen();
    }

    /**
     * Die Methode agieren fuehrt eine fuer das Schauspielerobjekt typische
     * Bewegung aus.
     */
    public void agieren()
    {
        lochLinks.verschieben(0, -10);
        lochRechts.verschieben(0, -10);
        warten(1);
        lochLinks.verschieben(0, 10);
        lochRechts.verschieben(0, 10);
    }
}
