package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_06.aufgabe_04.regen;

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
     * Positioniert den Tropfen und legt den Fallwinkel fest Boden und Vorboden
     * werden eingerichtet
     */
    RegenTropfen()
    {
        super();
        new Vorboden();
        new Boden();
        FigurTropfenFestlegen();
        GanzNachVornBringen();
        PositionSetzen(50, 50);
        WinkelSetzen(270);
    }

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
        if (Berührt("schwarz"))
        {
            PfützeWerden();
        }
        else
        {
            if (Berührt("weiß"))
            {
                FlachWerden();
                Gehen(5);
            }
            else
            {
                Gehen(10);
            }
        }
    }
}
