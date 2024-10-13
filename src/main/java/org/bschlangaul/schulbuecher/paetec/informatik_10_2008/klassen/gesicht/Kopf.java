package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.gesicht;

import static org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.werkzeuge.Pause.msWarten;

import java.util.Random;

import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.einfache_grafik.Ellipse;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.gesicht.interna.Schauspieler;

/**
 * Klasse Kopf Kopfobjekte stellen den Dienst animieren zur Verfuegung.
 *
 * @author Florian Prager, Ute Heuer, Universität Passau
 *
 * @version 02.2008
 */
public class Kopf
{
    /**
     * Feld fuer die Teile (die Schauspielerobjekte) des Kopfes (des
     * Theaterdirektors)
     */
    private Schauspieler[] spieler;

    private Random zufall;

    /**
     * Der Konstruktor erzeugt einen neuen Kopf mit allen dazugehoerigen
     * Schauspielerobjekten.
     */
    public Kopf()
    {
        spieler = new Schauspieler[7];
        Ellipse schaedel = new Ellipse();
        schaedel.farbeSetzen("gelb");
        schaedel.groesseSetzen(400, 420);
        schaedel.positionSetzen(200, 150);
        schaedel.anzeigen();
        /* 0, 1: Zwei Ohren */
        spieler[0] = new Ohr(175, 275);
        spieler[1] = new Ohr(575, 275);
        /* 2, 3: Zwei Augen */
        spieler[2] = new Auge(275, 250);
        spieler[3] = new Auge(450, 250);
        /* 4: Hut */
        spieler[4] = new Hut();
        /* 5: Mund */
        spieler[5] = new Mund();
        /* 6: Nase */
        spieler[6] = new Nase();
        // Zufallsgenerator bereitstellen
        zufall = new Random();
    }

    /**
     * Der Dienst animieren weist von Zeit zu Zeit zufaellig ausgewaehlte Schau-
     * spielerobjekte an, zu agieren.
     */
    public void animieren()
    {
        while (true)
        {
            msWarten(500);
            spieler[zufall.nextInt(7)].agieren();
        }
    }
}
