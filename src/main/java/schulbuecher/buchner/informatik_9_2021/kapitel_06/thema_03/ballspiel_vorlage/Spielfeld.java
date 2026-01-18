package schulbuecher.buchner.informatik_9_2021.kapitel_06.thema_03.ballspiel_vorlage;

import greenfoot.World;

/**
 * Projekt zu Kap. 6.3. <br>
 *
 * Klasse Spielfeld <br>
 * Der Programmtext dieser Klasse braucht für die Bearbeitung der
 * Arbeitsaufträge und Aufgaben weder gelesen noch verstanden zu werden.
 */
public class Spielfeld extends World
{
    public Spielfeld()
    {
        super(600, 400, 1);
        Ball ball = new Ball();
        addObject(ball, 300, 200);
        Schlaeger rechts = new Schlaeger(ball);
        addObject(rechts, 580, 200);
        Schlaeger links = new Schlaeger(ball);
        addObject(links, 20, 200);
        links.autopilot = true;
    }
}
