
/**
 * Beschreibung der Warteschlange
 *
 * @author Klaus Reinold
 * @version 0.9
 */
class Warteschlange
{
    /**
     * erster Knoten der Warteschlange */
    private Knoten anfang;

    /**
     * letzter Knoten der Warteschlange */
    private Knoten ende;

    /**
     * Konstruktor der Warteschlange
     */
    Warteschlange()
    {
        anfang = null;
        ende = null;
    }

    /**
     * Fügt ein neues Auto am Ende der Warteschlange ein.
     * @param autoNeu neues Auto
     *
     */
    void Einfügen(Auto autoNeu)
    {
        Knoten k;
        k = new Knoten(autoNeu);
        if (anfang == null)
        {
            anfang = k;
        }
        else
        {
            ende.NachfolgerSetzen(k);
        }
        ende = k;
    }

    /**
     * Entfernt das erste Auto aus der Warteschlange und gibt es zurück.
     * @return bisheriger erster Wagen
     */
    Auto Entfernen()
    {
        Knoten k = anfang;
        if (anfang != null)
        {
            if (anfang == ende)
            {
                anfang = null;
                ende = null;
            }
            else
            {
                anfang=anfang.NachfolgerGeben();
            }
            return k.DatenelementGeben();
        }
        else
        {
            return null;
        }
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
}
