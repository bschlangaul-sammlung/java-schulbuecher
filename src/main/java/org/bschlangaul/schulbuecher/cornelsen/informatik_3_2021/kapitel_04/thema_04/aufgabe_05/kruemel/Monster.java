package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_04.aufgabe_05.kruemel;

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
}
