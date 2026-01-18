package schulbuecher.buchner.informatik_9_2021.kapitel_06.thema_03.ballspiel_vorlage;

import greenfoot.Actor;
import greenfoot.Greenfoot;

/**
 * Klasse Schlaeger <br>
 * Kap. 6.3 Arbeitsauftrag 3, Aufgabe 1
 */
public class Schlaeger extends Actor
{
    boolean autopilot;

    Ball ball;

    public Schlaeger(Ball parameterBall)
    {
        autopilot = false;
        ball = parameterBall;
        setRotation(90);
    }

    public void act()
    {
        // Kapitel 6-3 A3
        if (Greenfoot.isKeyDown("space"))
        {
            if (Greenfoot.isKeyDown("left") && istLinkerSchlaeger())
            {
                autopilot = !autopilot;
            }
            if (Greenfoot.isKeyDown("right") && istRechterSchlaeger())
            {
                autopilot = !autopilot;
            }
        }
    }

    public boolean istLinkerSchlaeger()
    {
        return getX() < 100;
    }

    public boolean istRechterSchlaeger()
    {
        return getX() > 100;
    }

    public int gibYAbstandZuBall()
    {
        return this.getY() - ball.getY();
    }
}
