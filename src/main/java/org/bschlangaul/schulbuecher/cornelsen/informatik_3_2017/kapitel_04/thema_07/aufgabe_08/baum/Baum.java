package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_07.aufgabe_08.baum;

/**
 * Beschreibt einen stilisierten Baum
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Baum extends Figur
{
    /** Der Himmel in der oberen Hälfte */
    Rechteck himmel;

    /** Der Boden in der unteren Hälfte */
    Rechteck boden;

    /** Der Baumstamm */
    Rechteck stamm;

    /** Die Baumkrone */
    Kreis krone;

    /** Die aktuelle Jahreszeit */
    String jahreszeit;

    /** Die aktuelle Größe */
    int größe;

    /**
     * Legt die benötigten Objekte an.
     */
    Baum()
    {
        super();
        himmel = new Rechteck();
        boden = new Rechteck();
        stamm = new Rechteck();
        krone = new Kreis();
        himmel.FarbeSetzen("blau");
        himmel.GrößeSetzen(800, 300);
        himmel.PositionSetzen(0, 0);
        boden.FarbeSetzen("grün");
        boden.GrößeSetzen(800, 300);
        boden.PositionSetzen(0, 300);
        stamm.FarbeSetzen("braun");
        größe = 100;
        stamm.GrößeSetzen(30, größe);
        stamm.PositionSetzen(385, 380 - größe);
        krone.PositionSetzen(400, 300 - (2 * größe / 3));
        krone.RadiusSetzen(größe / 2);
        FrühlingSetzen();
    }

    /**
     * Stellt den Baum im Winter dar
     */
    void WinterSetzen()
    {
        jahreszeit = "Winter";
        krone.FarbeSetzen("weiß");
    }

    /**
     * Stellt den Baum im Frühling dar
     */
    void FrühlingSetzen()
    {
        jahreszeit = "Frühling";
        krone.FarbeSetzen("hellgrün");
    }

    /**
     * Stellt den Baum im Sommer dar
     */
    void SommerSetzen()
    {
        jahreszeit = "Sommer";
        krone.FarbeSetzen("grün");
    }

    /**
     * Stellt den Baum im Herbst dar
     */
    void HerbstSetzen()
    {
        jahreszeit = "Herbst";
        krone.FarbeSetzen("orange");
    }

    /**
     * Lässt den Baum wachsen
     */
    void Wachsen()
    {
        größe = größe + 4;
        stamm.GrößeSetzen(30, größe);
        stamm.PositionSetzen(385, 380 - größe);
        krone.PositionSetzen(400, 300 - (2 * größe / 3));
        krone.RadiusSetzen(größe / 2);
    }

    /**
     * Der Baum tut nichts automatisch
     */
    @Override
    void AktionAusführen()
    {
    }
}
