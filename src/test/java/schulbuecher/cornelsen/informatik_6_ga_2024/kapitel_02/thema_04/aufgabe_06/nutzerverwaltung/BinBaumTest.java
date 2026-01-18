package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_02.thema_04.aufgabe_06.nutzerverwaltung;

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
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @BeforeEach
    public void setUp()
    {
        user1 = new User("Geber", "Ann", 16);
        user2 = new User("Tross", "Albert", 16);
        user3 = new User("Fall", "Klara", 17);
        user4 = new User("Ter", "Lee", 18);
        user5 = new User("Sehr", "Kai", 20);
        user6 = new User("Pfahl", "Marta", 17);
        binBaum1 = new BinBaum();
        binBaum1.Einfügen(user5);
        binBaum1.Einfügen(user1);
        binBaum1.Einfügen(user2);
        binBaum1.Einfügen(user3);
        binBaum1.Einfügen(user4);
        binBaum1.Einfügen(user6);
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
