package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_02.aufgabe_06.spielwelt_2d;

/**
 * Eine Zelle des Spielfeldes.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Zelle extends Rechteck
{
    /**
     * Platziert eine Zelle
     */
    Zelle(int xLinksOben, int yLinksOben, String farbeNeu)
    {
        super();
        PositionSetzen(xLinksOben, yLinksOben);
        GrößeSetzen(46, 46);
        FarbeSetzen(farbeNeu);
    }
}
