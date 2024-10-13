package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_06.aufgabe_05.hausbau;

/**
 * Erzeugt das Rechteck für die Wand des Hauses.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Wand extends Rechteck
{
    /**
     * Legt Position, Größe und Farbe fest
     */
    Wand()
    {
        super();
        PositionSetzen(20, 120);
        GrößeSetzen(140, 140);
        FarbeSetzen("hellgrün");
    }
}
