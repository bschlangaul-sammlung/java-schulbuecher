package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_05.aufgabe_04.einfache_grafik;

/**
 * Dreieck mit Ecken auf Kästenchengröße
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class RasterDreieck extends Dreieck
{
    /**
     * Setzt die Position (der Spitze) des Dreiecks.
     *
     * @param x x-Position der Spitze
     * @param y y-Position der Spitze
     */
    @Override
    void PositionSetzen(int x, int y)
    {
        super.PositionSetzen(x * 10, y * 10);
    }

    /**
     * Setzt die Größe des Dreiecks.
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
     * Verschiebt das Dreieck um die angegebenen Werte.
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
