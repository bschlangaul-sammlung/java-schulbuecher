package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_04.aufgabe_02.taschenlampe;

/**
 * Stellt eine Taschenlampe dar
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Taschenlampe
{
    /**
     * Lampe
     */
    Dreieck lampe;

    /**
     * Zustand
     */
    String zustand;

    /**
     * Legt die benötigten Objekte an und richtet sie ein.
     */
    Taschenlampe()
    {
        Rechteck hintergrund = new Rechteck();
        hintergrund.GrößeSetzen(800, 600);
        hintergrund.PositionSetzen(0, 0);
        hintergrund.FarbeSetzen("weiß");
        lampe = new Dreieck();
        lampe.GrößeSetzen(200, 200);
        lampe.PositionSetzen(100, 200);
        lampe.Drehen(-90);
        lampe.FarbeSetzen("weiß");
        Rechteck schirmVorne = new Rechteck();
        schirmVorne.GrößeSetzen(50, 200);
        schirmVorne.PositionSetzen(100, 200);
        schirmVorne.FarbeSetzen("grau");
        Dreieck schirmHinten = new Dreieck();
        schirmHinten.GrößeSetzen(200, 200);
        schirmHinten.PositionSetzen(250, 200);
        schirmHinten.Drehen(-90);
        schirmHinten.FarbeSetzen("grau");
        Rechteck korpus = new Rechteck();
        korpus.GrößeSetzen(300, 100);
        korpus.PositionSetzen(200, 250);
        korpus.FarbeSetzen("grau");
        Rechteck schalter = new Rechteck();
        schalter.GrößeSetzen(75, 25);
        schalter.PositionSetzen(300, 225);
        schalter.FarbeSetzen("schwarz");
        zustand = "aus";
    }

    /**
     * Schaltet die Taschenlampe aus
     */
    void Ausschalten()
    {
        lampe.FarbeSetzen("weiß");
        zustand = "aus";
    }

    /**
     * Schaltet die Taschenlampe ein
     */
    void Einschalten()
    {
        lampe.FarbeSetzen("gelb");
        zustand = "ein";
    }

    /**
     * Schaltet die Taschenlampe blinkend
     */
    void Blinken()
    {
        lampe.FarbeSetzen("orange");
        zustand = "blinkend";
    }

    /**
     * Schaltet die Taschenlampe gemäß der Vorgabe weiter
     */
    void SchalterDrücken()
    {
        if (zustand == "aus")
        {
            Einschalten();
        }
        else
        {
            if (zustand == "ein")
            {
                Blinken();
            }
            else
            {
                Ausschalten();
            }
        }
    }
}
