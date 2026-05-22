package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_03.thema_04.aufgabe_00.kurze_wege;

/**
 * Rahmenprogramm für die kürzesten Wege
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Wege
{
    GraphMatrix g;

    Lesen l;

    /**
     * Legt das Graphenobjekt an.
     */
    Wege()
    {
        g = new GraphMatrix();
        l = new Lesen();
        l.LesenDatenbank("Autobahn.grdb", g);
    }

    /**
     * Startet die Besuche der Knoten.
     *
     * @param start Name des Startknotens
     * @param ziel Name des Zielknotens
     */
    void ReiseStarten1(String start, String ziel)
    {
        g.ZurückSetzen();
        g.KnotenBesuchen1(g.KnotenNummerGeben(start),
            g.KnotenNummerGeben(ziel));
    }

    /**
     * Startet die Besuche der Knoten.
     *
     * @param start Name des Startknotens
     * @param ziel Name des Zielknotens
     */
    void ReiseStarten2(String start, String ziel)
    {
        g.ZurückSetzen();
        g.KnotenBesuchen2(g.KnotenNummerGeben(start),
            g.KnotenNummerGeben(ziel),
            0);
        g.OptimalerWegAnzeigen();
    }
}
