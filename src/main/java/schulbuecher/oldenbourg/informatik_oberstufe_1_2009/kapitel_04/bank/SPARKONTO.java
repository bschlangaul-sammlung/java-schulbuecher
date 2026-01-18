package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.bank;

/**
 * Beschreibt Sparkonten.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class SPARKONTO extends KONTO
{
    double zinssatz;

    /**
     * Belegt die Attribute vor.
     *
     * @param nummer die Nummer des neuen Kontos
     * @param zins Zinssatz
     * @param bes Besitzer des Kontos
     * @param ver Verbindungsobjekt zur Datenbank
     */
    SPARKONTO(int nummer, double zins, KUNDE bes, DATENBANKVERBINDUNG ver)
    {
        super(nummer, bes, ver);
        zinssatz = zins;
    }

    /**
     * Besetzt die Attribute
     *
     * @param nummer die Nummer des neuen Kontos
     * @param stand der aktuelle Kontostand
     * @param zins Zinssatz
     * @param bes Besitzer des Kontos
     * @param ver Verbindungsobjekt zur Datenbank
     */
    SPARKONTO(int nummer, double stand, double zins, KUNDE bes,
            DATENBANKVERBINDUNG ver)
    {
        super(nummer, stand, bes, ver);
        zinssatz = zins;
    }

    /**
     * Meldet den Zinssatz
     *
     * @return nummer des Kontos
     */
    double ZinssatzGeben()
    {
        return zinssatz;
    }

    /**
     * Abheben vom Konto. Voraussetzung: betrag größer 0. Die änderung wird auch
     * persistent in der Datenbank ausgeführt. Es wird geprüft, dass der Betrag
     * den Kontostand nicht übersteigt.
     *
     * @param betrag abzuhebender Betrag
     *
     * @return true, wenn die Aktion ausgeführt werden konnte.
     */
    boolean Abheben(double betrag)
    {
        if (betrag <= kontostand)
        {
            return super.Abheben(betrag);
        }
        else
        {
            return false;
        }
    }

    /**
     * Berechnet den Jahreszins und addiert ihn zum Kontostand.
     */
    void Verzinsen()
    {
        double betrag;
        betrag = kontostand * zinssatz / 100.0;
        kontostand = kontostand + betrag;
        verbindung.KontostandSetzen(this, betrag, "Jahreszins");
    }
}
