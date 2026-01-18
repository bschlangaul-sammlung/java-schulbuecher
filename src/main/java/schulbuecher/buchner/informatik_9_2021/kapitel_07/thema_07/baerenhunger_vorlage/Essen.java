package schulbuecher.buchner.informatik_9_2021.kapitel_07.thema_07.baerenhunger_vorlage;

import greenfoot.Actor;

/**
 * Klasse Essen <br>
 *
 * Objekte dieser Klasse erscheinen am oberen Bildschirmrand, fallen nach unten
 * und drehen sich dabei.
 */
public class Essen extends Actor
{
    int fallgeschwindigkeit = 6;

    int drehgeschwindigkeit = 2;

    public void act()
    {
        int meinX = getX(); // x-Koordinate des Objekts
        int meinY = getY(); // y-Koordinate des Objekts
        turn(drehgeschwindigkeit); // Drehung um den Winkel drehgeschwindigkeit
        setLocation(meinX, meinY + fallgeschwindigkeit); // verschieben an die
                                                         // neue Position
    }
}
