package schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_01.thema_03.aufgabe_09.passwort2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Die Test-Klasse zum Überprüfen des Automaten für gültige E-Mail-Adressen.
 *
 * @author (Peter Brichzin)
 *
 * @version (10.9.2009)
 */
public class AutomatPasswort2Test
{
    @Test
    public void testenPositivBBBS()
    {
        AutomatPasswort2 a = new AutomatPasswort2();
        assertEquals(true, a.IstEingabeAkzeptiert("max$"));
    }

    @Test
    public void testenPositivBBSS()
    {
        AutomatPasswort2 a = new AutomatPasswort2();
        assertEquals(true, a.IstEingabeAkzeptiert("ma:)"));
    }

    @Test
    public void testenPositivBSSS()
    {
        AutomatPasswort2 a = new AutomatPasswort2();
        assertEquals(true, a.IstEingabeAkzeptiert("m:%§"));
    }

    @Test
    public void testenPositivSBBB()
    {
        AutomatPasswort2 a = new AutomatPasswort2();
        assertEquals(true, a.IstEingabeAkzeptiert("%lea"));
    }

    @Test
    public void testenPositivSSBB()
    {
        AutomatPasswort2 a = new AutomatPasswort2();
        assertEquals(true, a.IstEingabeAkzeptiert("):ha"));
    }

    @Test
    public void testenPositivSSSB()
    {
        AutomatPasswort2 a = new AutomatPasswort2();
        assertEquals(true, a.IstEingabeAkzeptiert("§$%z"));
    }

    @Test
    public void testenPositivBBBBBSSSSS()
    {
        AutomatPasswort2 a = new AutomatPasswort2();
        assertEquals(true, a.IstEingabeAkzeptiert("asdfg:)$%§"));
    }

    @Test
    public void testenPositivSBSBSBSBSBSBSBS()
    {
        AutomatPasswort2 a = new AutomatPasswort2();
        assertEquals(true, a.IstEingabeAkzeptiert("a§b$c%d:e)"));
    }

    @Test
    public void testenKeinS()
    {
        AutomatPasswort2 a = new AutomatPasswort2();
        assertEquals(false, a.IstEingabeAkzeptiert("keinbuchstabe"));
    }

    @Test
    public void testenkeinB()
    {
        AutomatPasswort2 a = new AutomatPasswort2();
        assertEquals(false, a.IstEingabeAkzeptiert("::::::::::::"));
    }

    @Test
    public void testenAnzahlKleiner4()
    {
        AutomatPasswort2 a = new AutomatPasswort2();
        assertEquals(false, a.IstEingabeAkzeptiert("§w§"));
    }

    @Test
    public void testenAnderesZeichen()
    {
        AutomatPasswort2 a = new AutomatPasswort2();
        assertEquals(false, a.IstEingabeAkzeptiert("keine5isterlaubt"));
    }
}
