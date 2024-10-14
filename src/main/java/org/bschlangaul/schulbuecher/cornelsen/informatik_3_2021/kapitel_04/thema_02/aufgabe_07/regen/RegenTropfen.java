package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_02.aufgabe_07.regen;

/**
 * Stellt einen Regentropfen in seinen verschiedenen Phasen dar.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class RegenTropfen extends Figur
{
    /**
     * Stellt den Regentropfen im Fall dar
     */
    void FigurTropfenFestlegen()
    {
        this.EigeneFigurLöschen();
        this.FigurteilFestlegenDreieck(-50, 0, 30, -30, 30, 30, "blau");
        this.FigurteilFestlegenEllipse(10, -30, 40, 60, "blau");
    }

    /**
     * Stellt den Regentropfen während des Aufpralls dar
     */
    void FlachWerden()
    {
        this.EigeneFigurLöschen();
        this.FigurteilFestlegenDreieck(-50, 0, 30, -30, 30, 30, "blau");
        this.FigurteilFestlegenRechteck(30, -45, 15, 90, "blau");
    }

    /**
     * Stellt den Regentropfen als Pfütze dar
     */
    void PfützeWerden()
    {
        this.EigeneFigurLöschen();
        this.FigurteilFestlegenRechteck(30, -45, 15, 90, "blau");
    }
}
