package org.bschlangaul.schulbuecher.cornelsen.informatik_6.kapitel_01.thema_02.aufgabe_02.arzt_mit_visualisierung;

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
     * Verwaltung der Daten des Patienten
     */
    private Patient daten;

    /**
     * Konstruktor des Patienten
     *
     * @param dneu Datenelement
     */
    Knoten(Patient dneu)
    {
        nachfolger = null;
        daten = dneu;
    }

    /**
     * Nachfolger des Patienten setzen
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
    Patient DatenelementGeben()
    {
        return daten;
    }

    /**
     * Gibt Information über den Patienten aus.
     */
    void InformationAusgeben()
    {
        daten.InformationAusgeben();
    }
}
