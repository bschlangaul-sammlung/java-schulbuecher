package schulbuecher.buchner.informatik_9_2021.kapitel_07.thema_07.baerenhunger;

import greenfoot.Actor;

public class Gegenstand extends Actor
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
