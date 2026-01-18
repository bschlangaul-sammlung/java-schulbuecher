package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_08.aufgabe_00.einstieg;

import schulbuecher.cornelsen.shared.graphics_and_games.Rechteck;

/**
 * Erlaubt das vollständige Anlegen im Konstruktor.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class RechteckBesser extends Rechteck
{
    /**
     * Legt das Rechteck nach den gegebenen Daten an.
     *
     * @param x x-Position der linken oberen Ecke
     * @param y y-Position der linken oberen Ecke
     * @param breite Breite des Rechtecks
     * @param höhe Höhe des Rechtecks
     * @param farbe Farbe des Rechtecks
     */
    RechteckBesser(int x, int y, int breite, int höhe, String farbe)
    {
        super();
        PositionSetzen(x, y);
        GrößeSetzen(breite, höhe);
        FarbeSetzen(farbe);
    }
}
