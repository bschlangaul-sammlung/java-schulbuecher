package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_08.aufgabe_06.verrueckte_reise;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Dreieck;

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
     */
    DreieckBesser(int x, int y, int breite, int höhe, String farbe)
    {
        super();
        PositionSetzen(x, y);
        GrößeSetzen(breite, höhe);
        FarbeSetzen(farbe);
    }
}
