package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.bank;

/**
 * Enthält dei Daten für eine Zeile eines Kontoauszugs.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class AUSZUGSEINTRAG
{
    int nummer;

    String datum;

    double betrag;

    String beschreibung;

    /**
     * Besetzt die Attribute.
     */
    AUSZUGSEINTRAG(int nummer, String datum, String beschreibung, double betrag)
    {
        this.nummer = nummer;
        this.datum = datum;
        this.betrag = betrag;
        this.beschreibung = beschreibung;
    }

    /**
     * Meldet die Auszugnummer
     *
     * @return laufende Nummer des Auszugs
     */
    int AuszugsnummerGeben()
    {
        return nummer;
    }

    /**
     * Meldet das Datum des Eintrags
     *
     * @return Datum des Auszugs
     */
    String DatumGeben()
    {
        return datum;
    }

    /**
     * Meldet die Beschreibung des Eintrags
     *
     * @return Beschreibung des Auszugs
     */
    String BeschreibungGeben()
    {
        return beschreibung;
    }

    /**
     * Meldet den Betrag
     *
     * @return Betrag des Auszugs
     */
    double BetragGeben()
    {
        return betrag;
    }
}
