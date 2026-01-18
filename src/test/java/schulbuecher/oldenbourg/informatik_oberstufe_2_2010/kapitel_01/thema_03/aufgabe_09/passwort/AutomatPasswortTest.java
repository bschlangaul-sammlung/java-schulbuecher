package schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_01.thema_03.aufgabe_09.passwort;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Die Test-Klasse zum Überprüfen des Automaten für gültige E-Mail-Adressen.
 *
 * @author (Peter Brichzin)
 *
 * @version (10.9.2009)
 */
public class AutomatPasswortTest
{
    @Test
    public void testenPositivBBBS()
    {
        AutomatPasswort a = new AutomatPasswort();
        assertEquals(true, a.IstEingabeAkzeptiert("BBBS"));
    }

    @Test
    public void testenPositivBBSS()
    {
        AutomatPasswort a = new AutomatPasswort();
        assertEquals(true, a.IstEingabeAkzeptiert("BBSS"));
    }

    @Test

    public void testenPositivBSSS()
    {
        AutomatPasswort a = new AutomatPasswort();
        assertEquals(true, a.IstEingabeAkzeptiert("BSSS"));
    }

    @Test
    public void testenPositivSBBBB()
    {
        AutomatPasswort a = new AutomatPasswort();
        assertEquals(true, a.IstEingabeAkzeptiert("SBBB"));
    }

    @Test
    public void testenPositivSSBB()
    {
        AutomatPasswort a = new AutomatPasswort();
        assertEquals(true, a.IstEingabeAkzeptiert("SSBB"));
    }

    @Test
    public void testenPositivSSSB()
    {
        AutomatPasswort a = new AutomatPasswort();
        assertEquals(true, a.IstEingabeAkzeptiert("SSSB"));
    }

    @Test
    public void testenPositivBBBBBSSSSS()
    {
        AutomatPasswort a = new AutomatPasswort();
        assertEquals(true, a.IstEingabeAkzeptiert("BBBBBSSSSS"));
    }

    @Test
    public void testenPositivSBSBSBSBSBSBSBS()
    {
        AutomatPasswort a = new AutomatPasswort();
        assertEquals(true, a.IstEingabeAkzeptiert("SBSBSBSBSBSBSBS"));
    }

    @Test
    public void testenKeinS()
    {
        AutomatPasswort a = new AutomatPasswort();
        assertEquals(false, a.IstEingabeAkzeptiert("BBBBBB"));
    }

    @Test
    public void testenkeinB()
    {
        AutomatPasswort a = new AutomatPasswort();
        assertEquals(false, a.IstEingabeAkzeptiert("SSSSS"));
    }

    @Test
    public void testenAnzahlKleiner4()
    {
        AutomatPasswort a = new AutomatPasswort();
        assertEquals(false, a.IstEingabeAkzeptiert("SBS"));
    }

    @Test
    public void testenAnderesZeichen()
    {
        AutomatPasswort a = new AutomatPasswort();
        assertEquals(false, a.IstEingabeAkzeptiert("SBSBSZSB"));
    }
}
