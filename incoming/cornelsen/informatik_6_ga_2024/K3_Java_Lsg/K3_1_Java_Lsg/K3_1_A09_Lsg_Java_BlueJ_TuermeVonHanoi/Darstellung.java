
import java.util.*;
/**
 * Verwaltet die Vísualisierung
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
class Darstellung extends Ereignisbehandlung
{
    /**
     * Abstand der Türme */
    static int turmAbstand = 250;
    /**
     * Position des Bodens */
    static int bodenPosition = 400;
    /**
     * Boden */
    private Rechteck boden;
    /**
     * Laufschiene */
    private Rechteck schiene;
    /**
     * Erster Turm */
    private Rechteck turm1;
    /**
     * Zweiter Turm */
    private Rechteck turm2;
    /**
     * Dritter Turm */
    private Rechteck turm3;
    /**
     * Der Laufkran */
    private Kran kran;
    /**
     * Die Scheibenstapel */
    private ArrayList<ArrayList<ScheibenSymbol>> türme;
    /**
     * Tickzähler für die Wartezeit */
    private int wartezeitZähler;

    /**
     * Baut die Darstellung auf und verwaltet die Türme und den Kran
     * @param scheibenAnzahl die Anzahl der Scheiben, die zu Beginn auf dem ersten Turm liegt
     */
    Darstellung (int scheibenAnzahl)
    {
        super();
        TaktdauerSetzen(100);
        wartezeitZähler = 0;
        boden = new Rechteck();
        boden.FarbeSetzen("schwarz");
        boden.PositionSetzen(0, bodenPosition);
        boden.GrößeSetzen(turmAbstand * 3, 5);
        schiene = new Rechteck();
        schiene.FarbeSetzen("schwarz");
        schiene.PositionSetzen(0, 50);
        schiene.GrößeSetzen(turmAbstand * 3, 5);
        turm1 = new Rechteck();
        turm1.FarbeSetzen("schwarz");
        turm1.PositionSetzen(turmAbstand / 2 - 3, bodenPosition - 200);
        turm1.GrößeSetzen(6, 200);
        turm2 = new Rechteck();
        turm2.FarbeSetzen("schwarz");
        turm2.PositionSetzen(turmAbstand * 3 / 2 - 3, bodenPosition - 200);
        turm2.GrößeSetzen(6, 200);
        turm3 = new Rechteck();
        turm3.FarbeSetzen("schwarz");
        turm3.PositionSetzen(turmAbstand * 5 / 2 - 3, bodenPosition - 200);
        turm3.GrößeSetzen(6, 200);
        kran = new Kran();
        türme = new ArrayList<ArrayList<ScheibenSymbol>>();
        türme.add(new ArrayList<ScheibenSymbol>());
        türme.add(new ArrayList<ScheibenSymbol>());
        türme.add(new ArrayList<ScheibenSymbol>());
        for (int i = 0; i < scheibenAnzahl; i += 1)
        {
            ScheibenSymbol neu = new ScheibenSymbol(scheibenAnzahl - i);
            neu.PositionSetzen(0, i);
            türme.get(0).add(neu);

        }
    }

    /**
     * Die eigentliche Aktionsmethode des Zeitgebers.
     * Erniedrigt den Zähler für die Wartezeit
     */
    @Override void TaktImpulsAusführen ()
    {
        wartezeitZähler -= 1;
    }

    /**
     * Bremst den Ablauf, um eine beobachtbare Bewegung zu erhalten.
     * @param ticks die Anzahl der abzuwartenden Ticks der Ereignisbehandlung
     */
    private void Warten (int ticks)
    {
        wartezeitZähler = ticks;
        do
        {
            try
            {
                wait (10);
            }
            catch (Exception e)
            {
            }
        }
        while (wartezeitZähler > 0);
    }

    /**
     * Senkt den Kran, gegebenenfalls mit Scheibe, auf die gewünschte Höhe ab.
     * @param zielHöhe die gewünschte Höhe
     * @param scheibe Referenz der bewegten Scheibe.
     */
    private void Absenken (int zielHöhe, ScheibenSymbol scheibe)
    {
        while (zielHöhe > kran.KranhöheGeben())
        {
            kran.Absenken ();
            if (scheibe != null)
            {
                scheibe.Absenken();
                Warten (3);
            }
            else
            {
                Warten (1);
            }
        }
    }

    /**
     * Hebt den Kran, gegebenenfalls mit Scheibe, auf die Fahrhöhe an.
     * @param scheibe Referenz der bewegten Scheibe.
     */
    private void Anheben (ScheibenSymbol scheibe)
    {
        while (100 < kran.KranhöheGeben())
        {
            kran.Anheben();
            if (scheibe != null)
            {
                scheibe.Anheben();
                Warten (3);
            }
            else
            {
                Warten (1);
            }
        }
    }

    /**
     * Fährt den Kran, gegebenenfalls mit Scheibe, auf die gewünschte Position nach links.
     * @param zielPosition die gewünschte Position
     * @param scheibe Referenz der bewegten Scheibe.
     */
    private void LinksFahren (int zielPosition, ScheibenSymbol scheibe)
    {
        while (zielPosition < kran.KranpositionGeben())
        {
            kran.LinksFahren ();
            if (scheibe != null)
            {
                scheibe.LinksFahren();
                Warten (3);
            }
            else
            {
                Warten (1);
            }
        }
    }

    /**
     * Fährt den Kran, gegebenenfalls mit Scheibe, auf die gewünschte Position nach rechts.
     * @param zielPosition die gewünschte Position
     * @param scheibe Referenz der bewegten Scheibe.
     */
    private void RechtsFahren (int zielPosition, ScheibenSymbol scheibe)
    {
        while (zielPosition > kran.KranpositionGeben())
        {
            kran.RechtsFahren ();
            if (scheibe != null)
            {
                scheibe.RechtsFahren();
                Warten (3);
            }
            else
            {
                Warten (1);
            }
        }
    }

    /**
     * Bewegt die oberste Scheibe vom Startturm zum Zielturm.
     * @param start Nummer des Startturms
     * @param ziel Nummer des Zielturms
     */
    void Bewegen (int start, int ziel)
    {
        int position;
        ScheibenSymbol scheibe;
        int scheibenanzahl;
        scheibenanzahl = türme.get(start).size();
        scheibe = türme.get(start).remove(scheibenanzahl - 1);
        position = turmAbstand / 2 + turmAbstand * start;
        if (position < kran.KranpositionGeben())
        {
            LinksFahren (position, null);
        }
        else if (position > kran.KranpositionGeben())
        {
            RechtsFahren (position, null);
        }
        Absenken (bodenPosition - ScheibenSymbol.basis * scheibenanzahl, null);
        Anheben (scheibe);
        position = turmAbstand / 2 + turmAbstand * ziel;
        if (position < kran.KranpositionGeben())
        {
            LinksFahren(position, scheibe);
        }
        else if (position > kran.KranpositionGeben())
        {
            RechtsFahren(position, scheibe);
        }
        scheibenanzahl = türme.get(ziel).size() + 1;
        Absenken (bodenPosition - ScheibenSymbol.basis * scheibenanzahl, scheibe);
        türme.get(ziel).add(scheibe);
        Anheben (null);
    }

    /**
     * Verschiebt die oberste Scheibe ohne Animation vom Startturm zum Zielturm.
     * @param start Nummer des Startturms
     * @param ziel Nummer des Zielturms
     */
    void Verschieben (int start, int ziel)
    {
        ScheibenSymbol scheibe;
        scheibe = türme.get(start).remove(türme.get(start).size() - 1);
        türme.get(ziel).add(scheibe);
        scheibe.PositionSetzen(ziel, türme.get(ziel).size() - 1);
        Warten(1);
    }
}
