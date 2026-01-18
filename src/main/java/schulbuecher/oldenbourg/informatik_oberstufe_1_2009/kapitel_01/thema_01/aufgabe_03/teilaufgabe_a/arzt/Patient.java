package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_01.aufgabe_03.teilaufgabe_a.arzt;

/**
 * Beschreibung der Klasse PATIENT
 */
class Patient
{
    /**
     * Name des Patienten
     */
    private String name;

    /**
     * Verwaltung des nachfolgenden Patienten in der Warteschlange.
     */
    private Patient nachfolger;

    /**
     * Konstruktor des Patienten
     */
    Patient(String s)
    {
        name = s;
    }

    /**
     * Nachfolger des Patienten setzen
     *
     * @param nf neuer Nachfolger
     */
    void NachfolgerSetzen(Patient nf)
    {
        nachfolger = nf;
    }

    /**
     * Gibt den Nachfolger des Patienten aus.
     *
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
}
