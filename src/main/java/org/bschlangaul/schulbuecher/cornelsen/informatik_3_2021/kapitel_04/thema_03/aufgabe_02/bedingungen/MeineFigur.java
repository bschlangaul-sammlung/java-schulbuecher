package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_03.aufgabe_02.bedingungen;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Figur;

/**
 * Tested die Rand-Bedingungen.
 */
class MeineFigur extends Figur
{
    /**
     * Die Methode bewegt die Figur bis zum Rand des sichtbaren Bereichs.
     */
    void ZumRandGehen()
    {
        while ((XPositionGeben() >= 0) && (XPositionGeben() <= 800)
                && (YPositionGeben() >= 0) && (YPositionGeben() <= 550))
        {
            Gehen(1);
        }
    }
}
