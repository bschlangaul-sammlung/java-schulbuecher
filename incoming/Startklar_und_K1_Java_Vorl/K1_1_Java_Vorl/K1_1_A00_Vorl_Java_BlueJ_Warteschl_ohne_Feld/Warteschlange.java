
/**
 * Beschreibung der Warteschlange
 * 
 * @author Klaus Reinold
 * @version 0.9
 */
class Warteschlange
{
    /** erstes Element der Warteschlange */
    private Patient anfang;

    /** letztes Element der Warteschlange */
    private Patient ende;

    /**
     * Konstruktor der Warteschlange
     */
    Warteschlange()
    {
        anfang = null; 
        ende = null;
    }

    /**
     * Fügt einen neuen Patienten am Ende der Warteschlange ein.
     * @param patientNeu neuer Patient
     */
    void Einfügen(Patient patientNeu)
    {
        if (anfang == null)
        {
            anfang = patientNeu;
        }
        else
        {
            ende.NachfolgerSetzen(patientNeu);
        }
        ende = patientNeu;
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
