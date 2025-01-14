package org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games;

/**
 * <p>
 * Zellen als Bestandteile der Welt, in der sich die Figuren bewegen können.
 * Jede Zelle hat die Größe 46x46 Pixel. Beachte Ränder um die Zellen, bei der
 * Anordnung in der Welt!
 * </p>
 *
 * <p>
 * Diese Klasse ist nicht im ursprünglichen GraphicsAndGames-Paket enthalten.
 * Sie wird aber in mehreren Projekten verwendet.
 * </p>
 *
 * @author Peter Brichzin
 *
 * @version 1.0
 */
public class Zelle extends Rechteck
{
    /**
     * Erzeugt und platziert eine Zelle in der gewünschten Farbe.
     *
     * @param xLinksOben x-Wert der Ecke links oben der Zelle
     * @param yLinksOben y-Wert der Ecke links oben der Zelle
     * @param farbeNeu Farbe der Zelle
     */
    public Zelle(int xLinksOben, int yLinksOben, String farbeNeu)
    {
        super();
        PositionSetzen(xLinksOben, yLinksOben);
        GrößeSetzen(46, 46);
        FarbeSetzen(farbeNeu);
    }
}
