package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_05.aufgabe_13.gemeinschaftspraxis;

/**
 * Beschreibung der Klasse Patient
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Patient implements Datenelement
{
    /**
     * Name des Patienten
     */
    private String name;

    /**
     * Name des Arztes
     */
    private String arzt;

    /**
     * Konstruktor des Patienten
     *
     * @param p Name des Patienten
     */
    Patient(String p, String a)
    {
        name = p;
        arzt = a;
    }

    /**
     * Gibt Information über den Patienten aus.
     */
    public void InformationAusgeben()
    {
        System.out.println(name);
    }

    /**
     * Gibt den Namen des Patienten aus
     *
     * @return Name des Patienten
     */
    String NameGeben()
    {
        return name;
    }

    /**
     * Gibt zurück, ob der Name gleich den übergebenen Wert ist.
     *
     * @param gesuchterWert gesuchter Wert
     *
     * @return Wahrheitswert, der angibt, ob der Name der gesuchte ist.
     */
    public boolean SchlüsselIstGleich(String gesuchterWert)
    {
        return arzt == gesuchterWert || arzt == "";
    }

    /**
     * Vergleich zweier Datenelemente bezüglich einer Ordnungsrelation
     *
     * @param dvergleich Datenelement zum Vergleich
     */
    public boolean IstKleinerAls(Datenelement dvergleich)
    {
        return name.compareTo(((Patient) dvergleich).name) < 0;
    }

}
