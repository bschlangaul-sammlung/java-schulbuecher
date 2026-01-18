package schulbuecher.buchner.informatik_9_2021.kapitel_07.thema_02.tiere_2;

import greenfoot.World;

/**
 * Projekt zu Kap. 7.2. <br>
 *
 * Klasse Tierwelt <br>
 * Hier müssen die Objekte erzeugt und in die Welt eingefügt werden, um sichtbar
 * zu sein.
 */
public class Tierwelt extends World
{
    public Tierwelt()
    {
        super(15, 4, 60); // erzeugt eine Welt mit 15x4 Zellen der Seitenlänge
                          // 60
        erstelleHintergrund(); // fügt Wasser, Gras und Steine in die Welt ein
        addObject(new Biene(), 2, 1); // erzeugt ein Objekt der Klasse Biene und
                                      // fügt es an der
                                      // Stelle (2|1) ein
        addObject(new Eisbaer(), 2, 2); // erzeugt ein Objekt der Klasse Eisbaer
                                        // und fügt es an der
                                        // Stelle (2|2) ein
        addObject(new Fisch(), 2, 3); // erzeugt ein Objekt der Klasse Fisch und
                                      // fügt es an der
                                      // Stelle (2|3) ein
        // Aufgabe 1
    }

    /*
     * Der Programmtext ab hier braucht für die Bearbeitung der Arbeitsaufträge
     * und Aufgaben weder gelesen noch verstanden zu werden.
     */
    void erstelleHintergrund()
    {
        addObject(new Wasser(), 2, 3);
        addObject(new Wasser(), 3, 3);
        int i = 0;
        while (i < getHeight())
        {
            addObject(new Wasser(), 4, i);
            addObject(new Wasser(), 5, i);
            addObject(new Wasser(), 6, i);
            addObject(new Gras(), 7, i);
            addObject(new Gras(), 8, i);
            addObject(new Gras(), 9, i);
            addObject(new Gras(), 10, i);
            addObject(new Gras(), 12, i);
            addObject(new Gras(), 13, i);
            addObject(new Gras(), 14, i);
            addObject(new Stein(), 11, i);
            i = i + 1;
        }
    }
}
