package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_08.aufgabe_02;

/**
 * Beschreiben Sie hier die Klasse WOERTERBUCHTEST.
 *
 * @author (Peter Brichzin)
 *
 * @version (14.4.09)
 */
public class WOERTERBUCHTEST
{
    WOERTERBUCH woerterbuch;

    /**
     * Konstruktor für Objekte der Klasse WOERTERBUCHTEST
     */
    public WOERTERBUCHTEST()
    {
        woerterbuch = new WOERTERBUCH();
    }

    /**
     * Methode zum Testen der Methode TiefeGeben am Beispiel des Baums aus
     * Kapitel 8 Abb. 1 bzw. 2
     *
     */
    public void TiefeGebenTesten()
    {
        System.out.println(
                "Test der Tiefe des Datenelements mit dem Schl\u00fce\u00dfel clip:");
        System.out.println(woerterbuch.TiefeGeben("clip"));
        System.out.println(
                "Testergebnis: " + (woerterbuch.TiefeGeben("clip") == 0));
        System.out.println("------------------------------------------------");
        System.out.println(
                "Test der Tiefe des Datenelements mit dem Schl\u00fce\u00dfel car:");
        System.out.println(woerterbuch.TiefeGeben("car"));
        System.out.println(
                "Testergebnis: " + (woerterbuch.TiefeGeben("car") == 1));
        System.out.println("------------------------------------------------");
        System.out.println(
                "Test der Tiefe des Datenelements mit dem Schl\u00fce\u00dfel cat:");
        System.out.println(woerterbuch.TiefeGeben("cat"));
        System.out.println(
                "Testergebnis: " + (woerterbuch.TiefeGeben("cat") == 2));
        System.out.println("------------------------------------------------");
        System.out.println(
                "Test der Tiefe des Datenelements mit dem Schl\u00fce\u00dfel cave:");
        System.out.println(woerterbuch.TiefeGeben("cave"));
        System.out.println(
                "Testergebnis: " + (woerterbuch.TiefeGeben("cave") == 3));
        System.out.println("------------------------------------------------");
        System.out.println(
                "Test der Tiefe des Datenelements mit dem Schl\u00fce\u00dfel cook:");
        System.out.println(woerterbuch.TiefeGeben("cook"));
        System.out.println(
                "Testergebnis: " + (woerterbuch.TiefeGeben("cook") == 3));
        System.out.println("------------------------------------------------");
        System.out.println(
                "Test der Tiefe des Datenelements mit dem Schl\u00fce\u00dfel cell:");
        System.out.println(woerterbuch.TiefeGeben("cell"));
        System.out.println(
                "Testergebnis: " + (woerterbuch.TiefeGeben("cell") == -1));
        System.out.println("------------------------------------------------");
        System.out.println(
                "Test der Tiefe des Datenelements mit dem Schl\u00fce\u00dfel cable:");
        System.out.println(woerterbuch.TiefeGeben("cable"));
        System.out.println(
                "Testergebnis: " + (woerterbuch.TiefeGeben("cable") == -1));
        System.out.println("------------------------------------------------");
        System.out.println(
                "Test der Tiefe des Datenelements mit dem Schl\u00fce\u00dfel cut:");
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
    public WOERTERBUCH WoerterbuchGeben()
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
        WOERTERBUCHEINTRAG wb1;
        WOERTERBUCHEINTRAG wb2;
        WOERTERBUCHEINTRAG wb3;
        KNOTEN knoten;
        wb1 = new WOERTERBUCHEINTRAG("cute", "nett, pfiffig");
        wb2 = new WOERTERBUCHEINTRAG("cut",
                "Schnitt, \u00d6ffnung, k\u00fcrzen");
        wb3 = new WOERTERBUCHEINTRAG("cup", "Tasse, Becher");
        knoten = new KNOTEN(wb1, new KNOTEN(wb2), new KNOTEN(wb3));
        woerterbuch.RechtsEinfuegen(knoten);
    }
}
