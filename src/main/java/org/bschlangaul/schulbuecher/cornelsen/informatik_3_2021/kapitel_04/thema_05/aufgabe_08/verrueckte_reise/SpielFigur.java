package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_05.aufgabe_08.verrueckte_reise;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Figur;

/**
 * Die Spielfigur der verrückten Reise
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class SpielFigur extends Figur
{
    /**
     * Bewegt die Figur gerade aus
     */
    @Override
    public void AktionAusführen()
    {
        Gehen(15);
    }

    /**
     * Steuert die Richtung der Spielfigur.
     *
     * @param taste KeyCode der gedrückten Taste
     */
    @Override
    public void SonderTasteGedrückt(int taste)
    {
        if (taste == 37)
        {
            Drehen(5);
        }
        else if (taste == 39)
        {
            Drehen(-5);
        }
    }
}
