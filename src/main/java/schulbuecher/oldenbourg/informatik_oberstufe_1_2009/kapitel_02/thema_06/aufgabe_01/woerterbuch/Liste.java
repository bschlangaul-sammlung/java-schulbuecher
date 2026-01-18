package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_06.aufgabe_01.woerterbuch;

/**
 * Beschreibung der Liste
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
public class Liste
{
    /**
     * Verwaltung des ersten Knotens in der Warteschlange.
     */
    private ListenElement anfang;

    /**
     * Konstruktor der Liste
     *
     */
    public Liste()
    {
        anfang = new Abschluss();
    }

    /**
     * Fügt ein neues Datenelement am Anfang der Liste ein.
     *
     * @param dneu neues Datenelement
     */
    public void VorneEinfuegen(DatenElement dneu)
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
    public void HintenEinfuegen(DatenElement dneu)
    {
        anfang = anfang.HintenEinfuegen(dneu);
    }

    /**
     * Fügt ein neues Datenelement vor einem bestimmten Datenelement ein.
     *
     * @param dneu neues Datenelement
     * @param d_vergleich Datenelement, vor dem eingefügt werden soll
     */
    public void EinfuegenVor(DatenElement dneu, DatenElement d_vergleich)
    {
        anfang = anfang.EinfuegenVor(dneu, d_vergleich);
    }

    /**
     * Fügt ein neues Datenelement sortiert in die Liste ein.
     *
     * @param dneu neues Datenelement
     */
    public void SortiertEinfuegen(DatenElement dneu)
    {
        anfang = anfang.SortiertEinfuegen(dneu);
    }

    /**
     * Entfernt einen Knoten mit einem bestimmten Datenelement aus der Liste
     *
     * @param dvergleich gesuchtes Datenelement
     */
    public void KnotenEntfernen(DatenElement dvergleich)
    {
        anfang = anfang.KnotenEntfernen(dvergleich);
    }

    /**
     * Entfernt den ersten Knoten aus der Liste und gibt sein Datenelement aus.
     *
     * @return Datenelement des bisher ersten Knotens
     */
    public DatenElement AnfangEntfernen()
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
    public DatenElement EndeEntfernen()
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
    public DatenElement Suchen(String vergleichswert)
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
