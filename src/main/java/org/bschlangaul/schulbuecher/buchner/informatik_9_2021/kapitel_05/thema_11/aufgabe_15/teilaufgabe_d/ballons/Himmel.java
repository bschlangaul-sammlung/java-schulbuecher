package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_05.thema_11.aufgabe_15.teilaufgabe_d.ballons;

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
        zeigeAnzahl(); // NEU in Aufgabe 15 c)
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
        int neueAnzahl = gibAnzahl() + 1; // NEU in Aufgabe 15 b)
        setzeAnzahl(neueAnzahl); // NEU in Aufgabe 15 b)
        zeigeAnzahl(); // NEU in Aufgabe 15 c)
    }

    void setzeAnzahl(int neueAnzahl) // Aufgabe 15 b)
    {
        anzahl = neueAnzahl;
    }

    int gibAnzahl() // Aufgabe 15 b)
    {
        return anzahl;
    }

    void zeigeAnzahl() // Aufgabe 15 c)
    {
        showText("Anzahl: " + gibAnzahl(), 60, 20);
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
