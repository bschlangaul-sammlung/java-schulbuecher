package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_07.aufgabe_09.binbaum_mit_entfernen_mit_testklasse;

/**
 * Beschreiben Sie hier die Klasse WOERTERBUCHTEST.
 *
 * @author (Ihr Name)
 *
 * @version (eine Versionsnummer oder ein Datum)
 */
public class WOERTERBUCHTEST
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    WOERTERBUCH woerterbuch;

    /**
     * Konstruktor für Objekte der Klasse WOERTERBUCHTEST
     */
    public WOERTERBUCHTEST()
    {
        woerterbuch = new WOERTERBUCH();
        woerterbuch.Einfuegen("code", "Chiffre");
        woerterbuch.Einfuegen("cobalt", "Kobalt");
        woerterbuch.Einfuegen("cube", "W\u00fcrfel");
        woerterbuch.Einfuegen("creek", "Bach");
        woerterbuch.Einfuegen("cup", "Tasse");
        woerterbuch.Einfuegen("cable", "Kabel");
        woerterbuch.Einfuegen("can", "Dose, k\u00f6nnen");
        woerterbuch.Einfuegen("canvas", "Leinwand");
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

    /**
     * Geben-Methode für das Wörterbuch zum Testen
     *
     * @return woerterbuch
     */
    public WOERTERBUCH WoerterbuchGeben()
    {
        return woerterbuch;
    }
}
