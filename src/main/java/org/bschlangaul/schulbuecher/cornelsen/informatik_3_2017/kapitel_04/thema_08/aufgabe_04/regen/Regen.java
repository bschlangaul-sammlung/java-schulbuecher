package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_08.aufgabe_04.regen;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Ereignisbehandlung;

/**
 * Steuert den Regen
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Regen extends Ereignisbehandlung
{
    Regen()
    {
        super();
        new Vorboden();
        new Boden();
        Starten();
    }

    /**
     * Erzeugt bei jedem Taktimpuls einen neuen Tropfen
     */
    @Override
    public void TaktImpulsAusführen()
    {
        new RegenTropfen();
    }

    /**
     * Erzeugt bei einem Musklick einen neuen Tropfen an der Stelle des Klicks
     *
     * @param x x-Position des Mausklicks
     * @param y y-Position des Mausklicks
     * @param anzahl Anzahl der aufeinanderfolgenden Mausklicks (hier nicht
     *     benötigt)
     */
    @Override
    public void MausGeklickt(int x, int y, int anzahl)
    {
        new RegenTropfen(x, y);
    }
}
