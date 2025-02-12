package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_01.thema_02.baeume.baum4;

import org.junit.jupiter.api.Test;

public class BaumTest
{
    @Test
    public void testDurchlauf()
    {
        Baum baum = new Baum();
        baum.Einfuegen(new ZahlDaten(18));
        baum.Einfuegen(new ZahlDaten(7));
        baum.Einfuegen(new ZahlDaten(28));
        baum.Einfuegen(new ZahlDaten(4));
        baum.Einfuegen(new ZahlDaten(12));
        baum.Einfuegen(new ZahlDaten(23));
        baum.Einfuegen(new ZahlDaten(33));
        baum.Einfuegen(new ZahlDaten(1));
        baum.Einfuegen(new ZahlDaten(5));
        baum.Einfuegen(new ZahlDaten(10));
        baum.Einfuegen(new ZahlDaten(16));
        baum.Einfuegen(new ZahlDaten(21));
        baum.Einfuegen(new ZahlDaten(24));
        baum.Einfuegen(new ZahlDaten(31));
        baum.Einfuegen(new ZahlDaten(36));
        baum.InOrder();
        baum.PostOrder();
        baum.PreOrder();
    }
}
