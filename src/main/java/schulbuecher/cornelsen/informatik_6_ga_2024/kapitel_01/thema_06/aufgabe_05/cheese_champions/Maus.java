package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_06.aufgabe_05.cheese_champions;

/**
 * Klasse zur Verwaltung einer Maus
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Maus implements Datenelement
{
    /**
     * Nummer der Maus
     */
    private int nummer;

    /**
     * Anzahl der Siege
     */
    private int siegeszahl;

    /**
     * Anzahl der Niederlagen
     */
    private int niederlagenzahl;

    /**
     * Setzt die Attributwerte geeignet
     *
     * @param nummerNeu Nummer der Maus
     */
    Maus(int nummerNeu)
    {
        nummer = nummerNeu;
        siegeszahl = 0;
        niederlagenzahl = 0;
    }

    /**
     * Erhöht die Siegeszahl um 1.
     */
    void SiegeszahlErhöhen()
    {
        siegeszahl = siegeszahl + 1;
    }

    /**
     * Erhöht die Niederlagenzahl um 1.
     */
    void NiederlagenzahlErhöhen()
    {
        niederlagenzahl = niederlagenzahl + 1;
    }

    /**
     * Ausgabe von Information als String
     */
    public void InformationAusgeben()
    {
        System.out
                .println(nummer + " | " + siegeszahl + " | " + niederlagenzahl);
    }

    /**
     * Rückgabe von Information als String
     *
     * @return Information
     */
    public String InformationGeben()
    {
        return nummer + " | " + siegeszahl + " | " + niederlagenzahl;
    }

    /**
     * Vergleich zweier Datenelemente bezüglich einer Ordnungsrelation
     *
     * @param dvergleich Datenelement zum Vergleich
     *
     * @return wahr, wenn die Nummer der Maus kleiner ist als die des
     *     Vergleichselements
     */
    public boolean IstKleinerAls(Datenelement dvergleich)
    {
        return (nummer < ((Maus) dvergleich).nummer);
    }

    /**
     * Identifikation eines Datenelements aufgrund seines Schlüssels
     *
     * @param s Schlüssel vom Typ String
     *
     * @return immer wahr
     */
    public boolean SchlüsselIstGleich(String s)
    {
        return true;
    }
}
