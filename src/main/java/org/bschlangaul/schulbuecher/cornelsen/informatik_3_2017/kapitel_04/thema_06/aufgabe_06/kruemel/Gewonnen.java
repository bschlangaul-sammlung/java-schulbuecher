package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_06.aufgabe_06.kruemel;

/**
 * Stellt den Gewinntext dar
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Gewonnen extends Text
{
    /**
     * Legt Position und Text fest
     */
    Gewonnen()
    {
        super();
        TextSetzen("Du hast das Spiel gewonnen");
        PositionSetzen(10, 20);
    }
}
