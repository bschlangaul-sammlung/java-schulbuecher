package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_02.thema_05.aufgabe_03.adressbuch_visualisierung_interface_datenelement;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * Die Test-Klasse WoerterbuchTest.
 *
 * @author Peter Brichzin
 *
 * @version 30.5.24
 */
public class WoerterbuchTest
{
    private Woerterbucheintrag woerterb1;

    private Woerterbucheintrag woerterb2;

    private Woerterbucheintrag woerterb3;

    private Woerterbucheintrag woerterb4;

    private Woerterbucheintrag woerterb5;

    private Woerterbucheintrag woerterb6;

    private Woerterbucheintrag woerterb7;

    private Woerterbucheintrag woerterb8;

    private Woerterbuch woerterbuch1;

    /**
     * Konstruktor fuer die Test-Klasse WoerterbuchTest
     */
    public WoerterbuchTest()
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
        woerterb4 = new Woerterbucheintrag("coin", "Münze, Geldstück");
        woerterb5 = new Woerterbucheintrag("cube", "Würfel");
        woerterb6 = new Woerterbucheintrag("call", "Anruf, Gespräch, anrufen");
        woerterb7 = new Woerterbucheintrag("cat", "Katze");
        woerterb8 = new Woerterbucheintrag("cave", "Höhle");
        woerterbuch1 = new Woerterbuch();
        woerterbuch1.Einfügen(woerterb1);
        woerterbuch1.Einfügen(woerterb2);
        woerterbuch1.Einfügen(woerterb3);
        woerterbuch1.Einfügen(woerterb4);
        woerterbuch1.Einfügen(woerterb5);
        woerterbuch1.Einfügen(woerterb6);
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
