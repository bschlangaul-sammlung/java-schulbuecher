package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_06.aufgabe_01.woerterbuch;

/**
 * Beschreibung der abstrakten Klasse LISTENELEMENT
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
abstract class ListenElement
{
    /**
     * Fügt ein Datenelement am Ende der Liste ein
     *
     * @param dneu neues Datenelement
     */
    abstract Knoten HintenEinfuegen(DatenElement dneu);

    /**
     * Fügt ein Datenelement vor einem bestimmten anderen Datenelement ein
     *
     * @param dneu neues Datenelement
     * @param d_vergleich gesuchtes Datenelement, vor dem eingefügt werden soll
     *
     * @return Weitergabe des künftigen Nachfolgers
     */
    abstract Knoten EinfuegenVor(DatenElement dneu, DatenElement d_vergleich);

    /**
     * Fügt ein Datenelement sortiert in die Liste ein
     *
     * @param dneu neues Datenelement
     *
     * @return Weitergabe des künftigen Nachfolgers
     */
    abstract Knoten SortiertEinfuegen(DatenElement dneu);

    /**
     * Entfernt einen Knoten, der über sein Datenelement identifiziert wird, aus
     * der Liste
     *
     * @param dvergleich gesuchtes Datenelement
     *
     * @return Weitergabe des künftigen Nachfolgers
     */
    abstract ListenElement KnotenEntfernen(DatenElement dvergleich);

    /**
     * Gibt das Datenelement des letzten Knotens aus
     *
     * @return hinterstes Datenelement
     */
    abstract DatenElement EndeGeben(DatenElement d);

    /**
     * Gibt den letzten Knoten aus und entfernt ihn aus der Liste
     *
     * @return bisheriger letzter Knoten
     */
    abstract ListenElement EndeEntfernen(DatenElement d);

    /**
     * Gibt Information über das Datenelement und den Nachfolger des Knotens
     * aus.
     */
    abstract void InformationAusgeben();

    /**
     * Sucht ein Datenelement, das über seinen Schlüssel identifiziert wird, und
     * gibt es aus.
     *
     * @param vergleichswert Schlüssel vom Typ String
     *
     * @return gesuchtes Datenelement
     */
    abstract DatenElement Suchen(String vergleichswert);

    /**
     * Gibt die Länge der Restliste aus
     *
     * @return Länge der Restliste
     */
    abstract int RestlaengeGeben();

    /**
     * Gibt eine Referenz auf das Datenelement aus
     *
     * @return Datenelement
     */
    abstract DatenElement DatenelementGeben();

    /**
     * Gibt eine Referenz auf den Nachfolger aus
     *
     * @return Nachfolger
     */
    abstract ListenElement NachfolgerGeben();
}
