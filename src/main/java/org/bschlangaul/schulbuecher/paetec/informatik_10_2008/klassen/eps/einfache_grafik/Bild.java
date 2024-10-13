package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.einfache_grafik;

// uh
import static org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.einfache_grafik.interna.FensterSpeicher.fortgeschrittenesFensterGeben;
import static org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.einfache_grafik.interna.GrafikSpeicher.einfachegrafikAnmelden;
import static org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.einfache_grafik.interna.GrafikSpeicher.fortgeschrittenegrafikGeben;

@SuppressWarnings("unused")

public class Bild
{
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

    private String dateiname;

    /**
     * Gibt an, ob die Grafik angezeigt wird
     */
    private boolean wirdAngezeigt;

    /**
     * Es wird ein neues Bildobjekt mit den Standardeinstellungen erzeugt.
     * Aufpunkt: (0, 0) - linke obere Ecke des ueberdeckenden Rechtecks. Das
     * Standardbild ist eine Tulpe, sie wird angezeigt. Bilder muessen im
     * Unterordner "Bilder" in fortgeschrittene Grafik liegen.
     */
    public Bild()
    {
        this(null);
    }

    /**
     * Es wird eine neue Grafik mit den Standardeinstellungen erzeugt. Das
     * Fenster, an dem die Grafik angemeldet wird, kann dabei angegeben werden.
     * Dazu muss zuerst ein Zeichenfenster erzeugt worden sein. Dieses kann dann
     * "waehrend des Konstruktoraufrufs eingefuellt" werden. Aufpunkt: (0, 0) -
     * linke obere Ecke des ueberdeckenden Rechtecks. Das Standardbild ist eine
     * Tulpe, sie wird angezeigt. Bilder muessen im Unterordner "Bilder" in
     * fortgeschrittene Grafik liegen.
     */
    public Bild(Zeichenfenster fenster)
    {// uh
        einfachegrafikAnmelden(this, fortgeschrittenesFensterGeben(fenster));// uh
        org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Bild fg = (org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Bild) fortgeschrittenegrafikGeben(
                this);
        wirdAngezeigt = false;
        breite = fg.breiteGeben();
        hoehe = fg.hoeheGeben();
        dateiname = fg.dateinameGeben();
    }

    /**
     * Eine neue Bilddatei kann gewaehlt werden. Die Werte der Attribute breite
     * und hoehe werden entsprechend der neuen Bilddatei angepasst.
     * <p>
     * Die Bilddatei muss im Unterordner Bilder (relativ zum Ort der Datei
     * "Bild.class" dieses Projekts) liegen. Es koennen die Formate png und jpg
     * und gif dargestellt werden. Der Unterordner "Bilder/" wird nach der
     * Eingabe automatisch ergaenzt, er darf nicht mit angegeben werden. Der
     * Dienst gibt ggf. Fehlermeldungen auf der Standardkonsole an den Benutzer
     * aus.
     * <p>
     * neuerDateiname - moegliche (Standard)Eingangswerte sind "Kirschen.png"
     * oder "Tulpe.png".
     */
    public void dateinameSetzen(String neuerDateiname)
    {
        org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Bild fg = (org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Bild) fortgeschrittenegrafikGeben(
                this);
        fg.dateinameSetzen(neuerDateiname);
        dateiname = fg.dateinameGeben();
        if (wirdAngezeigt)
            fg.fensterGeben().zeichnen();
    }

    /**
     * Der Dienst gibt eine Aufzaehlung aller Dateien im Bilder-Unterverzeichnis
     * zurueck.
     */
    public String bilderGeben()
    {
        String ergebnis = "";
        String[] dateiliste = org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Bild
                .bilderGeben();
        for (int i = 0; i < dateiliste.length; i++)
        {
            if (i == dateiliste.length - 1)
                ergebnis += dateiliste[i];
            else
                ergebnis += dateiliste[i] + ", ";
        }
        return ergebnis;
    }

    /**
     * Breite und Hoehe des Bildes koennen gewaehlt werden. Nicht positive
     * (unsinnige) Angaben werden automatisch auf den kleinsten noch sinnvollen
     * Wert fuer eine Grafik gesetzt, hier 1. Die Grafik ist dann entsprechend
     * auf dem Zeichenfenster zu sehen.
     */
    public void groesseSetzen(int neueBreite, int neueHoehe)
    {
        org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Bild fg = (org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Bild) fortgeschrittenegrafikGeben(
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
        org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Bild fg = (org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Bild) fortgeschrittenegrafikGeben(
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
        org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Bild fg = (org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Bild) fortgeschrittenegrafikGeben(
                this);
        fg.verschieben(deltaX, deltaY);
        if (wirdAngezeigt)
            fg.fensterGeben().zeichnen();
    }

    /**
     * Zeigt die Grafik (im Vordergrund) an
     */
    public void anzeigen()
    {
        org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Bild fg = (org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Bild) fortgeschrittenegrafikGeben(
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
        org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Bild fg = (org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Bild) fortgeschrittenegrafikGeben(
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
        org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Bild fg = (org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.Bild) fortgeschrittenegrafikGeben(
                this);
        return fg.toString();
    }
}
