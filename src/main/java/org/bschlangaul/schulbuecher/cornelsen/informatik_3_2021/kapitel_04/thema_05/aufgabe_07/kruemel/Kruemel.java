package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_05.aufgabe_07.kruemel;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Figur;

/**
 * Verwaltet einen Krümel
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Kruemel extends Figur
{
    /**
     * Stellt den orangen Krümel dar.
     */
    void FigurFestlegen()
    {
        EigeneFigurLöschen();
        FigurteilFestlegenEllipse(-5, -5, 10, 10, "orange");
    }

    /**
     * Der Krümel verschwindet bei Berührung
     */
    public void AktionAusführen()
    {
        if (Berührt())
        {
            Entfernen();
        }
    }
}
