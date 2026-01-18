package schulbuecher.buchner.informatik_9_2021.kapitel_06.thema_05.random_walk_a2b;

import greenfoot.Greenfoot;
import greenfoot.World;

/**
 * Projekt zum Kompetenzerwerb
 *
 */
public class Zufallsweg extends World
{
    int breite = 300; // Breite der Welt (= Länge des Weges)

    int hoehe = 21; // Höhe der Welt (= Breite des Weges)

    public Zufallsweg(int neueBreite, int neueHoehe)
    {
        super(neueBreite, neueHoehe, 3);
        breite = neueBreite;
        hoehe = neueHoehe;
        gehe();
    }

    public Zufallsweg()
    {
        super(300, 21, 3);
        gehe();
    }

    void gehe()
    {
        int x = 0; // x-Koordinate der Zellen links
        int y = hoehe / 2; // y-Koordinaten der Zellen in der Mitte
        int zz; // für die Zufallszahl
        while (x < breite) // wiederhole bis der rechte Rand erreicht ist
        {
            faerbeZelle(x, y); // Methode vorhanden
            x = x + 1; // neue x-Koordinate: 1 Schritt nach rechts
            zz = gibZufallszahl(); // Zufallszahl zwischen 1 und 100, Methode
                                   // vorhanden
            if (zz <= 50) // mit 50% Wahrscheinlichkeit ...
            {
                y = y - 1; // ... einen Schritt nach oben
            }
            else // ... sonst
            {
                y = y + 1; // ... einen Schritt nach unten
            }
            // Überschreitet y den erlaubten Wert, wird x so hoch gesetzt,
            // dass die Wiederholung nicht nochmals durchgeführt wirde.
            if (y < 0 || y >= hoehe)
            {
                x = breite + 1;
            }
        }
    }

    /**
     * gibZufallsZahl() Liefert eine Zufallszahl zwischen 1 und 100
     */
    int gibZufallszahl()
    {
        return Greenfoot.getRandomNumber(100) + 1;
    }

    void faerbeZelle(int x, int y)
    {
        Zelle zelle = new Zelle();
        addObject(zelle, x, y);
        zelle.erstelleBild();
    }
}
