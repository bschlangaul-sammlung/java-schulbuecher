package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_05.aufgabe_11.liste_komplett_ohne_Interface;

/**
 * Klasse zur Kennzeichnung des Endes der Liste
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Abschluss extends Listenelement
{

    /**
     * Gibt die Länge zurück.
     *
     * @return Länge
     */
    @Override
    int RestlängeGeben()
    {
        return 0;
    }

    /**
     * Gibt das Datenelement des Vorgängers (also des letzten Knotens) zurück
     *
     * @param dNeu übergebenes Datenelement
     *
     * @return übergebenes Datenelement
     */
    @Override
    Patient EndeGeben(Patient dNeu)
    {
        return dNeu;
    }

    /**
     * Entfernt den Knoten, dessen Datenelement das übergebene ist.
     *
     * @param dNeu übergebenes Datenelement
     *
     * @return gibt sich selbst zurück
     */
    @Override
    Listenelement KnotenEntfernen(Patient dNeu)
    {
        return this;
    }

    /**
     * Da der Abschluss kein Datenelement hat, gibt er null zurück
     *
     * @return null
     */
    @Override
    Patient DatenelementGeben()
    {
        return null;
    }

    /**
     * Da der Abschluss keinen Nachfolger hat, gibt er sich selbst zurück
     *
     * @return nachfolger
     */
    @Override
    Listenelement NachfolgerGeben()
    {
        return this;
    }

    /**
     * Gibt die Information zu den Datenelementen auf der Konsole aus
     */
    @Override
    void InformationAusgeben()
    {
    }

    /**
     * Fügt das Datenelement am Ende ein.
     *
     * @param dNeu neues Datenelement
     *
     * @return (neuer) Knoten als neuer Nachfolger des bisherigen Vorgängers
     */
    @Override
    Knoten HintenEinfügen(Patient dNeu)
    {
        return new Knoten(dNeu, this);
    }

    /**
     * Fügt ein neues Datenelement vor einem bestimmten Datenelement ein.
     *
     * @param dNeu neues Datenelement
     * @param dVergleich Datenelement, vor dem eingefügt werden soll
     *
     * @return Knoten als neuer Nachfolger für den alten Vorgänger
     */
    @Override
    Knoten EinfügenVor(Patient dNeu, Patient dVergleich)
    {
        return new Knoten(dNeu, this);
    }

    /**
     * Sucht ein Datenelement mit einem bestimmten Schlüsselwert in der Liste
     * und gibt es zurück.
     *
     * @param schlüssel Wert, nach dem gesucht wird
     *
     * @return gesuchtes Datenelement
     */
    @Override
    Patient Suchen(String schlüssel)
    {
        return null;
    }

    /**
     * Sortiertes Einfügen in die Liste
     *
     * @param dNeu neues Datenelement
     *
     * @return Knoten als neuer Nachfolger für den Vorgänger
     */
    @Override
    Knoten SortiertEinfügen(Patient dNeu)
    {
        return new Knoten(dNeu, this);
    }
}
