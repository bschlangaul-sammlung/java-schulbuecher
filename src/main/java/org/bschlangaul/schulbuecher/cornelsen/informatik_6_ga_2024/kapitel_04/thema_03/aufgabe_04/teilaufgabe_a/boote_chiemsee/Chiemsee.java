package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_03.aufgabe_04.teilaufgabe_a.boote_chiemsee;

/**
 * Verwaltet alle Boote
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
class Chiemsee
{
    /** Verwaltung der Liegeplätze */
    Stegverwaltung steg;

    /**
     * Konstruktor für Objekte der Klasse Chiemsee
     */
    Chiemsee()
    {
        steg = new Stegverwaltung();
        Boot boot;
        for (int i = 0; i < 15; i++)
        {
            boot = new Boot(i, steg);
            boot.start();
        }
    }
}
