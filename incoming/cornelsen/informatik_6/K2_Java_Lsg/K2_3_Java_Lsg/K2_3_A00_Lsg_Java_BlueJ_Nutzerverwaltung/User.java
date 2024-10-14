/**
 * Die Klasse User dient zur Speicherung von Usern
 * in einem Online-Shop.  
 * 
 * @author Peter Brichzin
 * @version 23.5.24
 */

class User 
{
    /** id - Schl�ssel dieses Datenelements */    
    private int id;
    /**  Nachname  */  
    private String nachname;
    /**  Vorname  */  
    private String vorname;

    /**
     * Konstruktor f�r Objekte der Klasse User
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
     * Gibt Information �ber das Datenelement zu Kontrollzwecken
     * auf das Terminalfenster aus.
     */
    void InformationAusgeben()
    {
        System.out.println("Der User " + vorname + " " + nachname + " hat die Id " + id + ".");
    }

    /**
     * Vergleicht zwei Datenelemente auf Gleichheit.
     * @param dvergleich Datenelement mit dem das Objekt verglichen wird.
     * @return true, wenn die beiden Datenelemente gleichen Schl�ssel haben.
     * 
     * Hinweis: f�r den lexikografischen Vergleich wird die Methode 
     * compareTo(String vergleichsZeichenkette) der Klasse String genutzt.
     * Das Ergebnis ist eine negative ganze Zahl, wenn das ausf�hrende 
     * Zeichenketten-Objekt lexikografisch vor dem Eingabewert liegt. 
     * Das Ergebnis ist eine positive ganze Zahl, das ausf�hrende 
     * Zeichenketten-Objekt lexikografisch hinter dem Eingabewert liegt.
     * Das Ergebnis ist 0, wenn die Zeichenketten gleich sind; 
     * 
     */
    boolean IstGleich(User dVergleich)
    {
        if(nachname.compareTo(dVergleich.NachnameGeben()) == 0)
        {
            return true;
        }
        else
        {
            return false;
        }       
    }

    /**
     * Vergleicht zwei Datenelemente bez�glich der Ordnungsrelation.
     * @param vergleichselement Datenelement mit dem das Objekt verglichen wird.
     * @return true, wenn das aktuelle Element einen gr��eren Schl�ssel 
     * hat, als das angegebene Vergleichselement.
     */
    boolean IstGr��erAls(User dVergleich)
    {
        if(nachname.compareTo(dVergleich.NachnameGeben()) > 0)                                                                                                                                                                                                                                                            
        {
            return true;
        }
        else
        {
            return false;
        }       
    }

    /**
     * Vergleicht zwei Schl�ssel, die als Zeichenketten vorliegen, auf Gleichheit.
     * @param vergleichsSchl�ssel Schl�ssel  mit dem der Schl�ssel des Objekt verglichen wird.
     * @return true, wenn die beiden Schl�ssel gleich sind.
     */
    boolean Schl�sselIstGleich(String vergleichsSchl�ssel)
    {
        if(nachname.compareTo(vergleichsSchl�ssel) == 0)                                                                                                                                                                                                                                                            
        {
            return true;
        }
        else
        {
            return false;
        }       
    }

    /**
     * Vergleicht zwei Schl�ssel, die als Zeichenketten vorliegen, bez�glich der Ordnungsrelation.
     * @param vergleichsSchl�ssel Schl�ssel  mit dem der Schl�ssel des Objekt verglichen wird.
     * @return true, wenn das aktuelle Element einen gr�&szlig;eren Schl�ssel 
     * hat, als das angegebene Vergleichselement.
     */
    boolean Schl�sselIstGr��erAls(String vergleichsSchl�ssel)
    {
        if(nachname.compareTo(vergleichsSchl�ssel) > 0)                                                                                                                                                                                                                                                            
        {
            return true;
        }
        else
        {
            return false;
        }      
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
