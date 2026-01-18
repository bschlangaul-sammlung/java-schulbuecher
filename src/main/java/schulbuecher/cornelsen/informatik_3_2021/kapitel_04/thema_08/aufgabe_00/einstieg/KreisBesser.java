package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_08.aufgabe_00.einstieg;

import schulbuecher.cornelsen.shared.graphics_and_games.Kreis;

/**
 * Erlaubt das vollständige Anlegen im Konstruktor.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class KreisBesser extends Kreis
{
    /**
     * Legt den Kreis nach den gegebenen Daten an.
     *
     * @param x x-Position des Mittelpunkts
     * @param y y-Position des Mittelpunkts
     * @param radius Radius des Kreises
     * @param farbe Farbe des Kreises
     */
    KreisBesser(int x, int y, int radius, String farbe)
    {
        super();
        PositionSetzen(x, y);
        RadiusSetzen(radius);
        FarbeSetzen(farbe);
    }
}
