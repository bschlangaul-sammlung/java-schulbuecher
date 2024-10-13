
/**
 * Beschreibung der Klasse Patient
 *
 * @author Klaus Reinold
 * @version 0.9
 */
class Patient
{
    /**
     * Name des Patienten */
    private String name;

    /**
     * Konstruktor des Patienten
     * @param s Name des Patienten
     */
    Patient(String s)
    {
        name = s;
    }

    /**
     * Gibt Information über den Patienten aus.
     */
    void InformationAusgeben()
    {
        System.out.println(name);
    }

    /**
     * Gibt den Namen des Patienten zurück
     * @return Name des Patienten
     */
    String NameGeben()
    {
        return name;
    }
}
