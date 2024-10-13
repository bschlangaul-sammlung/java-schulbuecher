package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_06.aufgabe_03c.spielwelt_2d;

/**
 * Zellen als Bestandteile der Welt, in der sich die Figuren bewegen können.
 * Jede Zelle hat die Größe 46x46 Pixel. Beachte Ränder um die Zellen, bei der
 * Anordnung in der Welt!
 *
 * @author Peter Brichzin
 *
 * @version 1.0
 */
class Zelle extends Rechteck
{
    /**
     * Erzeugt und platziert eine Zelle in der gewünschten Farbe.
     *
     * @param xLinksOben x-Wert der Ecke links oben der Zelle
     * @param yLinksOben y-Wert der Ecke links oben der Zelle
     * @param farbeNeu Farbe der Zelle
     */
    Zelle(int xLinksOben, int yLinksOben, String farbeNeu)
    {
        super();
        PositionSetzen(xLinksOben, yLinksOben);
        GrößeSetzen(46, 46);
        FarbeSetzen(farbeNeu);
    }
}
