package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_06.thema_04.zahlenspirale_a4;

import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.GreenfootImage;

/**
 * Klasse Zelle <br>
 *
 * Kap. 6.4 Arbeitsauftrag 3 und 4, Aufgabe 1
 */
public class Zelle extends Actor
{
    int x; // x-Koordinate der Zelle

    int y; // y-Koordi1nate der Zelle

    int nummer; // Nummer in der Zelle

    Zelle(int xNeu, int yNeu, int nummerNeu)
    {
        x = xNeu;
        y = yNeu;
        nummer = nummerNeu;
    }

    Color berechneFarbe()
    {
        if (istPrim(nummer) == true)
        {
            return Color.RED;
        }
        else
        {
            return Color.BLACK;
        }
    }

    boolean istPrim(int zahl) // liefert true, wenn zahl eine Primzahl ist
    {
        boolean istPrimzahl = true;
        int i = 2;
        while (i < zahl)
        {
            if (istTeilbarDurch(zahl, i) == true)
            {
                istPrimzahl = false;
            }
            i = i + 1;
        }
        if (zahl == 1)
        {
            istPrimzahl = false;
        }
        return istPrimzahl;
    }

    int getNummer() // Getter f�r das Attribut Nummer
    {
        return nummer;
    }
    // Aufgabe 1

    boolean istTeilbarDurch(int a, int b) // liefert true, wenn a durch b
                                          // teilbar ist
    {
        return a % b == 0;
    }

    /*
     * Der Programmtext ab hier braucht f�r die Bearbeitung der Arbeitsauftr�ge
     * und Aufgaben weder gelesen noch verstanden zu werden.
     */
    void erstelleBild()
    {
        int cellSize;
        cellSize = getWorld().getCellSize();
        GreenfootImage img;
        img = new GreenfootImage(cellSize, cellSize);
        img.setColor(berechneFarbe());
        img.fillRect(0, 0, cellSize, cellSize);
        if (cellSize >= 20)
        {
            img.setColor(Color.WHITE);
            img.setFont(img.getFont().deriveFont(10));
            img.drawString(nummer + "", 0, cellSize / 2);
        }
        setImage(img);
    }
}
