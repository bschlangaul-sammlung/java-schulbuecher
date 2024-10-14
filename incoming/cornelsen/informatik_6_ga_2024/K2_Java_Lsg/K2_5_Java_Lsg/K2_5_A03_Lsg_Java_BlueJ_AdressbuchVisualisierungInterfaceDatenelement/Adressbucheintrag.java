/**
 * Die Klasse Adressbucheintrag dient zur Speicherung von
 * Adressbucheinträgen. 
 * 
 * @author Peter Brichzin
 * @version 31.5.24
 */

class Adressbucheintrag implements Datenelement
{
    /** 
     * Name der Person, bewusst wird nicht unterschieden zwischen Nach- und Vornamen, 
     * da vertraute Personen nur mit dem Vornamen, nicht vertraute mit dem Nachnamen 
     * gespeichert werden.
     * Schlüssel dieses Datenelements
     */    
    private String name; 

    /**  Telefonnummer  */  
    private String telefonnummer;

    /** E-Mail Adresse  */  
    private String eMail;

    /**
     * Konstruktor für Objekte der Klasse Adressbucheintrag
     * @param nameNeu der Name.
     * @param telefonnummerNeu Telefonnummer.
     */
    Adressbucheintrag(String nameNeu, String telefonnummerNeu)
    {
        name = nameNeu;
        telefonnummer = telefonnummerNeu;
        eMail = "";
    }

    /**
     * Konstruktor für Objekte der Klasse Adressbucheintrag
     * @param nameNeu der Name.
     * @param telefonnummerNeu Telefonnummer.
     * @param eMailNeu E-Mail Adresse.
     */
    Adressbucheintrag(String nameNeu, String telefonnummerNeu, String eMailNeu)
    {
        name = nameNeu;
        telefonnummer = telefonnummerNeu;
        eMail = eMailNeu;
    }

    /**
     * Gibt Information über das Datenelement zu Kontrollzwecken
     * auf das Terminalfenster aus.
     */
    public void InformationAusgeben()
    {
        System.out.println(name + ": " + telefonnummer + "; " + eMail);
    }

    /**
     * Vergleicht zwei Datenelemente auf Gleichheit.
     * @param dvergleich Datenelement mit dem das Objekt verglichen wird.
     * @return true, wenn die beiden Datenelemente gleichen Schlüssel haben.
     */
    public boolean IstGleich(Datenelement dvergleich)
    {
        if(name.compareTo(dvergleich.SchlüsselAlsStringGeben()) == 0)
        {
            return true;
        }
        else
        {
            return false;
        }       
    }

    /**
     * Vergleicht zwei Datenelemente bezüglich der Ordnungsrelation.
     * @param vergleichselement Datenelement mit dem das Objekt verglichen wird.
     * @return true, wenn das aktuelle Element einen größeren Schlüssel hat, als das angegebene Vergleichselement.
     */
    public boolean IstGrößerAls(Datenelement dvergleich)
    {
        if(name.compareTo(dvergleich.SchlüsselAlsStringGeben()) > 0)                                                                                                                                                                                                                                                            
        {
            return true;
        }
        else
        {
            return false;
        }       
    }

    /**
     * Vergleicht zwei Schlüssel, die als Zeichenketten vorliegen, auf Gleichheit.
     * @param vergleichsSchluessel Schlüssel  mit dem der Schlüssel des Objekt verglichen wird.
     * @return true, wenn die beiden Schlüssel gleich sind.
     */
    public boolean SchlüsselIstGleich (String vergleichsSchlüssel)
    {
        if(name.compareTo(vergleichsSchlüssel) == 0)                                                                                                                                                                                                                                                            
        {
            return true;
        }
        else
        {
            return false;
        }     
    }

    /**
     * Vergleicht zwei Schlüssel, die als Zeichenketten vorliegen, bezüglich der Ordnungsrelation.
     * @param vergleichsSchlüssel Schlüssel  mit dem der Schlüssel des Objekt verglichen wird.
     * @return true, wenn das aktuelle Element einen größeren Schlüssel hat, als das angegebene Vergleichselement.
     */
    public boolean SchlüsselIstGrößerAls(String vergleichsSchlüssel)
    {
        if(name.compareTo(vergleichsSchlüssel) > 0)                                                                                                                                                                                                                                                            
        {
            return true;
        }
        else
        {
            return false;
        }     
    }

    /**
     * Gibt den Schlüssel des Datenelements als String aus, auch wenn der Datentyp vom 
     * String abweicht. Diese Methode wird beim Entfernen eines Knotens benötigt.
     * @return Schlüssel als String.
     */
    public String SchlüsselAlsStringGeben()
    {
        return name;
    }   

    /**
     * Geben-Methode zum Attribut namen
     * 
     * @return      den Namen
     */
    String NameGeben()
    {
        return name;
    }

    /**
     * Setzen-Methode zum Attribut namen
     * 
     * @param   nameNeu 
     * 
     */
    void NameSetzen(String nameNeu)
    {
        name = nameNeu;
    }

    /**
     * Setzen-Methode zum Attribut telefonnummer
     * 
     * @param   telefonnummerNeu 
     * 
     */
    void TelefonnummerSetzen(String telefonnummerNeu)
    {
        telefonnummer = telefonnummerNeu;
    }

    /**
     * Setzen-Methode zum Attribut eMail
     * 
     * @param   eMailNeu
     * 
     */
    void EMailSetzen(String eMailNeu)
    {
        eMail = eMailNeu;
    }

}
