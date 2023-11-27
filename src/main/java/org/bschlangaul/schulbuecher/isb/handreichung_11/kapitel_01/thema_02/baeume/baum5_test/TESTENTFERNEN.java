package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_01.thema_02.baeume.baum5_test;

/**
 * The test class TESTENTFERNEN.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TESTENTFERNEN extends junit.framework.TestCase
{
    /**
     * Default constructor for test class TESTENTFERNEN
     */
    public TESTENTFERNEN()
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

    public void testEntfernen()
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
        System.out.println("Vor dem Entfernen");
        baum.InOrder();
        baum.Entfernen(new ZAHLDATEN(4));
        System.out.println("Nach dem Entfernen");
        baum.InOrder();
    }
}
