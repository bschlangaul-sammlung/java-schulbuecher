package schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_07.aufgabe_03;

/**
 * Beobachter Meldungen aus dem Spiel.
 *
 * @author Albert Wiedeman
 *
 * @version 1.0
 */
interface Beobachter
{
    /**
     * Meldet die anzahl der noch zu suchenden Marken.
     *
     * @param anzahl Anzahl der Marken
     */
    void MarkenMelden(int anzahl);

    /**
     * Meldet, dass der Spieler gewonnen hat.
     */
    void GewonnenMelden();

    /**
     * Meldet, dass der Spieler verloren hat.
     */
    void VerlorenMelden();
}
