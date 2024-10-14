
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
     * Startet die Besuche der Knoten auf der Suche nach einem Laden.
     * @param start Name des Startknotens
     */
    void SucheDurchführenLaden(String start)
    {
        g.TiefensucheAusführen(g.KnotenNummerGeben(start), "laden");
    }
    
    /**
     * Startet die Besuche der Knoten auf der Suche nach einem Kunden.
     * @param start Name des Startknotens
     */
    void SucheDurchführenKunde(String start)
    {
        g.TiefensucheAusführen(g.KnotenNummerGeben(start), "kunde");
    }
}
