package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_05.aufgabe_05.cheese_champions;

/**
 * Beschreibung des Stapels überschreibt die nicht benötigten Methoden der
 * Liste.
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class STAPEL extends LISTE
{
    /**
     * Konstruktor des Stapels
     *
     */
    STAPEL()
    {
        super();
    }

    /**
     * Fügt ein neues Datenelement am Ende der Liste ein. <br>
     * Ohne Funktion für den Stapel, deshalb überschrieben
     *
     * @param dneu neues Datenelement
     */
    void HintenEinfuegen(DATENELEMENT dneu)
    {
    }

    /**
     * Fügt ein neues Datenelement vor einem bestimmten Datenelement ein. <br>
     * Ohne Funktion für den Stapel, deshalb überschrieben
     *
     * @param dneu neues Datenelement
     * @param d_vergleich Datenelement, vor dem eingefügt werden soll
     */
    void EinfuegenVor(DATENELEMENT dneu, DATENELEMENT d_vergleich)
    {
    }

    /**
     * Fügt ein neues Datenelement sortiert in die Liste ein. <br>
     * Ohne Funktion für den Stapel, deshalb überschrieben
     *
     * @param dneu neues Datenelement
     */
    void SortiertEinfuegen(DATENELEMENT dneu)
    {
    }

    /**
     * Entfernt einen Knoten mit einem bestimmten Datenelement aus der Liste
     * <br>
     * Ohne Funktion für den Stapel, deshalb überschrieben
     *
     * @param dvergleich gesuchtes Datenelement
     */
    void KnotenEntfernen(DATENELEMENT dvergleich)
    {
    }

    /**
     * Entfernt den letzten Knoten aus der Liste und gibt sein Datenelement aus.
     * <br>
     * Ohne Funktion für den Stapel, deshalb überschrieben
     *
     * @return Datenelement des bisher letzten Knotens
     */
    DATENELEMENT EndeEntfernen()
    {
        return null;
    }

    /**
     * Sucht ein Datenelement, das über seinen Schlüssel identifiziert wird, und
     * gibt es aus. <br>
     * Ohne Funktion für den Stapel, deshalb überschrieben
     *
     * @param vergleichswert gesuchter Schlüssel
     *
     * @return gesuchtes Datenelement
     */
    DATENELEMENT Suchen(String vergleichswert)
    {
        return null;
    }
}
