package schulbuecher.cornelsen.informatik_6.kapitel_01.thema_01.aufgabe_02.mediaplayer;

/**
 * Beschreibung der Warteschlange
 *
 * @author Klaus Reinold
 * @version 1.0
 */
class Warteschlange
{
    /**
     * Anfang der Warteschlange */
    private Medium anfang;

    /**
     * Ende der Warteschlange */
    private Medium ende;

    /**
     * Konstruktor der Warteschlange
     */
    public Warteschlange()
    {
        anfang = null;
        ende = null;
    }

    /**
     * Fügt eine neues Objekt am Ende der Warteschlange ein.
     * @param bildNeu neues Bild
     */
    public void Einfügen(Medium mediumNeu)
    {
        if (anfang == null)
        {
            anfang = mediumNeu;
        }
        else
        {
            ende.NachfolgerSetzen(mediumNeu);
        }
        ende = mediumNeu;
    }
    /**
     * Entfernt das erste Medium aus der Warteschlange und gibt es zurück.
     * @return bisheriges erstes Objekt
     */
    Medium Entfernen()
    {
        Medium m = anfang;
        if (anfang != null)
        {
            anfang = anfang.NachfolgerGeben() ;
        }
        return m;
    }

    /**
     * Gibt Information über die Warteschlange aus.
     */
    void InformationAusgeben()
    {
        if (anfang != null)
        {
            anfang. InformationAusgeben();
        }
    }
}
