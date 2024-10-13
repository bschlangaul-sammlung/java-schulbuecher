package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_06.aufgabe_01.woerterbuch;

/**
 * Beschreibung der Klasse ABSCHLUSS
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class ABSCHLUSS extends LISTENELEMENT
{
    /**
     * Fügt ein Datenelement am Ende der Liste ein
     *
     * @param dneu neues Datenelement
     */
    public KNOTEN HintenEinfuegen(DATENELEMENT dneu)
    {
        KNOTEN kneu;
        kneu = new KNOTEN(dneu, this);
        return kneu;
    }

    /**
     * Fügt ein Datenelement vor einem bestimmten anderen Datenelement ein
     *
     * @param dneu neues Datenelement
     * @param d_vergleich gesuchtes Datenelement, vor dem eingefügt werden soll
     *
     * @return Weitergabe des künftigen Nachfolgers
     */
    public KNOTEN EinfuegenVor(DATENELEMENT dneu, DATENELEMENT d_vergleich)
    {
        return HintenEinfuegen(dneu);
    }

    /**
     * Fügt ein Datenelement sortiert in die Liste ein
     *
     * @param dneu neues Datenelement
     *
     * @return Weitergabe des künftigen Nachfolgers
     */
    public KNOTEN SortiertEinfuegen(DATENELEMENT dneu)
    {
        return HintenEinfuegen(dneu);
    }

    /**
     * Entfernt einen Knoten, der über sein Datenelement identifiziert wird, aus
     * der Liste
     *
     * @param dvergleich gesuchtes Datenelement
     *
     * @return Weitergabe des künftigen Nachfolgers
     */
    public LISTENELEMENT KnotenEntfernen(DATENELEMENT dvergleich)
    {
        return null;
    }

    /**
     * Gibt das Datenelement des letzten Knotens aus
     *
     * @return hinterstes Datenelement (Vorgänger von Abschluss)
     */
    public DATENELEMENT EndeGeben(DATENELEMENT d)
    {
        return d;
    }

    /**
     * Gibt den letzten Knoten aus und entfernt ihn aus der Liste
     *
     * @return bisheriger letzter Knoten
     */
    public LISTENELEMENT EndeEntfernen(DATENELEMENT d)
    {
        return this;
    }

    /**
     * Gibt Information über das Datenelement und den Nachfolger des Knotens
     * aus.
     */
    public void InformationAusgeben()
    {
    }

    /**
     * Sucht ein Datenelement, das über seinen Schlüssel identifiziert wird, und
     * gibt es aus.
     *
     * @param vergleichswert Schlüssel vom Typ String
     *
     * @return gesuchtes Datenelement
     */
    public DATENELEMENT Suchen(String vergleichswert)
    {
        return null;
    }

    /**
     * Gibt die Länge der Restliste aus
     *
     * @return Länge der Restliste
     */
    public int RestlaengeGeben()
    {
        return 0;
    }

    /**
     * Gibt eine Referenz auf das Datenelement aus
     *
     * @return Datenelement
     */
    public DATENELEMENT DatenelementGeben()
    {
        return null;
    }

    /**
     * Gibt eine Referenz auf den Nachfolger aus
     *
     * @return Nachfolger
     */
    public LISTENELEMENT NachfolgerGeben()
    {
        return this;
    }
}
