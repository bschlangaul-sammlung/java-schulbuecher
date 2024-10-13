package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_03.aufgabe_02.bedingungen;

/**
 * Tested die Rand-Bedingungen.
 *
 * @author (your name)
 *
 * @version (a version number or a date)
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
