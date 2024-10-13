package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_04.thema_04.aufgabe1_kantine;

/**
 * Klasse Schueler, für Kapitel 4.2 Aufgabe 2
 *
 * @author Barbara Wieczorek
 *
 * @version 2022-02-28
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

    void giesseEin(Tasse eineTasse, double wieviel)
    {
        eineTasse.erhoeheFuellstand(wieviel);
    }

    void trinke(Tasse eineTasse, double wieviel)
    {
        eineTasse.verringereFuellstand(wieviel);
    }
}
