package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_01.thema_02.baeume.baum1_test;


/**
 * The test class BAUMAUFBAU.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BAUMAUFBAU extends junit.framework.TestCase
{
    private KNOTEN knoten4;
    private KNOTEN knoten12;
    private KNOTEN knoten23;
    private KNOTEN knoten33;
    private KNOTEN knoten7;
    private KNOTEN knoten28;
    private KNOTEN knoten18;
    private BAUM baum;

    /**
     * Default constructor for test class BAUMAUFBAU
     */
    public BAUMAUFBAU()
    {}

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    protected void setUp()
    {
        knoten4 = new KNOTEN(new ZAHLDATEN(4));
        knoten12 = new KNOTEN(new ZAHLDATEN(12));
        knoten23 = new KNOTEN(new ZAHLDATEN(23));
        knoten33 = new KNOTEN(new ZAHLDATEN(33));
        knoten7 = new KNOTEN(new ZAHLDATEN(7), knoten4, knoten12);
        knoten28 = new KNOTEN(new ZAHLDATEN(28), knoten23, knoten33);
        knoten18 = new KNOTEN(new ZAHLDATEN(18), knoten7, knoten28);
        baum = new BAUM(knoten18);
        baum.Suchen(new ZAHLDATEN(12));
        baum.Suchen(new ZAHLDATEN(29));
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    protected void tearDown()
    {}


    public void testTestSuchen()
    {
        assertNotNull(baum.Suchen(new ZAHLDATEN(12)));
        assertNull(baum.Suchen(new ZAHLDATEN(32)));
    }
}
