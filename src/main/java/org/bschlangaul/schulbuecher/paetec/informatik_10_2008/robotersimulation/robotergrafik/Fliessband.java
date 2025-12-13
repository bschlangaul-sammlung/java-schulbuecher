package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.robotersimulation.robotergrafik;

import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.Rechteck;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.interna.Zeichenfenster;

/**
 * Die Klasse Fliessband definiert ein Fliessband, auf dem sich Kugeln befinden,
 * die wiederum von einem Roboterarm erntfernt werden koennen.
 *
 * @author Florian Prager, Ute Heuer, Universität Passau
 *
 * @version 02.2008
 */
public class Fliessband
{
    /**
     * Das Fenster auf dem gezeichnet wird
     */
    private Zeichenfenster zeichenfenster;

    /**
     * Das Attribut xFliessbandEnde speichert die x-Koordinate, an der des
     * Fliessband zuende ist.
     */
    private int xFliessbandEnde = 400;

    /**
     * Das Attribut fliessband speichert des Rechteck-Objekt, das das Fliessband
     * darstellen soll.
     */
    private Rechteck fliessband;

    /**
     * Das Attribut kugeln speichert die Kugeln des Fliesbandes in einem Array.
     */
    private Kugel[] kugeln;

    /**
     * Das Attribut anzahlKugeln speichert die aktuelle Anzahl an Kugeln auf dem
     * Fliessband.
     */
    private int anzahlKugeln;

    /**
     * Der Konstruktor der Klasse Fliessband erzeugt ein neues Fliessband mit
     * der uebergebenen Anzahl an Kugeln darauf.
     */
    public Fliessband(Zeichenfenster aktuellesZeichenfenster, int anzahl)
    {
        zeichenfenster = aktuellesZeichenfenster;
        anzahlKugeln = anzahl;
        kugeln = new Kugel[anzahl];
        fliessbandErzeugen();
        fliessbandFuellen();
    }

    /**
     * Via Methode kugelEntfernen wird die Kugel aus der Darstelllung im
     * Zeichenfenster entfernt, die sich ganz vorne auf dem Fliessband befindet.
     */
    public Kugel kugelEntfernen()
    {
        Kugel zuEntfernende = null;
        if (kugeln[0] != null)
        {
            kugeln[0].verstecken();
            zuEntfernende = kugeln[0];
            kugeln[0] = null;
        }
        return zuEntfernende;
    }

    /**
     * Die Methode nachruecken laesst alle Kugeln im Array un eine Position nach
     * vorne wandern und passt die Position der Kugel-Objekte entsprechend an.
     * Dabei "verschwindet" die erste Kugel "ins Nichts".
     */
    public void nachruecken()
    {
        if (anzahlKugeln <= 0)
            return;
        if (kugeln[0] != null)
        {
            kugeln[0].verstecken();
            kugeln[0] = null;
        }
        for (int i = 1; i < anzahlKugeln; i++)
        {
            kugeln[i - 1] = kugeln[i];
            kugeln[i - 1].verschieben(35, 0);
        }
        anzahlKugeln--;
    }

    /**
     * Via Methode aufErsterKugel kann geprueft werden, ob die Position ganz
     * vorne am Fliessband angefordert (uebergeben) wird.
     */
    public boolean aufErsterKugel(int xPosition, int yPosition)
    {
        if (anzahlKugeln <= 0)
            return false;
        if (kugeln == null)
            return false;
        if (kugeln[0] == null)
            return false;
        int toleranz = 20;
        return xPosition <= kugeln[0].xPositionGeben() + toleranz
                && xPosition >= kugeln[0].xPositionGeben() - toleranz
                && yPosition <= kugeln[0].yPositionGeben() + toleranz
                && yPosition >= kugeln[0].yPositionGeben() - toleranz
                && kugeln[0].wirdAngezeigt();
    }

    /**
     * Die Methode fliessbandZeichnen zeichnet das Rechteck, dass das Fliessband
     * repraesentieren soll.
     */
    private void fliessbandErzeugen()
    {
        fliessband = new Rechteck(false, zeichenfenster);
        fliessband.groesseSetzen(xFliessbandEnde, 10);
        fliessband.farbeSetzen("schwarz");
        fliessband.positionSetzen(0, 80);
        fliessband.anmelden();
    }

    /**
     * Die Methode fliessbandFuellen fuellt das Fliessband mit Kugeln.
     */
    private void fliessbandFuellen()
    {
        for (int i = 0; i < kugeln.length; i++)
        {
            kugeln[i] = new Kugel(zeichenfenster, i + 1,
                    xFliessbandEnde - ((i + 1) * 35));
        }
    }
}
