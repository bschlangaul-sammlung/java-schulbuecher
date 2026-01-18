package schulbuecher.buchner.informatik_9_2021.kapitel_06.thema_06.kunst_Vorlage;

import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.GreenfootImage;

/**
 * Klasse Zelle <br>
 * Der Programmtext dieser Klasse braucht für die Bearbeitung der
 * Arbeitsaufträge und Aufgaben weder gelesen noch verstanden zu werden.
 */
class Zelle extends Actor
{
    static int zaehler = 0;

    int zahl;

    Zelle()
    {
        zaehler = zaehler + 1;
    }

    Color berechneFarbe()
    {
        zahl = zaehler % 4;
        if (zahl == 0)
        {
            return Color.ORANGE;
        }
        if (zahl == 1)
        {
            return Color.MAGENTA;
        }
        if (zahl == 2)
        {
            return Color.BLUE;
        }
        if (zahl == 3)
        {
            return Color.GREEN;
        }
        return Color.BLACK;
    }

    void erstelleBild()
    {
        int cellSize;
        cellSize = getWorld().getCellSize();
        GreenfootImage img = new GreenfootImage(cellSize, cellSize);
        img.setColor(berechneFarbe());
        img.fillRect(0, 0, cellSize, cellSize);
        setImage(img);
    }
}
