package schulbuecher.paetec.informatik_10_2008.gesicht;

import static schulbuecher.paetec.informatik_10_2008.eps.werkzeuge.Pause.warten;

import schulbuecher.paetec.informatik_10_2008.eps.einfache_grafik.Ellipse;
import schulbuecher.paetec.informatik_10_2008.gesicht.interna.Schauspieler;

/**
 * Die Klasse Auge zeichnet und animiert ein Auge.
 *
 * @author Florian Prager, Ute Heuer, Universität Passau
 *
 * @version 02.2008
 */
public class Auge implements Schauspieler
{
    private Ellipse pupille;

    private Ellipse auge;

    /**
     * Der Konstruktor erzeugt ein neues Auge an der uebergebenen Position.
     */
    public Auge(int xPosition, int yPosition)
    {
        auge = new Ellipse();
        auge.farbeSetzen("weiss");
        auge.groesseSetzen(100, 50);
        auge.positionSetzen(xPosition, yPosition);
        pupille = new Ellipse();
        pupille.farbeSetzen("schwarz");
        pupille.groesseSetzen(30, 20);
        pupille.positionSetzen(xPosition + 10, yPosition + 10);
        auge.anzeigen();
        pupille.anzeigen();
    }

    /**
     * Die Methode agieren fuehrt eine fuer das Schauspielerobjekt typische
     * Bewegung aus.
     */
    public void agieren()
    {
        pupille.verschieben(50, 0);
        warten(1);
        pupille.verschieben(-50, 0);
    }
}
