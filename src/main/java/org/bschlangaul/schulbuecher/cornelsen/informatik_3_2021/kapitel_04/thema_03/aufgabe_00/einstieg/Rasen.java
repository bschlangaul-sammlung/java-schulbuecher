package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_03.aufgabe_00.einstieg;

/**
 * Die Rasenfläche.
 *
 * @author Albert Weidemann
 *
 * @version 1.0
 */
class Rasen extends Rechteck
{
    /**
     * Plaziert den Rasen.
     */
    Rasen()
    {
        super();
        FarbeSetzen("grün");
        PositionSetzen(0, 10);
        GrößeSetzen(600, 490);
    }
}
