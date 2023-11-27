package org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_01.autokennzeichen;

public class Testablauf extends junit.framework.TestCase
{
    Autokennzeichen knacker = new Autokennzeichen();

    public void testeOaFj123()
    {
        assertTrue(knacker.wortUntersuchen("OA FJ 123"));
    }

    public void testeKeAbc95()
    {
        assertFalse(knacker.wortUntersuchen("KE ABC 95"));
    }

    public void testeDegA2010()
    {
        assertTrue(knacker.wortUntersuchen("DEG A 2010"));
    }
}
