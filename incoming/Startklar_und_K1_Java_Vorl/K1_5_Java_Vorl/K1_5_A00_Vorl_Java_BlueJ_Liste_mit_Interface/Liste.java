
/**
 * Beschreibung der Liste
 *
 * @author Klaus Reinold
 * @version 1.0
 */
class Liste
{
    /**
     * erster Knoten der Liste */
    private Knoten anfang;

    /**
     * Konstruktor der Liste
     */
    Liste()
    {
        anfang = null;
    }

    /**
     * Fügt ein neues Datenelement am Ende der Liste ein.
     * @param dNeu neues Datenelement
     */
    void HintenEinfügen(Patient dneu)
    {
        if (anfang != null)
        {
            anfang.HintenEinfügen(dneu);
        }
        else
        {
            anfang = new Knoten(dneu);
        }
    }

    /**
     * Fügt ein neues Datenelement am Anfang der Liste ein.
     * @param dneu neues Datenelement
     */
    void VorneEinfügen(Patient dneu)
    {
        Knoten kneu;
        kneu = new Knoten(dneu, anfang);
        anfang = kneu;
    }

    /**
     * Fügt ein neues Datenelement vor einem bestimmten Datenelement ein.
     * @param dneu neues Datenelement
     * @param d_vergleich Datenelement, vor dem eingefügt werden soll
     */
    void EinfügenVor(Patient dneu, Patient d_vergleich)
    {
        if (anfang != null)
        {
            anfang = anfang.EinfügenVor(dneu, d_vergleich);
        }
        else
        {
            VorneEinfügen(dneu);
        }
    }

    /**
     * Fügt ein neues Datenelement sortiert in die Liste ein.
     * @param dneu neues Datenelement
     */
    void SortiertEinfügen(Patient dneu)
    {
        if (anfang != null)
        {
            anfang = anfang.SortiertEinfügen(dneu);
        }
        else
        {
            VorneEinfügen(dneu);
        }
    }

    /**
     * Bestimmt die Länge der Liste
     * @return Listenlänge
     */
    int LängeGeben()
    {
        if (anfang == null)
        {
            return 0;
        }
        else
        {
            return anfang.RestlängeGeben();
        }
    }

    /**
     * Sucht ein Datenelement mit einem bestimmten Schlüssel in der Liste
     * @param gesuchterWert Zeichenkette, die als Schlüssel gefunden werden soll.
     * @return das gesuchte Datenelement
     */
    Patient Suchen(String gesuchterWert)
    {
        if (anfang != null)
        {
            return anfang.Suchen(gesuchterWert);
        }
        else
        {
            return null;
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
     * Entfernt einen Knoten mit einem bestimmten Datenelement aus der Liste
     * @param dvergleich gesuchtes Datenelement
     */
    void KnotenEntfernen(Patient dvergleich)
    {
        if (anfang != null)
        {
            anfang = anfang.KnotenEntfernen(dvergleich);
        }
    }

    /**
     * Entfernt den ersten Knoten aus der Liste und gibt sein Datenelement aus.
     * @return Datenelement des bisher ersten Knotens
     */
    Patient AnfangEntfernen()
    {
        if (anfang != null)
        {
            Patient d;
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
     * @return Datenelement des bisher letzten Knotens
     */
    Patient EndeEntfernen()
    {
        if (anfang != null)
        {
            Patient d;
            d = anfang.EndeGeben();
            anfang = anfang.EndeEntfernen();
            return d;
        }
        else
        {
            return null;
        }
    }
}
