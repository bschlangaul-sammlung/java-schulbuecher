package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.einfache_grafik;

import static org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.einfache_grafik.interna.GrafikSpeicher.*;
import static org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.einfache_grafik.interna.FensterSpeicher.*;// uh

@SuppressWarnings("unused")
public class Text
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

    private String inhalt;

    /**
     * Es wird eine neue Grafik mit den Standardeinstellungen erzeugt.
     */
    public Text()
    {
        this(48);
    }

    /**
     * Es wird eine neue Grafik mit den Standardeinstellungen erzeugt. Die
     * Schriftgroesse kann gewaehlt werden. Die Schriftgroesse des Textobjekts
     * kann gewaehlt werden. Werden hier unsinnige nicht positive Eingaben
     * gemacht, wird automatisch die kleinste moegliche Schriftgroesse 1
     * gesetzt.
     */
    public Text(int schriftgroesse)
    {
        this(schriftgroesse, null);
    }

    /**
     * Es wird eine neue Grafik mit den Standardeinstellungen erzeugt. Die
     * Schriftgroesse des Textobjekts kann gewaehlt werden. Werden hier
     * unsinnige nicht positive Eingaben gemacht, wird automatisch die kleinste
     * mögliche Schriftgroesse 1 gesetzt. Das Fenster, an dem die Grafik
     * angemeldet wird, kann angegeben werden. Dazu muss zuerst ein
     * Zeichenfenster erzeugt worden sein. Dieses kann dann "waehrend des
     * Konstruktoraufrufs eingefuellt" werden.
     */
    public Text(int schriftgroesse, Zeichenfenster fenster)
    {// uh
        einfachenTextAnmelden(schriftgroesse, this,
                fortgeschrittenesFensterGeben(fenster));// uh
        org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Text fg = (org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Text) fortgeschrittenegrafikGeben(
                this);
        wirdAngezeigt = false;
        breite = fg.breiteGeben();
        hoehe = fg.hoeheGeben();
        farbe = fg.farbeGeben();
        inhalt = fg.inhaltGeben();
    }

    /**
     * Breite und Hoehe der Grafik koennen gewaehlt werden. Nicht positive
     * (unsinnige) Angaben werden automatisch auf den kleinsten noch sinnvollen
     * Wert fuer eine Grafik gesetzt, hier 1. Die Grafik ist dann entsprechend
     * auf dem Zeichenfenster zu sehen.
     */
    public void groesseSetzen(int neueBreite, int neueHoehe)
    {
        org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Text fg = (org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Text) fortgeschrittenegrafikGeben(
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
        org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Text fg = (org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Text) fortgeschrittenegrafikGeben(
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
        org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Text fg = (org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Text) fortgeschrittenegrafikGeben(
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
        org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Text fg = (org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Text) fortgeschrittenegrafikGeben(
                this);
        fg.farbeSetzen(neueFarbe);
        farbe = fg.farbeGeben();
        if (wirdAngezeigt)
            fg.fensterGeben().zeichnen();
    }

    /**
     * Der anzuzeigende Inhalt kann gewaehlt werden. Achtung: Die
     * Anfuehrungsstriche beim Typ String nicht vergessen! Z.B. "Guten Morgen"
     * Aber es k�nnen auch Zahlen (z.B. Typ Integer oder Double) eingefuellt
     * werden. Z.B. 54 oder 3.14 Achtung: Der Inhalt wird in der bei
     * Konstruktion des Textobjekts festgelegten Schriftgroesse dargestellt! Die
     * Werte der Attribute breite und hoehe werden entsprechend aktualisiert.
     */
    public void inhaltSetzen(Object neuerInhalt)
    {
        org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Text fg = (org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Text) fortgeschrittenegrafikGeben(
                this);
        fg.inhaltSetzen(neuerInhalt);
        breite = fg.breiteGeben();
        hoehe = fg.hoeheGeben();
        inhalt = fg.inhaltGeben();
        if (wirdAngezeigt)
            fg.fensterGeben().zeichnen();
    }

    /**
     * Zeigt die Grafik (im Vordergrund) an
     */
    public void anzeigen()
    {
        org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Text fg = (org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Text) fortgeschrittenegrafikGeben(
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
        org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Text fg = (org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Text) fortgeschrittenegrafikGeben(
                this);
        fg.abmelden();
        wirdAngezeigt = false;
        fg.fensterGeben().zeichnen();
    }

    /**
     * Unsere einfache "Visitenkarte": unser Klassenname gefolgt von
     * interessanten Attributwerten
     */
    public String toString()
    {
        org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Text fg = (org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Text) fortgeschrittenegrafikGeben(
                this);
        return fg.toString();
    }
}
