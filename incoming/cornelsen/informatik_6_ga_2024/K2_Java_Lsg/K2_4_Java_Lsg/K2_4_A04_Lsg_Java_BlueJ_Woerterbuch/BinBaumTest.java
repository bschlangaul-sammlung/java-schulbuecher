import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Die Test-Klasse BinbaumTest.
 *
 * @author  Peter Brichzin
 * @version 28.5.24
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
    private BinBaum binBaum1;

    /**
     * Konstruktor fuer die Test-Klasse BinbaumTest
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
        woerterb1 = new Woerterbucheintrag("clip", "Clip, Spange, Klammer");
        woerterb2 = new Woerterbucheintrag("car", "Auto");
        woerterb3 = new Woerterbucheintrag("crab", "Krabbe");
        woerterb4 = new Woerterbucheintrag("coin", "Münze, Geldstück");
        woerterb5 = new Woerterbucheintrag("cube", "Würfel");
        woerterb6 = new Woerterbucheintrag("call", "Anruf, Gespräch, anrufen");
        woerterb7 = new Woerterbucheintrag("cat", "Katze");
        woerterb8 = new Woerterbucheintrag("cave", "Höhle");
        binBaum1 = new BinBaum();
        binBaum1.Einfügen(woerterb1);
        binBaum1.Einfügen(woerterb2);
        binBaum1.Einfügen(woerterb3);
        binBaum1.Einfügen(woerterb4);
        binBaum1.Einfügen(woerterb5);
        binBaum1.Einfügen(woerterb6);
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
