package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_06.aufgabe_06.kruemel;

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
     * Legt Position und Figur fest
     *
     * @param x x-Position des Krümels
     * @param y y-Position des Krümels
     */
    Kruemel(int x, int y)
    {
        super();
        FigurFestlegen();
        PositionSetzen(x, y);
    }

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
