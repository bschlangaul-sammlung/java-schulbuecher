package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_05.aufgabe_06.regen;

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
        EigeneFigurLöschen();
        FigurteilFestlegenDreieck(-50, 0, 30, -30, 30, 30, "blau");
        FigurteilFestlegenEllipse(10, -30, 40, 60, "blau");
    }

    /**
     * Stellt den Regentropfen während des Aufpralls dar
     */
    void FlachWerden()
    {
        EigeneFigurLöschen();
        FigurteilFestlegenDreieck(-50, 0, 30, -30, 30, 30, "blau");
        FigurteilFestlegenRechteck(30, -45, 15, 90, "blau");
    }

    /**
     * Stellt den Regentropfen als Pfütze dar
     */
    void PfützeWerden()
    {
        EigeneFigurLöschen();
        FigurteilFestlegenRechteck(30, -45, 15, 90, "blau");
    }

    /**
     * Methode wird aufgerufen, wenn die Figur handeln soll.
     */
    @Override
    void AktionAusführen()
    {
        WinkelSetzen(270);
        if (YPositionGeben() < 520 - 20)
        {
            FigurTropfenFestlegen();
            Gehen(10);
        }
        else
        {
            if (YPositionGeben() < 520 - 5)
            {
                FlachWerden();
                Gehen(5);
            }
            else
            {
                PfützeWerden();
            }
        }
    }
}
