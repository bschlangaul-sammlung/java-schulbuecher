package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_12.snake;

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
    Liste()
    {
        anfang = null;
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
        if (anfang != null)
        {
            anfang.HintenEinfuegen(dneu);
        }
        else
        {
            VorneEinfuegen(dneu);
        }
    }

    /**
     * Fügt ein neues Datenelement vor einem bestimmten Datenelement ein.
     *
     * @param dneu neues Datenelement
     * @param d_vergleich Datenelement, vor dem eingefügt werden soll
     */
    void EinfuegenVor(DatenElement dneu, DatenElement d_vergleich)
    {
        if (anfang != null)
        {
            anfang = anfang.EinfuegenVor(dneu, d_vergleich);
        }
        else
        {
            VorneEinfuegen(dneu);
        }
    }

    /**
     * Fügt ein neues Datenelement sortiert in die Liste ein.
     *
     * @param dneu neues Datenelement
     */
    void SortiertEinfuegen(DatenElement dneu)
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
     * Entfernt einen Knoten mit einem bestimmten Datenelement aus der Liste
     *
     * @param dvergleich gesuchtes Datenelement
     */
    void KnotenEntfernen(DatenElement dvergleich)
    {
        if (anfang != null)
        {
            anfang = anfang.KnotenEntfernen(dvergleich);
        }
    }

    /**
     * Entfernt den ersten Knoten aus der Liste und gibt sein Datenelement aus.
     *
     * @return Datenelement des bisher ersten Knotens
     */
    DatenElement AnfangEntfernen()
    {
        if (anfang != null)
        {
            DatenElement d;
            d = anfang.DatenelementGeben();
            anfang = anfang.NachfolgerGeben();
            return d;
        }
        else
        {
            return null;
        }
    }

    /**
     * Entfernt den letzten Knoten aus der Liste und gibt sein Datenelement aus.
     *
     * @return Datenelement des bisher letzten Knotens
     */
    DatenElement EndeEntfernen()
    {
        if (anfang != null)
        {
            DatenElement d;
            d = anfang.EndeGeben();
            anfang = anfang.EndeEntfernen();
            return d;
        }
        else
        {
            return null;
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
    DatenElement Suchen(String vergleichswert)
    {
        if (anfang == null)
        {
            return null;
        }
        else
        {
            return anfang.Suchen(vergleichswert);
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

    /**
     * Bestimmt die Länge der Liste und gibt sie aus.
     *
     * @return Länge der Liste
     */
    int LaengeGeben()
    {
        if (anfang == null)
        {
            return 0;
        }
        else
        {
            return anfang.RestlaengeGeben();
        }
    }

    /**
     * Entfernt alle Knoten ab einem bestimmten Knoten
     *
     * @param koordinaten Schlüssel in der Form "x,y"
     */
    void KnotenAbHierEntfernen(String koordinaten)
    {
        anfang = anfang.KnotenAbHierEntfernen(koordinaten, false);
    }
}
