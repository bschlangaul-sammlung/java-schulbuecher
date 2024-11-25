package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_05.aufgabe_05.cheese_champions;

/**
 * Beschreibung der Liste
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Liste
{
    /**
     * Verwaltung des ersten Knotens in der Warteschlange.
     */
    private ListenElement anfang;

    /**
     * Konstruktor der Liste
     *
     */
    Liste()
    {
        anfang = new Abschluss();
    }

    /**
     * Fügt ein neues Datenelement am Anfang der Liste ein.
     *
     * @param dneu neues Datenelement
     */
    void VorneEinfuegen(DatenElement dneu)
    {
        Knoten kneu;
        kneu = new Knoten(dneu, anfang);
        anfang = kneu;
    }

    /**
     * Fügt ein neues Datenelement am Ende der Liste ein.
     *
     * @param dneu neues Datenelement
     */
    void HintenEinfuegen(DatenElement dneu)
    {
        anfang = anfang.HintenEinfuegen(dneu);
    }

    /**
     * Fügt ein neues Datenelement vor einem bestimmten Datenelement ein.
     *
     * @param dneu neues Datenelement
     * @param d_vergleich Datenelement, vor dem eingefügt werden soll
     */
    void EinfuegenVor(DatenElement dneu, DatenElement d_vergleich)
    {
        anfang = anfang.EinfuegenVor(dneu, d_vergleich);
    }

    /**
     * Fügt ein neues Datenelement sortiert in die Liste ein.
     *
     * @param dneu neues Datenelement
     */
    void SortiertEinfuegen(DatenElement dneu)
    {
        anfang = anfang.SortiertEinfuegen(dneu);
    }

    /**
     * Entfernt einen Knoten mit einem bestimmten Datenelement aus der Liste
     *
     * @param dvergleich gesuchtes Datenelement
     */
    void KnotenEntfernen(DatenElement dvergleich)
    {
        anfang = anfang.KnotenEntfernen(dvergleich);
    }

    /**
     * Entfernt den ersten Knoten aus der Liste und gibt sein Datenelement aus.
     *
     * @return Datenelement des bisher ersten Knotens
     */
    DatenElement AnfangEntfernen()
    {
        DatenElement d;
        d = anfang.DatenelementGeben();
        anfang = anfang.NachfolgerGeben();
        return d;
    }

    /**
     * Entfernt den letzten Knoten aus der Liste und gibt sein Datenelement aus.
     *
     * @return Datenelement des bisher letzten Knotens
     */
    DatenElement EndeEntfernen()
    {
        DatenElement d;
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
    DatenElement Suchen(String vergleichswert)
    {
        return anfang.Suchen(vergleichswert);
    }

    /**
     * Gibt Information über die Liste aus.
     */
    String InformationAusgeben()
    {
        return anfang.InformationAusgeben();
    }

    /**
     * Bestimmt die Länge der Liste und gibt sie aus.
     *
     * @return Länge der Liste
     */
    int LaengeGeben()
    {
        return anfang.RestlaengeGeben();
    }
}