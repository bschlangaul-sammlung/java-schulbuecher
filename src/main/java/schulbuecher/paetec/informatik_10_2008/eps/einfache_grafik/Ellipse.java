package schulbuecher.paetec.informatik_10_2008.eps.einfache_grafik;

import static schulbuecher.paetec.informatik_10_2008.eps.einfache_grafik.interna.FensterSpeicher.fortgeschrittenesFensterGeben;
import static schulbuecher.paetec.informatik_10_2008.eps.einfache_grafik.interna.GrafikSpeicher.einfachegrafikAnmelden;
import static schulbuecher.paetec.informatik_10_2008.eps.einfache_grafik.interna.GrafikSpeicher.fortgeschrittenegrafikGeben;

@SuppressWarnings("unused")
public class Ellipse
{
    private String farbe;

    /**
     * Die Groesse des Bildes
     */
    private int breite;

    /**
     * Die Groesse des Bildes
     */
    private int hoehe;

    /**
     * Die xPosition der linken oberen Ecke des ueberdeckenden Rechtecks
     */
    private int xPosition;

    /**
     * Die yPosition der linken oberen Ecke des ueberdeckenden Rechtecks
     */
    private int yPosition;

    /**
     * Gibt an, ob die Grafik angezeigt wird
     */
    private boolean wirdAngezeigt;

    /**
     * Es wird eine neue Ellipse mit den Standardeinstellungen erzeugt. Die
     * Ellipse ist gefuellt.
     */
    public Ellipse()
    {
        this(null);
    }

    /**
     * Es wird eine neue Ellipse mit den Standardeinstellungen erzeugt. Das
     * Fenster, an dem die Ellipse angemeldet wird, kann dabei angegeben werden.
     * Dazu muss zuerst ein Zeichenfenster erzeugt worden sein. Dieses kann dann
     * "waehrend des Konstruktoraufrufs eingefuellt" werden. Die Ellipse ist
     * gefuellt.
     */
    public Ellipse(Zeichenfenster fenster)
    {// uh
        einfachegrafikAnmelden(this, fortgeschrittenesFensterGeben(fenster));// uh
        schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.Ellipse fg = (schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.Ellipse) fortgeschrittenegrafikGeben(
                this);
        wirdAngezeigt = false;
        breite = fg.breiteGeben();
        hoehe = fg.hoeheGeben();
        farbe = fg.farbeGeben();
    }

    /**
     * Breite und Hoehe der Ellipse koennen gewaehlt werden. Nicht positive
     * (unsinnige) Angaben werden automatisch auf den kleinsten noch sinnvollen
     * Wert fuer eine Grafik gesetzt, hier 1. Die Grafik ist dann entsprechend
     * auf dem Zeichenfenster zu sehen.
     */
    public void groesseSetzen(int neueBreite, int neueHoehe)
    {
        schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.Ellipse fg = (schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.Ellipse) fortgeschrittenegrafikGeben(
                this);
        fg.groesseSetzen(neueBreite, neueHoehe);
        breite = fg.breiteGeben();
        hoehe = fg.hoeheGeben();
        if (wirdAngezeigt)
            fg.fensterGeben().zeichnen();
    }

    /**
     * Veraendert den Aufpunkt der Grafik. Der Aufpunkt ist die linke obere Ecke
     * des die Grafik ueberdeckenden Rechtecks.
     */
    public void positionSetzen(int neueXPosition, int neueYPosition)
    {
        xPosition = neueXPosition;
        yPosition = neueYPosition;
        schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.Ellipse fg = (schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.Ellipse) fortgeschrittenegrafikGeben(
                this);
        fg.positionSetzen(neueXPosition, neueYPosition);
        if (wirdAngezeigt)
            fg.fensterGeben().zeichnen();
    }

    /**
     * Verschiebt die Grafik um deltaX in x-Richtung und um deltaY in
     * y-Richtung.
     */
    public void verschieben(int deltaX, int deltaY)
    {
        xPosition += deltaX;
        yPosition += deltaY;
        schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.Ellipse fg = (schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.Ellipse) fortgeschrittenegrafikGeben(
                this);
        fg.verschieben(deltaX, deltaY);
        if (wirdAngezeigt)
            fg.fensterGeben().zeichnen();
    }

    /**
     * Die Farbe der Grafik kann gewaehlt werden. Mögliche Farben sind: "weiss",
     * "gelb", "orange", "rot", "pink", "magenta", "cyan", "gruen", "blau",
     * "grau", "schwarz" Achtung: Die Anfuehrungsstriche sind noetig!
     */
    public void farbeSetzen(String neueFarbe)
    {
        schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.Ellipse fg = (schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.Ellipse) fortgeschrittenegrafikGeben(
                this);
        fg.farbeSetzen(neueFarbe);
        farbe = fg.farbeGeben();
        if (wirdAngezeigt)
            fg.fensterGeben().zeichnen();
    }

    /**
     * Zeigt die Grafik (im Vordergrund) an
     */
    public void anzeigen()
    {
        schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.Ellipse fg = (schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.Ellipse) fortgeschrittenegrafikGeben(
                this);
        fg.abmelden();
        fg.anmelden();
        wirdAngezeigt = true;
        fg.fensterGeben().zeichnen();
    }

    /**
     * Versteckt die Grafik
     */
    public void verstecken()
    {
        schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.Ellipse fg = (schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.Ellipse) fortgeschrittenegrafikGeben(
                this);
        fg.abmelden();
        wirdAngezeigt = false;
        fg.fensterGeben().zeichnen();
    }

    /**
     * Liefert den Flaecheninhalt der Ellipse
     */
    public double flaecheninhaltBerechnen()
    {
        return ((double) breite / 2.0) * ((double) hoehe / 2.0) * Math.PI;
    }

    /**
     * Unsere einfache "Visitenkarte": unser Klassenname gefolgt von
     * interessanten Attributwerten
     */
    public String toString()
    {
        schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.Ellipse fg = (schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.Ellipse) fortgeschrittenegrafikGeben(
                this);
        return fg.toString();
    }
}
