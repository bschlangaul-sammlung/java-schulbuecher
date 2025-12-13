package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.robotersimulation.robotergrafik;

import java.util.Random;

import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.Ellipse;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.Text;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.interna.Zeichenfenster;

/**
 * Die Klasse Kugel definiert eine Kugel mit Beschriftung, die sich auf dem
 * Fliessband befindet, und vom Roboterarm bewegt werden kann.
 *
 * @author Florian Prager, Ute Heuer, Universität Passau
 *
 * @version 02.2008
 */
public class Kugel
{
    /**
     * x-Koordinate des Punktes, um den die Kugel gedreht ist.
     */
    private int xDrehpunkt;

    /**
     * y-Koordinate des Punktes, um den die Kugel gedreht ist.
     */
    private int yDrehpunkt;

    /**
     * Das Attribut farbe haelt die Farbe der Kugel.
     */
    private String farbe;

    /**
     * Das Attribut nummer haelt die Nummer (Beschriftung) der Kugel.
     */
    private int nummer;

    /**
     * Das Attribut kreis haelt die Ellipse, die die Kugel mit Hilfe der
     * einfachenGrafik darstellen soll.
     */
    private Ellipse kreis;

    /**
     * Das Attribt kugelbeschriftung haelt das Text-Objekt, die die Beschriftung
     * mit Hilfe der einfachen Grafik darstellen soll.
     */
    private Text kugelbeschriftung;

    /**
     * Zeigt an, ob die Repraesentation der Kugel (Kreis mit Text) beim
     * Zeichenfenster angemeldet ist.
     */
    boolean angemeldet;

    /**
     * Dieser Konstruktor erzeugt eine neue Kugel mit der uebergebenen Nummer an
     * der uebergebenen x-Koordinate mit einer zufaelligen Farbe. Die Kugel wird
     * angezeigt.
     */
    public Kugel(Zeichenfenster fenster, int neueNummer, int neueXPosition)
    {
        String zufallsFarbe = "grau";
        Random zufall = new Random();
        int zufallszahl = zufall.nextInt(11);
        switch (zufallszahl)
        {
        case (0):
            zufallsFarbe = "gelb";
            break;

        case (1):
            zufallsFarbe = "orange";
            break;

        case (2):
            zufallsFarbe = "rot";
            break;

        case (3):
            zufallsFarbe = "pink";
            break;

        case (4):
            zufallsFarbe = "magenta";
            break;

        case (5):
            zufallsFarbe = "cyan";
            break;

        case (6):
            zufallsFarbe = "gruen";
            break;

        case (7):
            zufallsFarbe = "blau";
            break;

        case (8):
            zufallsFarbe = "grau";
            break;

        case (9):
            zufallsFarbe = "schwarz";
            break;

        case (10):
            zufallsFarbe = "weiss";
            break;

        default:
            zufallsFarbe = "grau";
        }
        nummer = neueNummer;
        farbe = zufallsFarbe;
        repraesentationErzeugen(fenster, neueXPosition, 50);
    }

    /**
     * Der Konstruktor erzeugt eine neue Kugel mit der uebergebenen Nummer an
     * der uebergebenen x-Koordinate und mit der uebergebenen Farbe. Die Kugel
     * wird angezeigt.
     */
    public Kugel(Zeichenfenster fenster, int neueNummer, int neueXPosition,
            String neueFarbe)
    {
        nummer = neueNummer;
        farbe = neueFarbe;
        repraesentationErzeugen(fenster, neueXPosition, 50);
    }

    /**
     * Die Methode positionSetzen setzt die Position der Kugel an die
     * uebergebene Stelle.
     */
    public void positionSetzen(int xPosition, int yPosition)
    {
        kreis.positionSetzen(xPosition, yPosition);
        kugelbeschriftung.positionSetzen(xPosition + 3, yPosition + 5);
    }

    /**
     * Verschiebt die Kugel und die angegebenen Werte
     */
    public void verschieben(int deltaX, int deltaY)
    {
        kreis.verschieben(deltaX, deltaY);
        kugelbeschriftung.verschieben(deltaX, deltaY);
    }

    /**
     * Setzt den Drehpunkt der Kugel
     */
    public void drehpunktSetzen(int neuerXDrehpunkt, int neuerYDrehpunkt)
    {
        xDrehpunkt = neuerXDrehpunkt;
        yDrehpunkt = neuerYDrehpunkt;
    }

    /**
     * Dreht die Kugel relativ zum bisherigen Winkel
     */
    public void drehen(int deltaWinkel)
    {
        kreis.drehenUm(xDrehpunkt, yDrehpunkt, deltaWinkel);
        kugelbeschriftung.drehenUm(xDrehpunkt, yDrehpunkt, deltaWinkel);
    }

    /**
     * Liefert die xPosition der Kugel
     */
    public double xPositionGeben()
    {
        return kreis.xPositionGeben();
    }

    /**
     * Liefert die yPosition der Kugel
     */
    public double yPositionGeben()
    {
        return kreis.yPositionGeben();
    }

    /**
     * Die Methode verstecken entfernt die Kugel vom Zeichenfenster.
     */
    public void verstecken()
    {
        kreis.abmelden();
        kugelbeschriftung.abmelden();
        kugelbeschriftung.fensterGeben().zeichnen();
        angemeldet = false;
    }

    /**
     * Die Methode anzeigen zeichnet die Kugel neu auf dem Zeichenfenster.
     */
    public void anzeigen()
    {
        kreis.anmelden();
        kugelbeschriftung.anmelden();
        kugelbeschriftung.fensterGeben().zeichnen();
        angemeldet = true;
    }

    /**
     * Die Methode wirdAngezeigt gibt den Anzeigestatus der Kugel zurueck.
     */
    public boolean wirdAngezeigt()
    {
        return angemeldet;
    }

    /**
     * Die Methode nummerGeben gibt die Nummer der Kugel zurueck.
     */
    public int nummerGeben()
    {
        return nummer;
    }

    /**
     * Die Methode farbeGeben gibt die Farbe der Kugel zurueck.
     */
    public String farbeGeben()
    {
        return farbe;
    }

    /**
     * Die Methode repraesentationErzeugen erzeugt die Repraesentation der
     * Kugel, indem sie die Ellipse und den Text fuer die Beschriftung erzeugt
     */
    private void repraesentationErzeugen(Zeichenfenster fenster, int xPos,
            int yPos)
    {
        kreis = new Ellipse(false, fenster);
        kreis.groesseSetzen(30, 30);
        kreis.positionSetzen(xPos, yPos);
        if (farbe == "weiss")
        {
            kreis.gefuelltSetzen(false);
            kreis.farbeSetzen("schwarz");
        }
        else
        {
            kreis.farbeSetzen(farbe);
        }
        kreis.anmelden();
        kugelbeschriftung = new Text(15, false, fenster);
        if (farbe == "schwarz" || farbe == "blau")
        {
            kugelbeschriftung.farbeSetzen("weiss");
        }
        else
        {
            kugelbeschriftung.farbeSetzen("schwarz");
        }
        kugelbeschriftung.positionSetzen(xPos + 3, yPos + 5);// 8, 5
        kugelbeschriftung.inhaltSetzen(nummer);
        drehpunktSetzen((int) xPos, (int) yPos);
        kugelbeschriftung.anmelden();
        angemeldet = true;
    }
}
