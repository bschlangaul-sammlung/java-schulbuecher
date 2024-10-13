package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_05.aufgabe_04.einfache_grafik;

/**
 * Kreis mit mittelpunkt und Rand auf Kästenchengröße
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class RasterKreis extends Kreis
{
    /**
     * Setzt die Position (des Mittelpunkts) des Kreises.
     *
     * @param x x-Position des Mittelpunkts
     * @param y y-Position des Mittelpunkts
     */
    @Override
    void PositionSetzen(int x, int y)
    {
        super.PositionSetzen(x * 10, y * 10);
    }

    /**
     * Verschiebt den Kreis um die angegebenen Werte.
     *
     * @param deltaX Verschiebung in x-Richtung
     * @param deltaY Verschiebung in y-Richtung
     */
    @Override
    void Verschieben(int deltaX, int deltaY)
    {
        super.Verschieben(deltaX * 10, deltaY * 10);
    }

    /**
     * Setzt den Radius des Kreises.
     *
     * @param radius (neuer) Radius
     */
    @Override
    void RadiusSetzen(int radius)
    {
        super.RadiusSetzen(radius * 10);
    }
}