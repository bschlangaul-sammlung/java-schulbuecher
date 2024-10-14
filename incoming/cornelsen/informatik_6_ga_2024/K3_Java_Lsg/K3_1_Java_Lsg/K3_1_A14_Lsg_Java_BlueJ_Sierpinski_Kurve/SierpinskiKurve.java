
/**
 * Zeichnet die Sierpinski-Kurve
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
class SierpinskiKurve
{
    /**
     * Die Turtle */
    private Turtle t;
    /**
     * Linienlänge */
    private double länge;
    /**
     * Länge der Kurzen Linien */
    private double länge2;

    /**
     * Legt die Turtle an und startet die Zeichnung
     * @param tiefe Rekursionstiefe
     */
    SierpinskiKurve(int tiefe)
    {
        t = new Turtle();
        länge = 125;
        double x0 = 400;
        double y0 = 250 - länge;
        for (int i = 1; i <= tiefe; i += 1)
        {
            x0 -= länge;
            länge = länge / 2.0;
            y0 -= länge;
        }
        länge2 = länge * 1.414213562373095;
        länge = länge * 2.0;
        t.StiftHeben();
        t.PositionSetzen((int) x0, (int) y0);
        t.StiftSenken();
        ElementAZeichnen(tiefe);
        t.WinkelSetzen(315);
        t.Gehen(länge2);
        ElementBZeichnen(tiefe);
        t.WinkelSetzen(225);
        t.Gehen(länge2);
        ElementCZeichnen(tiefe);
        t.WinkelSetzen(135);
        t.Gehen(länge2);
        ElementDZeichnen(tiefe);
        t.WinkelSetzen(45);
        t.Gehen(länge2);
    }

    /**
     * Zeichnet das Element A der Sierpinski-Kurve
     * @param tiefe Rekursionstiefe
     */
    private void ElementAZeichnen (int tiefe)
    {
        if (tiefe > 0)
        {
            ElementAZeichnen(tiefe - 1);
            t.WinkelSetzen(315);
            t.Gehen(länge2);
            ElementBZeichnen(tiefe - 1);
            t.WinkelSetzen(0);
            t.Gehen(länge);
            ElementDZeichnen(tiefe - 1);
            t.WinkelSetzen(45);
            t.Gehen(länge2);
            ElementAZeichnen(tiefe - 1);
        }
    }

    /**
     * Zeichnet das Element B der Sierpinski-Kurve
     * @param tiefe Rekursionstiefe
     */
    private void ElementBZeichnen (int tiefe)
    {
        if (tiefe > 0)
        {
            ElementBZeichnen(tiefe - 1);
            t.WinkelSetzen(225);
            t.Gehen(länge2);
            ElementCZeichnen(tiefe - 1);
            t.WinkelSetzen(270);
            t.Gehen(länge);
            ElementAZeichnen(tiefe - 1);
            t.WinkelSetzen(315);
            t.Gehen(länge2);
            ElementBZeichnen(tiefe - 1);
        }
    }

    /**
     * Zeichnet das Element C der Sierpinski-Kurve
     * @param tiefe Rekursionstiefe
     */
    private void ElementCZeichnen (int tiefe)
    {
        if (tiefe > 0)
        {
            ElementCZeichnen(tiefe - 1);
            t.WinkelSetzen(135);
            t.Gehen(länge2);
            ElementDZeichnen(tiefe - 1);
            t.WinkelSetzen(180);
            t.Gehen(länge);
            ElementBZeichnen(tiefe - 1);
            t.WinkelSetzen(225);
            t.Gehen(länge2);
            ElementCZeichnen(tiefe - 1);
        }
    }

    /**
     * Zeichnet das Element D der Sierpinski-Kurve
     * @param tiefe Rekursionstiefe
     */
    private void ElementDZeichnen (int tiefe)
    {
        if (tiefe > 0)
        {
            ElementDZeichnen(tiefe - 1);
            t.WinkelSetzen(45);
            t.Gehen(länge2);
            ElementAZeichnen(tiefe - 1);
            t.WinkelSetzen(90);
            t.Gehen(länge);
            ElementCZeichnen(tiefe - 1);
            t.WinkelSetzen(135);
            t.Gehen(länge2);
            ElementDZeichnen(tiefe - 1);
        }
    }
}
