package schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_04.thema_13.aufgabe_04;

/**
 * Klasse zur Verwaltung der Datenelemente
 *
 * @author Reinold
 *
 * @version 1.0
 */
public class DatenElement
{
    /**
     * Schlüssel
     */
    private int schluessel;

    /**
     * Konstruktor eines neuen Datenelements
     *
     * @param i künftiger Schlüssel
     */
    DatenElement(int i)
    {
        schluessel = i;
    }

    /**
     * Gibt aus, ob der übergebene Wert gleich dem Wert des Schlüssels ist.
     *
     * @param i gesuchter Schlüssel
     *
     * @return gesuchter Wahrheitswert
     */
    boolean SchluesselIstGleich(int i)
    {
        Zaehler.ZaehlerInkrementieren();
        return (schluessel == i);
    }

    /**
     * Gibt aus, ob der Wert des Schlüssels größer als der übergebene Wert ist.
     *
     * @param i übergebener Wert
     *
     * @return gesuchter Wahrheitswert
     */
    boolean SchluesselIstGroesser(int i)
    {
        Zaehler.ZaehlerInkrementieren();
        return (schluessel > i);
    }

    /**
     * Gibt den Schlüssel des Datenelements aus.
     *
     * @return Schlüssel
     */
    int SchluesselGeben()
    {
        return schluessel;
    }
}
