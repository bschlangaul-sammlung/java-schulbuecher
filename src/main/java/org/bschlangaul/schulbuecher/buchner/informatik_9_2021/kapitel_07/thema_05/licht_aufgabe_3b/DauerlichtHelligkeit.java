package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_07.thema_05.licht_aufgabe_3b;

import greenfoot.Color;

/**
 * Ein Objekt der Klasse DauerlichtHelligkeit ändert seine Helligkeit während es
 * leuchtet. Kap. 7.5, Aufgabe 3
 */
public class DauerlichtHelligkeit extends Dauerlicht
{
    Color rot;

    int helligkeit = 10;

    int richtung = 1; // +1: heller; -1: dunkler

    void zeigeLichtEin()
    {
        helligkeit = helligkeit + 10 * richtung;
        if ((helligkeit >= 240) || (helligkeit <= 10))
        {
            richtung = -richtung; // Richtungswechsel
        }
        rot = new Color(helligkeit, 0, 0); // Farbobjekt erzeugen
        licht.setColor(rot);
        licht.fillOval(0, 0, 100, 100);
        setImage(licht);
    }
}
