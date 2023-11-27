package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_06.thema_05.random_walk_Vorlage;

import greenfoot.Greenfoot;
import greenfoot.World;

/**
 * Projekt zu Kap. 6.5 <br>
 *
 * Aufgaben 1-3
 */
public class Zufallsweg extends World
{
    public Zufallsweg()
    {
        super(300, 21, 3);
        gehe();
    }

    void gehe()
    {
        // füge hier den Programmtext ein
    }

    /*
     * Die folgenden Methoden können zur Lösung der Aufgaben verwendet werden.
     * Dazu ist es nicht nötig ihre genaue Arbeitsweise zu verstehen.
     */
    int gibZufallszahl() // liefert eine Zufallszahl zwischen 1 und 100
    {
        return Greenfoot.getRandomNumber(100) + 1;
    }

    void faerbeZelle(int x, int y) // färbt die Zelle (x|y) rot ein
    {
        Zelle zelle = new Zelle();
        addObject(zelle, x, y);
        zelle.erstelleBild();
    }
}
