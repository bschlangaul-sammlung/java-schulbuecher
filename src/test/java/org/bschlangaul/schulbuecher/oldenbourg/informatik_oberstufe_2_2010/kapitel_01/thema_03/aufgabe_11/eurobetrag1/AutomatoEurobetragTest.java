package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_01.thema_03.aufgabe_11.eurobetrag1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Die Test-Klasse zum Überprüfen des Automaten für gültige E-Mail-Adressen.
 *
 * @author (Peter Brichzin)
 *
 * @version (10.9.2009)
 */
public class AutomatoEurobetragTest
{
    @Test
    public void testenPositivNullEuro()
    {
        AutomatEurobetrag a = new AutomatEurobetrag();
        assertEquals(true, a.IstEingabeAkzeptiert("0\u20AC"));
    }

    @Test
    public void testenPositivEinstelligEuroOhneCent()
    {
        AutomatEurobetrag a = new AutomatEurobetrag();
        assertEquals(true, a.IstEingabeAkzeptiert("2\u20AC"));
    }

    @Test
    public void testenPositivMehrstelligEuroMitCent()
    {
        AutomatEurobetrag a = new AutomatEurobetrag();
        assertEquals(true, a.IstEingabeAkzeptiert("1234.34\u20AC"));
    }

    @Test
    public void testenBeginnNullEuroMehrstellig()
    {
        AutomatEurobetrag a = new AutomatEurobetrag();
        assertEquals(false, a.IstEingabeAkzeptiert("012\u20AC"));
    }

    @Test
    public void testenCentbetragEinstellig()
    {
        AutomatEurobetrag a = new AutomatEurobetrag();
        assertEquals(false, a.IstEingabeAkzeptiert("99.9\u20AC"));
    }

    @Test
    public void testenTrennzeichenKomma()
    {
        AutomatEurobetrag a = new AutomatEurobetrag();
        assertEquals(false, a.IstEingabeAkzeptiert("99,99\u20AC"));
    }

    @Test
    public void testenLeerzeichenVorEuro()
    {
        AutomatEurobetrag a = new AutomatEurobetrag();
        assertEquals(false, a.IstEingabeAkzeptiert("42 \u20AC"));
    }
}
