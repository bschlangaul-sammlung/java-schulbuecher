package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_08.aufgabe_06.verrueckte_reise;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.*;

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
     */
    KreisBesser(int x, int y, int radius, String farbe)
    {
        super();
        PositionSetzen(x, y);
        RadiusSetzen(radius);
        FarbeSetzen(farbe);
    }
}
