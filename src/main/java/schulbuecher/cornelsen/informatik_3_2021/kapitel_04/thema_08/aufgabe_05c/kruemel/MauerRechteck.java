package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_08.aufgabe_05c.kruemel;

import schulbuecher.cornelsen.shared.graphics_and_games.Rechteck;

/**
 * Beschreibt ein Rechteck der (grauen) Mauer
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class MauerRechteck extends Rechteck
{
    /**
     * Der Konstruktor legt Position, Größe und Farbe fest
     *
     * @param x x-Koordinate des Rechtecks
     * @param y y-Koordinate des Rechtecks
     * @param breite Breite des Rechtecks
     * @param höhe Höhe des Rechtecks
     */
    MauerRechteck(int x, int y, int breite, int höhe)
    {
        super();
        PositionSetzen(x, y);
        GrößeSetzen(breite, höhe);
        FarbeSetzen("grau");
    }
}
