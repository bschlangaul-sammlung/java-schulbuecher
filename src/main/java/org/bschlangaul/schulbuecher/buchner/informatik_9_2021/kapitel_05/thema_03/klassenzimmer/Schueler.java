package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_05.thema_03.klassenzimmer;

import greenfoot.Actor;

/**
 * Klasse Schueler Kap. 5.1, Arbeitsauftrag 4c) und Aufgabe 1
 */
class Schueler extends Actor
{
    /*
     * Ab hier ist Platz für neue Methoden. Aktuell sind noch keine
     * programmiert. Methoden dürfen nicht nach dem letzten "}" stehen!
     */
    void geheNachLinks()
    {
        setRotation(180);
        move(1);
        setRotation(0);
    }

    void geheNachOben()
    {
        setRotation(270);
        move(1);
        setRotation(0);
    }
}
