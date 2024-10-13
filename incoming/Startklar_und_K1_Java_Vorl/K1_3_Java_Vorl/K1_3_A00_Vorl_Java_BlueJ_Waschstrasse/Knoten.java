
/**
 * Beschreibung der Klasse Knoten
 * 
 * @author Klaus Reinold 
 * @version 1.0
 */
class Knoten
{
    /** Verwaltung des nachfolgenden Knoten in der Warteschlange. */
    private Knoten nachfolger;
    
    /** Verwaltung der Daten des Autos */
    private Auto auto;

    /**
     * Konstruktor des Knoten
     * @param autoNeu verwaltetes Auto
     */
    Knoten(Auto autoNeu)
    {
        nachfolger  = null;
        auto = autoNeu;
    }

    /**
     * Nachfolger des Autos setzen
     * @param nf neuer Nachfolger
     */
    void NachfolgerSetzen(Knoten nf)
    {
        nachfolger = nf;
    }

    /**
     * Gibt den Nachfolger des Knoten aus.
     * @return Nachfolger
     */
    Knoten NachfolgerGeben()
    {
        return nachfolger;
    }
    
    /**
     * Gibt das Auto zurück
     * @return Auto
     */
    Auto DatenelementGeben()
    {
        return auto;
    }
    
    /**
     * Gibt Information über das Auto aus.
     */
    void InformationAusgeben()
    {
        auto.InformationAusgeben();
    }
}
