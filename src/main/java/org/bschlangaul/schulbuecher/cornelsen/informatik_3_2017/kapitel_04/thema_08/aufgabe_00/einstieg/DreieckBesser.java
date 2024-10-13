package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_08.aufgabe_00.einstieg;

/**
 * Erlaubt das vollständige Anlegen im Konstruktor.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class DreieckBesser extends Dreieck
{
    /**
     * Legt das Dreieck nach den gegebenen Daten an.
     *
     * @param x x-Position der Spitze
     * @param y y-Position der Spitze
     * @param breite Breite des Dreiecks
     * @param höhe Höhe des Dreiecks
     * @param winkel Drehwinkel des Dreiecks
     * @param farbe Farbe des Dreiecks
     */
    DreieckBesser(int x, int y, int breite, int höhe, int winkel, String farbe)
    {
        super();
        PositionSetzen(x, y);
        GrößeSetzen(breite, höhe);
        FarbeSetzen(farbe);
        WinkelSetzen(winkel);
    }
}
