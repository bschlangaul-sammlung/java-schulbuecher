package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_02.thema_03.aufgabe_00.nutzerverwaltung_visualisierung;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * Die Test-Klasse BinBaumTest.
 *
 * @author Peter Brichzin
 *
 * @version 23.5.24
 */
public class BinBaumTest
{
    private User user1;

    private User user2;

    private User user3;

    private User user4;

    private User user5;

    private User user6;

    private BinBaum binBaum1;

    /**
     * Konstruktor fuer die Test-Klasse BinBaumTest
     */
    public BinBaumTest()
    {
    }

    /**
     * Setzt das Testgerüst fuer den Test.
     * <p>
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @BeforeEach
    public void setUp()
    {
        user1 = new User(5781, "Geber", "Ann");
        user2 = new User(4221, "Tross", "Albert");
        user3 = new User(6345, "Fall", "Klara");
        user4 = new User(5799, "Ter", "Lee");
        user5 = new User(6300, "Sehr", "Kai");
        user6 = new User(5888, "Pfahl", "Marta");
        binBaum1 = new BinBaum();
        binBaum1.Einfügen(user1);
        binBaum1.Einfügen(user2);
        binBaum1.Einfügen(user3);
        binBaum1.Einfügen(user4);
    }

    /**
     * Gibt das Testgerüst wieder frei.
     * <p>
     * Wird nach jeder Testfall-Methode aufgerufen.
     */
    @AfterEach
    public void tearDown()
    {
    }
}
