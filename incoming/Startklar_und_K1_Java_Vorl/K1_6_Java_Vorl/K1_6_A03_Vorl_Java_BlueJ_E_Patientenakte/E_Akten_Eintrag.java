
/**
 * Klasse für einen E-Akten-Eintrag
 * 
 * @author Klaus Reinold 
 * @version 1.0
 */
class E_Akten_Eintrag implements Datenelement
{
    /** der Eintrag */
    private String eintrag;

    /**
     * Konstruktor
     * @param eintragNeu der Eintrag
     */
    E_Akten_Eintrag(String eintragNeu)
    {
        eintrag = eintragNeu;
    }

    /**
     * Methode zur Ausgabe von Information über das Datenelement
     */
    public void InformationAusgeben()
    {
        System.out.println(eintrag);
    }
    
    /**
     * Gibt zurück, ob der Name gleich den übergebenen Wert ist.
     * @param gesuchterWert gesuchter Wert
     * @return Wahrheitswert, der angibt, ob der Eintrag der gesuchte ist. 
     */
    public boolean SchlüsselIstGleich(String gesuchterWert)
    {
        return eintrag == gesuchterWert;
    }
        
    /**
     * Vergleich zweier Datenelemente bezüglich einer Ordnungsrelation
     * @param dvergleich Datenelement zum Vergleich
     */
    public boolean IstKleinerAls(Datenelement dvergleich)
    {
        return eintrag.compareTo(((E_Akten_Eintrag) dvergleich).eintrag)<0;
    }
}
