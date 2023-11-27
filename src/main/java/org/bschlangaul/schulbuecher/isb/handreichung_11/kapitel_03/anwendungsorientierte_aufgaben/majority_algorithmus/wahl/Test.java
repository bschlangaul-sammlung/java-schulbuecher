package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_03.anwendungsorientierte_aufgaben.majority_algorithmus.wahl;

/**
 * The test class Test.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test extends junit.framework.TestCase
{
    /**
     * Default constructor for test class Test
     */
    public Test()
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

    public void test_i()
    {
        WAHL wAHL1 = new WAHL();
        wAHL1.StimmeAbgeben("Peter");
        wAHL1.StimmeAbgeben("Peter");
        wAHL1.StimmeAbgeben("Anna");
        wAHL1.StimmeAbgeben("Anna");
        wAHL1.StimmeAbgeben("Lisa");
        wAHL1.StimmeAbgeben("Anna");
        wAHL1.StimmeAbgeben("Anna");
        wAHL1.WahlAuswerten();
    }

    public void test_ii()
    {
        WAHL wAHL1 = new WAHL();
        wAHL1.StimmeAbgeben("Peter");
        wAHL1.StimmeAbgeben("Peter");
        wAHL1.StimmeAbgeben("Anna");
        wAHL1.StimmeAbgeben("Karl");
        wAHL1.StimmeAbgeben("Lisa");
        wAHL1.StimmeAbgeben("Anna");
        wAHL1.StimmeAbgeben("Anna");
        wAHL1.WahlAuswerten();
    }

    public void test_iii()
    {
        WAHL wAHL1 = new WAHL();
        wAHL1.StimmeAbgeben("Peter");
        wAHL1.StimmeAbgeben("Peter");
        wAHL1.StimmeAbgeben("Anna");
        wAHL1.StimmeAbgeben("Lisa");
        wAHL1.StimmeAbgeben("Anna");
        wAHL1.StimmeAbgeben("Anna");
        wAHL1.WahlAuswerten();
    }
}
