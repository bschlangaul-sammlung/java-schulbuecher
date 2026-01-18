package schulbuecher.buchner.informatik_9_2021.kapitel_06.thema_05.random_walk_a2c2;

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
        int as; // für die Wahrscheinlichkeit mehr als einen
                // nach oben/unten zu machen
        int dy; // für die Anzahl der Schritte nach oben/unten
        while (x < breite) // wiederhole bis der rechte Rand erreicht ist
        {
            faerbeZelle(x, y); // Methode vorhanden
            x = x + 1; // neue x-Koordinate: 1 Schritt nach rechts
            zz = gibZufallszahl(); // Zufallszahl zwischen 1 und 100, Methode
                                   // vorhanden
            as = gibZufallszahl();
            if (as <= 50)
            {
                dy = 1;
            }
            else
            {
                dy = 2;
            }
            if (zz <= 30) // mit 30% Wahrscheinlichkeit ...
            {
                y = y - dy; // ... einen oder mehr Schritte nach oben
            }
            if (zz > 70) // mit 30% Wahrscheinlichkeit ...
            {
                y = y + dy; // ... einen oder mehr Schritte nach unten
            }
            // Mit den restlichen 40% Wahrscheinlichkeit wird y nicht geändert.
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
