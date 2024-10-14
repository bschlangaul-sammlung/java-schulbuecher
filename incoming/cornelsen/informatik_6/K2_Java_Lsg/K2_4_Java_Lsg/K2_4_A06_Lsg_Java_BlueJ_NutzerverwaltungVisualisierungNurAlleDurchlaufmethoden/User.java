/**
 * Die Klasse User dient zur Speicherung von Usern
 * in einem Online-Shop.  
 * 
 * @author Peter Brichzin
 * @version 23.5.24
 */

class User 
{
    /**  Nachname - Schlüssel dieses Datenelements  */  
    private String nachname;
    /**  Vorname  */  
    private String vorname;
    /**  Alter  */  
    private int alter;

    /**
     * Konstruktor für Objekte der Klasse User
     *
     * @param nachnameNeu Nachname
     * @param vornameNeu Vorname
     * @param alterNeu Alter
     */
    User(String nachnameNeu, String vornameNeu, int alterNeu)
    {
        nachname = nachnameNeu;
        vorname = vornameNeu;
        alter = alterNeu;
    }

    /**
     * Gibt den Schlüssel des Datenelements zu Kontrollzwecken
     * auf das Terminalfenster aus.
     */
    void InformationAusgeben()
    {
        System.out.println("" + nachname );
    }

    /**
     * Gibt alle Information über das Datenelement zu Kontrollzwecken
     * auf das Terminalfenster aus.
     */
    void InformationAusgeben2()
    {
        System.out.println("Der User " + vorname + " " + nachname + " ist " + alter + " Jahre alt.");
    }

    /**
     * Vergleicht zwei Datenelemente auf Gleichheit.
     * @param dvergleich Datenelement mit dem das Objekt verglichen wird.
     * @return true, wenn die beiden Datenelemente gleichen Schlüssel haben.
     * 
     * Hinweis: für den lexikografischen Vergleich wird die Methode 
     * compareTo(String vergleichsZeichenkette) der Klasse String genutzt.
     * Das Ergebnis ist eine negative ganze Zahl, wenn das ausführende 
     * Zeichenketten-Objekt lexikografisch vor dem Eingabewert liegt. 
     * Das Ergebnis ist eine positive ganze Zahl, das ausführende 
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
     * Vergleicht zwei Datenelemente bezüglich der Ordnungsrelation.
     * @param vergleichselement Datenelement mit dem das Objekt verglichen wird.
     * @return true, wenn das aktuelle Element einen größeren Schlüssel 
     * hat, als das angegebene Vergleichselement.
     */
    boolean IstGrößerAls(User dVergleich)
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
     * Vergleicht zwei Schlüssel, die als Zeichenketten vorliegen, auf Gleichheit.
     * @param vergleichsSchlüssel Schlüssel  mit dem der Schlüssel des Objekt verglichen wird.
     * @return true, wenn die beiden Schlüssel gleich sind.
     */
    boolean SchlüsselIstGleich(String vergleichsSchlüssel)
    {
        if(nachname.compareTo(vergleichsSchlüssel) == 0)                                                                                                                                                                                                                                                            
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
     * @return true, wenn das aktuelle Element einen größeren Schlüssel 
     * hat, als das angegebene Vergleichselement.
     */
    boolean SchlüsselIstGrößerAls(String vergleichsSchlüssel)
    {
        if(nachname.compareTo(vergleichsSchlüssel) > 0)                                                                                                                                                                                                                                                            
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
    
    /**
     * Gibt den Schlüssel als Zeichenkette zurück, macht dadurch das Projekt ein 
     * wenig übertragbarer
     * @return      Schlüssel
     */
    String SchlüsselAlsStringGeben()
    {
        return nachname;
    }
    
        /**
     * Geben-Methode zum Attribut vorname
     * 
     * @return      alter
     */
    public int AlterGeben()
    {
        return alter;
    }
}
