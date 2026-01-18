package schulbuecher.buchner.informatik_9_2021.kapitel_05.thema_03.klassenzimmer;

import greenfoot.Actor;

class Lehrer extends Actor
{
    /**
     * Die Methode bewegt die Lehrerin nach links
     */
    void geheNachLinks()
    {
        setRotation(180);
        move(1);
        setRotation(0);
    }

    /**
     * Die Methode bewegt die Lehrerin nach oben
     */
    void geheNachOben()
    {
        setRotation(270);
        move(1);
        setRotation(0);
    }
}
