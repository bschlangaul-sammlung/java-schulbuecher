
/**
 * Beispiele für diverse Graphen
 * 
 * @author Albert Wiedemann
 * @version 1.0
 */
class Beispiele
{
    GraphListe g;
    Lesen l;
    
    /**
     * Legt das Graphenobjekt an.
     */
    Beispiele ()
    {
        g = new GraphListe();
        l = new Lesen();
    }

    /**
     * Legt den Graphen für das Beispiel im Lehrtext an.
     * Am Ende Ausgabe der Adjazenzmatrix zur Kontrolle
     */
    void AusführenAbiturfahrt()
    {
        g.ZurückSetzen();
        if (l.LesenDatenbank("Abiturfahrt.grdb", g))
        {
            //g.Ausgeben();
        }
    }

    /**
     * Legt einen Graphen für den süddeutschen Teil des Autobahnnetzes an.
     * Am Ende Ausgabe der Adjazenzmatrix zur Kontrolle
     */
    void AusführenAutobahn()
    {
        g.ZurückSetzen();
        if (l.LesenDatenbank("Autobahn.grdb", g))
        {
            //g.Ausgeben();
        }
    }
 
    /**
     * Legt einen Graphen für das deutsche ICE-Netz an.
     * Am Ende Ausgabe der Adjazenzmatrix zur Kontrolle
     */
    void AusführenICE()
    {
        g.ZurückSetzen();
        if (l.LesenDatenbank("ICENetz.grdb", g))
        {
            //g.Ausgeben();
        }
    }

    /**
     * Legt einen zusammenhängenden Graphen an.
     * Am Ende Ausgabe der Adjazenzmatrix zur Kontrolle
     */
    void AusführenBeispielgraph()
    {
        g.ZurückSetzen();
        if (l.LesenDatenbank("Beispielgraph.grdb", g))
        {
            //g.Ausgeben();
        }
    }

    /**
     * Legt einen nicht zusammenhängenden Graphen an.
     * Am Ende Ausgabe der Adjazenzmatrix zur Kontrolle
     */
    void AusführenBeispielgraph2()
    {
        g.ZurückSetzen();
        if (l.LesenDatenbank("Beispielgraph2.grdb", g))
        {
            //g.Ausgeben();
        }
    }

    /**
     * Führt die Tiefensuche vom Startknoten zum Zielknoten durch
     * @param nameStartKnoten der Name des Startknotens
     * @param nameZielKnoten der Name des Zielknotens
     */
    void TiefensucheAusführen (String nameStartKnoten, String nameZielKnoten)
    {
        if (g != null)
        {
            g.TiefensucheAusführen(g.KnotenGeben(nameStartKnoten), g.KnotenGeben(nameZielKnoten));
        }
    }
}
