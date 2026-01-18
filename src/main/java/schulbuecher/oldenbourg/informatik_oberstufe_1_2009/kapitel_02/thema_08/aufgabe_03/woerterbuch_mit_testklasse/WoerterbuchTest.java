package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_08.aufgabe_03.woerterbuch_mit_testklasse;

/**
 * Beschreiben Sie hier die Klasse WOERTERBUCHTEST.
 *
 * @author (Peter Brichzin)
 *
 * @version (14.4.09)
 */
public class WoerterbuchTest
{
    Woerterbuch woerterbuch;

    /**
     * Konstruktor für Objekte der Klasse WOERTERBUCHTEST
     */
    public WoerterbuchTest()
    {
        woerterbuch = new Woerterbuch();
    }

    /**
     * Methode zum Testen der Methode TiefeGeben am Beispiel des Baums aus
     * Kapitel 8 Abb. 1 bzw. 2
     *
     */
    public void TiefeGebenTesten()
    {
        System.out.println(
                "Test der Tiefe des Datenelements mit dem Schlüe\u00dfel clip:");
        System.out.println(woerterbuch.TiefeGeben("clip"));
        System.out.println(
                "Testergebnis: " + (woerterbuch.TiefeGeben("clip") == 0));
        System.out.println("------------------------------------------------");
        System.out.println(
                "Test der Tiefe des Datenelements mit dem Schlüe\u00dfel car:");
        System.out.println(woerterbuch.TiefeGeben("car"));
        System.out.println(
                "Testergebnis: " + (woerterbuch.TiefeGeben("car") == 1));
        System.out.println("------------------------------------------------");
        System.out.println(
                "Test der Tiefe des Datenelements mit dem Schlüe\u00dfel cat:");
        System.out.println(woerterbuch.TiefeGeben("cat"));
        System.out.println(
                "Testergebnis: " + (woerterbuch.TiefeGeben("cat") == 2));
        System.out.println("------------------------------------------------");
        System.out.println(
                "Test der Tiefe des Datenelements mit dem Schlüe\u00dfel cave:");
        System.out.println(woerterbuch.TiefeGeben("cave"));
        System.out.println(
                "Testergebnis: " + (woerterbuch.TiefeGeben("cave") == 3));
        System.out.println("------------------------------------------------");
        System.out.println(
                "Test der Tiefe des Datenelements mit dem Schlüe\u00dfel cook:");
        System.out.println(woerterbuch.TiefeGeben("cook"));
        System.out.println(
                "Testergebnis: " + (woerterbuch.TiefeGeben("cook") == 3));
        System.out.println("------------------------------------------------");
        System.out.println(
                "Test der Tiefe des Datenelements mit dem Schlüe\u00dfel cell:");
        System.out.println(woerterbuch.TiefeGeben("cell"));
        System.out.println(
                "Testergebnis: " + (woerterbuch.TiefeGeben("cell") == -1));
        System.out.println("------------------------------------------------");
        System.out.println(
                "Test der Tiefe des Datenelements mit dem Schlüe\u00dfel cable:");
        System.out.println(woerterbuch.TiefeGeben("cable"));
        System.out.println(
                "Testergebnis: " + (woerterbuch.TiefeGeben("cable") == -1));
        System.out.println("------------------------------------------------");
        System.out.println(
                "Test der Tiefe des Datenelements mit dem Schlüe\u00dfel cut:");
        System.out.println(woerterbuch.TiefeGeben("cut"));
        System.out.println(
                "Testergebnis: " + (woerterbuch.TiefeGeben("cut") == -1));
        System.out.println("------------------------------------------------");
    }

    /**
     * Geben-Methode für das Wörterbuch zum Testen
     *
     * @return woerterbuch
     */
    public Woerterbuch WoerterbuchGeben()
    {
        return woerterbuch;
    }

    /**
     * Methode zum Testen der Methode RechtsEinfuegen: Fügt in den Baum aus
     * Abbildung 1, Kapitel 8 einen Baum mit den drei Schlüsseln Wurzel: cute;
     * linker Nachfolger: cut; rechter Nachfolger: cup ein
     *
     */
    public void RechtsEinfuegenTesten()
    {
        WoerterbuchEintrag wb1;
        WoerterbuchEintrag wb2;
        WoerterbuchEintrag wb3;
        Knoten knoten;
        wb1 = new WoerterbuchEintrag("cute", "nett, pfiffig");
        wb2 = new WoerterbuchEintrag("cut", "Schnitt, \u00d6ffnung, kürzen");
        wb3 = new WoerterbuchEintrag("cup", "Tasse, Becher");
        knoten = new Knoten(wb1, new Knoten(wb2), new Knoten(wb3));
        woerterbuch.RechtsEinfuegen(knoten);
    }

    /**
     * Methode zum Testen der Methode Entfernen: Knoten werden für
     * unterschiedliche Fälle entfernt und jeweils die Baumstruktur ausgegeben.
     * So ist ein überprüfen der Korrektheit über die Konsole möglich.
     *
     */
    public void EntfernenTesten()
    {
        System.out.println("Startsituation:");
        woerterbuch.InformationAusgeben();
        System.out.println(
                "Entfernen eines Knotens mit nur einem linken, keinen rechten Nachfolger: coin");
        woerterbuch.KnotenEntfernen("coin");
        woerterbuch.InformationAusgeben();
        System.out.println(
                "Entfernen eines Knotens mit rechten, keinen linken Nachfolger: cable");
        woerterbuch.KnotenEntfernen("cable");
        woerterbuch.InformationAusgeben();
        System.out.println("Entfernen eines Knotens mit zwei Nachfolger: crab");
        System.out.println("(Rechter Nachfolger ist verzweigt)");
        woerterbuch.KnotenEntfernen("crab");
        woerterbuch.InformationAusgeben();
        System.out
                .println("Entfernen eines Knotens mit zwei Nachfolger: creek");
        System.out.println("(Rechter Nachfolger ist eine entartete Liste)");
        woerterbuch.KnotenEntfernen("creek");
        woerterbuch.InformationAusgeben();
        System.out.println("Entfernen eines Knotens mit zwei Nachfolger: clip");
        System.out.println("(Knoten ist die Wurzel)");
        woerterbuch.KnotenEntfernen("clip");
        woerterbuch.InformationAusgeben();
        System.out.println("Entfernen eines Blatts: care");
        System.out.println("(Das Blatt ist ein linker Nachfolger)");
        woerterbuch.KnotenEntfernen("care");
        woerterbuch.InformationAusgeben();
        System.out.println("Entfernen eines Blatts: canvas");
        System.out.println("(Das Blatt ist ein rechter Nachfolger)");
        woerterbuch.KnotenEntfernen("canvas");
        woerterbuch.InformationAusgeben();
        System.out.println(
                "Versuch einen Schluessel zu entfernen, der nicht existiert: city");
        woerterbuch.KnotenEntfernen("city");
        woerterbuch.InformationAusgeben();
    }
}
