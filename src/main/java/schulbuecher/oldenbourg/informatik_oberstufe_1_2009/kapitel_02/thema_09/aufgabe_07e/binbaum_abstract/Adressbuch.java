package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_09.aufgabe_07e.binbaum_abstract;

/**
 * Adressbuch als geordneter Binärbaum implementiert.
 *
 * @author (Peter Brichzin)
 *
 * @version (20.3.09)
 */
public class Adressbuch extends BinBaum
{
    /**
     * Konstruktor für Objekte der Klasse ADRESSBUCH
     */
    public Adressbuch()
    {
        super();
    }

    /**
     * Einfuegen erzeugt ein ein Objekt der Klasse WOERTERBUCHEINTRAG mit den
     * Eingabewerten und fügt diesen Wörterbucheintrag sortiert in die Liste
     * woerterbuch ein.
     */
    public void Einfuegen(String name, String telefonnummer)
    {
        Adressbucheintrag neuerAdressbucheintrag;
        neuerAdressbucheintrag = new Adressbucheintrag(name, telefonnummer);
        this.Einfuegen(neuerAdressbucheintrag);
    }

    /**
     * Die Methode BedeutungSetzen ermöglicht es, bei einem englischen Wort die
     * deutsche Bedeutung zu verändern.
     */
    public void EintragSetzen(String gesuchterName, String telefonnummerNeu,
            String eMailNeu, String strasseNeu, String plzNeu, String ortNeu)
    {
        Adressbucheintrag adressbucheintrag;
        adressbucheintrag = (Adressbucheintrag) Suchen(gesuchterName);
        if (adressbucheintrag == null)
        {
            System.out.println("Eintrag existiert nicht!");
        }
        else
        {
            adressbucheintrag.EintragSetzen(telefonnummerNeu, eMailNeu,
                    strasseNeu, plzNeu, ortNeu);
        }
    }
}
