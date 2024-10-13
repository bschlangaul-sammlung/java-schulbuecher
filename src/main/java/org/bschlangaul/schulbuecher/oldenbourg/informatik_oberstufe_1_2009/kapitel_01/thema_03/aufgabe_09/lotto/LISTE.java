package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_09.lotto;

/**
 * Beschreibung der Liste
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class LISTE
{
    /**
     * Verwaltung des ersten Knotens in der Warteschlange.
     */
    private KNOTEN anfang;

    /**
     * Konstruktor der Liste
     *
     */
    LISTE()
    {
        anfang = null;
    }

    /**
     * Fügt ein neues Datenelement am Anfang der Liste ein.
     *
     * @param dneu neues Datenelement
     */
    void VorneEinfuegen(DATENELEMENT dneu)
    {
        KNOTEN kneu;
        kneu = new KNOTEN(dneu, anfang);
        anfang = kneu;
    }

    /**
     * Fügt ein neues Datenelement sortiert in die Liste ein.
     *
     * @param dneu neues Datenelement
     */
    void SortiertEinfuegen(DATENELEMENT dneu)
    {
        if (anfang != null)
        {
            anfang = anfang.SortiertEinfuegen(dneu);
        }
        else
        {
            VorneEinfuegen(dneu);
        }
    }

    /**
     * Gibt Information über die Liste aus.
     */
    void InformationAusgeben()
    {
        if (anfang != null)
        {
            anfang.InformationAusgeben();
        }
    }
}
