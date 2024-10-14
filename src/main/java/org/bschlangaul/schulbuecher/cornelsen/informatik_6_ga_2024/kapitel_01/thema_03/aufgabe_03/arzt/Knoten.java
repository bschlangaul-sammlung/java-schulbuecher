package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_03.aufgabe_03.arzt;

/**
 * Beschreibung der Klasse Knoten
 *
 * @author Klaus Reinold
 *
 * @version 0.9
 */
class Knoten
{
    /**
     * Verwaltung des nachfolgenden Knoten in der Warteschlange.
     */
    private Knoten nachfolger;

    /**
     * Verwaltung der Daten
     */
    private Datenelement daten;

    /**
     * Konstruktor des Knoten
     *
     * @param dneu Datenelement
     */
    Knoten(Datenelement dneu)
    {
        nachfolger = null;
        daten = dneu;
    }

    /**
     * Nachfolger des Knoten setzen
     *
     * @param nf neuer Nachfolger
     */
    void NachfolgerSetzen(Knoten nf)
    {
        nachfolger = nf;
    }

    /**
     * Gibt den Nachfolger des Knoten aus.
     *
     * @return Nachfolger
     */
    Knoten NachfolgerGeben()
    {
        return nachfolger;
    }

    /**
     * Gibt das Datenelement zurück
     *
     * @return Datenelement
     */
    Datenelement DatenelementGeben()
    {
        return daten;
    }

    /**
     * Gibt Information über das Datenelement aus.
     */
    void InformationAusgeben()
    {
        daten.InformationAusgeben();
    }
}
