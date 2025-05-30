import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Die Test-Klasse BinBaumTest.
 *
 * @author  Peter Brichzin
 * @version 23.5.24
 */
public class BinBaumTest
{
    private Adressbucheintrag eintrag1;
    private Adressbucheintrag eintrag2;
    private Adressbucheintrag eintrag3;
    private Adressbucheintrag eintrag4;
    private Adressbucheintrag eintrag5;
    private Adressbucheintrag eintrag6;
    private Adressbucheintrag eintrag7;
    private Adressbucheintrag eintrag8;
    private BinBaum binBaum1;

    /**
     * Konstruktor fuer die Test-Klasse BinBaumTest
     */
    public BinBaumTest()
    {
    }

    /**
     *  Setzt das Testgerüst fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @BeforeEach
    public void setUp()
    {
        eintrag1 = new Adressbucheintrag("Ann", "0171 39200 00");
        eintrag2 = new Adressbucheintrag("Tom", "0171 39200 10");
        eintrag3 = new Adressbucheintrag("Kia", "0171 39200 20");
        eintrag4 = new Adressbucheintrag("Mara", "0171 39200 30");
        eintrag5 = new Adressbucheintrag("Kai Ser", "0171 39200 40");
        eintrag6 = new Adressbucheintrag("Lee Ter", "0171 39200 50");
        eintrag7 = new Adressbucheintrag("Ben H.", "0171 39200 60");
        eintrag8 = new Adressbucheintrag("Miro", "0171 39200 70");
        binBaum1 = new BinBaum();
        binBaum1.Einfügen(eintrag3);
        binBaum1.Einfügen(eintrag1);
        binBaum1.Einfügen(eintrag2);
        binBaum1.Einfügen(eintrag4);
        binBaum1.Einfügen(eintrag5);
        binBaum1.Einfügen(eintrag6);
        binBaum1.Einfügen(eintrag7);
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