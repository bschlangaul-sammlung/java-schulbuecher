package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_03.aufgabe_07.parkett;

/**
 * Die Turtle legt Parkettböden.
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class ParkettTurtle extends Turtle
{
    /**
     * Der Konstruktor positioniert die Turtle
     */
    ParkettTurtle()
    {
        super();
        GanzNachVornBringen();
        PositionSetzen(10, 15);
        StiftSenken();
    }

    /**
     * Zeichnet ein rotes Parallelogrammelement
     */
    void ParallelogrammRotZeichnen()
    {
        FarbeSetzen("blau");
        ParallelogrammZeichnen();
    }

    /**
     * Zeichnet ein grünes Parallelogrammelement
     */
    void ParallelogrammGrünZeichnen()
    {
        FarbeSetzen("grün");
        ParallelogrammZeichnen();
    }

    /**
     * Zeichnet ein Parallelogrammelement in der eingestellten Farbe
     */
    void ParallelogrammZeichnen()
    {
        // vor
        Gehen(10);
        // zurück
        Drehen(90);
        Gehen(1);
        Drehen(90);
        Gehen(9);
        Drehen(180);
        // vor
        Gehen(10);
        // zurück
        Drehen(90);
        Gehen(1);
        Drehen(90);
        Gehen(9);
        Drehen(180);
        // vor
        Gehen(10);
        // zurück
        Drehen(90);
        Gehen(1);
        Drehen(90);
        Gehen(9);
        Drehen(180);
        // vor
        Gehen(10);
        // zurück
        Drehen(90);
        Gehen(1);
        Drehen(90);
        Gehen(9);
        Drehen(180);
        // vor
        Gehen(10);
        // zurück
        Drehen(90);
        Gehen(1);
        Drehen(90);
        Gehen(9);
        Drehen(180);
        Gehen(4);
        Drehen(-90);
        Gehen(5);
        Drehen(90);
    }

    /**
     * Legt eine Reihe aus grünen und roten Elementen
     */
    void GrünRotReiheLegen()
    {
        while (XPositionGeben() < 700)
        {
            ParallelogrammGrünZeichnen();
            ParallelogrammRotZeichnen();
        }
        Drehen(180);
        StiftHeben();
        while (XPositionGeben() > 10)
        {
            Gehen(1);
        }
        Drehen(90);
        Gehen(5);
        Drehen(90);
        StiftSenken();
    }

    /**
     * Legt eine Reihe aus roten und grünen Elementen
     */
    void RotGrünReiheLegen()
    {
        while (XPositionGeben() < 700)
        {
            ParallelogrammRotZeichnen();
            ParallelogrammGrünZeichnen();
        }
        Drehen(180);
        StiftHeben();
        while (XPositionGeben() > 10)
        {
            Gehen(1);
        }
        Drehen(90);
        Gehen(5);
        Drehen(90);
        StiftSenken();
    }

    /**
     * Legt das Parkett über die ganze Zeichenfläche
     */
    void ParkettLegen()
    {
        while (YPositionGeben() < 500)
        {
            GrünRotReiheLegen();
            RotGrünReiheLegen();
        }
    }

    /**
     * Zeichnet ein Pfeilelement in der eingestellten Farbe
     */
    void PfeilZeichnen()
    {
        // vor
        Gehen(10);
        // zurück
        Drehen(90);
        Gehen(1);
        Drehen(90);
        Gehen(9);
        Drehen(180);
        // vor
        Gehen(10);
        // zurück
        Drehen(90);
        Gehen(1);
        Drehen(90);
        Gehen(9);
        Drehen(180);
        // vor
        Gehen(10);
        // zurück
        Drehen(90);
        Gehen(1);
        Drehen(90);
        Gehen(9);
        Drehen(180);
        // vor
        Gehen(10);
        // zurück
        Drehen(90);
        Gehen(1);
        Drehen(90);
        Gehen(9);
        Drehen(180);
        // vor
        Gehen(10);
        // zurück
        Drehen(90);
        Gehen(1);
        Drehen(90);
        Gehen(10);
        Drehen(180);
        // vor
        Gehen(10);
        // zurück
        Drehen(180);
        Gehen(1);
        Drehen(-90);
        Gehen(1);
        Drehen(90);
        Gehen(10);
        Drehen(180);
        // vor
        Gehen(10);
        // zurück
        Drehen(180);
        Gehen(1);
        Drehen(-90);
        Gehen(1);
        Drehen(90);
        Gehen(10);
        Drehen(180);
        // vor
        Gehen(10);
        // zurück
        Drehen(180);
        Gehen(1);
        Drehen(-90);
        Gehen(1);
        Drehen(90);
        Gehen(10);
        Drehen(180);
        // vor
        Gehen(10);
        // zurück
        Drehen(180);
        Gehen(1);
        Drehen(-90);
        Gehen(1);
        Drehen(90);
        Gehen(10);
        Drehen(180);
        // vor
        Gehen(10);
        // zur nächsten Position
        Drehen(-90);
        Gehen(9);
        Drehen(90);
    }

    /**
     * Zeichnet ein gelbes Pfeilelement
     */
    void PfeilGelbZeichnen()
    {
        FarbeSetzen("gelb");
        PfeilZeichnen();
    }

    /**
     * Zeichnet ein hellgrünes Pfeilelement
     */
    void PfeilHellgrünZeichnen()
    {
        FarbeSetzen("hellgrün");
        PfeilZeichnen();
    }

    /**
     * Legt eine Reihe aus hellgrünen und gelben Pfeilelementen
     */
    void HellgrünGelbReiheLegen()
    {
        while (XPositionGeben() < 700)
        {
            PfeilHellgrünZeichnen();
            PfeilGelbZeichnen();
        }
        Drehen(180);
        StiftHeben();
        while (XPositionGeben() > 10)
        {
            Gehen(1);
        }
        Drehen(90);
        Gehen(10);
        Drehen(90);
        StiftSenken();
    }

    /**
     * Legt das Parkett aus Pfeilen über die ganze Zeichenfläche
     */
    void ParkettLegen2()
    {
        while (YPositionGeben() < 500)
        {
            HellgrünGelbReiheLegen();
        }
    }
}
