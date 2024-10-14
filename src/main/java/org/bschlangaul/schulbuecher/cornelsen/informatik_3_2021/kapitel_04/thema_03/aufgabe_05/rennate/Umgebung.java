package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_03.aufgabe_05.rennate;

/**
 * Baut die Verkehrsinsel auf.
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Umgebung
{
    TurtleRennate t;

    Rechteck r1;

    Kreis k1;

    Kreis k2;

    Umgebung()
    {
        r1 = new Rechteck();
        r1.PositionSetzen(0, 0);
        r1.FarbeSetzen("grau");
        r1.GrößeSetzen(800, 600);
        k1 = new Kreis();
        k1.PositionSetzen(400, 250);
        k1.FarbeSetzen("grün");
        k1.RadiusSetzen(200);
        k2 = new Kreis();
        k2.PositionSetzen(400, 250);
        k2.FarbeSetzen("rot");
        k2.RadiusSetzen(100);
        t = new TurtleRennate();
        t.StiftHeben();
        t.Gehen(110);
        t.Drehen(40);
        t.SpazierenGehen();
    }
}
