
/**
 * Rahmenklasse für die Wegesuche aus dem Labyrith.
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
class Rahmen
{
    /**
     * Das Labyrinth */
    private Labyrinth l;
    /**
     * Der zugehörige Graph */
    private GraphMatrix g;
    /**
     * Der verirrte Theseus */
    private Theseus t;

    /**
     * Legt die benötigten Objekte an.
     */
    Rahmen ()
    {
        l = new Labyrinth(20, 13);
        l.Generieren();
        g = new GraphMatrix();
        l.GraphErzeugen(g);
        t = null;
    }

    /**
     * Zeigt nur den Graphen an.
     */
    void GraphAnzeigen()
    {
        l.SichtbarkeitSetzen(false);
        g.SichtbarkeitSetzen(true);
        if (t != null)
        {
            t.SichtbarkeitSetzen(false);
        }
    }

    /**
     * Zeigt nur das Labyrinth an.
     */
    void LabyrinthAnzeigen()
    {
        l.SichtbarkeitSetzen(true);
        g.SichtbarkeitSetzen(false);
        if (t != null)
        {
            t.SichtbarkeitSetzen(true);
        }
    }

    /**
     * Positioniert den verirrten Theseus auf einen geeigneten Startpunkt
     */
    private void TheseusPositionieren()
    {
        if (t != null)
        {
            t.Entfernen();
        }
        LabyrinthAnzeigen();
        l.StartpunktGenerieren();
        t = new Theseus(l.XStartGeben(), l.YStartGeben());
    }

    /**
     * Ermittelt den Weg aus dem Labyrinth und bereitet den Gang zu Ausgang vor.
     */
    private void FluchtwegBerechnen()
    {
        if (t != null)
        {
            t.WegSetzen(g.TiefensucheAusführen(l.XStartGeben(), l.YStartGeben(), l.XAusgangGeben(), l.YAusgangGeben()));
        }
    }

    /**
     * Setzt Theseus auf eine Startposition und setzt den Weg zum Ausgang
     */
    void FluchtAusführen()
    {
        TheseusPositionieren();
        FluchtwegBerechnen();
    }
}
