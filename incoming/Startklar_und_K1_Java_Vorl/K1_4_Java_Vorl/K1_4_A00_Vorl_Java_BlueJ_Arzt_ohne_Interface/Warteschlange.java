
/**
 * Beschreibung der Warteschlange
 * 
 * @author Klaus Reinold
 * @version 1.0
 */
class Warteschlange
{
    /** erster Knoten der Warteschlange */
    private Knoten anfang;

    /**
     * Konstruktor der Warteschlange
     */
    Warteschlange()
    {
        anfang = null; 
    }

    /**
     * Fügt ein neues Datenelement am Ende der Warteschlange ein.
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
     * Entfernt den ersten Patient aus der Warteschlange und gibt ihn zurück.
     * @return bisheriger erster Patient 
     */
    Patient Entfernen()
    {
        return null;
        // Die Lösung muss überarbeitet werden, weil die Referenz auf das Ende
        // nicht mehr vorhanden ist. 
        // Knoten k = anfang;
        // if (anfang != null)
        // {
            // if (anfang == ende)
            // {
                // anfang = null;
                // ende = null;
            // }
            // else
            // {
                // anfang=anfang.NachfolgerGeben();
            // }
            // return k.DatenelementGeben();
        // }
        // else
        // {
            // return null;
        // }
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
