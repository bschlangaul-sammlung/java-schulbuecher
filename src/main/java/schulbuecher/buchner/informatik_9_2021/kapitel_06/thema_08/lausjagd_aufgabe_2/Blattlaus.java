package schulbuecher.buchner.informatik_9_2021.kapitel_06.thema_08.lausjagd_aufgabe_2;

import greenfoot.Actor;
import greenfoot.Greenfoot;

/**
 * Klasse Blattlaus <br>
 * Enthält unter anderem die Steuerung der Blattlaus-Objekte. <br>
 * Der Programmtext dieser Klasse braucht für die Bearbeitung der
 * Arbeitsaufträge und Aufgaben weder gelesen noch verstanden zu werden.
 */
public class Blattlaus extends Actor
{
    public void act()
    {
        double rnd = Math.random();
        Blattlaus naechste = gibNaehesteBlattlaus();
        Marienkaefer kaefer = gibKaefer();
        if (naechste != null && rnd < 0.3)
        {
            int rotation = berechneWinkelZwischen(this, naechste);
            double distanz = berechneDistanzZwischen(this, naechste);
            if (distanz > 15)
            {
                setRotation(rotation);
                move(1);
            }
            else
            {
                setRotation(rotation + 180);
                move(1);
            }
        }
        else
        {
            if (rnd < 0.8 && berechneDistanzZwischen(this, kaefer) < 100)
            {
                int rotation = berechneWinkelZwischen(this, gibKaefer());
                setRotation(rotation + 180);
                move(3);
            }
            else
            {
                setRotation(Greenfoot.getRandomNumber(360));
                move(2);
            }
        }
        if (getX() < 100)
        {
            setLocation(100, getY());
        }
        if (getX() > 700)
        {
            setLocation(700, getY());
        }
    }

    Marienkaefer gibKaefer()
    {
        return getWorld().getObjects(Marienkaefer.class).get(0);
    }

    Blattlaus gibNaehesteBlattlaus()
    {
        double kleinsteEntfernung = Double.POSITIVE_INFINITY;
        Blattlaus naechste = null;
        for (Blattlaus laus : getWorld().getObjects(Blattlaus.class))
        {
            if (laus != this)
            {
                double dist = berechneDistanzZwischen(this, laus);
                if (dist < kleinsteEntfernung)
                {
                    kleinsteEntfernung = dist;
                    naechste = laus;
                }
            }
        }
        return naechste;
    }

    double berechneDistanzZwischen(Actor actor1, Actor actor2)
    {
        int dx = actor1.getX() - actor2.getX();
        int dy = actor1.getY() - actor2.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    int berechneWinkelZwischen(Actor start, Actor dest)
    {
        int dx = dest.getX() - start.getX();
        int dy = dest.getY() - start.getY();
        return berechneRotationAusVektor(dx, dy);
    }

    int berechneRotationAusVektor(int dx, int dy)
    {
        double winkelPolar = Math.atan2(-dy, dx); // -dy: Greenfoot Koordinaten
                                                  // sind gespiegelt
        double winkelGrad = (winkelPolar / Math.PI * 180 + 360) % 360; // Polar
                                                                       // ->
                                                                       // Grad
        double winkelGreenfoot = 360 - winkelGrad; // Greenfoot Rotation ist
                                                   // gespiegelt
        return (int) winkelGreenfoot;
    }
}
