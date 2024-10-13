package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_05.thema_04.hasenjagd_vorlage;

import greenfoot.Actor;
import greenfoot.Greenfoot;

/**
 * Klasse Fuchs <br>
 * Enthält unter anderem die Steuerung des Fuchs-Objekts. <br>
 * Der Programmtext dieser Klasse braucht für die Bearbeitung der
 * Arbeitsaufträge und Aufgaben weder gelesen noch verstanden zu werden.
 */
public class Fuchs extends Actor
{
    Hase hase;

    Fuchs(Hase hase)
    {
        setImage("Fuchs.png");
        this.hase = hase;
    }

    public void act()
    {
        jage();
        testeObGewonnen();
    }

    void jage()
    {
        int xAbstandZuFuchs = gibXAbstandZuHase(); // xHase - xFuchs
        int yAbstandZuFuchs = gibYAbstandZuHase(); // yHase - yFuchs
        int xAbstandAbsolut = gibBetrag(xAbstandZuFuchs); // |xHase - xFuchs|
        int yAbstandAbsolut = gibBetrag(yAbstandZuFuchs); // |yHase - yFuchs|
        if (xAbstandAbsolut > yAbstandAbsolut)
        {
            // Der x-Abstand ist größer, der Fuchs sollte ihn verringern, indem
            // er nach rechts bzw.
            // links geht!
            if (xAbstandZuFuchs < 0)
            {
                setRotation(0); // Schaue nach rechts
            }
            else
            {
                setRotation(180); // Schaue nach links
            }
        }
        else
        {
            /// Der y-Abstand ist größer, der Fuchs sollte ihn verringern, indem
            /// er nach oben bzw.
            /// unten geht!
            if (yAbstandZuFuchs < 0)
            {
                setRotation(90); // Schaue nach oben
            }
            else
            {
                setRotation(270); // Schaue nach unten
            }
        }
        move(1); // Bewege in Blickrichtung
        setRotation(0); // Schaue nach rechts (um Bild gerade zu drehen)
    }

    void laufeZufaellig()
    {
        // Der Zufall entscheidet über die Richtung
        int rnd = Greenfoot.getRandomNumber(4);
        if (rnd == 0)
        {
            setRotation(0); // Schaue nach rechts
        }
        else if (rnd == 1)
        {
            setRotation(90); // Schaue nach unten
        }
        else
        {
            if (rnd == 2)
            {
                setRotation(180); // Schaue nach links
            }
            else
            {
                if (rnd == 3)
                {
                    setRotation(270); // Schaue nach oben
                }
            }
        }
        move(1); // Bewege in Blickrichtung
        setRotation(0); // Schaue nach rechts (um Bild gerade zu drehen)
    }

    int gibXAbstandZuHase()
    {
        return this.getX() - hase.getX();
    }

    int gibYAbstandZuHase()
    {
        return this.getY() - hase.getY();
    }

    int gibBetrag(int x)
    {
        return Math.abs(x);
    }

    void testeObGewonnen()
    {
        if (this.getX() == hase.getX() && this.getY() == hase.getY())
        {
            hase.setImage("Fleisch.png");
            if (this.getX() != 0)
            {
                setRotation(180);
                move(1);
                setRotation(270);
            }
            else
            {
                setRotation(0);
                move(1);
                setRotation(90);
            }
            Greenfoot.stop();
        }
    }
}
