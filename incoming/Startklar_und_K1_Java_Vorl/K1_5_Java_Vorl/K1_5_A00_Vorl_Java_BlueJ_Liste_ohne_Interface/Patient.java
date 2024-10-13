/**
 * Beschreibung der Klasse Patient
 * 
 * @author Klaus Reinold 
 * @version 1.0
 */
class Patient implements Datenelement
{
    /** Name des Patienten */
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
    public void InformationAusgeben()
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
    
    /**
     * Gibt zurück, ob der Name gleich den übergebenen Wert ist.
     * @param gesuchterWert gesuchter Wert
     * @return Wahrheitswert, der angibt, ob der Name der gesuchte ist. 
     */
    public boolean SchlüsselIstGleich(String gesuchterWert)
    {
        return name == gesuchterWert;
    }
    
    /**
     * Vergleich zweier Datenelemente bezüglich einer Ordnungsrelation
     * @param dvergleich Datenelement zum Vergleich
     */
    public boolean IstKleinerAls(Datenelement dvergleich)
    {
        return name.compareTo(((Patient) dvergleich).name)<0;
    }

}
