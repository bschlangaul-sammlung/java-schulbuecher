package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_02.aufgabe_08.kruemel;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Figur;

/**
 * Verwaltet das Monster
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Monster extends Figur
{
    /**
     * Stellt das Monster mit geschlossenem Mund dar.
     */
    void Schließen()
    {
        this.EigeneFigurLöschen();
        this.FigurteilFestlegenEllipse(-50, -50, 100, 100, "gelb");
        this.FigurteilFestlegenRechteck(0, -2, 50, 4, "schwarz");
        this.FigurteilFestlegenEllipse(10, -40, 20, 20, "schwarz");
    }

    /**
     * Stellt das Monster mit offenem Mund dar.
     */
    void Öffnen()
    {
        this.EigeneFigurLöschen();
        this.FigurteilFestlegenEllipse(-50, -50, 100, 100, "gelb");
        this.FigurteilFestlegenDreieck(0, 0, 50, -10, 50, 10, "schwarz");
        this.FigurteilFestlegenEllipse(10, -40, 20, 20, "schwarz");
    }
}
