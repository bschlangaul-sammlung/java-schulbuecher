
/**
 * Zeichnet die Hilbert-Kurve
 * 
 * @author Albert Wiedemann 
 * @version 1.0
 */
class Hilbert
{
    /** Die Turtle */
    private Turtle t;
    /** Linienlänge */
    private double länge;

    /**
     * Legt die Turtle an und startet die Zeichnung
     * @param tiefe Rekursionstiefe
     */
    Hilbert(int tiefe)
    {
        t = new Turtle();
        länge = 400.0 / Math.pow(2.0, tiefe);
        t.StiftHeben();
        t.PositionSetzen((int) (länge / 2.0), (int) (länge / 2.0));
        t.StiftSenken();
        Element(false, tiefe);
    }
    
    /**
     * Dreht um 90° nach links oder rechts
     * @param links wenn wahr, dann Linksdrehung
     */
    private void Drehen(boolean links)
    {
        if (links)
        {
            t.Drehen(90);
        }
        else
        {
            t.Drehen(-90);
        }
    }
    
    /**
     * Zeichnet ein Element der Kurve
     * @param links wenn wahr, dann Linksdrehung
     * @param stufe restliche Rekursionstiefe
     */
    private void Element(boolean links, int stufe)
    {
        if (stufe > 0)
        {
            Drehen(links);
            Element(!links, stufe - 1);
            t.Gehen(länge);
            Drehen(!links);
            Element(links, stufe - 1);
            t.Gehen(länge);
            Element(links, stufe - 1);
            Drehen(!links);
            t.Gehen(länge);
            Element(!links, stufe - 1);
            Drehen(links);
        }
    }
}
