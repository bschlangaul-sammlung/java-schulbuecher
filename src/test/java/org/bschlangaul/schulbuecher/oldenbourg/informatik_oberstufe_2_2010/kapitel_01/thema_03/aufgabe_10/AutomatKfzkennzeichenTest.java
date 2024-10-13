package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_01.thema_03.aufgabe_10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Die Test-Klasse zum Überprüfen des Automaten für gültige E-Mail-Adressen.
 *
 * @author (Peter Brichzin)
 *
 * @version (10.9.2009)
 */
public class AutomatKfzkennzeichenTest
{
    @Test
    public void testenPositivBB_BBZZZZ()
    {
        AutomatKfzkennzeichen a = new AutomatKfzkennzeichen();
        assertEquals(true, a.IstEingabeAkzeptiert("AN-NA1998"));
    }

    @Test
    public void testenPositivBBB_BZZ()
    {
        AutomatKfzkennzeichen a = new AutomatKfzkennzeichen();
        assertEquals(true, a.IstEingabeAkzeptiert("LAU-T99"));
    }

    @Test
    public void testenPositivB_BZ()
    {
        AutomatKfzkennzeichen a = new AutomatKfzkennzeichen();
        assertEquals(true, a.IstEingabeAkzeptiert("M-M1"));
    }

    @Test
    public void testenPositivB_BBZZZ()
    {
        AutomatKfzkennzeichen a = new AutomatKfzkennzeichen();
        assertEquals(true, a.IstEingabeAkzeptiert("N-NN40"));
    }

    @Test
    public void testenVierBuchstabenAmAnfang()
    {
        AutomatKfzkennzeichen a = new AutomatKfzkennzeichen();
        assertEquals(false, a.IstEingabeAkzeptiert("INFO-S40"));
    }

    @Test
    public void testenZahlBuchstabenAmAnfang()
    {
        AutomatKfzkennzeichen a = new AutomatKfzkennzeichen();
        assertEquals(false, a.IstEingabeAkzeptiert("I2-NFO56"));
    }

    @Test
    public void testenDreiBuchstabenInMitte()
    {
        AutomatKfzkennzeichen a = new AutomatKfzkennzeichen();
        assertEquals(false, a.IstEingabeAkzeptiert("ZZ-ZERO100"));
    }

    @Test
    public void testenZahlBeginntMitNull()
    {
        AutomatKfzkennzeichen a = new AutomatKfzkennzeichen();
        assertEquals(false, a.IstEingabeAkzeptiert("JB-A007"));
    }

    @Test
    public void testenZahlMehrAls4Stellen()
    {
        AutomatKfzkennzeichen a = new AutomatKfzkennzeichen();
        assertEquals(false, a.IstEingabeAkzeptiert("AA-B12345"));
    }
}
