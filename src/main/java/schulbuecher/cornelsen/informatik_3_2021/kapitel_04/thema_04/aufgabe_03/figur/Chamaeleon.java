package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_04.aufgabe_03.figur;

import schulbuecher.cornelsen.shared.graphics_and_games.Figur;

/**
 * Beschreibt ein Chamäleon.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Chamaeleon extends Figur
{
    /**
     * Legt das Chamäleon in der Farbe grün an.
     */
    Chamaeleon()
    {
        super();
        GrünSetzen();
    }

    /**
     * Erzeugt die grüne Chamäleon-Figur
     */
    void GrünSetzen()
    {
        FigurteilFestlegenDreieck(-50, 25, 25, -15, 25, 10, "grün");
        FigurteilFestlegenDreieck(25, -15, 50, 10, 25, 10, "grün");
        FigurteilFestlegenRechteck(-10, 5, 10, 30, "grün");
        FigurteilFestlegenRechteck(15, 0, 10, 35, "grün");
        FigurteilFestlegenDreieck(25, 25, 35, 35, 25, 35, "grün");
        FigurteilFestlegenEllipse(25, -5, 8, 8, "rot");
    }

    /**
     * Erzeugt die blaue Chamäleon-Figur
     */
    void BlauSetzen()
    {
        FigurteilFestlegenDreieck(-50, 25, 25, -15, 25, 10, "blau");
        FigurteilFestlegenDreieck(25, -15, 50, 10, 25, 10, "blau");
        FigurteilFestlegenRechteck(-10, 5, 10, 30, "blau");
        FigurteilFestlegenRechteck(15, 0, 10, 35, "blau");
        FigurteilFestlegenDreieck(25, 25, 35, 35, 25, 35, "blau");
        FigurteilFestlegenEllipse(25, -5, 8, 8, "rot");
    }

    /**
     * Erzeugt die rote Chamäleon-Figur
     */
    void RotSetzen()
    {
        FigurteilFestlegenDreieck(-50, 25, 25, -15, 25, 10, "rot");
        FigurteilFestlegenDreieck(25, -15, 50, 10, 25, 10, "rot");
        FigurteilFestlegenRechteck(-10, 5, 10, 30, "rot");
        FigurteilFestlegenRechteck(15, 0, 10, 35, "rot");
        FigurteilFestlegenDreieck(25, 25, 35, 35, 25, 35, "rot");
        FigurteilFestlegenEllipse(25, -5, 8, 8, "orange");
    }

    /**
     * Erzeugt die schwarze Chamäleon-Figur
     */
    void SchwarzSetzen()
    {
        FigurteilFestlegenDreieck(-50, 25, 25, -15, 25, 10, "schwarz");
        FigurteilFestlegenDreieck(25, -15, 50, 10, 25, 10, "schwarz");
        FigurteilFestlegenRechteck(-10, 5, 10, 30, "schwarz");
        FigurteilFestlegenRechteck(15, 0, 10, 35, "schwarz");
        FigurteilFestlegenDreieck(25, 25, 35, 35, 25, 35, "schwarz");
        FigurteilFestlegenEllipse(25, -5, 8, 8, "rot");
    }

    /**
     * Stellt das Chamäleon rot dar, wenn eine andere Grafikfigur berührt wird,
     * sonst schwarz.
     */
    void Umfärben()
    {
        if (Berührt())
        {
            RotSetzen();
        }
        else
        {
            SchwarzSetzen();
        }
    }

    /**
     * Stellt das Chamäleon in der Farbe der brührten Figur dar.
     */
    void UmfärbenBesser()
    {
        if (Berührt("rot"))
        {
            RotSetzen();
        }
        else if (Berührt("blau"))
        {
            BlauSetzen();
        }
        else if (Berührt("grün"))
        {
            GrünSetzen();
        }
        else
        {
            SchwarzSetzen();
        }
    }
}
