package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.robotersimulation.robotergrafik;

import static org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.einfache_grafik.interna.FensterSpeicher.fortgeschrittenesFensterGeben;
import static org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.werkzeuge.Pause.msWarten;

import java.util.ArrayList;

import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.einfache_grafik.Zeichenfenster;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.Ellipse;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.Rechteck;

/**
 * Die Klasse Roboterarm definiert die Funktionsweise und Darstellung eines
 * Roboterarms, der sich im Kreis bewegen, zugreifen und loslassen kann.
 *
 * @author Florian Prager, Ute Heuer, Frank Fiedler
 *
 * @version 09.2008
 */
public class Roboterarm
{
    /**
     * Zwischen den Bewegungen wartet der Roboterarm etwas. Die Zeit ist in ms
     * angegeben.
     */
    private int wartezeit = 100;

    /**
     * Falls das Drehen animiert wird, passiert das mit einer Schrittweite in
     * Grad.
     *
     */
    private int winkelschrittweite = 1;

    /**
     * Haelt die Referenz auf das Zeichenfenster-Objekt. So kann ein komplettes
     * Neuzeichnen angestossen werden, und zwar erst dann, wenn der Entwickler
     * es wuenscht. So koennen schoenere Ablaeufe grafisch dargestellt werden.
     * Figuren werden nicht mehr alle einzeln etwas stakatoartig gezeichnet.
     * Statt dessen kann ein Bild aus mehreren Figuren einfach auf einen Schlag
     * gezeichnet werden.
     */
    private org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.interna.Zeichenfenster zeichenfenster;

    /**
     * Die Repraesentation des Zeichenfensters als einfachesFenster - alle
     * technischen Details werden versteckt, sie koennen in BlueJ nicht mehr
     * inspiziert werden.
     */
    private Zeichenfenster fenster;

    /**
     * Mittelpunkt des Greifers
     */
    private int xNabenmittelpunkt = 550;

    /**
     * Das Attribut arm speichert das Rechteck, das den Arm des Roboters
     * darstellen soll.
     */
    private Rechteck arm;

    /**
     * Das Attribut greifer speichert die Ellipse, die den Greifer des Roboters
     * darstellen soll.
     */
    private Ellipse greifer;

    /**
     * Das Attribut zentrum speichert die Ellipse, die die Narbe des Roboterarms
     * darstellen soll.
     */
    private Ellipse zentrum;

    /**
     * Das Attribut kugel speichert die Referenz auf die Kugel, die sich bei
     * geschlossenem Zustand im Greifer des Roboterarms befindet.
     */
    private Kugel kugel;

    /**
     * Das Attribut topfliste speichert die Liste, die die Toepfe enthaelt, in
     * die die Kugeln fallen koennen.
     */
    private ArrayList<Topf> topfliste;

    /**
     * Das Attribut fliessband speichert die Referenz auf das Fliessband-Objekt,
     * von dem der Greifer die Kugeln nehmen kann.
     */
    private Fliessband fliessband;

    /**
     * Speichert den aktuellen Winkel des Arms
     */
    private int winkel = 0;

    /**
     * Ein Roboterarm kann ein Fliessband bedienen. Der Nutzer des Arms kann
     * festlegen, wieviele Kugeln Anfangs auf dem Fliessband liegen sollen. mit
     * anzahlKugelnAufFliessband.
     */
    public Roboterarm(int anzahlKugelnAufFliessband)
    {
        fenster = new Zeichenfenster(810, 700);
        // zugehoerige "technische Umsetzung" eines Zeichenfensters
        zeichenfenster = fortgeschrittenesFensterGeben(fenster);
        // auf schlechte Qualitaet wechseln - kann auskommentiert werden
        // zeichenfenster.zeichenqualitaetWechseln();
        topfliste = new ArrayList<Topf>();
        topfliste.add(new Topf(zeichenfenster, 430, "A"));
        topfliste.add(new Topf(zeichenfenster, 625, "B"));
        fliessband = new Fliessband(zeichenfenster, anzahlKugelnAufFliessband);
        arm = new Rechteck(false, zeichenfenster);
        arm.groesseSetzen(182, 16);
        arm.positionSetzen(xNabenmittelpunkt - 8, 163 - 8);
        arm.farbeSetzen("schwarz");
        arm.anmelden();
        zentrum = new Ellipse(false, zeichenfenster);
        zentrum.groesseSetzen(16, 16);
        zentrum.positionSetzen(xNabenmittelpunkt - 8, 163 - 8);
        zentrum.gefuelltSetzen(false);
        zentrum.farbeSetzen("weiss");
        zentrum.anmelden();
        greifer = new Ellipse(false, zeichenfenster);
        greifer.groesseSetzen(40, 40);
        greifer.positionSetzen(xNabenmittelpunkt - 8 + 182, 163 - 20);
        greifer.gefuelltSetzen(false);
        greifer.farbeSetzen("schwarz");
        greifer.anmelden();
        zeichnen(0);
        zeichenfenster.zeichenautomatStarten();
    }

    public Zeichenfenster fensterGeben()
    {
        return fenster;
    }

    /**
     * Die Methode drehen dreht den Roboterarm um den uebergebenen Winkel gegen
     * den Uhrzeigersinn weiter.
     */
    public void drehen(int deltaWinkel, boolean istAnimiert)
    {
        arm.fensterGeben().zeichenautomatStoppen();
        winkel += deltaWinkel;
        if (istAnimiert)
        {
            if (deltaWinkel > 0)
            {
                for (int i = 0; i < deltaWinkel; i++)
                {
                    zeichnen(winkelschrittweite);
                }
            }
            else
            {
                deltaWinkel *= -1;
                for (int i = 0; i < deltaWinkel; i++)
                {
                    zeichnen(-winkelschrittweite);
                }
            }
        }
        else
        {// nicht animiert
            zeichnen(deltaWinkel);
            msWarten(wartezeit);
        }
        arm.fensterGeben().zeichenautomatStarten();
    }

    /**
     * Die Methode greifen greift nur dann nach einer Kugel, falls sich der
     * Roboterarm ueber dem Fliessband befindet und keine Kugel gegriffen hat.
     */
    public void greifen()
    {
        msWarten(wartezeit);
        if (kugel == null)
        {
            if (fliessband.aufErsterKugel(greifer.xPositionGeben(),
                    greifer.yPositionGeben()))
            {
                kugel = fliessband.kugelEntfernen();
            }
            if (kugel != null)
            {
                kugel.positionSetzen(xNabenmittelpunkt - 8 + 182, 163 - 15);
                kugel.drehpunktSetzen(xNabenmittelpunkt, 163);
                kugel.drehen(winkel);
                greifer.abmelden();
                greifer = new Ellipse(arm.fensterGeben());
                greifer.gefuelltSetzen(false);
                greifer.farbeSetzen("schwarz");
                greifer.groesseSetzen(30, 30);
                greifer.positionSetzen(xNabenmittelpunkt - 8 + 182, 163 - 15);
                greifer.drehenUm(xNabenmittelpunkt, 163, winkel);
                fliessband.nachruecken();
                kugel.anzeigen();
            }
        }
    }

    /**
     * Die Methode loslassen laesst eine Kugel los, falls eine gegriffen wurde.
     */
    public void loslassen()
    {
        msWarten(wartezeit);
        if (kugel != null)
        {
            greifer.abmelden();
            greifer = new Ellipse(arm.fensterGeben());
            greifer.gefuelltSetzen(false);
            greifer.farbeSetzen("schwarz");
            greifer.groesseSetzen(40, 40);
            greifer.positionSetzen(xNabenmittelpunkt - 8 + 182, 163 - 20);
            greifer.drehenUm(xNabenmittelpunkt, 163, winkel);
            kugel.verstecken();
            for (Topf topf : topfliste)
            {
                topf.hineinfallen((int) kugel.xPositionGeben() + 15);
            }
            kugel = null;
        }
    }

    /**
     * Die Methode kugelFarbeGeben gibt die Farbe der gegriffenen Kugel zurueck,
     * oder "Es ist keine Kugel in der Hand!" falls keine Kugel gegriffen wurde.
     */
    public String kugelFarbeGeben()
    {
        if (kugel != null)
        {
            return kugel.farbeGeben();
        }
        return "Es ist keine Kugel in der Hand!";
    }

    /**
     * Liefert true, wenn der Greifer offen ist
     */
    public boolean istOffen()
    {
        return kugel == null;
    }

    private void zeichnen(int deltaWinkel)
    {
        arm.drehenUm(xNabenmittelpunkt, 163, deltaWinkel);
        greifer.drehenUm(xNabenmittelpunkt, 163, deltaWinkel);
        if (kugel != null)
            kugel.drehen(deltaWinkel);
        zeichenfenster.zeichnen();
    }
}
