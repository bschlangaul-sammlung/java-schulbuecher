package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_09.aufgabe_07.adressbuch;

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
     * Wörterbuch mit 11 Einträgen, wie in Abbildung 1 bzw. 2 von Kapitel 9.
     */
    public Woerterbuch()
    {
        woerterbuch = new BinBaum();
        Einfuegen("clip", "Klammer, abschneiden, anstecken");
        Einfuegen("car", "Auto, Fahrzeug, Waggon");
        Einfuegen("call", "Gespräch, nennen, rufen");
        Einfuegen("cat", "Katze");
        // Einfuegen("can","Dose, können");
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
        WorterbuchEintrag neuerWoerterbucheintrag;
        neuerWoerterbucheintrag = new WorterbuchEintrag(wort, bedeutung);
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
        WorterbuchEintrag woerterbucheintrag;
        woerterbucheintrag = (WorterbuchEintrag) Suchen(gesuchtesWort);
        if (woerterbucheintrag == null)
        {
            System.out.println("Eintrag existiert nicht!");
        }
        else
        {
            woerterbucheintrag.BedeutungSetzen(bedeutungNeu);
        }
    }

    /**
     * Gibt die Tiefe des Knotens an, in dem ein Datenelement mit dem Schlüssel
     * suchSchluessel gespeichert ist.
     *
     * @param gesuchtesWort Schlüssel, nach dem gesucht wird als Zeichenkette
     *
     * @return Tiefe als positive Zahl, bzw. -1 falls der suchSchluessel nicht
     *     vorhanden ist.
     */
    public int TiefeGeben(String gesuchtesWort)
    {
        return woerterbuch.TiefeGeben(gesuchtesWort);
    }

    /**
     * Fügt ein Baumelement "rechts unten" in den Baum ein. Das eingefügte
     * Baumelement kann selbst auch Nachfolger haben. In diesem Fall kann mit
     * der Methode RechtsEinfuegen verschiedene Bäme zusammengefügt werden. Es
     * ist wichtig, an der richtigen Stelle einzufügen, damit die Ordnung des
     * Binärbaums nicht zerstört wird!
     *
     * @param element einzufügendes Baumelement
     */
    public void RechtsEinfuegen(BaumElement element)
    {
        woerterbuch.RechtsEinfuegen(element);
    }

    /**
     * Gibt alle Einträge des Wörterbuchs als Baum aus.
     *
     */
    public void BaumAusgeben()
    {
        woerterbuch.StrukturAusgeben();
        System.out.println("---------------------------------");
    }

    /**
     * Gibt alle Einträge inklusiv Abschluss-Objekte des Wörterbuchs als Baum
     * aus.
     *
     */
    public void BaumAusgeben2()
    {
        woerterbuch.StrukturAusgeben2();
        System.out.println("---------------------------------");
    }

    /**
     * Gibt alle Einträge des Wörterbuchs alphabetisch (Inorder) als Liste aus.
     *
     */
    public void InformationAusgeben()
    {
        woerterbuch.InorderAusgeben();
        System.out.println("---------------------------------");
    }

    /**
     * Gibt alle Einträge des Wörterbuchs preorder aus.
     *
     */
    public void InformationPreorderAusgeben()
    {
        woerterbuch.PreorderAusgeben();
        System.out.println("---------------------------------");
    }

    /**
     * Gibt alle Einträge des Wörterbuchs postorder als Liste aus.
     *
     */
    public void InformationPostorderAusgeben()
    {
        woerterbuch.PostorderAusgeben();
        System.out.println("---------------------------------");
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
     * Berechnet die Höhe des Baums und gibt diesen Wert zurück
     *
     * @return Höhe des Baums u
     */
    public int HoeheGeben()
    {
        return woerterbuch.HoeheGeben();
    }
}
