package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_03.aufgabe_00.einstieg;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Figur;
import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Rechteck;

/**
 * Der Mähroboter geht gerade aus, bis er auf einen Zaun trifft (braunes
 * Hindernis).
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Maehroboter extends Figur
{
    int batteriestand;

    /**
     * Der Konstruktor erzeugt die Form, den Zaun und die Rasenfläche
     */
    Maehroboter()
    {
        super();
        FigurteilFestlegenRechteck(-50, -40, 20, 10, "schwarz");
        FigurteilFestlegenRechteck(-50, 30, 20, 10, "schwarz");
        FigurteilFestlegenRechteck(30, -40, 20, 10, "schwarz");
        FigurteilFestlegenRechteck(30, 30, 20, 10, "schwarz");
        FigurteilFestlegenEllipse(-50, -40, 100, 80, "cyan");
        FigurteilFestlegenDreieck(5, -10, 45, 0, 5, 10, "rot");
        PositionSetzen(300, 400);
        Drehen(90);
        batteriestand = 200;
        new Rasen();
        new ZaunNord();
        new ZaunWest();
        new ZaunOst();
        new ZaunSued();
        GanzNachVornBringen();
    }

    /**
     * Mäht so lange, so lange kein Hindernis kommt.
     */
    void BisZaunMähen()
    {
        while (!Berührt("braun") && BatteriestandGeben() > 10) // ! bedeutet
                                                               // NICHT
        {
            FahrenUndMähen();
        }
    }

    /**
     * Mäht so lange, so lange kein Hindernis kommt.
     */
    void Mähen()
    {
        while (BatteriestandGeben() > 10)
        {
            BisZaunMähen();
            Drehen(80);
            System.out.println(WinkelGeben());
            Gehen(10);
        }
    }

    /**
     * Simulation des Mähvorgangs.
     */
    void FahrenUndMähen()
    {
        Gehen(5);
        MähspurDarstellen();
        BatteriestandUm1Reduzieren();
        System.out.println("Batteriestand " + BatteriestandGeben());
    }
    // Hilfsmethoden, die als Black Box verwendet werden können

    /**
     * Meldet den Batteriestand.
     *
     * @return Batteriestand
     */
    int BatteriestandGeben()
    {
        return batteriestand;
    }

    /**
     * Erhöht den Batteriestand um 1.
     */
    void BatteriestandUm1Reduzieren()
    {
        batteriestand = batteriestand - 1;
    }

    /**
     * Im Anzeigefenster eine Mähspur darstellen.
     */
    private void MähspurDarstellen()
    {
        Rechteck r;
        r = new Rechteck();
        r.FarbeSetzen("hellgrün");
        if (WinkelGeben() > 45 && WinkelGeben() <= 135)
        {
            r.GrößeSetzen(20, 5);
            r.PositionSetzen(XPositionGeben() - 10, YPositionGeben() + 25);
        }
        else if (WinkelGeben() > 135 && WinkelGeben() <= 225)
        {
            r.GrößeSetzen(5, 20);
            r.PositionSetzen(XPositionGeben() - 25, YPositionGeben() - 10);
        }
        if (WinkelGeben() > 225 && WinkelGeben() <= 315)
        {
            r.GrößeSetzen(20, 5);
            r.PositionSetzen(XPositionGeben() - 10, YPositionGeben() - 35);
        }
        if (WinkelGeben() > 315 || WinkelGeben() <= 45)
        {
            r.GrößeSetzen(5, 20);
            r.PositionSetzen(XPositionGeben() + 25, YPositionGeben() - 10);
        }
        GanzNachVornBringen();
        try
        {
            Thread.sleep(50);
        }
        catch (InterruptedException e)
        {
        }
    }

    /**
     * Drehen und den Drehwinkel im INtervall [0;360[ halten.
     */
    @Override
    public void Drehen(int grad)
    {
        super.Drehen(grad);
        if (WinkelGeben() >= 360)
        {
            WinkelSetzen(WinkelGeben() - 360);
        }
        else if (WinkelGeben() < 0)
        {
            WinkelSetzen(WinkelGeben() + 360);
        }
    }
}
