package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_05.aufgabe_11.liste_komplett_mit_interface_und_visualisierung;

/**
 * Abstrakte Klasse Listenelement als Oberklasse für Knoten und Abschluss
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
public abstract class Listenelement
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
     */
    abstract Datenelement EndeGeben(Datenelement dNeu);

    /**
     * Entfernt den Knoten, dessen Datenelement das übergebene ist.
     *
     * @param dNeu übergebenes Datenelement
     *
     * @return Listenelement
     */
    abstract Listenelement KnotenEntfernen(Datenelement dNeu);

    /**
     * Gibt das Datenelement eines Knoten zurück
     *
     * @return daten
     */
    abstract Datenelement DatenelementGeben();

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
    abstract Knoten HintenEinfügen(Datenelement dNeu);

    /**
     * Fügt ein neues Datenelement vor einem bestimmten Datenelement ein.
     *
     * @param dNeu neues Datenelement
     * @param dVergleich Datenelement, vor dem eingefügt werden soll
     *
     * @return Knoten als neuer Nachfolger für den Vorgänger
     */
    abstract Knoten EinfügenVor(Datenelement dNeu, Datenelement dVergleich);

    /**
     * Sucht ein Datenelement mit einem bestimmten Schlüsselwert in der Liste
     * und gibt es zurück.
     *
     * @param schlüssel Wert, nach dem gesucht wird
     *
     * @return gesuchtes Datenelement
     */
    abstract Datenelement Suchen(String schlüssel);

    /**
     * Sortiertes Einfügen in die Liste
     *
     * @param dNeu neues Datenelement
     *
     * @return Knoten als neuer Nachfolger für den Vorgänger
     */
    abstract Knoten SortiertEinfügen(Datenelement dNeu);

}
