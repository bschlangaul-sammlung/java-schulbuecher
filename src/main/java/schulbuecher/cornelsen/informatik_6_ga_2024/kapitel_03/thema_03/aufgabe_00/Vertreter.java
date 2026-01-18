package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_03.thema_03.aufgabe_00;

import schulbuecher.cornelsen.shared.graph_visualisierung.Lesen;

/**
 * Rahmenprogramm für die Vertreterreise
 *
 * @author Albert Wiedemann
 *
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
     *
     * @param start Name des Startknotens
     */
    void ReiseStarten(String start)
    {
        g.ZurückSetzen();
        g.KnotenBesuchen(g.KnotenNummerGeben(start));
    }

    public static void main(String[] args)
    {
        Vertreter vertreter = new Vertreter();
        vertreter.ReiseStarten("N");
    }
}
