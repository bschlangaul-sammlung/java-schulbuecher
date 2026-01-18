package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_03.aufgabe_05.teilaufgabe_b.erzeuger_verbraucher;

import schulbuecher.cornelsen.shared.graphics_and_games.Rechteck;

/**
 * Kiste beim Erzeuger-Verbraucher-Problem
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
class Kiste extends Rechteck
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
        FarbeSetzen("braun");
    }

    /**
     * Stellt die Kiste auf dem Speicherplatz dar.
     */
    void ImSpeicherDarstellen()
    {
        PositionSetzen(375, 200);
        SichtbarkeitSetzen(true);
    }

    /**
     * Verbirgt die Kiste auf dem Speicherplatz.
     */
    void SpeicherdarstellungVerbergen()
    {
        SichtbarkeitSetzen(false);
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
