package schulbuecher.cornelsen.informatik_5_2023.kapitel_01.thema_02.aufgabe_07.graph_liste;

/**
 * Beispiele für diverse Graphen
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Beispiele
{
    GraphListe g;

    Lesen l;

    /**
     * Legt das Graphenobjekt an.
     */
    Beispiele()
    {
        g = new GraphListe();
        l = new Lesen();
    }

    /**
     * Legt den Graphen für das Beispiel im Lehrtext an. Am Ende Ausgabe der
     * Adjazenzmatrix zur Kontrolle
     */
    void AusführenAbiturfahrt()
    {
        g.ZurückSetzen();
        if (l.LesenDatenbank("Abiturfahrt.grdb", g))
        {
            g.Ausgeben();
        }
    }

    /**
     * Legt einen Graphen für den süddeutschen Teil des Autobahnnetztes an. Am
     * Ende Ausgabe der Adjazenzmatrix zur Kontrolle
     */
    void AusführenAutobahn()
    {
        g.ZurückSetzen();
        if (l.LesenDatenbank("Autobahnen.grdb", g))
        {
            g.Ausgeben();
        }
    }

    /**
     * Legt einen Graphen für dei gegebenen Flugverbindungen an. Am Ende Ausgabe
     * der Adjazenzmatrix zur Kontrolle
     */
    void AusführenFlug()
    {
        g.ZurückSetzen();
        if (l.LesenDatenbank("Fluglinien.grdb", g))
        {
            g.Ausgeben();
        }
    }

    /**
     * Legt einen Graphen für das deutsche ICE-Netzt an. Am Ende Ausgabe der
     * Adjazenzmatrix zur Kontrolle
     */
    void AusführenICE()
    {
        g.ZurückSetzen();
        if (l.LesenDatenbank("ICENetz.grdb", g))
        {
            g.Ausgeben();
        }
    }

    /**
     * Legt einen Graphen für das münchner S-U-Bahn-Netzt an. Am Ende Ausgabe
     * der Adjazenzmatrix zur Kontrolle
     */
    void AusführenSUBahn()
    {
        g.ZurückSetzen();
        if (l.LesenDatenbank("SUBahn.grdb", g))
        {
            g.Ausgeben();
        }
    }
}
