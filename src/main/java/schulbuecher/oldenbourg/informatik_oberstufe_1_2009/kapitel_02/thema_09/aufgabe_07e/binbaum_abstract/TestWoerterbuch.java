package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_09.aufgabe_07e.binbaum_abstract;

/**
 * Die KLasse TESTWOERTERBUCH erzeugt ein gefülltes Wörterbuch. über die Methode
 * WoerterbuchGeben kann man auf das erzteugte Objekt zugreifen und eigene bzw.
 * geerbte Methoden testen.
 *
 * @author (Peter Brichzin)
 *
 * @version (20.3.09)
 */
public class TestWoerterbuch
{
    // Testet ein Wörterbuch
    Woeterbuch woerterbuch;

    /**
     * Konstruktor für Objekte der Klasse TEST
     */
    public TestWoerterbuch()
    {
        woerterbuch = new Woeterbuch();
        woerterbuch.Einfuegen(new WoerterbuchEintrag("clip",
                "Klammer, abschneiden, anstecken"));
        woerterbuch.Einfuegen(
                new WoerterbuchEintrag("car", "Auto, Fahrzeug, Waggon"));
        woerterbuch.Einfuegen(new WoerterbuchEintrag("call",
                "Anruf, Ernennung, anrufen, bezeichnen"));
        // woerterbuch.Einfuegen(new WOERTERBUCHEINTRAG("can","Becher, Dose,
        // koennen" ));
        woerterbuch.Einfuegen(new WoerterbuchEintrag("cat", "Katze"));
        woerterbuch.Einfuegen(
                new WoerterbuchEintrag("care", "Fuersorge, Sorgfalt"));
        woerterbuch.Einfuegen(new WoerterbuchEintrag("cave",
                "Hoehle, aushoehlen, einbrechen"));
        woerterbuch.Einfuegen(
                new WoerterbuchEintrag("crab", "Krabbe, Krebs, Griesgram"));
        woerterbuch.Einfuegen(
                new WoerterbuchEintrag("coin", "Muenze, auspraegen, erfinden"));
        woerterbuch.Einfuegen(new WoerterbuchEintrag("cook", "Koch, kochen"));
        woerterbuch.Einfuegen(new WoerterbuchEintrag("cube",
                "Wuerfel, dritte Potenz, in die dritte Potenz heben, in Wuerfel schneiden"));
        woerterbuch.Einfuegen(new WoerterbuchEintrag("crow",
                "Kraehe, Freudenschrei, frohlocken, kraehen"));
    }

    public Woeterbuch WoerterbuchGeben()
    {
        return woerterbuch;
    }
}
