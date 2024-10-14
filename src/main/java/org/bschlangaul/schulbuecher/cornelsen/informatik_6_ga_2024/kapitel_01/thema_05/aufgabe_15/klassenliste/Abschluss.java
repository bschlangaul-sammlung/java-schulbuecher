package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_05.aufgabe_15.klassenliste;

/**
 * Klasse zur Kennzeichnung des Ende der Liste
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
    Datenelement EndeGeben(Datenelement dNeu)
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
    Listenelement KnotenEntfernen(Datenelement dNeu)
    {
        return this;
    }

    /**
     * Da der Abschluss kein Datenelement hat, gibt er null zurück
     *
     * @return null
     */
    @Override
    Datenelement DatenelementGeben()
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
     * Fügt das Datenelement am Ende ein.
     *
     * @param dNeu neues Datenelement
     *
     * @return (neuer) Knoten als neuer Nachfolger des bisherigen Vorgängers
     */
    @Override
    Knoten HintenEinfügen(Datenelement dNeu)
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
    Knoten EinfügenVor(Datenelement dNeu, Datenelement dVergleich)
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
    Datenelement Suchen(String schlüssel)
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
    Knoten SortiertEinfügen(Datenelement dNeu)
    {
        return new Knoten(dNeu, this);
    }

    /**
     * Entfernt eine Person aus der Liste
     *
     * @param name Name der Person
     *
     * @return Abschluss gibt sich selbst zurück
     */
    @Override
    Listenelement Entfernen(String name)
    {
        return this;
    }

    /**
     * Gibt die Liste aller Namen zurück
     *
     * @return Namensliste
     */
    @Override
    String NamenslisteGeben()
    {
        return "";
    }
}
