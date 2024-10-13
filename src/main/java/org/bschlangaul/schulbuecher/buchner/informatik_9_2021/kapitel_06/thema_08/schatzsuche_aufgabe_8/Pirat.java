package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_06.thema_08.schatzsuche_aufgabe_8;

import greenfoot.Actor;
import greenfoot.Greenfoot;

/**
 * Klasse Pirat <br>
 *
 * Teilaufgaben b), c), e), f), g) und h)
 */
public class Pirat extends Actor
{
    int anzahlGoldstuecke = 0;

    Anzeige anzeige = new Anzeige();

    Spielwelt spielwelt;

    Pirat(Spielwelt welt)
    {
        spielwelt = welt;
    }

    public void act()
    {
        // Aufgaben b) und d): Methoden zum Steuern von Joe
        if (Greenfoot.isKeyDown("right"))
        {
            bewege(1, 0);
        }
        if (Greenfoot.isKeyDown("left"))
        {
            bewege(-1, 0);
        }
        if (Greenfoot.isKeyDown("up"))
        {
            bewege(0, -1);
        }
        if (Greenfoot.isKeyDown("down"))
        {
            bewege(0, 1);
        }
        // Aufgabe e): Grasbüschel entfernen
        if (Greenfoot.isKeyDown("e"))
        {
            entferneGras();
        }
        // Aufgabe f): Schatztruhen öffnen
        if (Greenfoot.isKeyDown("space"))
        {
            öffneSchatztruhe();
        }
        // Aufgabe g): Schiff besteigen
        if (Greenfoot.isKeyDown("s"))
        {
            besteigeSchiff();
        }
        // Aufgabe c)
        Greenfoot.delay(5);
    }

    void erhalteLob()
    {
        // Aufgabe h)
        if (gibAnzahlGoldstuecke() <= 20)
        {
            String lob1 = "So wenige! Ist";
            String lob2 = "das dein Ernst?";
            spielwelt.getAnzeige().zeigeLob(lob1, lob2);
        }
        if (gibAnzahlGoldstuecke() > 20 && gibAnzahlGoldstuecke() < 40)
        {
            String lob1 = "Gut gemacht!";
            String lob2 = "Sammle mehr!";
            spielwelt.getAnzeige().zeigeLob(lob1, lob2);
        }
        if (gibAnzahlGoldstuecke() >= 40)
        {
            String lob1 = "Respekt! Nun";
            String lob2 = "bist Du reich!";
            spielwelt.getAnzeige().zeigeLob(lob1, lob2);
        }
    }

    /*
     * Die Methoden ab hier können zur Lösung der Aufgaben verwendet werden.
     */
    boolean beruehrtSchiff() // liefert true, wenn der Pirat in einer Zelle
                             // neben dem Schiff ist
    {
        return getObjectsInRange(1, Piratenschiff.class).isEmpty() == false;
    }

    void bewege(int dx, int dy) // bewegt den Piraten um dx Zellen nach
                                // rechts/links und dy Zellen
                                // nach oben/unten
    {
        if (istFeldFrei(dx, dy) && getX() < 16)
        {
            setLocation(getX() + dx, getY() + dy);
        }
    }

    boolean istFeldFrei(int dx, int dy) // liefert true, wenn das Feld mit den
                                        // Korrdinaten (x|y)
                                        // frei ist
    {
        return getOneObjectAtOffset(dx, dy, Fels.class) == null
                && getOneObjectAtOffset(dx, dy, Schatztruhe.class) == null
                && getOneObjectAtOffset(dx, dy, Gras.class) == null;
    }

    void entferneGras() // entfernt Grasbüschel, die sich in einer Zelle neben
                        // dem Píraten befinden
    {
        for (Gras gras : getObjectsInRange(1, Gras.class))
        {
            getWorld().removeObject(gras);
        }
    }

    void öffneSchatztruhe() // entfernt Schatztruhen, die sich in einer Zelle
                            // neben dem Píraten
                            // befinden
    // entnimmt ihnen eine zufällige Anzahl an Goldmünzen
    {
        for (Schatztruhe truhe : getObjectsInRange(1, Schatztruhe.class))
        {
            anzahlGoldstuecke = anzahlGoldstuecke
                    + Greenfoot.getRandomNumber(10);
            getWorld().removeObject(truhe);
            anzeige.setzeGoldstuecke(anzahlGoldstuecke);
        }
    }

    int gibAnzahlGoldstuecke() // Getter für das Attribut anzahlGoldstuecke
    {
        return anzahlGoldstuecke;
    }

    void besteigeSchiff() // Pirat wird entfernt, erhält Lob oder Tadel, das
                          // Programm stoppt
    {
        if (getObjectsInRange(1, Piratenschiff.class).isEmpty() == false)
        {
            erhalteLob();
            getWorld().removeObject(this);
            Greenfoot.stop();
        }
    }
}
