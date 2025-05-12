package org.bschlangaul.schulbuecher.isb.abitur.pruefung_2025;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AutomatTest
{

    private static Automat automat;

    @BeforeAll
    public static void setUp()
    {
        automat = new Automat();
    }

    @Test
    public void testLengthValidation()
    {
        // Test: length must be exactly 4
        assertFalse(automat.prüfen("ABC"));
        assertFalse(automat.prüfen("ABCDE"));
        // A valid code with correct length
        assertTrue(automat.prüfen("A123"));
    }

    @Test
    public void testFirstCharAtoD()
    {
        // Valid cases for A-D
        assertTrue(automat.prüfen("A123"));
        assertTrue(automat.prüfen("B123"));
        assertTrue(automat.prüfen("C123"));
        assertTrue(automat.prüfen("D123"));

        // Invalid: second and third both 0
        assertFalse(automat.prüfen("A001"));

        // Invalid: second is 0, third is not 0
        assertFalse(automat.prüfen("A012"));
    }

    @Test
    public void testFirstCharEtoH()
    {
        // Valid cases for E-H
        assertTrue(automat.prüfen("E123"));
        assertTrue(automat.prüfen("F123"));
        assertTrue(automat.prüfen("G123"));
        assertTrue(automat.prüfen("H123"));

        // Invalid: second and third both 0
        assertFalse(automat.prüfen("E001"));
    }

    @Test
    public void testSecondCharIs1()
    {
        // Valid: second is 1, third is 0, 1, or 2
        assertTrue(automat.prüfen("A101"));
        assertTrue(automat.prüfen("A111"));
        assertTrue(automat.prüfen("A121"));

        // Invalid: second is 1, third is not 0, 1, or 2
        assertFalse(automat.prüfen("A131"));
    }

    @Test
    public void testFourthChar()
    {
        // Valid: fourth is 1-6
        assertTrue(automat.prüfen("A121"));
        assertTrue(automat.prüfen("A122"));
        assertTrue(automat.prüfen("A123"));
        assertTrue(automat.prüfen("A124"));
        assertTrue(automat.prüfen("A125"));
        assertTrue(automat.prüfen("A126"));

        // Invalid: fourth is not 1-6
        assertFalse(automat.prüfen("A120"));
        assertFalse(automat.prüfen("A127"));
    }

    @Test
    public void testCombinedRules()
    {
        // Testing multiple rules together
        assertTrue(automat.prüfen("A123"));
        assertTrue(automat.prüfen("E123"));
        assertFalse(automat.prüfen("A007"));
        assertFalse(automat.prüfen("E007"));
        assertFalse(automat.prüfen("A137"));
        assertFalse(automat.prüfen("Z123"));
    }
}
