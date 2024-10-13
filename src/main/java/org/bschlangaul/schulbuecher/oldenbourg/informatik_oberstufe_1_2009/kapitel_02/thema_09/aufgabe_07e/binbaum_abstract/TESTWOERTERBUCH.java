package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_09.aufgabe_07e.binbaum_abstract;

/**
 * Die KLasse TESTWOERTERBUCH erzeugt ein gefülltes Wörterbuch. über die Methode
 * WoerterbuchGeben kann man auf das erzteugte Objekt zugreifen und eigene bzw.
 * geerbte Methoden testen.
 *
 * @author (Peter Brichzin)
 *
 * @version (20.3.09)
 */
public class TESTWOERTERBUCH
{
    // Testet ein Wörterbuch
    WOERTERBUCH woerterbuch;

    /**
     * Konstruktor für Objekte der Klasse TEST
     */
    public TESTWOERTERBUCH()
    {
        woerterbuch = new WOERTERBUCH();
        woerterbuch.Einfuegen(new WOERTERBUCHEINTRAG("clip",
                "Klammer, abschneiden, anstecken"));
        woerterbuch.Einfuegen(
                new WOERTERBUCHEINTRAG("car", "Auto, Fahrzeug, Waggon"));
        woerterbuch.Einfuegen(new WOERTERBUCHEINTRAG("call",
                "Anruf, Ernennung, anrufen, bezeichnen"));
        // woerterbuch.Einfuegen(new WOERTERBUCHEINTRAG("can","Becher, Dose,
        // koennen" ));
        woerterbuch.Einfuegen(new WOERTERBUCHEINTRAG("cat", "Katze"));
        woerterbuch.Einfuegen(
                new WOERTERBUCHEINTRAG("care", "Fuersorge, Sorgfalt"));
        woerterbuch.Einfuegen(new WOERTERBUCHEINTRAG("cave",
                "Hoehle, aushoehlen, einbrechen"));
        woerterbuch.Einfuegen(
                new WOERTERBUCHEINTRAG("crab", "Krabbe, Krebs, Griesgram"));
        woerterbuch.Einfuegen(
                new WOERTERBUCHEINTRAG("coin", "Muenze, auspraegen, erfinden"));
        woerterbuch.Einfuegen(new WOERTERBUCHEINTRAG("cook", "Koch, kochen"));
        woerterbuch.Einfuegen(new WOERTERBUCHEINTRAG("cube",
                "Wuerfel, dritte Potenz, in die dritte Potenz heben, in Wuerfel schneiden"));
        woerterbuch.Einfuegen(new WOERTERBUCHEINTRAG("crow",
                "Kraehe, Freudenschrei, frohlocken, kraehen"));
    }

    public WOERTERBUCH WoerterbuchGeben()
    {
        return woerterbuch;
    }
}
