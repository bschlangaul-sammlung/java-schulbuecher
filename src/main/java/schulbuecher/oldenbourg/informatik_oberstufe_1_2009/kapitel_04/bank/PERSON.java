package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.bank;

/**
 * Oberklasse für alle Personen.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
abstract class PERSON
{
    protected String name;

    protected int pin;

    /**
     * Belegt name und pin der Person
     *
     * @param n Name der neuen Person
     * @param p PIN der neuen Person
     */
    PERSON(String n, int p)
    {
        name = n;
        pin = p;
    }

    /**
     * Gibt die Pin des Kunden zurück
     *
     * @return PIN des Kunden
     */
    int PinGeben()
    {
        return pin;
    }

    /**
     * Gibt den Namen des Kunden zurück
     *
     * @return Name des Kunden
     */
    String NameGeben()
    {
        return name;
    }

    /**
     * Setzt eine neue PIN für den Kunden.
     *
     * @param nummer die neue PIN
     */
    void PinSetzen(int nummer)
    {
        pin = nummer;
        BANK.BankGeben().DatenbankverbindungGeben().PinSetzen(name, nummer);
    }
}
