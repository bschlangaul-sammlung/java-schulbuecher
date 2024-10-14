package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_01.aufgabe_08.spielwelt_2d;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Rechteck;

/**
 * Legt das Spielfeld an und die nicht beweglichen Objekte
 *
 * @author Peter Brichzin
 *
 * @version 12.12.19
 */
class KleineWelt
{
    /**
     * Baut das Szenario auf.
     */
    KleineWelt()
    {
        Rechteck rechteck0;
        rechteck0 = new Rechteck();
        rechteck0.PositionSetzen(2, 2);
        rechteck0.GrößeSetzen(96, 96);
        rechteck0.FarbeSetzen("blau");
        Rechteck rechteck1;
        rechteck1 = new Rechteck();
        rechteck1.PositionSetzen(102, 2);
        rechteck1.GrößeSetzen(96, 96);
        rechteck1.FarbeSetzen("blau");
        Rechteck rechteck2;
        rechteck2 = new Rechteck();
        rechteck2.PositionSetzen(202, 2);
        rechteck2.GrößeSetzen(96, 96);
        rechteck2.FarbeSetzen("blau");
        Rechteck rechteck3;
        rechteck3 = new Rechteck();
        rechteck3.PositionSetzen(2, 102);
        rechteck3.GrößeSetzen(96, 96);
        rechteck3.FarbeSetzen("blau");
        Rechteck rechteck4;
        rechteck4 = new Rechteck();
        rechteck4.PositionSetzen(102, 102);
        rechteck4.GrößeSetzen(96, 96);
        rechteck4.FarbeSetzen("blau");
        Rechteck rechteck5;
        rechteck5 = new Rechteck();
        rechteck5.PositionSetzen(202, 102);
        rechteck5.GrößeSetzen(96, 96);
        rechteck5.FarbeSetzen("blau");
        Rechteck rechteck6;
        rechteck6 = new Rechteck();
        rechteck6.PositionSetzen(2, 202);
        rechteck6.GrößeSetzen(96, 96);
        rechteck6.FarbeSetzen("blau");
        Rechteck rechteck7;
        rechteck7 = new Rechteck();
        rechteck7.PositionSetzen(102, 202);
        rechteck7.GrößeSetzen(96, 96);
        rechteck7.FarbeSetzen("blau");
        Rechteck rechteck8;
        rechteck8 = new Rechteck();
        rechteck8.PositionSetzen(202, 202);
        rechteck8.GrößeSetzen(96, 96);
        rechteck8.FarbeSetzen("blau");
    }

    public static void main(String[] args)
    {
        new KleineWelt();
    }
}
