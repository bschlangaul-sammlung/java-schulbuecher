package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_03.aufgabe_04.labyrinth;

/**
 * Der Ausgang
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Ausgang extends Rechteck
{
    /**
     * Konstruktor
     */
    Ausgang()
    {
        super();
        PositionSetzen(14 * 50 + 15 + 1, 8 * 50 + 20 + 1);
        GrößeSetzen(48, 48);
        FarbeSetzen("grün");
    }
}
