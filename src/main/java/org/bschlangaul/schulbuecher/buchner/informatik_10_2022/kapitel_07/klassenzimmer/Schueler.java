package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_07.klassenzimmer;

/**
 * Klasse Schueler, für Kapitel 4.4 Aufgabe 1
 *
 * @author Barbara Wieczorek
 *
 * @version 2022-06-03
 */
class Schueler
{
    String vorname;

    String name;

    /**
     * Konstruktor für Objekte der Klasse Schueler
     */
    Schueler(String einVorname, String einName)
    {
        vorname = einVorname;
        name = einName;
    }

    String gibName()
    {
        return vorname + " " + name;
    }
}
