package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_08.aufgabe_11.jaeger_beute;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Ereignisbehandlung;

/**
 * Steuert das Verfolgungsspiel.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Verfolgung extends Ereignisbehandlung
{
    /**
     * Legt die Objekte an.
     */
    public Verfolgung()
    {
        new Beute(600, 400);
        new Jaeger(600, 400);
        TaktdauerSetzen(100);
    }

    /**
     * Die eigentliche Aktionsmethode des Zeitgebers. <br>
     * Muss bei Bedarf von einer Unterklasse überschrieben werden.
     */
    @Override
    public void TaktImpulsAusführen()
    {
        // nichts
    }

    /**
     * Die eigentliche Aktionsmethode für einen Mausklick. <br>
     * Muss bei Bedarf von einer Unterklasse überschrieben werden.
     *
     * @param x x-Position des Mausklicks
     * @param y y-Position des Mausklicks
     * @param anzahl Anzahl der aufeinanderfolgenden Mausklicks
     */
    @Override
    public void MausGeklickt(int x, int y, int anzahl)
    {
        // nichts
    }
}
