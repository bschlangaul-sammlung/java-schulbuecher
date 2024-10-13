package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.adressverwaltung;

/**
 * Beschreibt eine E-Mailadresse.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class EMAIL implements DATENELEMENT
{
    private int personennummer;

    private int lfnr;

    private String email;

    private String notiz;

    /**
     * Legt die Daten der E-Mail-Adresse an.
     *
     * @param personennummer Schlüssel der Person
     * @param lfnr laufende Nummer innerhalb der Person
     * @param email eigentliche Mailadresse
     * @param notiz Notiz
     */
    EMAIL(int personennummer, int lfnr, String email, String notiz)
    {
        this.personennummer = personennummer;
        this.lfnr = lfnr;
        this.email = email;
        this.notiz = notiz;
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
        return ((personennummer == ((EMAIL) test).personennummer)
                && (lfnr == ((EMAIL) test).lfnr));
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
        EMAIL t = (EMAIL) test;
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
     * @param email die Telefonnummer
     * @param notiz Bemerkung zum Anschluss
     */
    void DatenSetzen(String email, String notiz)
    {
        this.email = email;
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
     * Meldet die Adresse
     *
     * @return EMailadresse
     */
    String AdresseGeben()
    {
        return email;
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
     * Erzeugt eine brauchbare Stringrepräsentation der Person
     *
     * @return Darstellungsstring
     */
    public String toString()
    {
        return email + ",  " + notiz;
    }
}
