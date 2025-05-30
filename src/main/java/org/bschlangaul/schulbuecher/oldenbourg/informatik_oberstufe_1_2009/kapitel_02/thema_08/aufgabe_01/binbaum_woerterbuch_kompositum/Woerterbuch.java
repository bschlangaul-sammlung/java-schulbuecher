package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_08.aufgabe_01.binbaum_woerterbuch_kompositum;

/**
 * Englisch-deutsches Wörterbuch als geordneter Binärbaum implementiert.
 *
 * @author (Peter Brichzin)
 *
 * @version (20.3.09)
 */
public class Woerterbuch
{
    /**
     * Implementierung des Wörterbuchs als geordneter Binärbaum
     */
    private BinBaum woerterbuch;

    /**
     * Konstruktor für Objekte der Klasse WOERTERBUCH, erzeugt ein englischen
     * Wörterbuch mit 12 Einträgen, wie in Abbildung 1 bzw. 2 von Kapitel 8.
     */
    public Woerterbuch()
    {
        woerterbuch = new BinBaum();
        Einfuegen("clip", "Klammer, abschneiden, anstecken");
        Einfuegen("car", "Auto, Fahrzeug, Waggon");
        Einfuegen("call", "Gespräch, nennen, rufen");
        Einfuegen("cat", "Katze");
        Einfuegen("can", "Dose, können");
        Einfuegen("care", "Fürsorge, Sorgfalt");
        Einfuegen("cave", "Höhle, aushöhlen, einbrechen");
        Einfuegen("crab", "Krabbe, Griesgram, einbrennen");
        Einfuegen("coin", "Münze, ausprägen, erfinden");
        Einfuegen("cube", "Würfel");
        Einfuegen("cook", "Koch, kochen");
        Einfuegen("crow", "Krähe, Jauchzer, frohlocken");
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
        WoerterbuchEintrag neuerWoerterbucheintrag;
        neuerWoerterbucheintrag = new WoerterbuchEintrag(wort, bedeutung);
        woerterbuch.Einfuegen(neuerWoerterbucheintrag);
    }

    /**
     * Sucht ein englisches Wort im Wörterbuch
     *
     * @param gesuchtesWort gesuchter Schlüssel
     *
     * @return gesuchter Wörterbucheintrag
     */
    public DatenElement Suchen(String gesuchtesWort)
    {
        return woerterbuch.Suchen(gesuchtesWort);
    }

    /**
     * überprüt, ob ein Datenelement mit dem eingegebenen Schlüssel (in Form
     * einer Zeichenkette) vorhanden ist.
     *
     * @param gesuchtesWort Schlüssel, nach dem gesucht wird als Zeichenkette
     *
     * @return true, im Erfolgsfall, false sonst.
     */
    public boolean IstVorhanden(String gesuchtesWort)
    {
        return woerterbuch.IstVorhanden(gesuchtesWort);
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
        WoerterbuchEintrag woerterbucheintrag;
        woerterbucheintrag = (WoerterbuchEintrag) Suchen(gesuchtesWort);
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
