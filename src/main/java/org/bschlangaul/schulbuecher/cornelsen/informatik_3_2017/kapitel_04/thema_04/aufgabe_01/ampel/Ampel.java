package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_04.aufgabe_01.ampel;

/**
 * Stellt eine einfache Ampel dar
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Ampel
{
    /**
     * obere Lampe
     */
    Kreis lampeOben;

    /**
     * mittlere Lampe
     */
    Kreis lampeMitte;

    /**
     * untere Lampe
     */
    Kreis lampeUnten;

    /**
     * Ampelphase
     */
    String ampelphase;

    /**
     * Legt die benötigten Objekte an und richtet sie ein.
     */
    Ampel()
    {
        Rechteck hilf = new Rechteck();
        hilf.PositionSetzen(100, 50);
        hilf.GrößeSetzen(50, 150);
        hilf.FarbeSetzen("schwarz");
        hilf = new Rechteck();
        hilf.PositionSetzen(103, 53);
        hilf.GrößeSetzen(44, 144);
        hilf.FarbeSetzen("weiß");
        hilf = new Rechteck();
        hilf.PositionSetzen(100, 98);
        hilf.GrößeSetzen(50, 4);
        hilf.FarbeSetzen("schwarz");
        hilf = new Rechteck();
        hilf.PositionSetzen(100, 148);
        hilf.GrößeSetzen(50, 4);
        hilf.FarbeSetzen("schwarz");
        lampeOben = new Kreis();
        lampeOben.PositionSetzen(125, 75);
        lampeOben.RadiusSetzen(20);
        lampeOben.FarbeSetzen("rot");
        lampeMitte = new Kreis();
        lampeMitte.PositionSetzen(125, 125);
        lampeMitte.RadiusSetzen(20);
        lampeMitte.FarbeSetzen("schwarz");
        lampeUnten = new Kreis();
        lampeUnten.PositionSetzen(125, 175);
        lampeUnten.RadiusSetzen(20);
        lampeUnten.FarbeSetzen("schwarz");
        ampelphase = "rot";
    }

    /**
     * Setzt die Ampel auf rot
     */
    void RotSetzen()
    {
        lampeOben.FarbeSetzen("rot");
        lampeMitte.FarbeSetzen("schwarz");
        lampeUnten.FarbeSetzen("schwarz");
        ampelphase = "rot";
    }

    /**
     * Setzt die Ampel auf rot-gelb
     */
    void RotGelbSetzen()
    {
        lampeOben.FarbeSetzen("rot");
        lampeMitte.FarbeSetzen("gelb");
        lampeUnten.FarbeSetzen("schwarz");
        ampelphase = "rotgelb";
    }

    /**
     * Setzt die Ampel auf grün
     */
    void GrünSetzen()
    {
        lampeOben.FarbeSetzen("schwarz");
        lampeMitte.FarbeSetzen("schwarz");
        lampeUnten.FarbeSetzen("grün");
        ampelphase = "grün";
    }

    /**
     * Setzt die Ampel auf gelb
     */
    void GelbSetzen()
    {
        lampeOben.FarbeSetzen("schwarz");
        lampeMitte.FarbeSetzen("gelb");
        lampeUnten.FarbeSetzen("schwarz");
        ampelphase = "gelb";
    }

    /**
     * Schaltet die Ampel gemäß der StVO weiter
     */
    void Weiterschalten()
    {
        if (ampelphase == "rot")
        {
            RotGelbSetzen();
        }
        else
        {
            if (ampelphase == "rotgelb")
            {
                GrünSetzen();
            }
            else
            {
                if (ampelphase == "grün")
                {
                    GelbSetzen();
                }
                else
                {
                    RotSetzen();
                }
            }
        }
    }
}
