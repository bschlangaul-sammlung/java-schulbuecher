package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_09.aufgabe_07e.binbaum_abstract;

/**
 * Englisch-deutsches Wörterbuch als geordneter Binärbaum implementiert.
 *
 * @author (Peter Brichzin)
 *
 * @version (20.3.09)
 */
public class WOERTERBUCH extends BINBAUM
{
    /**
     * Konstruktor für Objekte der Klasse WOERTERBUCH,
     */
    public WOERTERBUCH()
    {
        super();
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
        this.Einfuegen(neuerWoerterbucheintrag);
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
