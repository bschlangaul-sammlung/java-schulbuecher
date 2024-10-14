package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_05.aufgabe_03.grundstruktur_ohne_Interface;

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
    private Patient daten;

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
    Knoten(Patient dNeu, Listenelement lNeu)
    {
        daten = dNeu;
        nachfolger = lNeu;
    }
}
