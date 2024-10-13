
/**
 * Beschreibung der Klasse Patient
 * 
 * @author Klaus Reinold 
 * @version 0.9
 */
class Patient
{
    /** Name des Patienten */
    private String name;

    /** Verwaltung des nachfolgenden Patienten in der Warteschlange. */
    private Patient nachfolger;

    /**
     * Konstruktor des Patienten
     * @param s Name des Patienten
     */
    Patient(String s)
    {
        name = s;
    }

    /**
     * Nachfolger des Patienten setzen
     * @param nf neuer Nachfolger
     */
    void NachfolgerSetzen(Patient nf)
    {
        nachfolger = nf;
    }

    /**
     * Gibt den Nachfolger des Patienten aus.
     * @return Nachfolger
     */
    Patient NachfolgerGeben()
    {
        return nachfolger;
    }

    /**
     * Gibt Information über den Patienten aus.
     */
    void InformationAusgeben()
    {
        System.out.println(name);
    }

    /**
     * Gibt den Namen des Patienten aus
     * @return Name des Patienten
     */
    String NameGeben()
    {
        return name;
    }
}
