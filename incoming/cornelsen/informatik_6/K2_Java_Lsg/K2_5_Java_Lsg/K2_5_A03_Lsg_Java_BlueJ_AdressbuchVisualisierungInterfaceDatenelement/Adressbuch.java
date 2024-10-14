/**
 * Adressbuch als Unterklasse eines geordneten Binärbaums implementiert.
 * 
 * @author Peter Brichzin
 * @version 30.5.24
 */
class Adressbuch extends BinBaum
{
    /**
     * Konstruktor für Objekte der Klasse Adressbuch
     */
    Adressbuch()
    {
        super();
    }

    /**
     * Einfuegen erzeugt ein ein Objekt der Klasse Adressbucheintrag mit den Eingabewerten und
     * fügt diesen sortiert in das Adressbuch ein. 
     * @param name Name, nicht differenziert nach Vor- und Nachname
     * @param telefonnummer 
     */
    void Einfügen(String name, String telefonnummer)
    {
        Adressbucheintrag neuerAdressbucheintrag;
        neuerAdressbucheintrag = new Adressbucheintrag(name, telefonnummer);
        this.Einfügen(neuerAdressbucheintrag);
    }

    /**
     * Sucht einen Namen im Adressbuch. Ruft nur die Methode der Oberklasse auf, 
     * deshalb könnte diese Methode auch weggelassen werden.
     * 
     * @param gesuchterName gesuchter Schlüssel
     * @return gesuchter Adressbucheintrag
     */
    Datenelement EintragSuchen(String gesuchterName)
    {
        return Suchen(gesuchterName);
    }

    /**
     * Gibt alle Einträge des Adressbuchs als Baum aus.
     * 
     */
    void EinträgeAlsBaumAusgeben()
    {
        StrukturAusgeben();
        System.out.println("---------------------------------");
    }

    /**
     * Gibt alle Einträge des Adressbuchs alphabetisch (Inorder) als Liste  aus.
     * 
     */
    void EinträgeAlphabetischAusgeben()
    {
        InorderAusgeben();
        System.out.println("---------------------------------");
    }

    /**
     * Die Methode TelefonnummerAktualisieren ermöglicht es, bei einem 
     * Adressbucheintrag die Telefonnummer zu aktualisieren.
     * @param gesuchterName gesuchter Schlüssel
     * @param telefonnummerNeu neue Telefonnummer
     */
    void EintragSetzen(String gesuchterName, String telefonnummerNeu)
    {
        Adressbucheintrag adressbucheintrag;
        adressbucheintrag = (Adressbucheintrag) Suchen(gesuchterName);
        if (adressbucheintrag == null)
        {
            System.out.println("Eintrag existiert nicht!");
        }
        else
        {
            adressbucheintrag.TelefonnummerSetzen(telefonnummerNeu);
        }        
    }
}