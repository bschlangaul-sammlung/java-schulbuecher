package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_02.thema_03.aufgabe_03.woerterbuch_visualisierung;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * Die Test-Klasse BinbaumTest.
 *
 * @author Peter Brichzin
 *
 * @version 23.5.24
 */
public class BinBaumTest
{
    private Woerterbucheintrag woerterb1;

    private Woerterbucheintrag woerterb2;

    private Woerterbucheintrag woerterb3;

    private Woerterbucheintrag woerterb4;

    private Woerterbucheintrag woerterb5;

    private Woerterbucheintrag woerterb6;

    private BinBaum binBaum1;

    private Woerterbucheintrag woerterb7;

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
        woerterb2 = new Woerterbucheintrag("cat", "Katze");
        woerterb3 = new Woerterbucheintrag("cup", "Tasse, Becher");
        woerterb4 = new Woerterbucheintrag("cut", "Schnitt, Öffnung, kürzen");
        woerterb5 = new Woerterbucheintrag("cube", "Würfel");
        woerterb6 = new Woerterbucheintrag("cave", "Höhle");
        binBaum1 = new BinBaum();
        binBaum1.Einfügen(woerterb1);
        binBaum1.Einfügen(woerterb2);
        binBaum1.Einfügen(woerterb3);
        binBaum1.Einfügen(woerterb4);
        woerterb7 = new Woerterbucheintrag("crab", "Krabbe");
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
}
