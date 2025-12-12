package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_02.thema_05.aufgabe_03.adressbuch_visualisierung_interface_datenelement;

/**
 * Woerterbuch als Unterklasse eines geordneten Binärbaums implementiert.
 *
 * @author Peter Brichzin
 *
 * @version 30.5.24
 */
class Woerterbuch extends BinBaum
{
    /**
     * Konstruktor für Objekte der Klasse Wörterbuch
     */
    Woerterbuch()
    {
        super();
    }

    /**
     * Einfügen erzeugt ein ein Objekt der Klasse Woerterbuch mit den
     * Eingabewerten und fügt diesen sortiert in das Woerterbuch ein.
     *
     * @param wort englisches Wort
     * @param bedeutung deutsche Bedeutung, mehrere Begriffe möglich
     */
    void Einfügen(String wort, String bedeutung)
    {
        Woerterbucheintrag neuerWoerterbucheintrag;
        neuerWoerterbucheintrag = new Woerterbucheintrag(wort, bedeutung);
        this.Einfügen(neuerWoerterbucheintrag);
    }

    /**
     * Sucht einen Wort im Wörterbuch. Ruft nur die Methode der Oberklasse auf,
     * deshalb könnte diese Methode auch weggelassen werden.
     *
     * @param gesuchtesWort englisches Wort
     *
     * @return gesuchter Woerterbucheintrag
     */
    Datenelement EintragSuchen(String gesuchtesWort)
    {
        return Suchen(gesuchtesWort);
    }

    /**
     * Gibt alle Einträge des Wörterbuchs als Baum aus.
     *
     */
    void EinträgeAlsBaumAusgeben()
    {
        StrukturAusgeben();
        System.out.println("---------------------------------");
    }

    /**
     * Gibt alle Einträge des Wörterbuchs alphabetisch (Inorder) als Liste aus.
     *
     */
    void EinträgeAlphabetischAusgeben()
    {
        InorderAusgeben();
        System.out.println("---------------------------------");
    }

    /**
     * Die Methode BedeutungAktualisieren ermöglicht es, bei einem
     * Wörterbucheintrag die Bedeutung zu aktualisieren.
     *
     * @param gesuchtesWort gesuchter Schlüssel
     * @param bedeutungNeu neue Telefonnummer
     */
    void EintragSetzen(String gesuchtesWort, String bedeutungNeu)
    {
        Woerterbucheintrag woerterbucheintrag;
        woerterbucheintrag = (Woerterbucheintrag) Suchen(gesuchtesWort);
        if (woerterbucheintrag == null)
        {
            System.out.println("Eintrag existiert nicht!");
        }
        else
        {
            woerterbucheintrag.BedeutungSetzen(bedeutungNeu);
        }
    }
}
