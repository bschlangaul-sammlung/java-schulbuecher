package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_07.aufgabe_09.binbaum_mit_entfernen_mit_testklasse;

/**
 * Englisch-deutsches Wörterbuch als geordneter Binärbaum (ohne Composite
 * Pattern) implementiert.
 *
 * @author (Peter Brichzin)
 *
 * @version (20.3.09)
 */
public class WOERTERBUCH
{
    /**
     * Implementierung des Wörterbuchs als geordneter Binärbaum
     */
    private BINBAUM woerterbuch;

    /**
     * Konstruktor für Objekte der Klasse WOERTERBUCH, erzeugt ein englischen
     * Wörterbuch mit 7 Einträgen, wie in Abbildung 6 bzw. 8 von Kapitel 7.
     */
    public WOERTERBUCH()
    {
        woerterbuch = new BINBAUM();
        Einfuegen("clip", "Klammer, abschneiden, anstecken");
        Einfuegen("car", "Auto, Fahrzeug, Waggon");
        Einfuegen("cat", "Katze");
        Einfuegen("care", "F\u00fcrsorge, Sorgfalt");
        Einfuegen("cave", "H\u00f6hle, aush\u00f6hlen, einbrechen");
        Einfuegen("crab", "Krabbe, Krebs, Griesgram");
        Einfuegen("coin", "M\u00fcnze, auspr\u00e4gen, erfinden");
    }

    /**
     * Einfuegen erzeugt ein ein Objekt der Klasse WOERTERBUCHEINTRAG mit den
     * Eingabewerten und fügt diesen Wörterbucheintrag sortiert in die Liste
     * woerterbuch ein. Es wird verhindert, dass ein englisches Wort mehrfach im
     * Wörterbuch abgespeichert werden kann.
     *
     * @param wort englisches Wort
     * @param bedeutung die deutsche(n) Bedeutung(en).
     */
    public void Einfuegen(String wort, String bedeutung)
    {
        WOERTERBUCHEINTRAG neuerWoerterbucheintrag;
        neuerWoerterbucheintrag = new WOERTERBUCHEINTRAG(wort, bedeutung);
        woerterbuch.Einfuegen(neuerWoerterbucheintrag);
    }

    /**
     * Sucht ein englisches Wort im Wörterbuch
     *
     * @param gesuchtesWort gesuchter Schlüssel
     *
     * @return gesuchter Wörterbucheintrag
     */
    public DATENELEMENT Suchen(String gesuchtesWort)
    {
        return woerterbuch.Suchen(gesuchtesWort);
    }

    /**
     * Entfernt den Knoten, dessen Datenelement den eingegebenen Schlüssel hat.
     * Falls es keinen Knoten mit dem eingegebenen Schlüssel gibt, wird dies
     * über die Standardausgabe mitgeteilt.
     *
     * @param suchSchluessel Schlüssel, nach dem gesucht wird als Zeichenkette
     */
    public void KnotenEntfernen(String suchSchluessel)
    {
        woerterbuch.KnotenEntfernen(suchSchluessel);
    }

    /**
     * Gibt alle Einträge des Wörterbuchs aus.
     */
    public void InformationAusgeben()
    {
        woerterbuch.StrukturAusgeben();
        System.out.println("---------------------------------");
    }

    /**
     * Die Methode BedeutungSetzen ermöglicht es, bei einem englischen Wort die
     * deutsche Bedeutung zu verändern.
     *
     * @param gesuchtesWort englisches Wort, dessen Bedeutung verändert werden
     *     soll
     * @param bedeutungNeu neue Bedeutung
     */
    public void BedeutungSetzen(String gesuchtesWort, String bedeutungNeu)
    {
        WOERTERBUCHEINTRAG woerterbucheintrag;
        woerterbucheintrag = (WOERTERBUCHEINTRAG) Suchen(gesuchtesWort);
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
