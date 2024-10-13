package org.bschlangaul.schulbuecher.cornelsen.informatik_6.kapitel_01.thema_05.aufgabe_03.grundstruktur_mit_interface;

/**
 * Beschreibung der Klasse Knoten
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
@SuppressWarnings("unused")

class Knoten extends Listenelement
{
    /**
     * Verwaltung der Daten
     */
    private Datenelement daten;

    /**
     * Verwaltung des nachfolgenden Knotens in der Liste
     */
    private Listenelement nachfolger;

    /**
     * Konstruktor des Knotens
     *
     * @param dNeu Datenelement
     * @param lNeu neuer Nachfolger
     */
    Knoten(Datenelement dNeu, Listenelement lNeu)
    {
        daten = dNeu;
        nachfolger = lNeu;
    }
}
