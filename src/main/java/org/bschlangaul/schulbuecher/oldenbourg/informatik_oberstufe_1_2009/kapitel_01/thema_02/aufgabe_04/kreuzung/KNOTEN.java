package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_02.aufgabe_04.kreuzung;

/**
 * Beschreibung der Klasse KNOTEN
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class KNOTEN
{
    /**
     * Datenelement des Knotens
     */
    private DATENELEMENT daten;

    /**
     * Verwaltung des nachfolgenden Knotens in der Warteschlange.
     */
    private KNOTEN nachfolger;

    /**
     * Konstruktor des Patienten
     *
     * @param dneu neu einzufügendes Datenelement
     */
    KNOTEN(DATENELEMENT dneu)
    {
        daten = dneu;
        nachfolger = null;
    }

    /**
     * Nachfolger des Knotens setzen
     *
     * @param nf neuer Nachfolger
     */
    void NachfolgerSetzen(KNOTEN nf)
    {
        nachfolger = nf;
    }

    /**
     * Gibt den Nachfolger des Knotens aus.
     *
     * @return nachfolger
     */
    KNOTEN NachfolgerGeben()
    {
        return nachfolger;
    }

    /**
     * Gibt das Datenelement des Knotens aus.
     *
     * @return daten
     */
    DATENELEMENT DatenelementGeben()
    {
        return daten;
    }

    /**
     * Ruft die gleichnamige Methode des Datenelements aus.
     */
    void InformationAusgeben()
    {
        daten.InformationAusgeben();
    }
}
