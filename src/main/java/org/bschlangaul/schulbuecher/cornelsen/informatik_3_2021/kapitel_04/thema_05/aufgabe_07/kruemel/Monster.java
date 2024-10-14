package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_05.aufgabe_07.kruemel;

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
     * Stellt das gelb gefärbte Monster mit geschlossenem Mund dar.
     */
    void GeschlossenGelb()
    {
        EigeneFigurLöschen();
        FigurteilFestlegenEllipse(-50, -50, 100, 100, "gelb");
        FigurteilFestlegenRechteck(0, -2, 50, 4, "schwarz");
        FigurteilFestlegenEllipse(10, -40, 20, 20, "schwarz");
    }

    /**
     * Stellt das orange gefärbte Monster mit geschlossenem Mund dar.
     */
    void GeschlossenOrange()
    {
        EigeneFigurLöschen();
        FigurteilFestlegenEllipse(-50, -50, 100, 100, "orange");
        FigurteilFestlegenRechteck(0, -2, 50, 4, "schwarz");
        FigurteilFestlegenEllipse(10, -40, 20, 20, "schwarz");
    }

    /**
     * Stellt das rot gefärbte Monster mit geschlossenem Mund dar.
     */
    void GeschlossenRot()
    {
        EigeneFigurLöschen();
        FigurteilFestlegenEllipse(-50, -50, 100, 100, "rot");
        FigurteilFestlegenRechteck(0, -2, 50, 4, "schwarz");
        FigurteilFestlegenEllipse(10, -40, 20, 20, "schwarz");
    }

    /**
     * Stellt das grün gefärbte Monster mit geschlossenem Mund dar.
     */
    void GeschlossenGrün()
    {
        EigeneFigurLöschen();
        FigurteilFestlegenEllipse(-50, -50, 100, 100, "grün");
        FigurteilFestlegenRechteck(0, -2, 50, 4, "schwarz");
        FigurteilFestlegenEllipse(10, -40, 20, 20, "schwarz");
    }

    /**
     * Stellt das Monster in der angegebenen Farbe mit offenem Mund dar.
     *
     * @param farbe die gewünschte Farbe
     */
    void Offen(String farbe)
    {
        EigeneFigurLöschen();
        FigurteilFestlegenEllipse(-50, -50, 100, 100, farbe);
        FigurteilFestlegenDreieck(0, 0, 50, -10, 50, 10, "schwarz");
        FigurteilFestlegenEllipse(10, -40, 20, 20, "schwarz");
    }

    /**
     * Stellt das in einer der Farben gelb, orange, rot bzw. grün mit
     * geschlossenem Mund dar.
     *
     * @param farbe die gewünschte Farbe
     */
    void Schließen(String farbe)
    {
        if (farbe == "gelb")
        {
            GeschlossenGelb();
        }
        if (farbe == "orange")
        {
            GeschlossenOrange();
        }
        if (farbe == "rot")
        {
            GeschlossenRot();
        }
        if (farbe == "grün")
        {
            GeschlossenGrün();
        }
    }

    /**
     * Stellt das in einer der Farben gelb, orange, rot bzw. grün mit offenem
     * Mund dar.
     *
     * @param farbe die gewünschte Farbe
     */
    void Öffnen(String farbe)
    {
        if ((farbe == "gelb") || (farbe == "orange") || (farbe == "rot")
                || (farbe == "grün"))
        {
            Offen(farbe);
        }
    }

    /**
     * Die Aktionsmethode für gedrückte Sondertasten.
     *
     * @param taste KeyCode der gedrückten Taste
     */
    @Override
    public void SonderTasteGedrückt(int taste)
    {
        if (taste == 37)
        {
            WinkelSetzen(180);
        }
        else
        {
            if (taste == 38)
            {
                WinkelSetzen(90);
            }
            else
            {
                if (taste == 39)
                {
                    WinkelSetzen(0);
                }
                else
                {
                    if (taste == 40)
                    {
                        WinkelSetzen(270);
                    }
                }
            }
        }
    }

    /**
     * Das Monster geht maximal bis zum Rand
     */
    public void AktionAusführen()
    {
        if (WinkelGeben() == 0)
        {
            if (XPositionGeben() < 790)
            {
                Gehen(10);
            }
        }
        else
        {
            if (WinkelGeben() == 90)
            {
                if (YPositionGeben() > 30)
                {
                    Gehen(10);
                }
            }
            else
            {
                if (WinkelGeben() == 180)
                {
                    if (XPositionGeben() > 10)
                    {
                        Gehen(10);
                    }
                }
                else
                {
                    if (WinkelGeben() == 270)
                    {
                        if (YPositionGeben() < 500)
                        {
                            Gehen(10);
                        }
                    }
                }
            }
        }
    }
}
