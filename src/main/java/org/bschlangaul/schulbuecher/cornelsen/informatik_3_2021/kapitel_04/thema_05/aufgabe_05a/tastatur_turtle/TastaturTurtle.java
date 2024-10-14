package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_05.aufgabe_05a.tastatur_turtle;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.*;

/**
 * Durch die Tastatur gesteuerte Turtle
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class TastaturTurtle extends Turtle
{
    /**
     * Die Methode für gedrückte Sondertasten.
     *
     * @param taste KeyCode der gedrückten Taste
     */
    @Override
    public void SonderTasteGedrückt(int taste)
    {
        System.out.println("Sondertaste: " + taste);
    }
}
