package schulbuecher.buchner.informatik_9_2021.kapitel_07.thema_05.licht_aufgabe_3b;

import greenfoot.Color;

/**
 * Ein Objekt der Klasse DauerlichtFarbe ändert seine Farbe während es leuchtet.
 * Kap. 7.5, Aufgabe 3
 */
public class DauerlichtFarbe extends Dauerlicht
{
    void zeigeLichtEin()
    {
        if (farbe == Color.YELLOW)
        {
            farbe = Color.RED;
        }
        else
        {
            if (farbe == Color.RED)
            {
                farbe = Color.BLUE;
            }
            else
            {
                if (farbe == Color.BLUE)
                {
                    farbe = Color.YELLOW;
                }
            }
        }
        licht.setColor(farbe);
        licht.fillOval(0, 0, 100, 100);
        setImage(licht);
    }
}
