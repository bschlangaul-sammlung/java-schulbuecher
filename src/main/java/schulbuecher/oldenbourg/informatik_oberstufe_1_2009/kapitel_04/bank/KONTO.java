package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.bank;

/**
 * Oberklasse aller Kontoarten
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
abstract class KONTO
{
    protected double kontostand;

    protected int kontonummer;

    private KUNDE besitzer;

    protected DATENBANKVERBINDUNG verbindung;

    /**
     * Besetzt die Attribute
     *
     * @param nummer die Nummer des neuen Kontos
     * @param bes Besitzer des Kontos
     * @param ver Verbindungsobjekt zur Datenbank
     */
    KONTO(int nummer, KUNDE bes, DATENBANKVERBINDUNG ver)
    {
        this(nummer, 0.0, bes, ver);
    }

    /**
     * Besetzt die Attribute
     *
     * @param nummer die Nummer des neuen Kontos
     * @param stand der aktuelle Kontostand
     * @param bes Besitzer des Kontos
     * @param ver Verbindungsobjekt zur Datenbank
     *
     */
    KONTO(int nummer, double stand, KUNDE bes, DATENBANKVERBINDUNG ver)
    {
        kontostand = stand;
        kontonummer = nummer;
        besitzer = bes;
        verbindung = ver;
    }

    /**
     * Meldet die Kontonummer
     *
     * @return Nummer des Kontos
     */
    int KontonummerGeben()
    {
        return kontonummer;
    }

    /**
     * Meldet den Kontostand
     *
     * @return Stand des Kontos
     */
    double KontostandGeben()
    {
        return kontostand;
    }

    /**
     * Meldet den Eigentuemer
     *
     * @return Eigentümer des Kontos
     */
    KUNDE EigentuemerGeben()
    {
        return besitzer;
    }

    /**
     * Einzahlen auf das Konto. Voraussetzung: betrag größer 0.
     *
     * @param betrag einzuzahlender Betrag
     */
    void Einzahlen(double betrag)
    {
        kontostand = kontostand + betrag;
        verbindung.KontostandSetzen(this, betrag, "Einzahlung");
    }

    /**
     * Abheben vom Konto. Voraussetzung: betrag größer 0. Die änderung wird auch
     * persistent in der Datenbank ausgeführt.
     *
     * @param betrag abzuhebender Betrag
     *
     * @return true, wenn die Aktion ausgeführt werden konnte.
     */
    boolean Abheben(double betrag)
    {
        kontostand = kontostand - betrag;
        verbindung.KontostandSetzen(this, -betrag, "Auszahlung");
        return true;
    }

    /**
     * Generiert die Daten für die Erstellung des Kontoauszugs.
     *
     * @return Referenz auf das Ergebnisfeld oder null
     */
    AUSZUGSEINTRAG[] AuszugsdatenErstellen()
    {
        return verbindung.AuszugsdatenErstellen(this);
    }
}
