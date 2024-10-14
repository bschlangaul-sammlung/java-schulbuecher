package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_05.aufgabe_09.spielwelt_2d;

import java.awt.event.KeyEvent;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Figur;

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
        WinkelSetzen(0);
        GanzNachVornBringen();
    }

    /**
     * Florian geht einen Schritt in Blickrichtung.
     */
    void Gehen()
    {
        if (WinkelGeben() == 0)
        {
            NachOstenGehen();
        }
        else
        {
            if (WinkelGeben() == 90)
            {
                NachNordenGehen();
            }
            else
            {
                if (WinkelGeben() == 180)
                {
                    NachWestenGehen();
                }
                else
                {
                    if (WinkelGeben() == 270)
                    {
                        NachSüdenGehen();
                    }
                }
            }
        }
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

    /**
     * Steuerung der Figur: Links-/Rechtsdrehen über Cursortasten.
     */
    @Override
    public void SonderTasteGedrückt(int taste)
    {
        if (taste == KeyEvent.VK_RIGHT)
        {
            RechtsDrehen();
        }
        else
        {
            if (taste == KeyEvent.VK_LEFT)
            {
                LinksDrehen();
            }
        }
    }

    /**
     * Ständige Bewegung, außer Florian ist an der Grenze seiner Welt.
     */
    @Override
    public void AktionAusführen()
    {
        Gehen();
    }
}
