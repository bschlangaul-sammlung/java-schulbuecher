package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_08.aufgabe_05.kruemel;

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
     * Anzahl der gefressenen Krümel
     */
    int anzahl;

    /**
     * Mundstellung
     */
    boolean mundIstZu;

    /**
     * Legt die Figur und die Munstellung fest.
     */
    Monster()
    {
        super();
        anzahl = 0;
        mundIstZu = true;
        Schließen("gelb");
    }

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
        switch (taste)
        {
        case 37:
            Drehen(90);
            break;

        case 38:
            Gehen(10);
            break;

        case 39:
            Drehen(-90);
            break;

        case 40:
            Drehen(180);
            break;
        }
    }

    /**
     * Die Aktionsmethode für gedrückte Sondertasten.
     *
     * @param taste die gedrückte Taste
     */
    @Override
    public void TasteGedrückt(char taste)
    {
        switch (taste)
        {
        case ' ':
            Gehen(50);
            break;
        }
    }

    /**
     * Das Monster geht maximal bis zum Rand
     */
    public void AktionAusführen()
    {
        if (mundIstZu)
        {
            Öffnen("gelb");
            mundIstZu = false;
        }
        else
        {
            Schließen("gelb");
            mundIstZu = true;
        }
        if (WinkelGeben() == 0)
        {
            if (XPositionGeben() < 790)
            {
                Gehen(10);
            }
            else
            {
                new Verloren();
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
                else
                {
                    new Verloren();
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
                    else
                    {
                        new Verloren();
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
                        else
                        {
                            new Verloren();
                        }
                    }
                }
            }
        }
        if (Berührt("orange"))
        {
            anzahl = anzahl + 1;
        }
        if (anzahl == 10)
        {
            new Gewonnen();
        }
    }
}
