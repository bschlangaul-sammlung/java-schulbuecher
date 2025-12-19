package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_01.aufgabe_02.lagerarbeit;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Figur;

/**
 * Darstellung eines Lageristen
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
public class LageristenSymbol extends Figur
{
    /**
     * Konstruktor für Objekte der Klasse LageristenSymbol
     */
    public LageristenSymbol(String helmfarbe, int nummer)
    {
        // Kopf von oben
        FigurteilFestlegenEllipse(-50, -10, 20, 20, helmfarbe);
        // Kiste von oben
        FigurteilFestlegenRechteck(-30, -40, 80, 80, "braun");
        PositionSetzen(50, 100 + 100 * nummer);
    }

    /**
     * Unterbricht die Programmausführung für die angegebene Zeit.
     */
    void Warten(int millis)
    {
        try
        {
            Thread.sleep(5);
        }
        catch (InterruptedException e)
        {
        }
    }
}
