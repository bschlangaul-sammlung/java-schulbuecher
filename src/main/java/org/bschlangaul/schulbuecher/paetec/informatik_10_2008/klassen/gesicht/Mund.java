package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.gesicht;

import static org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.werkzeuge.Pause.warten;

import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.einfache_grafik.Ellipse;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.gesicht.interna.Schauspieler;

/**
 * Die Klasse Mund zeichnet und animiert einen Mund.
 *
 * @author Florian Prager, Ute Heuer, Universität Passau
 *
 * @version 02.2008
 */
public class Mund implements Schauspieler
{
    private Ellipse mund;

    private Ellipse lippen;

    /**
     * Der Konstruktor erzeugt einen neuen Mund.
     */
    public Mund()
    {
        lippen = new Ellipse();
        lippen.farbeSetzen("rot");
        lippen.groesseSetzen(200, 100);
        lippen.positionSetzen(300, 425);
        mund = new Ellipse();
        mund.farbeSetzen("schwarz");
        mund.groesseSetzen(150, 50);
        mund.positionSetzen(325, 450);
        lippen.anzeigen();
        mund.anzeigen();
    }

    /**
     * Die Methode agieren fuehrt eine fuer das Schauspielerobjekt typische
     * Bewegung aus.
     */
    public void agieren()
    {
        mund.verstecken();
        mund.groesseSetzen(50, 50);
        mund.positionSetzen(375, 450);
        mund.anzeigen();
        warten(1);
        mund.verstecken();
        mund.groesseSetzen(150, 50);
        mund.positionSetzen(325, 450);
        mund.anzeigen();
    }
}
