package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_05.thema_03.klassenzimmer_vorlage;

import greenfoot.Actor;

/**
 * Klasse Lehrer <br>
 * Kap. 5.1, Arbeitsaufträge 2 und 3
 */
public class Lehrer extends Actor
{
    void geheNachOben() // bewegt die Lehrerin nach oben
    {
        setRotation(270); // dreht das Objekt, so dass die Bewegungsrichtung
                          // nach oben zeigt
        move(1); // bewegt das Objekt um eine Zelle in Blickwegungsrichtung
        setRotation(0); // dreht das Objekt, so dass die Bewegungsrichtung nach
                        // rechts zeigt
    }

    void geheNachLinks() // bewegt die Lehrerin nach links
    {
        setRotation(180); // dreht das Objekt, so dass die Bewegungsrichtung
                          // nach links zeigt
        move(1); // bewegt das Objekt um eine Zelle in Blickwegungsrichtung
        setRotation(0); // dreht das Objekt, so dass die Bewegungsrichtung nach
                        // rechts zeigt
    }
}
