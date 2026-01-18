package schulbuecher.buchner.informatik_9_2021.kapitel_06.thema_04.zahlenspirale_a1;

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
        if (istQuadratzahl(nummer) == true)
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

    boolean istQuadratzahl(int zahl) // liefert true, wenn zahl eine Qudratzahl
                                     // ist
    {
        boolean istQuadratzahl = false;
        int i = 1;
        while (i * i <= zahl)
        {
            if (i * i == zahl)
            {
                istQuadratzahl = true;
            }
            i = i + 1;
        }
        return istQuadratzahl;
    }

    int getNummer() // Getter für das Attribut Nummer
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
     * Der Programmtext ab hier braucht für die Bearbeitung der Arbeitsaufträge
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
