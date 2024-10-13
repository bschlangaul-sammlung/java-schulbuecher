package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_07.thema_07.baerenhunger_vorlage;

import greenfoot.Color;
import greenfoot.GreenfootImage;

/**
 * Ein Punktezaehler ist die graphische Darstellung einer Punktzahl.
 */
public class Punktezaehler
{
    private int punktzahl;

    private String ueberschrift;

    /**
     * Erzeuge einen Punktezaehler mit der angegebenen Ueberschrift. Seine
     * Punktzahl ist am Anfang 0.
     */
    public Punktezaehler(String titel)
    {
        punktzahl = 0;
        ueberschrift = titel;
    }

    /**
     * Erhoehe die Punktzahl um die Gutschrift.
     */
    public void erhoeheUm(int gutschrift)
    {
        punktzahl = punktzahl + gutschrift;
    }

    /**
     * Gib die aktuelle Punktzahl des Punktezaehlers
     */
    public int gibPunktzahl()
    {
        return punktzahl;
    }

    /**
     * Zeichne den Punktezaehler auf das Bild, so dass seine linke obere Ecke
     * bei (x|y) liegt.
     */
    public void zeichneAuf(GreenfootImage bild, int x, int y)
    {
        /*
         * Der Text auf dem Punktezaehler besteht aus der Ueberschrift, einem
         * Doppelpunkt, einem Leerzeichen und der Punktzahl.
         */
        String text = "   " + ueberschrift + ": " + punktzahl + "   ";
        /*
         * Die Zaehlergrafik enthaelt den Text, der schwarz auf gelb in
         * Schriftgroesse 20 geschrieben ist.
         */
        GreenfootImage zaehlerGrafik = new GreenfootImage(text, 20, Color.BLACK,
                Color.YELLOW);
        /*
         * Zeichne die Zaehlergraphik auf das Bild an Position (x|y).
         */
        bild.drawImage(zaehlerGrafik, x, y);
    }
}
