package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_03.aufgabe_09.spielwelt_2d;

import schulbuecher.cornelsen.shared.graphics_and_games.Figur;

/**
 * Eine Spielfigur in der Blumenwelt.
 *
 * @author Peter Brichzin
 *
 * @version Version 1.0
 */
class Florian extends Figur
{
    /**
     * Legt die Form und die Startposition fest.
     */
    Florian()
    {
        super();
        FigurteilFestlegenRechteck(-20, -15, 40, 60, "orange");
        FigurteilFestlegenEllipse(-10, -50, 20, 30, "orange");
        FigurteilFestlegenDreieck(0, 0, 0, 30, 18, 15, "gelb");
        PositionSetzen(75, 125);
        GanzNachVornBringen();
    }

    /**
     * Lässt Florian eine Zelle nach Osten gehen.
     */
    void NachOstenGehen()
    {
        PositionSetzen(XPositionGeben() + 50, YPositionGeben());
    }

    /**
     * Lässt Florian eine Zelle nach Westen gehen.
     */
    void NachWestenGehen()
    {
        PositionSetzen(XPositionGeben() - 50, YPositionGeben());
    }

    /**
     * Lässt Florian eine Zelle nach Süden gehen.
     */
    void NachSüdenGehen()
    {
        PositionSetzen(XPositionGeben(), YPositionGeben() + 50);
    }

    /**
     * Lässt Florian eine Zelle nach Norden gehen.
     */
    void NachNordenGehen()
    {
        PositionSetzen(XPositionGeben(), YPositionGeben() - 50);
    }

    /**
     * Dreht sich um 90 Grad nach links Tipp: Teste vorab (an einem Objekt der
     * Klasse Florian) die Methoden Drehen, WinkelGeben, WinkelSetzen der
     * Oberklasse
     */
    void LinksDrehen()
    {
        WinkelSetzen(WinkelGeben() + 90);
    }

    /**
     * Dreht sich um 90 Grad nach rechts Tipp: Teste vorab (an einem Objekt der
     * Klasse Florian) die Methoden Drehen, WinkelGeben, WinkelSetzen der
     * Oberklasse
     */
    void RechtsDrehen()
    {
        WinkelSetzen(WinkelGeben() - 90);
    }
}
