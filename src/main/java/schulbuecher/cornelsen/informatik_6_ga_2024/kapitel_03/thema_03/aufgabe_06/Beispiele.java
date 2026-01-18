package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_03.thema_03.aufgabe_06;

import schulbuecher.cornelsen.shared.graph_visualisierung.Lesen;

/**
 * Beispiele für diverse Graphen
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Beispiele
{
    GraphMatrix g;

    Lesen l;

    /**
     * Legt das Graphenobjekt an.
     */
    Beispiele()
    {
        g = new GraphMatrix();
        l = new Lesen();
    }

    /**
     * Legt einen Graphen für eine Abiturfahrt an. Am Ende Ausgabe der
     * Adjazenzmatrix zur Kontrolle
     */
    void AusführenAbiturfahrt()
    {
        g.ZurückSetzen();
        if (l.LesenDatenbank("Abiturfahrt.grdb", g))
        {
            // g.Ausgeben();
        }
    }

    /**
     * Legt einen Graphen für den süddeutschen Teil des Autobahnnetzes an. Am
     * Ende Ausgabe der Adjazenzmatrix zur Kontrolle
     */
    void AusführenAutobahn()
    {
        g.ZurückSetzen();
        if (l.LesenDatenbank("Autobahn.grdb", g))
        {
            // g.Ausgeben();
        }
    }

    /**
     * Legt einen Graphen für das deutsche ICE-Netz an. Am Ende Ausgabe der
     * Adjazenzmatrix zur Kontrolle
     */
    void AusführenICE()
    {
        g.ZurückSetzen();
        if (l.LesenDatenbank("ICENetz.grdb", g))
        {
            // g.Ausgeben();
        }
    }

    /**
     * Legt einen zusammenhängenden Graphen an. Am Ende Ausgabe der
     * Adjazenzmatrix zur Kontrolle
     */
    void AusführenBeispielgraph()
    {
        g.ZurückSetzen();
        if (l.LesenDatenbank("Beispielgraph.grdb", g))
        {
            // g.Ausgeben();
        }
    }

    /**
     * Legt einen nicht zusammenhängenden Graphen an. Am Ende Ausgabe der
     * Adjazenzmatrix zur Kontrolle
     */
    void AusführenBeispielgraph2()
    {
        g.ZurückSetzen();
        if (l.LesenDatenbank("Beispielgraph2.grdb", g))
        {
            // g.Ausgeben();
        }
    }

    /**
     * Führt die Tiefensuche vom Startknoten aus durch
     *
     * @param nameStartKnoten der Bezeichner des Startknotens
     */
    void TiefensucheAusführen(String nameStartKnoten)
    {
        if (g != null)
        {
            g.TiefensucheAusführen(g.KnotenNummerGeben(nameStartKnoten));
        }
    }

    /**
     * Testet, ob der Graph zusammenhängend ist.
     */
    void ZusammenhangTesten()
    {
        if (g.ZusammenhangTesten())
        {
            System.out.println("Der Graph ist zusammenhängend.");
        }
        else
        {
            System.out.println("Der Graph ist nicht zusammenhängend.");
        }
    }

    public static void main(String[] args)
    {
        Beispiele beispiele = new Beispiele();
        beispiele.AusführenAbiturfahrt();
    }
}
