package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_01.thema_02.baeume.baum1;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class BaumTest
{
    private Knoten knoten4;

    private Knoten knoten12;

    private Knoten knoten23;

    private Knoten knoten33;

    private Knoten knoten7;

    private Knoten knoten28;

    private Knoten knoten18;

    private Baum baum;

    /**
     * Sets up the test fixture.
     * <p>
     * Called before every test case method.
     */
    protected void setUp()
    {
        knoten4 = new Knoten(new ZahlDaten(4));
        knoten12 = new Knoten(new ZahlDaten(12));
        knoten23 = new Knoten(new ZahlDaten(23));
        knoten33 = new Knoten(new ZahlDaten(33));
        knoten7 = new Knoten(new ZahlDaten(7), knoten4, knoten12);
        knoten28 = new Knoten(new ZahlDaten(28), knoten23, knoten33);
        knoten18 = new Knoten(new ZahlDaten(18), knoten7, knoten28);
        baum = new Baum(knoten18);
        baum.Suchen(new ZahlDaten(12));
        baum.Suchen(new ZahlDaten(29));
    }

    @Disabled
    @Test
    public void testTestSuchen()
    {
        assertNotNull(baum.Suchen(new ZahlDaten(12)));
        assertNull(baum.Suchen(new ZahlDaten(32)));
    }
}
