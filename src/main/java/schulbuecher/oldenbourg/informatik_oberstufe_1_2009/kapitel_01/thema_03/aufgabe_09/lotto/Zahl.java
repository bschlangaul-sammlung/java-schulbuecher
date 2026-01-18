package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_09.lotto;

/**
 * Klasse zur Verwaltung einer Lottozahl
 *
 * @author Klaus van Djikstran
 *
 * @version 1.0
 */
class Zahl implements DatenElement
{
    /**
     * Zu verwaltender Wert
     */
    private int z;

    /**
     * Konstruktor
     */
    Zahl(int zahlNeu)
    {
        z = zahlNeu;
    }

    /**
     * Ausgabe der Zahl auf der Konsole
     */
    public void InformationAusgeben()
    {
        System.out.println(z);
    }

    /**
     * Vergleich zweier Zahlen
     *
     * @param dvergleich Vergleichs-Datenelement
     *
     * @return Wahrheitswert
     */
    public boolean IstKleinerAls(DatenElement dvergleich)
    {
        Zahl zahl;
        zahl = (Zahl) dvergleich;
        if (z < zahl.ZahlGeben())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Ausgabe der verwalteten Zahl
     *
     * @return Zahl
     */
    private int ZahlGeben()
    {
        return z;
    }
}
