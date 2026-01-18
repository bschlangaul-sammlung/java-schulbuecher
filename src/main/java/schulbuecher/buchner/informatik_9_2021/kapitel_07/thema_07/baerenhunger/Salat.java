package schulbuecher.buchner.informatik_9_2021.kapitel_07.thema_07.baerenhunger;

import greenfoot.Greenfoot;

public class Salat extends Essen
{
    int drift;

    Salat()
    {
        fallgeschwindigkeit = 8;
        drift = Greenfoot.getRandomNumber(5) - 2;
    }

    public void act()
    {
        int meinX = getX();
        int meinY = getY();
        turn(drehgeschwindigkeit);
        setLocation(meinX + drift, meinY + fallgeschwindigkeit);
    }
}
