package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_01.thema_03.aufgabe_09.passwort;

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
        AutomatPasswort a = new AutomatPasswort();
        assertEquals(true, a.IstEingabeAkzeptiert("BBBS"));
    }

    public void testenPositivBBSS()
    {
        AutomatPasswort a = new AutomatPasswort();
        assertEquals(true, a.IstEingabeAkzeptiert("BBSS"));
    }

    public void testenPositivBSSS()
    {
        AutomatPasswort a = new AutomatPasswort();
        assertEquals(true, a.IstEingabeAkzeptiert("BSSS"));
    }

    public void testenPositivSBBBB()
    {
        AutomatPasswort a = new AutomatPasswort();
        assertEquals(true, a.IstEingabeAkzeptiert("SBBB"));
    }

    public void testenPositivSSBB()
    {
        AutomatPasswort a = new AutomatPasswort();
        assertEquals(true, a.IstEingabeAkzeptiert("SSBB"));
    }

    public void testenPositivSSSB()
    {
        AutomatPasswort a = new AutomatPasswort();
        assertEquals(true, a.IstEingabeAkzeptiert("SSSB"));
    }

    public void testenPositivBBBBBSSSSS()
    {
        AutomatPasswort a = new AutomatPasswort();
        assertEquals(true, a.IstEingabeAkzeptiert("BBBBBSSSSS"));
    }

    public void testenPositivSBSBSBSBSBSBSBS()
    {
        AutomatPasswort a = new AutomatPasswort();
        assertEquals(true, a.IstEingabeAkzeptiert("SBSBSBSBSBSBSBS"));
    }

    public void testenKeinS()
    {
        AutomatPasswort a = new AutomatPasswort();
        assertEquals(false, a.IstEingabeAkzeptiert("BBBBBB"));
    }

    public void testenkeinB()
    {
        AutomatPasswort a = new AutomatPasswort();
        assertEquals(false, a.IstEingabeAkzeptiert("SSSSS"));
    }

    public void testenAnzahlKleiner4()
    {
        AutomatPasswort a = new AutomatPasswort();
        assertEquals(false, a.IstEingabeAkzeptiert("SBS"));
    }

    public void testenAnderesZeichen()
    {
        AutomatPasswort a = new AutomatPasswort();
        assertEquals(false, a.IstEingabeAkzeptiert("SBSBSZSB"));
    }
}
