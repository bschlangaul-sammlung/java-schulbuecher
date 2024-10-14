
/**
 * Zeichnet den Pythagorasbaum.
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
class PythagorasBaum
{
    /**
     * die Turtle */
    Turtle turtle;
    /**
     * Seite a des rechtwinkeligen Ausgangsdreiecks */
    double a;
    /**
     * Seite b des rechtwinkeligen Ausgangsdreiecks */
    double b;
    /**
     * Seite c^2 des rechtwinkeligen Ausgangsdreiecks */
    double c2;
    /**
     * Seitenverhältnis für die Berechnung der C-Punkte der angefügten Dreiecke */
    double bc;
    /**
     * Seitenverhältnis für die Berechnung der C-Punkte der angefügten Dreiecke */
    double abc;

    /**
     * Besetzt die Konstanten und baut den Baum auf.
     * @param tiefe die Rekursionstiefe
     */
    PythagorasBaum (int tiefe)
    {
        turtle = new Turtle();
        //a = 300.0;
        //b = 400.0;
        a = 100.0;
        b = 100.0;
        //a = 120.0;
        //b = 50.0;
        c2 = a * a + b * b;
        bc = (b * b) / c2;
        abc = a * b / c2;
        ViereckZeichnen(400.0, 100.0, 500.0, 100.0, 500.0, 200.0, 400.0, 200.0);
        SchrittAusführen(400.0, 200.0, 500.0, 200.0, tiefe);
    }

    /**
     * Berechnet die Richtung von Startpunkt zum Zielpunkt.
     * @param xStart x-Koordinate des Startpunkts
     * @param yStart y-Koordinate des Startpunkts
     * @param xZiel x-Koordinate des Zielpunkts
     * @param yZiel y-Koordinate des Zielpunkts
     * @return Richtungswinkel zum Zielpunkt
     */
    private int RichtungGeben(double xStart, double yStart, double xZiel, double yZiel)
    {
        double dx = xZiel - xStart;
        double dy = yZiel - yStart;
        int richtung = 0;
        if (dx == 0)
        {
            if (dy > 0)
            {
                richtung = 270;
            }
            else if (dy < 0)
            {
                richtung = 90;
            }
        }
        else if (dx > 0)
        {
            richtung = -((int) Math.round(Math.atan(dy / dx) * 180.0 / Math.PI));
        }
        else
        {
            richtung = 180 - ((int) Math.round(Math.atan(dy / dx) * 180.0 / Math.PI));
        }
        return richtung;
    }

    /**
     * Berechnet die Weglänge von Startpunkt zum Zielpunkt.
     * @param xStart x-Koordinate des Startpunkts
     * @param yStart y-Koordinate des Startpunkts
     * @param xZiel x-Koordinate des Zielpunkts
     * @param yZiel y-Koordinate des Zielpunkts
     * @return Weglänge zum Zielpunkt
     */
    private double LängeGeben(double xStart, double yStart, double xZiel, double yZiel)
    {
        double dx = xZiel - xStart;
        double dy = yZiel - yStart;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Zeichnet das Dreieck mit den angegebenen Eckpunkten
     * @param ax x-Koordinate der Ecke A
     * @param ay y-Koordinate der Ecke A
     * @param bx x-Koordinate der Ecke B
     * @param by y-Koordinate der Ecke B
     * @param cx x-Koordinate der Ecke C
     * @param cy y-Koordinate der Ecke C
     */
    private void DreieckZeichnen(double ax, double ay, double bx, double by, double cx, double cy)
    {
        turtle.PositionSetzen((int) ax, (int) ay);
        turtle.WinkelSetzen(RichtungGeben(ax, ay, bx, by));
        turtle.Gehen(LängeGeben(ax, ay, bx, by));
        turtle.WinkelSetzen(RichtungGeben(bx, by, cx, cy));
        turtle.Gehen(LängeGeben(bx, by, cx, cy));
        turtle.WinkelSetzen(RichtungGeben(cx, cy, ax, ay));
        turtle.Gehen(LängeGeben(cx, cy, ax, ay));
    }

    /**
     * Zeichnet das Viereck mit den angegebenen Eckpunkten
     * @param ax x-Koordinate der Ecke A
     * @param ay y-Koordinate der Ecke A
     * @param bx x-Koordinate der Ecke B
     * @param by y-Koordinate der Ecke B
     * @param cx x-Koordinate der Ecke C
     * @param cy y-Koordinate der Ecke C
     * @param dx x-Koordinate der Ecke D
     * @param dy y-Koordinate der Ecke D
     */
    private void ViereckZeichnen (double ax, double ay, double bx, double by, double cx, double cy, double dx, double dy)
    {
        turtle.PositionSetzen((int) ax, (int) ay);
        turtle.WinkelSetzen(RichtungGeben(ax, ay, bx, by));
        turtle.Gehen(LängeGeben(ax, ay, bx, by));
        turtle.WinkelSetzen(RichtungGeben(bx, by, cx, cy));
        turtle.Gehen(LängeGeben(bx, by, cx, cy));
        turtle.WinkelSetzen(RichtungGeben(cx, cy, dx, dy));
        turtle.Gehen(LängeGeben(cx, cy, dx, dy));
        turtle.WinkelSetzen(RichtungGeben(dx, dy, ax, ay));
        turtle.Gehen(LängeGeben(dx, dy, ax, ay));
    }

    /**
     * Führt einen Rekursionsschritt aus
     * @param ax x-Koordinate der Ecke A der Basislinie
     * @param ay y-Koordinate der Ecke A der Basislinie
     * @param bx x-Koordinate der Ecke B der Basislinie
     * @param by y-Koordinate der Ecke B der Basislinie
     * @param tiefe die Rekursionstiefe
     */
    private void SchrittAusführen(double ax, double ay, double bx, double by, int tiefe)
    {
		if (tiefe > 0)
		{
            double cx = ax + (bx - ax) * bc - (by - ay) * abc;
            double cy = ay + (by - ay) * bc + (bx - ax) * abc;
            DreieckZeichnen(ax, ay, bx, by, cx, cy);
            double p1x = ax - (cy - ay);
            double p1y = ay + (cx - ax);
            double p2x = cx - (cy - ay);
            double p2y = cy + (cx - ax);
            ViereckZeichnen(ax, ay, cx, cy, p2x, p2y, p1x, p1y);
            SchrittAusführen(p1x, p1y, p2x, p2y, tiefe - 1);
            p1x = cx - (by - cy);
            p1y = cy + (bx - cx);
            p2x = bx - (by - cy);
            p2y = by + (bx - cx);
            ViereckZeichnen(cx, cy, bx, by, p2x, p2y, p1x, p1y);
            SchrittAusführen(p1x, p1y, p2x, p2y, tiefe - 1);
        }
    }
}
