package org.bschlangaul.schulbuecher.isb.abitur.pruefung_2025;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AutomatTest {

    private static Automat automat;

    @BeforeAll
    public static void setUp() {
        automat = new Automat();
    }

    @Test
    public void testLengthValidation() {
        // Test: length must be exactly 4
        assertFalse(automat.prüfen("ABC"));
        assertFalse(automat.prüfen("ABCDE"));
        // A valid code with correct length
        assertTrue(automat.prüfen("A103"));
    }

    @Test
    public void testFirstCharAtoD() {
        // Valid cases for A-D
        assertTrue(automat.prüfen("A103"));
        assertTrue(automat.prüfen("B103"));
        assertTrue(automat.prüfen("C103"));
        assertTrue(automat.prüfen("D103"));

        // Invalid: second and third both 0
        assertFalse(automat.prüfen("A001"));

        // Invalid: second is 0, third is not 0
        assertFalse(automat.prüfen("A112"));
    }

    @Test
    public void testFirstCharEtoH() {
        // Valid cases for E-H
        assertTrue(automat.prüfen("E123"));
        assertTrue(automat.prüfen("F123"));
        assertTrue(automat.prüfen("G123"));
        assertTrue(automat.prüfen("H123"));

        // Invalid: second and third both 0
        assertFalse(automat.prüfen("E001"));
    }

    @Test
    public void testSecondCharIs1() {
        // Valid: second is 1, third is 0, 1, or 2
        assertTrue(automat.prüfen("A101"));

        // Invalid: second is 1, third is not 0, 1, or 2
        assertFalse(automat.prüfen("A131"));
    }

    @Test
    public void testFourthChar() {
        // Valid: fourth is 1-6
        assertTrue(automat.prüfen("A101"));
        assertTrue(automat.prüfen("A102"));
        assertTrue(automat.prüfen("A103"));
        assertTrue(automat.prüfen("A104"));
        assertTrue(automat.prüfen("A105"));
        assertTrue(automat.prüfen("A106"));

        // Invalid: fourth is not 1-6
        assertFalse(automat.prüfen("A100"));
        assertFalse(automat.prüfen("A107"));
    }

    @Test
    public void firstLetter() {
        // Valid: fourth is 1-6
        assertFalse(automat.prüfen("X101"));
    }

    @Test
    public void testCombinedRules() {
        // Testing multiple rules together
        assertTrue(automat.prüfen("A103"));
        assertTrue(automat.prüfen("E123"));
        assertFalse(automat.prüfen("A007"));
        assertFalse(automat.prüfen("E007"));
        assertFalse(automat.prüfen("A107"));
        // assertFalse(automat.prüfen("Z123"));
    }
}
