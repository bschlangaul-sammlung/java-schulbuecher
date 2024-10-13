package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.bank;

/**
 * Beschreibt Girokonten.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class GIROKONTO extends KONTO
{
    double ueberziehungsrahmen;

    /**
     * Belegt die Attribute vor.
     *
     * @param nummer die Nummer des neuen Kontos
     * @param ueberziehung gewährter Dispokredit
     * @param bes Besitzer des Kontos
     * @param ver Verbindungsobjekt zur Datenbank
     */
    GIROKONTO(int nummer, double ueberziehung, KUNDE bes,
            DATENBANKVERBINDUNG ver)
    {
        super(nummer, bes, ver);
        ueberziehungsrahmen = ueberziehung;
    }

    /**
     * Besetzt die Attribute
     *
     * @param nummer die Nummer des neuen Kontos
     * @param stand der aktuelle Kontostand
     * @param ueberziehung gewährter Dispokredit
     * @param bes Besitzer des Kontos
     * @param ver Verbindungsobjekt zur Datenbank
     */
    GIROKONTO(int nummer, double stand, double ueberziehung, KUNDE bes,
            DATENBANKVERBINDUNG ver)
    {
        super(nummer, stand, bes, ver);
        ueberziehungsrahmen = ueberziehung;
    }

    /**
     * Meldet den überziehungsrahmen
     *
     * @return überziehungsrahmen des Kontos
     */
    double UeberziehungsrahmenGeben()
    {
        return ueberziehungsrahmen;
    }

    /**
     * Abheben vom Konto. Voraussetzung: betrag größer 0. Die änderung wird auch
     * persistent in der Datenbank ausgeführt. Es wird geprüft, dass der Betrag
     * den Kreditrahmen nicht übersteigt.
     *
     * @param betrag abzuhebender Betrag
     *
     * @return true, wenn die Aktion ausgeführt werden konnte.
     */
    boolean Abheben(double betrag)
    {
        if (betrag <= kontostand + ueberziehungsrahmen)
        {
            return super.Abheben(betrag);
        }
        else
        {
            return false;
        }
    }
}
