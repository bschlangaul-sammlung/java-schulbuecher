
import java.util.*;
/**
 * Verwaltet das Labyrinth
 * 
 * @author Albert Wiedemann 
 * @version 1.0
 */
class Labyrinth
{
    /** Feld der Labyrinthelemente */
    private ArrayList<ArrayList<LabyrinthElement>> elemente;
    /** Zufallsgenrator */
    private Random zufall;
    /** x-Koordinate des Ausgangs */
    private int xAusgang;
    /** y-Koordinate des Ausgangs */
    private int yAusgang;
    /** x-Koordinate des Startpunkts */
    private int xStart;
    /** y-Koordinate des Startpunkts */
    private int yStart;

    /**
     * Legt die Attribute an.
     * @param breite Breite des Labyrinths in Zellenanzahl
     * @param höhe Höhe des Labyrinths in Zellenanzahl
     */
    Labyrinth (int breite, int höhe)
    {
        zufall = new Random();
        elemente = new ArrayList<ArrayList<LabyrinthElement>>();
        for (int b = 0; b < breite; b += 1)
        {
            elemente.add(new ArrayList<LabyrinthElement>());
            for (int h = 0; h < höhe; h += 1)
            {
                elemente.get(b).add(null);
            }
        }
        xAusgang = -1;
        yAusgang = -1;
        xStart = -1;
        yStart = -1;
    }
    
    /**
     * Generiert das Labyrinth
     */
    void Generieren()
    {
        int dx;
        int dy;
        int xmax = elemente.size();
        int ymax = elemente.get(0).size();
        int minSchritte = xmax * ymax / 3;
        int schritte = 1;
        int x = zufall.nextInt(xmax - 2) + 1;
        int y = zufall.nextInt(ymax - 2) + 1;
        elemente.get(x).set(y, new Gang (x, y));
        
        while(true)
        {
            do
            {
                dx = zufall.nextInt(3) - 1;
                dy = zufall.nextInt(3) - 1;
            } while(Math.abs(dx) == Math.abs(dy));
            x += dx;
            y += dy;
            if ((x == 0) || (y == 0) || (x == xmax - 1) || (y == ymax - 1))
            {
                if ((schritte > minSchritte) && (elemente.get(x).get(y) == null))
                {
                    elemente.get(x).set(y, new Ausgang (x, y));
                    xAusgang = x;
                    yAusgang = y;
                    break;
                }
                else
                {
                    x -= dx;
                    y -= dy;
                }
            }
            else if (elemente.get(x).get(y) == null)
            {
                if ((elemente.get(x - 1).get(y - 1) != null) && (elemente.get(x - 1).get(y) != null) && (elemente.get(x).get(y - 1) != null) ||
                    (elemente.get(x + 1).get(y - 1) != null) && (elemente.get(x + 1).get(y) != null) && (elemente.get(x).get(y - 1) != null) ||
                    (elemente.get(x + 1).get(y + 1) != null) && (elemente.get(x + 1).get(y) != null) && (elemente.get(x).get(y + 1) != null) ||
                    (elemente.get(x - 1).get(y + 1) != null) && (elemente.get(x - 1).get(y) != null) && (elemente.get(x).get(y + 1) != null))
                {
                    x -= dx;
                    y -= dy;
                }
                else
                {
                    schritte += 1;
                    elemente.get(x).set(y, new Gang (x, y));
                }
            }
        }
        for (int b = 0; b < elemente.size(); b += 1)
        {
            for (int h = 0; h < elemente.get(b).size(); h += 1)
            {
                if (elemente.get(b).get(h) == null)
                {
                    elemente.get(b).set(h, new Mauer (b, h));
                }
            }
        }
    }

    /**
     * Erzeugt die Graphendarstellung
     * @param graph das Objekt zur Verwaltung des Graphen
     */
    void GraphErzeugen(GraphMatrix graph)
    {
        for (int x = 0; x < elemente.size(); x += 1)
        {
            for (int y = 0; y < elemente.get(x).size(); y += 1)
            {
                if (! (elemente.get(x).get(y) instanceof Mauer))
                {
                    graph.KnotenEinfügen(x, y);
                    if (elemente.get(x).get(y) instanceof Ausgang)
                    {
                        graph.KnotenGeben(x, y).FarbeSetzen("grün");
                    }
                    if ((x > 0) && ! (elemente.get(x - 1).get(y) instanceof Mauer))
                    {
                        graph.KanteEinfügen(x, y, x - 1, y);
                    }
                    if ((y > 0) && ! (elemente.get(x).get(y - 1) instanceof Mauer))
                    {
                        graph.KanteEinfügen(x, y, x, y - 1);
                    }
                }
            }
        }
    }
    
    /**
     * Setzt die Sichtbarkeit des Labyrinths
     * @param sichtbar wenn wahr, ist das Labyrinth sichtbar
     */
    void SichtbarkeitSetzen(boolean sichtbar)
    {
        for (int x = 0; x < elemente.size(); x += 1)
        {
            for (int y = 0; y < elemente.get(x).size(); y += 1)
            {
                elemente.get(x).get(y).SichtbarkeitSetzen(sichtbar);
            }
        }
    }
    
    /**
     * Meldet die x-Koordinate des Ausgangs zurück
     * @return x-Koordinate des Ausgangs
     */
    int XAusgangGeben()
    {
        return xAusgang;
    }
    
    /**
     * Meldet die y-Koordinate des Ausgangs zurück
     * @return y-Koordinate des Ausgangs
     */
    int YAusgangGeben()
    {
        return yAusgang;
    }
    
    /**
     * Startpunkt ermitteln
     */
    void StartpunktGenerieren()
    {
        int x1, y1, x2, y2, x3, y3;
        do
        {
            x1 = zufall.nextInt(elemente.size() - 2) + 1;
            y1 = zufall.nextInt(elemente.get(0).size() - 2) + 1;
        } while (elemente.get(x1).get(y1) instanceof Mauer);
        do
        {
            x2 = zufall.nextInt(elemente.size() - 2) + 1;
            y2 = zufall.nextInt(elemente.get(0).size() - 2) + 1;
        } while (elemente.get(x2).get(y2) instanceof Mauer);
        do
        {
            x3 = zufall.nextInt(elemente.size() - 2) + 1;
            y3 = zufall.nextInt(elemente.get(0).size() - 2) + 1;
        } while (elemente.get(x3).get(y3) instanceof Mauer);
        if (Math.abs(x1 - xAusgang) + Math.abs(y1 - yAusgang) > Math.abs(x2 - xAusgang) + Math.abs(y2 - yAusgang))
        {
            if (Math.abs(x1 - xAusgang) + Math.abs(y1 - yAusgang) > Math.abs(x3 - xAusgang) + Math.abs(y3 - yAusgang))
            {
                xStart = x1;
                yStart = y1;
            }
            else if (Math.abs(x2 - xAusgang) + Math.abs(y2 - yAusgang) > Math.abs(x3 - xAusgang) + Math.abs(y3 - yAusgang))
            {
                xStart = x2;
                yStart = y2;
            }
            else
            {
                xStart = x3;
                yStart = y3;
                
            }
        }
        else if (Math.abs(x2 - xAusgang) + Math.abs(y2 - yAusgang) > Math.abs(x3 - xAusgang) + Math.abs(y3 - yAusgang))
        {
            xStart = x2;
            yStart = y2;
        }
        else
        {
            xStart = x3;
            yStart = y3;
            
        }
    }
    
    /**
     * Meldet die x-Koordinate des Ausgangs zurück
     * @return x-Koordinate des Ausgangs
     */
    int XStartGeben()
    {
        return xStart;
    }
    
    /**
     * Meldet die y-Koordinate des Ausgangs zurück
     * @return y-Koordinate des Ausgangs
     */
    int YStartGeben()
    {
        return yStart;
    }
}
