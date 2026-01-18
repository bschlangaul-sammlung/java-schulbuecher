package schulbuecher.buchner.informatik_9_2021.kapitel_05.thema_05.hunderennen;

import greenfoot.World;

/**
 * Projekt zu Kap. 5.3 Der Programmtext in dieser Klasse braucht für die
 * Bearbeitung der Arbeitsaufträge und Aufgaben weder gelesen noch verstanden zu
 * werden.
 */
public class Rennbahn extends World
{
    public Rennbahn()
    {
        super(900, 400, 1);
        Hund hundOben = new Hund();
        addObject(hundOben, 100, 80);
        hundOben.setImage("Husky.png");
        Hund hundMitte = new Hund();
        addObject(hundMitte, 100, 200);
        hundMitte.setImage("Dackel.png");
        Hund hundUnten = new Hund();
        addObject(hundUnten, 100, 320);
        hundUnten.setImage("Pudel.png");
    }
}
