package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_02.aufgabe_05.figur;

/**
 * Verschiedene Figurenformen.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class MeineFigur extends Figur
{
    /**
     * Stellt die Figur als Auto dar
     */
    void FigurAutoSetzen()
    {
        this.FigurteilFestlegenRechteck(-50, -40, 20, 10, "schwarz");
        this.FigurteilFestlegenRechteck(-50, 30, 20, 10, "schwarz");
        this.FigurteilFestlegenRechteck(30, -40, 20, 10, "schwarz");
        this.FigurteilFestlegenRechteck(30, 30, 20, 10, "schwarz");
        this.FigurteilFestlegenEllipse(-50, -40, 100, 80, "rot");
    }

    /**
     * Stellt die Figur als Monster dar
     */
    void FigurMonsterSetzen()
    {
        this.FigurteilFestlegenEllipse(-40, -40, 80, 80, "gelb");
        this.FigurteilFestlegenRechteck(10, -2, 30, 4, "schwarz");
        this.FigurteilFestlegenEllipse(15, -25, 15, 15, "schwarz");
    }

    /**
     * Stellt die Figur als Auto dar
     */
    void FigurAutoSetzenVollständig()
    {
        this.EigeneFigurLöschen();
        this.FigurteilFestlegenRechteck(-50, -40, 20, 10, "schwarz");
        this.FigurteilFestlegenRechteck(-50, 30, 20, 10, "schwarz");
        this.FigurteilFestlegenRechteck(30, -40, 20, 10, "schwarz");
        this.FigurteilFestlegenRechteck(30, 30, 20, 10, "schwarz");
        this.FigurteilFestlegenEllipse(-50, -40, 100, 80, "rot");
    }

    /**
     * Stellt die Figur als Monster dar
     */
    void FigurMonsterSetzenVollständig()
    {
        this.EigeneFigurLöschen();
        this.FigurteilFestlegenEllipse(-40, -40, 80, 80, "gelb");
        this.FigurteilFestlegenRechteck(10, -2, 30, 4, "schwarz");
        this.FigurteilFestlegenEllipse(15, -25, 15, 15, "schwarz");
    }

    /**
     * Stellt die Figur als buntes Quadrat dar
     */
    void FigurBuntesQuadratSetzen()
    {
        this.EigeneFigurLöschen();
        this.FigurteilFestlegenRechteck(-50, -50, 100, 100, "schwarz");
        this.FigurteilFestlegenRechteck(-48, -48, 96, 96, "rot");
        this.FigurteilFestlegenRechteck(-38, -38, 76, 76, "blau");
        this.FigurteilFestlegenRechteck(-28, -28, 56, 56, "gelb");
    }
}
