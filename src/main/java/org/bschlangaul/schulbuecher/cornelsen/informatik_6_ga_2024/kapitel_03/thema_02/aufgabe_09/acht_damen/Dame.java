package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_03.thema_02.aufgabe_09.acht_damen;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Dreieck;
import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Kreis;
import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Rechteck;

/**
 * Stellt eine Dame auf der Grafikoberfläche dar.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Dame
{
    /**
     * x-Position der Dame
     */
    private int x;

    /**
     * y-Position der Dame
     */
    private int y;

    /**
     * Das Basisrechteck
     */
    private Rechteck basis;

    /** 1. Zacke der Krone */
    private Dreieck zacke1;

    /** 2. Zacke der Krone */
    private Dreieck zacke2;

    /** 3. Zacke der Krone */
    private Dreieck zacke3;

    /** 4. Zacke der Krone */
    private Dreieck zacke4;

    /**
     * Kreis auf der 1. Zacke
     */
    private Kreis kreis1;

    /**
     * Kreis auf der 2. Zacke
     */
    private Kreis kreis2;

    /**
     * Kreis auf der 3. Zacke
     */
    private Kreis kreis3;

    /**
     * Kreis auf der 4. Zacke
     */
    private Kreis kreis4;

    /**
     * Erzeugt die Einzelteile der Dame
     */
    Dame()
    {
        x = 50;
        y = 50;
        basis = new Rechteck();
        basis.FarbeSetzen("orange");
        basis.GrößeSetzen(40, 10);
        zacke1 = new Dreieck();
        zacke1.FarbeSetzen("orange");
        zacke1.GrößeSetzen(10, 20);
        zacke2 = new Dreieck();
        zacke2.FarbeSetzen("orange");
        zacke2.GrößeSetzen(10, 20);
        zacke3 = new Dreieck();
        zacke3.FarbeSetzen("orange");
        zacke3.GrößeSetzen(10, 20);
        zacke4 = new Dreieck();
        zacke4.FarbeSetzen("orange");
        zacke4.GrößeSetzen(10, 20);
        kreis1 = new Kreis();
        kreis1.FarbeSetzen("orange");
        kreis1.RadiusSetzen(2);
        kreis2 = new Kreis();
        kreis2.FarbeSetzen("orange");
        kreis2.RadiusSetzen(2);
        kreis3 = new Kreis();
        kreis3.FarbeSetzen("orange");
        kreis3.RadiusSetzen(2);
        kreis4 = new Kreis();
        kreis4.FarbeSetzen("orange");
        kreis4.RadiusSetzen(2);
        PositionSetzen(0, 0);
    }

    /**
     * Ordnet die Teile gemäß der Position an.
     */
    void Anordnen()
    {
        basis.PositionSetzen(x + 5, y + 35);
        zacke1.PositionSetzen(x + 10, y + 15);
        zacke2.PositionSetzen(x + 20, y + 15);
        zacke3.PositionSetzen(x + 30, y + 15);
        zacke4.PositionSetzen(x + 40, y + 15);
        kreis1.PositionSetzen(x + 10, y + 13);
        kreis2.PositionSetzen(x + 20, y + 13);
        kreis3.PositionSetzen(x + 30, y + 13);
        kreis4.PositionSetzen(x + 40, y + 13);
    }

    /**
     * Setzt die Position auf dem Schachbrett Das Brett hat links oben die
     * Koordinaten (50|50)
     *
     * @param zeile Zeilennummer des Brettes (0 - 7)
     * @param spalte Spaltennummer des Brettes (0 - 7)
     */
    void PositionSetzen(int zeile, int spalte)
    {
        x = 50 + spalte * 50;
        y = 400 - zeile * 50;
        Anordnen();
    }

    /**
     * Steuert die Sichtbarkeit der Dame
     *
     * @param sichtbar wenn wahr, wird die Dame angezeigt
     */
    void SichtbarkeitSetzen(boolean sichtbar)
    {
        basis.SichtbarkeitSetzen(sichtbar);
        zacke1.SichtbarkeitSetzen(sichtbar);
        zacke2.SichtbarkeitSetzen(sichtbar);
        zacke3.SichtbarkeitSetzen(sichtbar);
        zacke4.SichtbarkeitSetzen(sichtbar);
        kreis1.SichtbarkeitSetzen(sichtbar);
        kreis2.SichtbarkeitSetzen(sichtbar);
        kreis3.SichtbarkeitSetzen(sichtbar);
        kreis4.SichtbarkeitSetzen(sichtbar);
    }
}
