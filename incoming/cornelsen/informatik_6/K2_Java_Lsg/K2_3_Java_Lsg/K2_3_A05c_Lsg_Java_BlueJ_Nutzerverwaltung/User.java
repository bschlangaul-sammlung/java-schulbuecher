/**
 * Die Klasse User dient zur Speicherung von
 * Usern in einem Online-Shop.  
 * 
 * @author Peter Brichzin
 * @version 23.5.24
 */
class User 
{
    /** id - Schlüssel dieses Datenelements */    
    private int id;
    /**  Nachname  */  
    private String nachname;
    /**  Vorname  */  
    private String vorname;

    /**
     * Konstruktor für Objekte der Klasse User
     *
     * @param idNeu Identifikationsnummer
     * @param nachnameNeu Nachname
     * @param vornameNeu Vorname
     */
    User(int idNeu, String nachnameNeu, String vornameNeu)
    {
        id = idNeu;
        nachname = nachnameNeu;
        vorname = vornameNeu;
    }

    /**
     * Gibt Information über das Datenelement zu Kontrollzwecken
     * auf das Terminalfenster aus.
     */
    void InformationAusgeben()
    {
        System.out.println("Der User " + vorname + " " + nachname + " hat die Identifikationsnummer " + id + ".");
    }

    /**
     * Vergleicht zwei Datenelemente auf Gleichheit.
     * @param dvergleich Datenelement mit dem das Objekt verglichen wird.
     * @return true, wenn die beiden Datenelemente gleichen Schlüssel haben.
     */
    boolean IstGleich(User dVergleich)
    {

        if(id == dVergleich.IdGeben())
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
    boolean IstGrößerAls(User dVergleich)
    {
        if(id > dVergleich.IdGeben())                                                                                                                                                                                                                                                            
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
    boolean SchlüsselIstGleich(int vergleichsSchlüssel)
    {
        return id == vergleichsSchlüssel;
    }

    /**
     * Vergleicht zwei Schlüssel, die als Zeichenketten vorliegen, bezüglich der Ordnungsrelation.
     * @param vergleichsSchluessel Schlüssel  mit dem der Schlüssel des Objekt verglichen wird.
     * @return true, wenn das aktuelle Element einen größeren Schlüssel hat, als das angegebene Vergleichselement.
     */
    boolean SchlüsselIstGrößerAls(int vergleichsSchlüssel)
    {
        return id > vergleichsSchlüssel;
    }

    /**
     * Geben-Methode zum Attribut id
     * @return Identifikationsnummer
     */
    int IdGeben()
    {
        return id;
    }

    /**
     * Gibt den Schlüssel als Zeichenkette zurück.
     * @return      Vorname
     */
    String SchlüsselGeben()
    {
        return String.valueOf(id);
    }

    /**
     * Geben-Methode zum Attribut nachname
     * @return      Nachname
     */

    String NachnameGeben()
    {
        return nachname;
    }

    /**
     * Geben-Methode zum Attribut vorname
     * @return      Vorname
     */
    String VornameGeben()
    {
        return vorname;
    }
}