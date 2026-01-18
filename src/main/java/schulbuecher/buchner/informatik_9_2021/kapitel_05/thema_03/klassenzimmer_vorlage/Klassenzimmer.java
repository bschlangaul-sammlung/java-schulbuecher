package schulbuecher.buchner.informatik_9_2021.kapitel_05.thema_03.klassenzimmer_vorlage;

import greenfoot.World;

/**
 * Projekt zu Kap. 5.3 <br>
 * Der Programmtext dieser Klasse braucht für die Bearbeitung der
 * Arbeitsaufträge und Aufgaben weder gelesen noch verstanden zu werden.
 */
public class Klassenzimmer extends World
{
    public Klassenzimmer()
    {
        super(6, 4, 100);
        addObject(new Sitzplatz(), 0, 1);
        addObject(new Sitzplatz(), 1, 1);
        addObject(new Sitzplatz(), 4, 1);
        addObject(new Sitzplatz(), 5, 1);
        Schueler stefan = new Schueler();
        addObject(stefan, 1, 0);
    }
}
