package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_05.aufgabe_04.einfache_grafik;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.*;

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
    public void PositionSetzen(int x, int y)
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
    public void GrößeSetzen(int breite, int höhe)
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
    public void Verschieben(int deltaX, int deltaY)
    {
        super.Verschieben(deltaX * 10, deltaY * 10);
    }
}
