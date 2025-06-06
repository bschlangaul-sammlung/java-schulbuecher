package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_03.thema_01.aufgabe_10.listen_und_baeume;

/**
 * Abstrakte Klasse Listenelement als Oberklasse für Knoten und Abschluss
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
abstract class Listenelement
{
    /**
     * Gibt die Länge zurück.
     *
     * @return Länge
     */
    abstract int RestlängeGeben();

    /**
     * Gibt das Datenelement des letzten Knoten zurück
     *
     * @param dNeu übergebenes Datenelement
     *
     * @return hinterstes Datenelement
     */
    abstract Patient EndeGeben(Patient dNeu);

    /**
     * Entfernt den Knoten, dessen Datenelement das übergebene ist.
     *
     * @param dNeu übergebenes Datenelement
     *
     * @return Listenelement
     */
    abstract Listenelement KnotenEntfernen(Patient dNeu);

    /**
     * Gibt das Datenelement eines Knoten zurück
     *
     * @return daten
     */
    abstract Patient DatenelementGeben();

    /**
     * Gibt den Nachfolger eines Knoten zurück
     *
     * @return nachfolger
     */
    abstract Listenelement NachfolgerGeben();

    /**
     * Gibt die Information zu den Datenelementen auf der Konsole aus
     */
    abstract void InformationAusgeben();

    /**
     * Fügt das Datenelement am Ende ein.
     *
     * @param dNeu neues Datenelement
     *
     * @return Knoten als neuer Nachfolger
     */
    abstract KnotenListe HintenEinfügen(Patient dNeu);

    /**
     * Fügt ein neues Datenelement vor einem bestimmten Datenelement ein.
     *
     * @param dNeu neues Datenelement
     * @param dVergleich Datenelement, vor dem eingefügt werden soll
     *
     * @return Knoten als neuer Nachfolger für den Vorgänger
     */
    abstract KnotenListe EinfügenVor(Patient dNeu, Patient dVergleich);

    /**
     * Sucht ein Datenelement mit einem bestimmten Schlüsselwert in der Liste
     * und gibt es zurück.
     *
     * @param schlüssel Wert, nach dem gesucht wird
     *
     * @return gesuchtes Datenelement
     */
    abstract Patient Suchen(String schlüssel);

    /**
     * Sortiertes Einfügen in die Liste
     *
     * @param dNeu neues Datenelement
     *
     * @return Knoten als neuer Nachfolger für den Vorgänger
     */
    abstract KnotenListe SortiertEinfügen(Patient dNeu);
}
