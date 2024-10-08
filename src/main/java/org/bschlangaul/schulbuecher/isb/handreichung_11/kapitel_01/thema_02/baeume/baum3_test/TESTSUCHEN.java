package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_01.thema_02.baeume.baum3_test;

/**
 * The test class TESTSUCHEN.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TESTSUCHEN extends junit.framework.TestCase
{
    /**
     * Default constructor for test class TESTSUCHEN
     */
    public TESTSUCHEN()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    protected void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    protected void tearDown()
    {
    }

    public void testTestSuchen()
    {
        BAUM baum = new BAUM();
        baum.Einfuegen(new ZAHLDATEN(18));
        baum.Einfuegen(new ZAHLDATEN(7));
        baum.Einfuegen(new ZAHLDATEN(28));
        baum.Einfuegen(new ZAHLDATEN(4));
        baum.Einfuegen(new ZAHLDATEN(12));
        baum.Einfuegen(new ZAHLDATEN(23));
        baum.Einfuegen(new ZAHLDATEN(33));
        baum.Einfuegen(new ZAHLDATEN(1));
        baum.Einfuegen(new ZAHLDATEN(5));
        baum.Einfuegen(new ZAHLDATEN(10));
        baum.Einfuegen(new ZAHLDATEN(16));
        baum.Einfuegen(new ZAHLDATEN(21));
        baum.Einfuegen(new ZAHLDATEN(24));
        baum.Einfuegen(new ZAHLDATEN(31));
        baum.Einfuegen(new ZAHLDATEN(36));
        assertNotNull(baum.Suchen(new ZAHLDATEN(12)));
        assertNull(baum.Suchen(new ZAHLDATEN(32)));
    }
}
