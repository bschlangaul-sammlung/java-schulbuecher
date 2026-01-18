package schulbuecher.buchner.informatik_9_2021.kapitel_07.thema_05.licht_aufgabe_2b;

import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

/**
 * Oberklasse für die Lichter.
 *
 */
class Licht extends Actor
{
    GreenfootImage licht = new GreenfootImage(100, 100);

    Color farbe = Color.YELLOW;

    boolean istAn;

    Licht()
    {
        istAn = false;
        zeigeLichtAus();
    }

    void schalteUm()
    {
        istAn = !istAn; // vertauscht true und false
    }

    void zeigeLichtEin()
    {
        licht.setColor(farbe);
        licht.fillOval(0, 0, 100, 100);
        setImage(licht);
    }

    void zeigeLichtAus()
    {
        licht.setColor(Color.WHITE);
        licht.fillOval(0, 0, 100, 100);
        setImage(licht);
    }

    void leuchte()
    {
        if (istAn == true)
        {
            zeigeLichtEin();
        }
        else
        {
            zeigeLichtAus();
        }
    }

    void setzeFarbe(Color neueFarbe)
    {
        farbe = neueFarbe;
    }

    Color gibFarbe()
    {
        return farbe;
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            schalteUm();
        }
        if (farbe == Color.YELLOW)
        {
            farbe = Color.RED;
        }
        else
        {
            farbe = Color.YELLOW;
        }
        leuchte();
    }
}
