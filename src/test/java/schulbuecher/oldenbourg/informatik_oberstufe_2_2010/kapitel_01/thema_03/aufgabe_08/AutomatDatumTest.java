package schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_01.thema_03.aufgabe_08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Die Test-Klasse zum Überprüfen des Automaten für gültige E-Mail-Adressen.
 *
 * @author (Peter Brichzin)
 *
 * @version (10.9.2009)
 */
public class AutomatDatumTest
{
    @Test
    public void testenPositivTagEinstelligMonatEinstelligVor2000()
    {
        AutomatDatum a = new AutomatDatum();
        assertEquals(true, a.IstEingabeAkzeptiert("01.03.1900"));
    }

    @Test
    public void testenTagNull()
    {
        AutomatDatum a = new AutomatDatum();
        assertEquals(false, a.IstEingabeAkzeptiert("00.03.1900"));
    }

    @Test
    public void testenPositivTagNach10MonatZweistelligNach2000()
    {
        AutomatDatum a = new AutomatDatum();
        assertEquals(true, a.IstEingabeAkzeptiert("11.10.2001"));
    }

    @Test
    public void testenPositivTagNach20MonatZweistelligNach2000()
    {
        AutomatDatum a = new AutomatDatum();
        assertEquals(true, a.IstEingabeAkzeptiert("23.11.2001"));
    }

    @Test
    public void testenPositivTagNach30MonatZweistelligNach2000()
    {
        AutomatDatum a = new AutomatDatum();
        assertEquals(true, a.IstEingabeAkzeptiert("31.12.2099"));
    }

    @Test
    public void testenErsteZifferFalsch()
    {
        AutomatDatum a = new AutomatDatum();
        assertEquals(false, a.IstEingabeAkzeptiert("41.03.1900"));
    }

    @Test
    public void testenTagNach31()
    {
        AutomatDatum a = new AutomatDatum();
        assertEquals(false, a.IstEingabeAkzeptiert("32.03.1900"));
    }

    @Test
    public void testenMonatNach12()
    {
        AutomatDatum a = new AutomatDatum();
        assertEquals(false, a.IstEingabeAkzeptiert("12.13.1968"));
    }

    @Test
    public void testenJahrVor1900()
    {
        AutomatDatum a = new AutomatDatum();
        assertEquals(false, a.IstEingabeAkzeptiert("10.10.1899"));
    }

    @Test
    public void testenJahrNach2100()
    {
        AutomatDatum a = new AutomatDatum();
        assertEquals(false, a.IstEingabeAkzeptiert("12.06.2121"));
    }

    @Test
    public void testenDDMMYY()
    {
        AutomatDatum a = new AutomatDatum();
        assertEquals(false, a.IstEingabeAkzeptiert("08.09.10"));
    }

    @Test
    public void testenDMMYYYY()
    {
        AutomatDatum a = new AutomatDatum();
        assertEquals(false, a.IstEingabeAkzeptiert("1.11.1968"));
    }

    @Test
    public void testenDDMYYYY()
    {
        AutomatDatum a = new AutomatDatum();
        assertEquals(false, a.IstEingabeAkzeptiert("31.1.2001"));
    }
}
