package schulbuecher.buchner.informatik_9_2021.kapitel_06.thema_08.pixelgrafik_aufgabe_9a_d;

import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.GreenfootImage;

/**
 * Projekt zu Kap. 6.3. <br>
 *
 * Klasse Zelle <br>
 * Teilaufgaben e) und f)
 */
public class Zelle extends Actor
{
    Color farbe; // Attribut farbe, Datentyp Color

    int farbNr;

    Zelle()
    {
        if (farbNr == 0)
        {
            farbe = Color.BLACK; // weist dem Attribut farbe den Wert BLACK
                                 // (schwarz) zu
        }
        if (farbNr == 1)
        {
            farbe = Color.BLUE;
        }
        if (farbNr == 2)
        {
            farbe = Color.CYAN;
        }
        if (farbNr == 3)
        {
            farbe = Color.GREEN;
        }
    }

    /*
     * Der Programmtext ab hier braucht für die Bearbeitung der Aufgaben weder
     * gelesen noch verstanden zu werden.
     */
    void erstelleBild()
    {
        int cellSize = getWorld().getCellSize();
        GreenfootImage img;
        img = new GreenfootImage(cellSize, cellSize);
        img.setColor(farbe);
        img.fillRect(0, 0, cellSize, cellSize);
        setImage(img);
    }
}
