package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_06.aufgabe_01.woerterbuch;

/**
 * Englisch-deutsches Wörterbuch als Liste implementiert.
 *
 * @author (Peter Brichzin)
 *
 * @version (20.3.09)
 */
public class Woerterbuch
{
    /**
     * Implementierung des Wörterbuchs als Liste
     */
    private Liste woerterbuch;

    /**
     * Konstruktor für Objekte der Klasse WOERTERBUCH, erzeugt ein englischen
     * Wörterbuch mit 15 Einträgen.
     */
    public Woerterbuch()
    {
        woerterbuch = new Liste();
        SortiertEinfuegen("cup", "Tasse, Becher");
        SortiertEinfuegen("cube",
                "Wuerfel, dritte Potenz, in die dritte Potenz heben, in Wuerfel schneiden");
        SortiertEinfuegen("crow", "Kraehe, Freudenschrei, frohlocken, kraehen");
        SortiertEinfuegen("crab", "Krabbe, Krebs, Griesgram");
        SortiertEinfuegen("cook", "Koch, kochen");
        SortiertEinfuegen("coin", "Muenze, auspraegen, erfinden");
        SortiertEinfuegen("code", "Chiffre, Vorwahl,chiffrieren");
        SortiertEinfuegen("clip", "Klammer, abschneiden, anstecken");
        SortiertEinfuegen("cave", "Hoehle, aushoehlen, einbrechen");
        SortiertEinfuegen("cat", "Katze");
        SortiertEinfuegen("care", "Fuersorge, Sorgfalt");
        SortiertEinfuegen("car", "Auto, Fahrzeug, Waggon");
        SortiertEinfuegen("can", "Becher, Dose, koennen");
        SortiertEinfuegen("call", "Anruf, Ernennung, anrufen, bezeichnen");
        SortiertEinfuegen("cake", "Kuchen, Platte, backen");
    }

    /**
     * SortiertEinfuegen erzeugt ein ein Objekt der Klasse WOERTERBUCHEINTRAG
     * mit den Eingabewerten und fügt diesen Wörterbucheintrag sortiert in die
     * Liste woerterbuch ein. Es wird verhindert, dass ein englisches Wort
     * mehrfach im Wörterbuch abgespeichert werden kann.
     *
     * @param wort englisches Wort
     * @param bedeutung die deutsche(n) Bedeutung(en).
     */
    public void SortiertEinfuegen(String wort, String bedeutung)
    {
        WoerterbuchEintrag neuerWoerterbucheintrag;
        neuerWoerterbucheintrag = new WoerterbuchEintrag(wort, bedeutung);
        if (Suchen(wort) == null)
        {
            woerterbuch.SortiertEinfuegen(neuerWoerterbucheintrag);
        }
        else
        {
            System.out.println("Eintrag existiert schon");
        }
    }

    /**
     * Sucht ein englsiches Wort im Wörterbuch
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
     * Gibt alle Einträge des Wörterbuchs aus.
     */
    public void InformationAusgeben()
    {
        woerterbuch.InformationAusgeben();
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
