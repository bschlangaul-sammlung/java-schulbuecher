
/**
 * Zeichnet die Levy-C-Kurve
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
class Kurve
{
    /**
     * Die Turtle */
    private Turtle t;

    /**
     * Legt die Turtle an
     */
    Kurve ()
    {
        t = new Turtle();
        t.StiftHeben();
        t.PositionSetzen(350, 250);
        t.StiftSenken();
    }

    /**
     * Zeichnet die Levy-C-Kurve mit der gegebenen Tiefe in der angegebenen Farbe.
     * @param tiefe Rekursionstiefe
     * @param farbe die Linienfarbe
     */
    void KurveZeichnen (int tiefe, String farbe)
    {
        t.Löschen();
        t.FarbeSetzen(farbe);
        t.PositionSetzen(350, 250);
        SchrittAusführen(150, tiefe);
        t.Drehen(90);
        SchrittAusführen(150, tiefe);
        t.Drehen(90);
        SchrittAusführen(150, tiefe);
        t.Drehen(90);
        SchrittAusführen(150, tiefe);
        t.Drehen(90);
    }

    /**
     * Zeichnet die Levy-C-Kurve mit den Tiefen 0 bis 3
     */
    void KurveZeichnen0bis3 ()
    {
        t.Löschen();
        t.FarbeSetzen("schwarz");
        t.PositionSetzen(350, 250);
        SchrittAusführen (150, 0);
        t.FarbeSetzen("rot");
        t.PositionSetzen(350, 250);
        SchrittAusführen (150, 1);
        t.FarbeSetzen("grün");
        t.PositionSetzen(350, 250);
        SchrittAusführen (150, 2);
        t.FarbeSetzen("blau");
        t.PositionSetzen(350, 250);
        SchrittAusführen (150, 3);
    }

    /**
     * Zeichnet ein Element der Kurve durch Ausführen des nächsten Rekursionsschrittes
     * @param länge die Linienlänge
     * @param tiefe die (restliche) Rekursionstiefe
     */
    private void SchrittAusführen(double länge, int tiefe)
    {
        if (tiefe > 0)
        {
            t.Drehen(45);
            SchrittAusführen(länge * 0.7071, tiefe - 1);
            t.Drehen(-90);
            SchrittAusführen(länge * 0.7071, tiefe - 1);
            t.Drehen(45);
        }
        else
        {
            t.Gehen(länge);
        }
    }
}
