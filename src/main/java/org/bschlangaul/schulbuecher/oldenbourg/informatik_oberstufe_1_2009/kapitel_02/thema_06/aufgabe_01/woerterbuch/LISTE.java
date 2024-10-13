package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_06.aufgabe_01.woerterbuch;

/**
 * Beschreibung der Liste
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
public class LISTE
{
    /** Verwaltung des ersten Knotens in der Warteschlange. */
    private LISTENELEMENT anfang;

    /**
     * Konstruktor der Liste
     *
     */
    public LISTE()
    {
        anfang = new ABSCHLUSS();
    }

    /**
     * Fügt ein neues Datenelement am Anfang der Liste ein.
     *
     * @param dneu neues Datenelement
     */
    public void VorneEinfuegen(DATENELEMENT dneu)
    {
        KNOTEN kneu;
        kneu = new KNOTEN(dneu, anfang);
        anfang = kneu;
    }

    /**
     * Fügt ein neues Datenelement am Ende der Liste ein.
     *
     * @param dneu neues Datenelement
     */
    public void HintenEinfuegen(DATENELEMENT dneu)
    {
        anfang = anfang.HintenEinfuegen(dneu);
    }

    /**
     * Fügt ein neues Datenelement vor einem bestimmten Datenelement ein.
     *
     * @param dneu neues Datenelement
     * @param d_vergleich Datenelement, vor dem eingefügt werden soll
     */
    public void EinfuegenVor(DATENELEMENT dneu, DATENELEMENT d_vergleich)
    {
        anfang = anfang.EinfuegenVor(dneu, d_vergleich);
    }

    /**
     * Fügt ein neues Datenelement sortiert in die Liste ein.
     *
     * @param dneu neues Datenelement
     */
    public void SortiertEinfuegen(DATENELEMENT dneu)
    {
        anfang = anfang.SortiertEinfuegen(dneu);
    }

    /**
     * Entfernt einen Knoten mit einem bestimmten Datenelement aus der Liste
     *
     * @param dvergleich gesuchtes Datenelement
     */
    public void KnotenEntfernen(DATENELEMENT dvergleich)
    {
        anfang = anfang.KnotenEntfernen(dvergleich);
    }

    /**
     * Entfernt den ersten Knoten aus der Liste und gibt sein Datenelement aus.
     *
     * @return Datenelement des bisher ersten Knotens
     */
    public DATENELEMENT AnfangEntfernen()
    {
        DATENELEMENT d;
        d = anfang.DatenelementGeben();
        anfang = anfang.NachfolgerGeben();
        return d;
    }

    /**
     * Entfernt den letzten Knoten aus der Liste und gibt sein Datenelement aus.
     *
     * @return Datenelement des bisher letzten Knotens
     */
    public DATENELEMENT EndeEntfernen()
    {
        DATENELEMENT d;
        d = anfang.EndeGeben(null);
        anfang = anfang.EndeEntfernen(d);
        return d;
    }

    /**
     * Sucht ein Datenelement, das über seinen Schlüssel identifiziert wird, und
     * gibt es aus.
     *
     * @param vergleichswert gesuchter Schlüssel
     *
     * @return gesuchtes Datenelement
     */
    public DATENELEMENT Suchen(String vergleichswert)
    {
        return anfang.Suchen(vergleichswert);
    }

    /**
     * Gibt Information über die Liste aus.
     */
    public void InformationAusgeben()
    {
        anfang.InformationAusgeben();
    }

    /**
     * Bestimmt die Länge der Liste und gibt sie aus.
     *
     * @return Länge der Liste
     */
    public int LaengeGeben()
    {
        return anfang.RestlaengeGeben();
    }
}
