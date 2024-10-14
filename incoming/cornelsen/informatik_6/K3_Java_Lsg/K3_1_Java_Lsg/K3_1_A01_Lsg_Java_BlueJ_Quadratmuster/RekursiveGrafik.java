
/**
 * Rahmenklasse zum Zeichen von Mustern aus Quadraten
 * 
 * @author Albert Wiedemann
 * @version 1.0
 */
class RekursiveGrafik
{
    /** Die Turtle zum Zeichnen */
    Turtle turtle;

    /**
     * Der Konstruktor legt die Turtle an.
     */
    RekursiveGrafik ()
    {
        turtle = new Turtle();
        turtle.FarbeSetzen("blau");
        turtle.PositionSetzen(400, 200);
    }
    
    /**
     * Zeichnet ein Quadrat mit gegebener Seitenlänge an der Stelle der Turtle
     * @param länge Seitenlänge des Quadrats
     */
    private void QuadratZeichnen(double länge)
    {
        for (int i = 0; i < 4; i += 1)
        {
            turtle.Gehen(länge);
            turtle.Drehen(-90);
        }
    }
    
    /**
     * Zeichnet ein Element der Perlenkette
     * @param anzahl (Rest-)anzahl der Quadrate
     */
    void PerlenketteZeichnen (int anzahl)
    {
        if (anzahl == 1)
        {
            QuadratZeichnen(10);
        }
        else
        {
            PerlenketteZeichnen(anzahl - 1);
            turtle.Gehen(20);
            QuadratZeichnen(10);
        }
    }
    
    /**
     * Zeichnet ein Element der Quadratmuster
     * @param anzahl (Rest-)anzahl der Quadrate
     */
    void QuadratmusterZeichnen(int anzahl)
    {
        if (anzahl > 0)
        {
            QuadratZeichnen(anzahl * 10);
            QuadratmusterZeichnen(anzahl - 1);
        }
    }
    
    /**
     * Zeichnet Quadratmuster im Kreis
     * @param gesamtanzahlQuadrate insgesamte Anzahl der Quadrate
     * @param nochZuZeichnendeQuadrate Anzahl der noch zu zeichnenden Quadrate
     */
    void MusterZeichnen(int gesamtanzahlQuadrate, int nochZuZeichnendeQuadrate)
    {
        if (nochZuZeichnendeQuadrate > 0)
        {
            turtle.StiftHeben();
            turtle.Drehen(360 / gesamtanzahlQuadrate);
            turtle.Gehen(50);
            turtle.StiftSenken();
            QuadratZeichnen(20);
            turtle.StiftHeben();
            turtle.Drehen(180);
            turtle.Gehen(50);
            turtle.StiftSenken();
            turtle.Drehen(180);
            MusterZeichnen(gesamtanzahlQuadrate, nochZuZeichnendeQuadrate - 1);
        }
    }
    
    /**
     * Zeichnet Quadratmuster im Kreis mit variablem Radius
     * @param anzahlQuadrate Anzahl der Quadrate
     * @param quadratNummer Nummer des aktuellen Quadrats
     * @param radius der Radius des Kreises mit den Quadraten
     */
    private void MusterZeichnen2(int anzahlQuadrate, int quadratNummer, int radius)
    {
        if (quadratNummer > 0)
        {
            turtle.StiftHeben();
            turtle.Drehen(360 / anzahlQuadrate);
            turtle.Gehen(radius);
            turtle.StiftSenken();
            QuadratZeichnen(radius / 2);
            turtle.StiftHeben();
            turtle.Drehen(180);
            turtle.Gehen(radius);
            turtle.StiftSenken();
            turtle.Drehen(180);
            MusterZeichnen2(anzahlQuadrate, quadratNummer - 1, radius);
        }
    }
    
    /**
     * Zeichnet eine Folge immer kleinerer Quadratkreise
     * @param anzahlQuadrate Anzahl der Quadrate
     * @param quadratNummer Nummer des aktuellen Quadrats
     * @param radius der Radius des Kreises mit den Quadraten
     */
    void QuadratkreiseZeichnen(int anzahlQuadrate, int radius)
    {
        if (radius >= 30)
        {
            MusterZeichnen2(anzahlQuadrate, anzahlQuadrate, radius);
            QuadratkreiseZeichnen(anzahlQuadrate, radius / 2);
        }
    }
}
