package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_05.aufgabe_14.lotto;

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
     * @param zahlNeu übergebenes Datenelement
     */
    abstract int EndeGeben(int zahlNeu);

    /**
     * Entfernt den Knoten, dessen Datenelement das übergebene ist.
     *
     * @param zahlNeu übergebenes Datenelement
     *
     * @return Listenelement
     */
    abstract Listenelement KnotenEntfernen(int zahlNeu);

    /**
     * Gibt das Datenelement eines Knoten zurück
     *
     * @return zahl
     */
    abstract int ZahlGeben();

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
     * @param zahlNeu neues Datenelement
     *
     * @return Knoten als neuer Nachfolger
     */
    abstract Knoten HintenEinfügen(int zahlNeu);

    /**
     * Fügt ein neues Datenelement vor einem bestimmten Datenelement ein.
     *
     * @param zahlNeu neues Datenelement
     * @param zahlVergleich Datenelement, vor dem eingefügt werden soll
     *
     * @return Knoten als neuer Nachfolger für den Vorgänger
     */
    abstract Knoten EinfügenVor(int zahlNeu, int zahlVergleich);

    /**
     * Sucht ein Datenelement mit einem bestimmten Schlüsselwert in der Liste
     * und gibt es zurück.
     *
     * @param schlüssel Wert, nach dem gesucht wird
     *
     * @return gesuchtes Datenelement
     */
    abstract int Suchen(String schlüssel);

    /**
     * Sortiertes Einfügen in die Liste
     *
     * @param zahlNeu neues Datenelement
     *
     * @return Knoten als neuer Nachfolger für den Vorgänger
     */
    abstract Knoten SortiertEinfügen(int zahlNeu);
}
