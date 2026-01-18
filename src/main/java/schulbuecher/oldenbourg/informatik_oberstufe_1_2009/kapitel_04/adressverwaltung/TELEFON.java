package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.adressverwaltung;

/**
 * Beschreibt eine Telefonnummer.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class TELEFON implements DATENELEMENT
{
    private int personennummer;

    private int lfnr;

    private String nummer;

    private String notiz;

    private String art;

    /**
     * Legt die Daten der Person an.
     *
     * @param personennummer Schlüssel der Person
     * @param lfnr laufende Nummer innerhalb der Person
     * @param nummer Telefonnummer
     * @param notiz Notiz
     * @param art Art der Nummer
     */
    TELEFON(int personennummer, int lfnr, String nummer, String notiz,
            String art)
    {
        this.personennummer = personennummer;
        this.lfnr = lfnr;
        this.nummer = nummer;
        this.notiz = notiz;
        this.art = art;
    }

    /**
     * Vergleicht das Datemelement mit dem Parameter.
     *
     * @param test Datenelement mit dem Testschlüssel
     *
     * @return true, wenn die Schlüssel übereinstimmen
     */
    public boolean IstGleich(DATENELEMENT test)
    {
        return ((personennummer == ((TELEFON) test).personennummer)
                && (lfnr == ((TELEFON) test).lfnr));
    }

    /**
     * Vergleicht das Datemelement mit dem Parameter. <br>
     * Hat das Datenelement einen kleineren Schlüssel als test, ist das Ergebnis
     * -1. <br>
     * Hat das Datenelement den gleichen Schlüssel wie test, ist das Ergebnis 0.
     * <br>
     * Hat das Datenelement einen größeren Schlüssel als test, ist das Ergebnis
     * 1.
     *
     * @param test Datenelement mit dem Testschlüssel
     *
     * @return Vergleichsergebnis
     */
    public int Vergleichen(DATENELEMENT test)
    {
        TELEFON t = (TELEFON) test;
        if ((personennummer < t.personennummer)
                || (personennummer == t.personennummer) && (lfnr < t.lfnr))
        {
            return -1;
        }
        else if ((personennummer == t.personennummer) && (lfnr == t.lfnr))
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }

    /**
     * Setzt die laufende Nummer des Eintrags.
     *
     * @param lfnr laufende Nummer
     */
    void LaufendeNummerSetzen(int lfnr)
    {
        this.lfnr = lfnr;
    }

    /**
     * ändert die Daten des Telefoneintrags.
     *
     * @param nummer die Telefonnummer
     * @param art die Art des Anschlusses
     * @param notiz Bemerkung zum Anschluss
     */
    void DatenSetzen(String nummer, String art, String notiz)
    {
        this.nummer = nummer;
        this.art = art;
        this.notiz = notiz;
    }

    /**
     * Meldet die Personennummer des Besitzers
     *
     * @return Personennummer
     */
    int PersonenNummerGeben()
    {
        return personennummer;
    }

    /**
     * Meldet die laufende Nummer des Eintrags.
     *
     * @return laufende Nummer
     */
    int LaufendeNummerGeben()
    {
        return lfnr;
    }

    /**
     * Meldet die Nummer
     *
     * @return Telefonnummer
     */
    String NummerGeben()
    {
        return nummer;
    }

    /**
     * Meldet die Notiz
     *
     * @return Notiz
     */
    String NotizGeben()
    {
        return notiz;
    }

    /**
     * Meldet die Art der Nummer
     *
     * @return Art der Telefonnummer
     */
    String ArtGeben()
    {
        return art;
    }

    /**
     * Erzeugt eine brauchbare Stringrepräsentation der Person
     *
     * @return Darstellungsstring
     */
    public String toString()
    {
        return nummer + " (" + art + "),  " + notiz;
    }
}
