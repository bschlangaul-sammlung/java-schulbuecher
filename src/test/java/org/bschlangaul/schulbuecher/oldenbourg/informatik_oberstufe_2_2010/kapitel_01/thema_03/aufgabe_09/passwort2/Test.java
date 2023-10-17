package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_01.thema_03.aufgabe_09.passwort2;

/**
 * Die Test-Klasse zum Überprüfen des Automaten für gültige E-Mail-Adressen.
 *
 * @author (Peter Brichzin)
 * @version (10.9.2009)
 */
public class Test extends junit.framework.TestCase
{

    public void testenPositivBBBS()
    {
        AutomatPasswort2 a = new AutomatPasswort2();
        assertEquals(true, a.IstEingabeAkzeptiert("max$"));
    }

    public void testenPositivBBSS()
    {
        AutomatPasswort2 a = new AutomatPasswort2();
        assertEquals(true, a.IstEingabeAkzeptiert("ma:)"));
    }

    public void testenPositivBSSS()
    {
        AutomatPasswort2 a = new AutomatPasswort2();
        assertEquals(true, a.IstEingabeAkzeptiert("m:%§"));
    }

    public void testenPositivSBBB()
    {
        AutomatPasswort2 a = new AutomatPasswort2();
        assertEquals(true, a.IstEingabeAkzeptiert("%lea"));
    }

    public void testenPositivSSBB()
    {
        AutomatPasswort2 a = new AutomatPasswort2();
        assertEquals(true, a.IstEingabeAkzeptiert("):ha"));
    }

    public void testenPositivSSSB()
    {
        AutomatPasswort2 a = new AutomatPasswort2();
        assertEquals(true, a.IstEingabeAkzeptiert("§$%z"));
    }

    public void testenPositivBBBBBSSSSS()
    {
        AutomatPasswort2 a = new AutomatPasswort2();
        assertEquals(true, a.IstEingabeAkzeptiert("asdfg:)$%§"));
    }

    public void testenPositivSBSBSBSBSBSBSBS()
    {
        AutomatPasswort2 a = new AutomatPasswort2();
        assertEquals(true, a.IstEingabeAkzeptiert("a§b$c%d:e)"));
    }

    public void testenKeinS()
    {
        AutomatPasswort2 a = new AutomatPasswort2();
        assertEquals(false, a.IstEingabeAkzeptiert("keinbuchstabe"));
    }

    public void testenkeinB()
    {
        AutomatPasswort2 a = new AutomatPasswort2();
        assertEquals(false, a.IstEingabeAkzeptiert("::::::::::::"));
    }

    public void testenAnzahlKleiner4()
    {
        AutomatPasswort2 a = new AutomatPasswort2();
        assertEquals(false, a.IstEingabeAkzeptiert("§w§"));
    }

    public void testenAnderesZeichen()
    {
        AutomatPasswort2 a = new AutomatPasswort2();
        assertEquals(false, a.IstEingabeAkzeptiert("keine5isterlaubt"));
    }

}
