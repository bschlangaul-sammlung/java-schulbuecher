package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_01.thema_03.aufgabe_07;

/**
 * Die Test-Klasse zum Überprüfen des Automaten für gültige E-Mail-Adressen.
 *
 * @author (Peter Brichzin)
 * @version (10.9.2009)
 */
public class Test extends junit.framework.TestCase
{

    public void testenZ8Endzustand()
    {
        AutomatEmail a = new AutomatEmail();
        assertEquals(true, a.IstEingabeAkzeptiert("jz@ssl.nl"));
    }

    public void testenZ9Endzustand()
    {
        AutomatEmail a = new AutomatEmail();
        assertEquals(true, a.IstEingabeAkzeptiert("jenni@ssl12-n.net"));
    }

    public void testenZ10Endzustand()
    {
        AutomatEmail a = new AutomatEmail();
        assertEquals(true, a.IstEingabeAkzeptiert("j.@ssl22.netz"));
    }

    public void testenTopLevelzulang()
    {
        AutomatEmail a = new AutomatEmail();
        assertEquals(false, a.IstEingabeAkzeptiert("j.@ssl22.netze"));
    }

    public void testenNurTopLevel()
    {
        AutomatEmail a = new AutomatEmail();
        assertEquals(false, a.IstEingabeAkzeptiert("jenni@net"));
    }

    public void testenThirdLevel()
    {
        AutomatEmail a = new AutomatEmail();
        assertEquals(false, a.IstEingabeAkzeptiert("jz@ssl.netz.sz"));
    }

    public void testenBindestrichfalsch()
    {
        AutomatEmail a = new AutomatEmail();
        assertEquals(false, a.IstEingabeAkzeptiert("jenni@ssl-.net"));
    }

    public void testenZahlInTopLevel()
    {
        AutomatEmail a = new AutomatEmail();
        assertEquals(false, a.IstEingabeAkzeptiert("jenni@ssl.net2"));
    }

    public void testenUnerlaubtesZeichen()
    {
        AutomatEmail a = new AutomatEmail();
        assertEquals(false, a.IstEingabeAkzeptiert("jenni$st@ssl.net"));
    }

}
