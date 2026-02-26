package schulbuecher.isb.abitur.pruefung_2022.inf1.aufgabe_ii.teilaufgabe_04;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AbonnentTest {

    @Test
    public void testIstKleinerAlsTrue() {
        Abonnent abonnent = new Abonnent();
        abonnent.eMail = "alice@example.com";
        assertTrue(abonnent.istKleinerAls("bob@example.com"));
    }

    @Test
    public void testIstKleinerAlsFalse() {
        Abonnent abonnent = new Abonnent();
        abonnent.eMail = "bob@example.com";
        assertFalse(abonnent.istKleinerAls("alice@example.com"));
    }

    @Test
    public void testIstKleinerAlsEqual() {
        Abonnent abonnent = new Abonnent();
        abonnent.eMail = "alice@example.com";
        assertFalse(abonnent.istKleinerAls("alice@example.com"));
    }

    @Test
    public void testIstKleinerAlsWithNumbers() {
        Abonnent abonnent = new Abonnent();
        abonnent.eMail = "a@example.com";
        assertTrue(abonnent.istKleinerAls("b@example.com"));
    }

    @Test
    public void testIstKleinerAlsCaseSensitive() {
        Abonnent abonnent = new Abonnent();
        abonnent.eMail = "A@example.com";
        assertTrue(abonnent.istKleinerAls("a@example.com"));
    }
}
