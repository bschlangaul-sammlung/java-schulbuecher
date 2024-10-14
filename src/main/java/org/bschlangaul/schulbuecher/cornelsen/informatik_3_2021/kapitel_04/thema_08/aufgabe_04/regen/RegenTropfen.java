package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_08.aufgabe_04.regen;

import java.util.Random;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Figur;

/**
 * Stellt einen Regentropfen in seinen verschiedenen Phasen dar.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class RegenTropfen extends Figur
{
    Random zufallsgenerator;

    /**
     * Positioniert den Tropfen zufällig und legt den Fallwinkel fest
     */
    RegenTropfen()
    {
        super();
        FigurTropfenFestlegen();
        zufallsgenerator = new Random();
        PositionSetzen(zufallsgenerator.nextInt(800),
                zufallsgenerator.nextInt(50) + 25);
        WinkelSetzen(270);
    }

    /**
     * Positioniert den Tropfen nach Angabe und legt den Fallwinkel fest
     *
     * @param xPos x-Position des Tropfens
     * @param yPos y-Position des Tropfens
     */
    RegenTropfen(int xPos, int yPos)
    {
        super();
        FigurTropfenFestlegen();
        PositionSetzen(xPos, yPos);
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
    public void AktionAusführen()
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
