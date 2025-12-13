package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_02.thema_05.aufgabe_05.woerterbuch;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Die Test-Klasse BinbaumTest.
 *
 * @author (Peter Brichzin)
 *
 * @version (28.5.24)
 */
public class BinBaumTest
{
    private Woerterbucheintrag woerterb1;

    private Woerterbucheintrag woerterb2;

    private Woerterbucheintrag woerterb3;

    private Woerterbucheintrag woerterb4;

    private Woerterbucheintrag woerterb5;

    private Woerterbucheintrag woerterb6;

    private Woerterbucheintrag woerterb7;

    private Woerterbucheintrag woerterb8;

    private Woerterbucheintrag woerterb9;

    private Woerterbucheintrag woerterb10;

    private Woerterbucheintrag woerterb11;

    private Woerterbucheintrag woerterb12;

    private Baumelement teilbaum;

    private BinBaum binBaum1;

    private BinBaum binBaum2;

    /**
     * Konstruktor fuer die Test-Klasse BinbaumTest
     */
    public BinBaumTest()
    {
    }

    /**
     * Setzt das Testgerüst fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @BeforeEach
    public void setUp()
    {
        woerterb1 = new Woerterbucheintrag("clip", "Clip, Spange, Klammer");
        woerterb2 = new Woerterbucheintrag("car", "Auto");
        woerterb3 = new Woerterbucheintrag("crab", "Krabbe");
        woerterb4 = new Woerterbucheintrag("call", "Anruf, Gespräch, anrufen");
        woerterb5 = new Woerterbucheintrag("can", "Dose, können");
        woerterb6 = new Woerterbucheintrag("cat", "Katze");
        woerterb7 = new Woerterbucheintrag("care", "Pflege, Zuwendung");
        woerterb8 = new Woerterbucheintrag("cave", "Höhle");

        woerterb9 = new Woerterbucheintrag("coin", "Münze, Geldstück");
        woerterb10 = new Woerterbucheintrag("cube", "Würfel");
        woerterb11 = new Woerterbucheintrag("cook", "Koch, kochen");
        woerterb12 = new Woerterbucheintrag("crow", "Krähe");

        binBaum1 = new BinBaum();
        binBaum1.Einfügen(woerterb1);
        binBaum1.Einfügen(woerterb2);
        binBaum1.Einfügen(woerterb3);
        binBaum1.Einfügen(woerterb6);
        binBaum1.Einfügen(woerterb7);
        binBaum1.Einfügen(woerterb8);
        binBaum1.Einfügen(woerterb9);
        binBaum1.Einfügen(woerterb10);
        binBaum1.Einfügen(woerterb11);
        binBaum1.Einfügen(woerterb12);
        binBaum2 = new BinBaum();
        binBaum2.Einfügen(woerterb2);
        binBaum2.Einfügen(woerterb4);
        binBaum2.Einfügen(woerterb5);
        teilbaum = new Knoten(woerterb6, new Knoten(woerterb7),
                new Knoten(woerterb8));

    }

    /**
     * Gibt das Testgerüst wieder frei.
     *
     * Wird nach jeder Testfall-Methode aufgerufen.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void testRechtsEinfügen()
    {
        System.out.println("Baum vorher:");
        System.out.println("");
        binBaum2.StrukturAusgeben();
        System.out.println("");
        System.out.println("---------------------------------------");

        System.out.println("Baum nachher:");
        System.out.println("");
        binBaum2.RechtsEinfügen(teilbaum);
        binBaum2.StrukturAusgeben();
        System.out.println("");
        System.out.println("---------------------------------------");
    }

    @Test
    public void testEntfernen()
    {
        System.out.println("Baum vorher:");
        System.out.println("");
        binBaum1.StrukturAusgeben();
        System.out.println("");
        System.out.println("---------------------------------------");

        System.out.println(
                "Test von Fall 1: zu entfernender Knoten ist ein Blatt");
        System.out.println("Baum nach entfernen von cook:");
        System.out.println("");
        binBaum1.KnotenEntfernen("cook");
        binBaum1.StrukturAusgeben();
        System.out.println("");
        System.out.println("---------------------------------------");

        System.out.println(
                "Test von Fall 2: zu entfernender Knoten hat genau einen Nachfolger");
        System.out.println("Baum nach entfernen von car:");
        System.out.println("");
        binBaum1.KnotenEntfernen("car");
        binBaum1.StrukturAusgeben();
        System.out.println("");
        System.out.println("---------------------------------------");

        System.out.println(
                "Test von Fall 3: zu entfernender Knoten hat genau zwei Nachfolger");
        System.out.println("Baum nach entfernen von crab:");
        System.out.println("");
        binBaum1.KnotenEntfernen("crab");
        binBaum1.StrukturAusgeben();
        System.out.println("");
        System.out.println("---------------------------------------");
    }

    @Test
    public void testEntfernen2()
    {
        System.out.println("Baum vorher:");
        System.out.println("");
        binBaum1.StrukturAusgeben();
        System.out.println("");
        System.out.println("---------------------------------------");

        System.out.println(
                "Test von Fall 1: zu entfernender Knoten ist ein Blatt");
        System.out.println("Baum nach entfernen von cook:");
        System.out.println("");
        binBaum1.KnotenEntfernen2("cook");
        binBaum1.StrukturAusgeben();
        System.out.println("");
        System.out.println("---------------------------------------");

        System.out.println(
                "Test von Fall 2: zu entfernender Knoten hat genau einen Nachfolger");
        System.out.println("Baum nach entfernen von car:");
        System.out.println("");
        binBaum1.KnotenEntfernen2("car");
        binBaum1.StrukturAusgeben();
        System.out.println("");
        System.out.println("---------------------------------------");

        System.out.println(
                "Test von Fall 3: zu entfernender Knoten hat genau zwei Nachfolger");
        System.out.println("Baum nach entfernen von crab:");
        System.out.println("");
        binBaum1.KnotenEntfernen2("crab");
        binBaum1.StrukturAusgeben();
        System.out.println("");
        System.out.println("---------------------------------------");
    }
}
