package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_09.aufgabe_07.adressbuch;

/**
 * Die Klasse ADRESSBUCHEINTRAG dient zur Speicherung von Adressbucheinträgen
 *
 * @author (Peter Brichzin)
 *
 * @version (1.8.08)
 */
public class AdressbuchEintrag implements DatenElement
{
    /**
     * Name der Person, bewusst wird nicht unterschieden zwischen Nach- und
     * Vornamen, da vertraute Personen nur mit dem Vornamen, nicht vertraute mit
     * dem Nachnamen gespeichert werden Schlüssel dieses Datenelements
     */
    private String name;

    /**
     * Telefonnummer
     */
    private String telefonnummer;

    /**
     * E-Mail Adresse
     */
    private String eMail;

    /**
     * Strasse und Hausnummer
     */
    private String strasse;

    /**
     * Postleitzahl
     */
    private String plz;

    /**
     * Ort
     */
    private String ort;

    /**
     * Konstruktor für Objekte der Klasse ADRESSBUCHEINTRAG
     *
     * @param nameNeu der Name.
     * @param telefonnummerNeu Telefonnummer.
     */
    public AdressbuchEintrag(String nameNeu, String telefonnummerNeu)
    {
        name = nameNeu;
        telefonnummer = telefonnummerNeu;
        eMail = "";
        strasse = "";
        plz = "";
        ort = "";
    }

    /**
     * Konstruktor für Objekte der Klasse ADRESSBUCHEINTRAG
     *
     * @param nameNeu der Name.
     * @param telefonnummerNeu Telefonnummer.
     * @param eMailNeu E-Mail Adresse.
     */
    public AdressbuchEintrag(String nameNeu, String telefonnummerNeu,
            String eMailNeu)
    {
        name = nameNeu;
        telefonnummer = telefonnummerNeu;
        eMail = eMailNeu;
        strasse = "";
        plz = "";
        ort = "";
    }

    /**
     * Konstruktor für Objekte der Klasse ADRESSBUCHEINTRAG
     *
     * @param nameNeu der Name.
     * @param telefonnummerNeu Telefonnummer.
     * @param eMailNeu E-Mail Adresse.
     */
    public AdressbuchEintrag(String nameNeu, String telefonnummerNeu,
            String eMailNeu, String strasseNeu, String plzNeu, String ortNeu)
    {
        name = nameNeu;
        telefonnummer = telefonnummerNeu;
        eMail = eMailNeu;
        strasse = strasseNeu;
        plz = plzNeu;
        ort = ortNeu;
    }

    /**
     * Gibt Information über das Datenelement zu Kontrollzwecken auf das
     * Terminalfenster aus.
     */
    public void InformationAusgeben()
    {
        System.out.println(name + ": " + telefonnummer + "; " + eMail + "; "
                + strasse + "; " + plz + " " + ort);
    }

    /**
     * Vergleicht zwei Datenelemente bezüglich der Ordnungsrelation.
     *
     * @param dvergleich Datenelement mit dem das Objekt verglichen wird.
     *
     * @return true, wenn das aktuelle Element einen kleineren Schlüssel hat,
     *     als das angegebene Vergleichselement.
     */
    public boolean IstKleinerAls(DatenElement dvergleich)
    {
        // überprüfung, ob der Eingabewert vom Typ ADRESSBUCHEINTRAG (ABE) ist
        AdressbuchEintrag vergleichsABE;
        vergleichsABE = (AdressbuchEintrag) dvergleich;
        if (name.compareTo(vergleichsABE.NameGeben()) < 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Vergleicht zwei Datenelemente auf Gleichheit.
     *
     * @param dvergleich Datenelement mit dem das Objekt verglichen wird.
     *
     * @return true, wenn die beiden Datenelemente gleichen Schlüssel haben.
     */
    public boolean IstGleich(DatenElement dvergleich)
    {
        // überprüfung, ob der Eingabewert vom Typ ADRESSBUCHEINTRAG (ABE) ist
        AdressbuchEintrag vergleichsABE;
        vergleichsABE = (AdressbuchEintrag) dvergleich;
        // Vergleich der beiden Schlüssel und Rückgabe des Ergebnisses als
        // boolean
        return name == vergleichsABE.name;
    }

    /**
     * /** Vergleicht zwei Datenelemente bezüglich der Ordnungsrelation.
     *
     * @param dvergleich Datenelement mit dem das Objekt verglichen wird.
     *
     * @return true, wenn das aktuelle Element einen größeren Schlüssel hat, als
     *     das angegebene Vergleichselement.
     */
    public boolean IstGroesserAls(DatenElement dvergleich)
    {
        // überprüfung, ob der Eingabewert vom Typ ADRESSBUCHEINTRAG (WBE) ist
        AdressbuchEintrag vergleichsABE;
        vergleichsABE = (AdressbuchEintrag) dvergleich;
        // Um die Ordnungsrelation herzustellen, wird eine Referenz auf ein
        // auf ein Objekt der Javabibliothek Collator benötigt
        if (name.compareTo(vergleichsABE.NameGeben()) > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Vergleicht zwei Schlüssel, die als Zeichenketten vorliegen, auf
     * Gleichheit.
     *
     * @param vergleichsSchluessel Schlüssel mit dem der Schlüssel des Objekt
     *     verglichen wird.
     *
     * @return true, wenn die beiden Schlüssel gleich sind.
     */
    public boolean SchluesselIstGleich(String vergleichsSchluessel)
    {
        return (name == vergleichsSchluessel);
    }

    /**
     * Vergleicht zwei Schlüssel, die als Zeichenketten vorliegen, bezüglich der
     * Ordnungsrelation.
     *
     * @param vergleichsSchluessel Schlüssel mit dem der Schlüssel des Objekt
     *     verglichen wird.
     *
     * @return true, wenn das aktuelle Element einen größeren Schlüssel hat, als
     *     das angegebene Vergleichselement.
     */
    public boolean SchluesselIstGroesserAls(String vergleichsSchluessel)
    {
        if (name.compareTo(vergleichsSchluessel) > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Vergleicht zwei Schlüssel, die als Zeichenketten vorliegen, bezüglich der
     * Ordnungsrelation.
     *
     * @param vergleichsSchluessel Schlüssel mit dem der Schlüssel des Objekt
     *     verglichen wird.
     *
     * @return true, wenn das aktuelle Element einen kleineren Schlüssel hat,
     *     als das angegebene Vergleichselement.
     */
    public boolean SchluesselIstKleinerAls(String vergleichsSchluessel)
    {
        if (name.compareTo(vergleichsSchluessel) < 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Gibt den Schlüssel des Datenelements zu Kontrollzwecken als String aus,
     * auch wenn der Datentyp vom String abweicht.
     *
     * @return Schlüssel als String.
     */
    public String SchluesselAlsStringGeben()
    {
        return name;
    }

    /**
     * Geben-Methode zum Attribut wort
     *
     * @return den Namen
     */
    public String NameGeben()
    {
        return name;
    }

    /**
     * Setzen-Methode zum Attribut bedeutung
     */
    public void EintragSetzen(String telefonnummerNeu, String eMailNeu,
            String strasseNeu, String plzNeu, String ortNeu)
    {
        telefonnummer = telefonnummerNeu;
        eMail = eMailNeu;
        strasse = strasseNeu;
        plz = plzNeu;
        ort = ortNeu;
    }
}
