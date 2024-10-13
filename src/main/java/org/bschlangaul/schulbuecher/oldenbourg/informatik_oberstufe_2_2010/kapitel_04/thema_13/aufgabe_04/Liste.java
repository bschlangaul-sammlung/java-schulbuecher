package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_04.thema_13.aufgabe_04;

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
    private Knoten anfang;

    /**
     * Konstruktor der Liste
     *
     */
    public Liste()
    {
        anfang = null;
    }

    /**
     * Fügt ein neues Datenelement sortiert in die Liste ein.
     *
     * @param dneu neues Datenelement
     */
    public void SortiertEinfuegen(DatenElement dneu)
    {
        if (anfang != null)
        {
            anfang = anfang.SortiertEinfuegen(dneu);
        }
        else
        {
            Knoten kneu;
            kneu = new Knoten(dneu, anfang);
            anfang = kneu;
        }
    }

    /**
     * Sucht ein Datenelement, das über seinen Schlüssel identifiziert wird, und
     * gibt es aus.
     *
     * @param vergleichswert gesuchter Schlüssel
     *
     * @return gesuchtes Datenelement
     */
    public DatenElement Suchen(int vergleichswert)
    {
        Zaehler.ZaehlerInkrementieren();
        if (anfang == null)
        {
            Zaehler.ZaehlerInkrementieren();
            return null;
        }
        else
        {
            Zaehler.ZaehlerInkrementieren();
            return anfang.Suchen(vergleichswert);
        }
    }
}
