package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.adressverwaltung;

/**
 * Beschreibt eine Person mit ihrer Adresse.
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
import java.text.*;

class PERSON implements DATENELEMENT
{
    private int personennummer;

    private String name;

    private String vorname;

    private int adressnummer;

    private String strasse;

    private String hausnummer;

    private String plz;

    private String ort;

    static private Collator collator = Collator.getInstance();

    /**
     * Legt die Daten der Person an.
     *
     * @param personennummer Schlüssel der Person
     * @param name Name der Person
     * @param vorname Vorname der Person
     * @param adressnummer Schlüssel der Adresse
     * @param strasse Straße
     * @param hausnummer Hausnummer
     * @param plz Postleitzahl
     * @param ort Wohnort
     */
    PERSON(int personennummer, String name, String vorname, int adressnummer,
            String strasse, String hausnummer, String plz, String ort)
    {
        this.personennummer = personennummer;
        this.name = name;
        this.vorname = vorname;
        this.adressnummer = adressnummer;
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.plz = plz;
        this.ort = ort;
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
        return ((name == ((PERSON) test).name)
                && (vorname == ((PERSON) test).vorname));
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
        PERSON p = (PERSON) test;
        if ((collator.compare(name, p.name) < 0)
                || (collator.compare(name, p.name) == 0)
                        && (collator.compare(vorname, p.vorname) < 0))
        {
            return -1;
        }
        else if ((collator.compare(name, p.name) == 0)
                && (collator.compare(vorname, p.vorname) == 0))
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }

    /**
     * ändert die Personennummer der Person
     *
     * @param personennummer Schlüssel der Person
     */
    void PersonenNummerSetzen(int personennummer)
    {
        this.personennummer = personennummer;
    }

    /**
     * ändert die Adressdaten der Person
     *
     * @param name Name der Person
     * @param vorname Vorname der Person
     */
    void PersonendatenSetzen(String name, String vorname)
    {
        this.name = name;
        this.vorname = vorname;
    }

    /**
     * ändert die Adressdaten der Person
     *
     * @param adressnummer Schlüssel der Adresse
     * @param strasse Straße
     * @param hausnummer Hausnummer
     * @param plz Postleitzahl
     * @param ort Wohnort
     */
    void AdresseSetzen(int adressnummer, String strasse, String hausnummer,
            String plz, String ort)
    {
        this.adressnummer = adressnummer;
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.plz = plz;
        this.ort = ort;
    }

    /**
     * ändert die Adressnummer der Person
     *
     * @param adressnummer Schlüssel der Adresse
     */
    void AdressNummerSetzen(int adressnummer)
    {
        this.adressnummer = adressnummer;
    }

    /**
     * Meldet den Schlüssel der Person
     *
     * @return Nummer
     */
    int NummerGeben()
    {
        return personennummer;
    }

    /**
     * Meldet den Schlüssel der Adresse
     *
     * @return Adressnummer
     */
    int AdressNummerGeben()
    {
        return adressnummer;
    }

    /**
     * Meldet den Namen der Person
     *
     * @return Name
     */
    String NameGeben()
    {
        return name;
    }

    /**
     * Meldet den Vornamen der Person
     *
     * @return Vorname
     */
    String VornameGeben()
    {
        return vorname;
    }

    /**
     * Meldet die Straße
     *
     * @return Straße
     */
    String StrasseGeben()
    {
        return strasse;
    }

    /**
     * Meldet die Hausnummer
     *
     * @return Hausnummer
     */
    String HausnummerGeben()
    {
        return hausnummer;
    }

    /**
     * Meldet die Postleitzahl
     *
     * @return Postleitzahl
     */
    String PlzGeben()
    {
        return plz;
    }

    /**
     * Meldet den Ort
     *
     * @return Ort
     */
    String OrtGeben()
    {
        return ort;
    }

    /**
     * Erzeugt eine brauchbare Stringrepräsentation der Person
     *
     * @return Darstellungsstring
     */
    public String toString()
    {
        return name + " " + vorname + ", " + ort;
    }
}
