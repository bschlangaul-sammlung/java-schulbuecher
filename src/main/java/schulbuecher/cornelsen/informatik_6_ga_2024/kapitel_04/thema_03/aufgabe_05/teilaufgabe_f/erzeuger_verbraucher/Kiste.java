package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_03.aufgabe_05.teilaufgabe_f.erzeuger_verbraucher;

/**
 * Kiste beim Erzeuger-Verbraucher-Problem
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
class Kiste
{
    /** Laufende Nummer der Kiste */
    private int nummer;

    /**
     * Legt die Kistennummer fest.
     *
     * @param nummerNeu Nummer der Kiste
     */
    Kiste(int nummerNeu)
    {
        nummer = nummerNeu;
    }

    /**
     * Meldet die Nummer der Kiste.
     *
     * @return Kistennummer
     */
    int KistennummerGeben()
    {
        return nummer;
    }
}
