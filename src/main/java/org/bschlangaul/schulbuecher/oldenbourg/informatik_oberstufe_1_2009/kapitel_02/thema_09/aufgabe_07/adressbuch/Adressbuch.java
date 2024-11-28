package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_09.aufgabe_07.adressbuch;

/**
 * Adressbuch als geordneter Binärbaum implementiert.
 *
 * @author (Peter Brichzin)
 *
 * @version (20.3.09)
 */
public class Adressbuch
{
    /**
     * Implementierung des Wörterbuchs als geordneter Binärbaum
     */
    private BinBaum adressbuch;

    /**
     * Konstruktor für Objekte der Klasse ADRESSBUCH, erzeugt ein Adressbuch mit
     * 7 Einträgen
     */
    public Adressbuch()
    {
        adressbuch = new BinBaum();
        Einfuegen("Heidrun", "97000101");
        Einfuegen("Albert", "97000102");
        Einfuegen("Barbara", "97000103");
        Einfuegen("Klaus", "97000104");
        Einfuegen("Birgit", "97000105");
        Einfuegen("Ulli", "97000106");
        Einfuegen("Jennni", "97000108");
        Einfuegen("Peter", "97000109");
    }

    /**
     * Einfuegen erzeugt ein ein Objekt der Klasse WOERTERBUCHEINTRAG mit den
     * Eingabewerten und fügt diesen Wörterbucheintrag sortiert in die Liste
     * woerterbuch ein. Es wird verhindert, dass ein englisches Wort mehrfach im
     * Wörterbuch abgespeichert werden kann.
     */
    public void Einfuegen(String name, String telefonnummer)
    {
        AdressbuchEintrag neuerAdressbucheintrag;
        neuerAdressbucheintrag = new AdressbuchEintrag(name, telefonnummer);
        adressbuch.Einfuegen(neuerAdressbucheintrag);
    }

    /**
     * Sucht einen Namen im Adressbuch
     *
     * @param gesuchterName gesuchter Schlüssel
     *
     * @return gesuchter Adressbucheintrag
     */
    public DatenElement Suchen(String gesuchterName)
    {
        return adressbuch.Suchen(gesuchterName);
    }

    /**
     * überprüt, ob ein Datenelement mit dem eingegebenen Schlüssel (in Form
     * einer Zeichenkette) vorhanden ist.
     *
     * @return true, im Erfolgsfall, false sonst.
     */
    public boolean IstVorhanden(String gesuchterName)
    {
        return adressbuch.IstVorhanden(gesuchterName);
    }

    /**
     * Gibt alle Einträge des Wörterbuchs als Baum aus.
     *
     */
    public void BaumAusgeben()
    {
        adressbuch.StrukturAusgeben();
        System.out.println("---------------------------------");
    }

    /**
     * Gibt alle Einträge inklusiv Abschluss-Objekte des Wörterbuchs als Baum
     * aus.
     *
     */
    public void BaumAusgeben2()
    {
        adressbuch.StrukturAusgeben2();
        System.out.println("---------------------------------");
    }

    /**
     * Gibt alle Einträge des Wörterbuchs alphabetisch (Inorder) als Liste aus.
     *
     */
    public void InformationAusgeben()
    {
        adressbuch.InorderAusgeben();
        System.out.println("---------------------------------");
    }

    /**
     * Die Methode BedeutungSetzen ermöglicht es, bei einem englischen Wort die
     * deutsche Bedeutung zu verändern.
     */
    public void EintragSetzen(String gesuchterName, String telefonnummerNeu,
            String eMailNeu, String strasseNeu, String plzNeu, String ortNeu)
    {
        AdressbuchEintrag adressbucheintrag;
        adressbucheintrag = (AdressbuchEintrag) Suchen(gesuchterName);
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
