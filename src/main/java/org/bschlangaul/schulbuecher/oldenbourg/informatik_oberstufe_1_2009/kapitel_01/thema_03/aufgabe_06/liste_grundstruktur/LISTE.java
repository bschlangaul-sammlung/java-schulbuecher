package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_06.liste_grundstruktur;

/**
 * Beschreibung der Liste
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class LISTE
{
    /** Verwaltung des ersten Knotens in der Warteschlange. */
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
     * Fügt ein neues Datenelement am Ende der Liste ein.
     *
     * @param dneu neues Datenelement
     */
    void HintenEinfuegen(DATENELEMENT dneu)
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
    void EinfuegenVor(DATENELEMENT dneu, DATENELEMENT d_vergleich)
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
     * Entfernt einen Knoten mit einem bestimmten Datenelement aus der Liste
     *
     * @param dvergleich gesuchtes Datenelement
     */
    void KnotenEntfernen(DATENELEMENT dvergleich)
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
    DATENELEMENT AnfangEntfernen()
    {
        if (anfang != null)
        {
            DATENELEMENT d;
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
    DATENELEMENT EndeEntfernen()
    {
        if (anfang != null)
        {
            DATENELEMENT d;
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
    DATENELEMENT Suchen(String vergleichswert)
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
}
