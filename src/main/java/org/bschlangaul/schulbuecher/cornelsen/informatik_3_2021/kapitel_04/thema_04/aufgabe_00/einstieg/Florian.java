package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_04.aufgabe_00.einstieg;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Figur;

/**
 * Die Spielfigur der Blumentwelt.
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
        WinkelSetzen(0);
        GanzNachVornBringen();
    }

    /**
     * Florian geht einen Schritt nach Osten. Ist Florian am Rand der Welt,
     * bewegt er sich nicht weiter.
     */
    void NachOstenGehen()
    {
        if (XPositionGeben() < 450)
        {
            PositionSetzen(XPositionGeben() + 50, YPositionGeben());
        }
    }

    /**
     * Florian geht einen Schritt nach Süden. Ist Florian am Rand der Welt,
     * bewegt er sich nicht weiter.
     */
    void NachSüdenGehen()
    {
        if (YPositionGeben() < 450)
        {
            PositionSetzen(XPositionGeben(), YPositionGeben() + 50);
        }
        else
        {
            System.out.println("Autsch!");
        }
    }

    /**
     * Florian geht einen Schritt nach Westen. Ist Florian am Rand der Welt,
     * bewegt er sich nicht weiter.
     */
    void NachWestenGehen()
    {
        if (XPositionGeben() > 50)
        {
            PositionSetzen(XPositionGeben() - 50, YPositionGeben());
        }
    }

    /**
     * Florian geht einen Schritt nach Westen. Ist Florian am Rand der Welt,
     * bewegt er sich nicht weiter.
     */
    void NachNordenGehen()
    {
        if (YPositionGeben() > 50)
        {
            PositionSetzen(XPositionGeben(), YPositionGeben() - 50);
        }
    }

    /**
     * Dreht sich um 90 Grad nach links Tipp: Teste vorab (an einem Objekt der
     * Klasse Florian) die Methoden Drehen, WinkelGeben, WinkelSetzen der
     * Oberklasse
     */
    void LinksDrehen()
    {
        if (WinkelGeben() == 0)
        {
            WinkelSetzen(90);
        }
        else
        {
            if (WinkelGeben() == 90)
            {
                WinkelSetzen(180);
            }
            else
            {
                if (WinkelGeben() == 180)
                {
                    WinkelSetzen(270);
                }
                else
                {
                    if (WinkelGeben() == 270)
                    {
                        WinkelSetzen(0);
                    }
                }
            }
        }
    }

    /**
     * Dreht sich um 90 Grad nach rechts
     */
    void RechtsDrehen()
    {
        if (WinkelGeben() == 0)
        {
            WinkelSetzen(270);
        }
        else
        {
            if (WinkelGeben() == 90)
            {
                WinkelSetzen(0);
            }
            else
            {
                if (WinkelGeben() == 180)
                {
                    WinkelSetzen(90);
                }
                else
                {
                    if (WinkelGeben() == 270)
                    {
                        WinkelSetzen(180);
                    }
                }
            }
        }
    }
}
