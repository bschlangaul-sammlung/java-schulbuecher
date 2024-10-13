package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_05.aufgabe_04.einfache_grafik;

/**
 * Rechteck mit Ecken auf Kästenchengröße
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class RasterRechteck extends Rechteck
{
    /**
     * Setzt die Position (der linken oberen Ecke) des Rechtecks.
     *
     * @param x x-Position der linken oberen Ecke
     * @param y y-Position der linken oberen Ecke
     */
    @Override
    void PositionSetzen(int x, int y)
    {
        super.PositionSetzen(x * 10, y * 10);
    }

    /**
     * Setzt die Größe des Rechtecks.
     *
     * @param breite (neue) Breite
     * @param höhe (neue) Höhe
     */
    @Override
    void GrößeSetzen(int breite, int höhe)
    {
        super.GrößeSetzen(breite * 10, höhe * 10);
    }

    /**
     * Verschiebt das Rechteck um die angegebenen Werte.
     *
     * @param deltaX Verschiebung in x-Richtung
     * @param deltaY Verschiebung in y-Richtung
     */
    @Override
    void Verschieben(int deltaX, int deltaY)
    {
        super.Verschieben(deltaX * 10, deltaY * 10);
    }
}
