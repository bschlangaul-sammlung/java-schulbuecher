package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_06.aufgabe_04.regen;

/**
 * Simuliert die Information, dass der Boden gleich erreicht ist.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Vorboden extends Rechteck
{
    /**
     * Setzt Position, Größe und Farbe
     */
    Vorboden()
    {
        super();
        GrößeSetzen(800, 15);
        FarbeSetzen("weiß");
        PositionSetzen(0, 501);
    }
}
