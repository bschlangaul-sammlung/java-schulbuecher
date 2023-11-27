package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_05.thema_11.aufgabe_15.teilaufgabe_a.ballons;

import greenfoot.Greenfoot;
import greenfoot.World;

/**
 * Projekt zu Kap. 5.11 Aufgabe 15 <br>
 * Teilaufgaben a), b), c)
 */
public class Himmel extends World
{
    int anzahl = 0;

    public Himmel()
    {
        super(900, 600, 1); // erzeugt eine Welt aus 900x600 Zellen mit der
                            // Kantenlänge 1 Pixel
        Fadenkreuz fadenkreuz = new Fadenkreuz(this); // erzeugt das Fadenkreuz
                                                      // ...
        addObject(fadenkreuz, 450, 520); // ... und fügt es ein
        setPaintOrder(Fadenkreuz.class); // Fadenkreuz immer im Vordergrund
        showText("Anzahl: " + anzahl, 60, 20); // zeigt den Text links oben an
        Greenfoot.setSpeed(50); // stellt die Ablaufgeschwindigkeit ein
                                // (möglich: 1 ...100)
    }

    public void act() // wird regelmäßig automatisch aufgerufen
    {
        erzeugeBallon(); // erzeugt einen neuen Ballon an der Stelle, wo die
                         // Maus geklickt wurde
    }

    void zaehleBallons() // zählt die erzeugten Ballons und zeigt die Anzahl an
    {
        anzahl = anzahl + 1; // Aufgabe 15 a)
        showText("Anzahl: " + anzahl, 60, 20); // zeigt den Text an der Stelle
                                               // (60|20) an
    }

    /*
     * Der Programmtext ab hier braucht für die Bearbeitung der Arbeitsaufträge
     * und Aufgaben weder gelesen noch verstanden zu werden.
     */
    void erzeugeBallon()
    {
        if (Greenfoot.mouseClicked(null) == true)
        {
            Ballon meinBallon = new Ballon();
            addObject(meinBallon, Greenfoot.getMouseInfo().getX(),
                    Greenfoot.getMouseInfo().getY());
            zaehleBallons();
        }
    }
}
