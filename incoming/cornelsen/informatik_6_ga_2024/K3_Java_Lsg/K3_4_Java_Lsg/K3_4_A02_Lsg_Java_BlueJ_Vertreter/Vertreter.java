
/**
 * Rahmenprogramm für die Vertreterreise
 * 
 * @author Albert Wiedemann
 * @version 1.0
 */
class Vertreter
{
    GraphMatrix g;
    Lesen l;
    
    /**
     * Legt das Graphenobjekt an.
     */
    Vertreter()
    {
        g = new GraphMatrix();
        l = new Lesen();
        l.LesenDatenbank("Autobahn.grdb", g);
    }
    
    /**
     * Startet die Besuche der Knoten.
     * @param start Name des Startknotens
     */
    void SucheDurchführen(String start)
    {
        g.TiefensucheAusführen(g.KnotenNummerGeben(start));
    }
}
