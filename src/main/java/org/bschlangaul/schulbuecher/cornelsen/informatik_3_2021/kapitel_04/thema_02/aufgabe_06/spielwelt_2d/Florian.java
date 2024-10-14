package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_02.aufgabe_06.spielwelt_2d;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Figur;

/**
 * Die Spielfigur der Blumenwelt.
 *
 * @author (Peter Brichzin)
 *
 * @version (Version 1.0)
 */
class Florian extends Figur
{
    /**
     * Legt die Form und die Startposition fest.
     */
    Florian()
    {
        super();
        this.FigurteilFestlegenRechteck(-20, -15, 40, 60, "orange");
        this.FigurteilFestlegenEllipse(-10, -50, 20, 30, "orange");
        this.FigurteilFestlegenDreieck(0, 0, 0, 30, 18, 15, "gelb");
        this.PositionSetzen(75, 125);
        this.GanzNachVornBringen();
    }

    /**
     * Lässt Florian eine Zelle nach Osten gehen.
     */
    void NachOstenGehen()
    {
        this.PositionSetzen(this.XPositionGeben() + 50, this.YPositionGeben());
    }

    /**
     * Lässt Florian eine Zelle nach Westen gehen.
     */
    void NachWestenGehen()
    {
        this.PositionSetzen(this.XPositionGeben() - 50, this.YPositionGeben());
    }

    /**
     * Lässt Florian eine Zelle nach Süden gehen.
     */
    void NachSüdenGehen()
    {
        this.PositionSetzen(this.XPositionGeben(), this.YPositionGeben() + 50);
    }

    /**
     * Lässt Florian eine Zelle nach Norden gehen.
     */
    void NachNordenGehen()
    {
        this.PositionSetzen(this.XPositionGeben(), this.YPositionGeben() - 50);
    }

    /**
     * Dreht sich um 90 Grad nach links Tipp: Teste vorab (an einem Objekt der
     * Klasse Florian) die Methoden Drehen, WinkelGeben, WinkelSetzen der
     * Oberklasse
     */
    void LinksDrehen()
    {
        this.WinkelSetzen(this.WinkelGeben() + 90);
    }

    /**
     * Dreht sich um 90 Grad nach rechts Tipp: Teste vorab (an einem Objekt der
     * Klasse Florian) die Methoden Drehen, WinkelGeben, WinkelSetzen der
     * Oberklasse
     */
    void RechtsDrehen()
    {
        this.WinkelSetzen(this.WinkelGeben() - 90);
    }
}
