package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_02.aufgabe_04.ball;

/**
 * Ein einfacher Ball
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
class Ball extends Kreis
{
    /**
     * Bewegt den Ball um 10 Einheiten nach oben
     */
    void BewegenNachOben()
    {
        this.Verschieben(0, -10);
    }

    /**
     * Bewegt den Ball um die angegebenen Einheiten nach oben
     *
     * @param länge gibt an, wie weit der Ball nach oben bewegt werden soll
     */
    void BewegenNachOben(int länge)
    {
        this.Verschieben(0, -länge);
    }

    /**
     * Bewegt den Ball um 10 Einheiten nach oben
     */
    void BewegenNachUnten()
    {
        this.Verschieben(0, 10);
    }

    /**
     * Bewegt den Ball um die angegebenen Einheiten nach unten
     *
     * @param länge gibt an, wie weit der Ball nach unten bewegt werden soll
     */
    void BewegenNachUnten(int länge)
    {
        this.Verschieben(0, länge);
    }
}
