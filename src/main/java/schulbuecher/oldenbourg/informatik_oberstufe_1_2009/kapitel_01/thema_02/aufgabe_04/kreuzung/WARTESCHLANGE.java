package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_02.aufgabe_04.kreuzung;

/**
 * Beschreibung der Warteschlange
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class WARTESCHLANGE
{
    /**
     * Verwaltung des ersten Knotens in der Warteschlange.
     */
    private KNOTEN anfang;

    /**
     * Verwaltung des letzten Knotens in der Warteschlange.
     */
    private KNOTEN ende;

    /**
     * Konstruktor der WARTESCHLANGE
     *
     */
    WARTESCHLANGE()
    {
        anfang = null;
        ende = null;
    }

    /**
     * Fügt ein neues Datenelement am Ende der Warteschlange ein.
     *
     * @param datenelementNeu neues Datenelement
     */
    void Einfuegen(DATENELEMENT datenelementNeu)
    {
        KNOTEN neuerKnoten;
        neuerKnoten = new KNOTEN(datenelementNeu);
        if (ende != null)
        {
            ende.NachfolgerSetzen(neuerKnoten);
        }
        else
        {
            anfang = neuerKnoten;
        }
        ende = neuerKnoten;
    }

    /**
     * Entfernt den ersten Knoten aus der Warteschlange und gibt sein
     * Datenelement aus.
     *
     * @return Datenelement des bisherigen ersten Knotens
     */
    DATENELEMENT Entfernen()
    {
        DATENELEMENT ausgabe;
        ausgabe = null;
        if (ende != null)
        {
            ausgabe = anfang.DatenelementGeben();
            if (anfang != ende)
            {
                anfang = anfang.NachfolgerGeben();
            }
            else
            {
                anfang = null;
                ende = null;
            }
        }
        return ausgabe;
    }

    /**
     * Gibt Information über die Warteschlange aus.
     */
    void InformationAusgeben()
    {
        if (anfang != null)
        {
            anfang.InformationAusgeben();
        }
    }

    /**
     * Gibt den Anfangsknoten aus
     *
     * @return Anfang
     */
    KNOTEN AnfangGeben()
    {
        return anfang;
    }
}
