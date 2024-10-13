package org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_01.autokennzeichen;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class AutokennzeichenTest
{
    Autokennzeichen knacker = new Autokennzeichen();

    @Test
    public void testeOaFj123()
    {
        assertTrue(knacker.wortUntersuchen("OA FJ 123"));
    }

    @Test
    public void testeKeAbc95()
    {
        assertFalse(knacker.wortUntersuchen("KE ABC 95"));
    }

    @Test
    public void testeDegA2010()
    {
        assertTrue(knacker.wortUntersuchen("DEG A 2010"));
    }
}
