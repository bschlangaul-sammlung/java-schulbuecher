package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_05.aufgabe_05.cheese_champions;

/**
 * Klasse zur Verwaltung einer Maus
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class MAUS implements DATENELEMENT
{
    /** nummer der Maus */
    private int nummer;

    /** Anzahl der Siege */
    private int siegeszahl;

    /** Anzahl der Niederlagen */
    private int niederlagenzahl;

    /**
     * Setzt die Attributwerte geeignet
     *
     * @param nummerNeu Nummer der Maus
     */
    MAUS(int nummerNeu)
    {
        nummer = nummerNeu;
        siegeszahl = 0;
        niederlagenzahl = 0;
    }

    /**
     * Erhöht die Siegeszahl um 1.
     */
    void SiegeszahlErhoehen()
    {
        siegeszahl = siegeszahl + 1;
    }

    /**
     * Erhöht die Niederlagenzahl um 1.
     */
    void NiederlagenzahlErhoehen()
    {
        niederlagenzahl = niederlagenzahl + 1;
    }

    /**
     * Ausgabe von Information als String
     */
    public String InformationAusgeben()
    {
        return nummer + " | " + siegeszahl + " | " + niederlagenzahl;
    }

    /**
     * Vergleich zweier Datenelemente bezüglich einer Ordnungsrelation
     *
     * @param dvergleich Datenelement zum Vergleich
     */
    public boolean IstKleinerAls(DATENELEMENT dvergleich)
    {
        return (nummer < ((MAUS) dvergleich).nummer);
    }

    /**
     * Identifikation eines Datenelements aufgrund seines Schlüssels
     *
     * @param s Schlüssel vom Typ String
     */
    public boolean SchluesselIstGleich(String s)
    {
        return true;
    }
}
