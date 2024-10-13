package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_03.anwendungsorientierte_aufgaben.majority_algorithmus.wahl;

import org.junit.jupiter.api.Test;

public class WAHLTest
{

    @Test

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

    @Test

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

    @Test
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
