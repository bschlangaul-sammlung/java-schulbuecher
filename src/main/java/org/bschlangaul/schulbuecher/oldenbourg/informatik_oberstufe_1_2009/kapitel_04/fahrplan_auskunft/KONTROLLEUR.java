package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.fahrplan_auskunft;

/**
 * Logik der Benutzerführung.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class KONTROLLEUR
{
    private OBERFLAECHE oberflaeche;

    private GRAPH g;

    private BAHNHOFSLISTE bahnhoefe;

    private PLANANZEIGE plan;

    /**
     * Setzt die Attribute.
     *
     * @param g Verbindungsgraph
     * @param b Bahnhofsliste;
     * @param p Anzeige Netzplan
     */
    KONTROLLEUR(GRAPH g, BAHNHOFSLISTE b, PLANANZEIGE p)
    {
        this.g = g;
        plan = p;
        bahnhoefe = b;
        oberflaeche = null;
    }

    /**
     * Setzt die zugehörige Oberfläche.
     *
     * @param o Oberfläche
     */
    void OberflaecheSetzen(OBERFLAECHE o)
    {
        oberflaeche = o;
    }

    /**
     * Setzt den Startbahnhof der Route.
     *
     * @param nummer Index des Startbahnhofs
     */
    void StartbahnhofSetzen(int nummer)
    {
        plan.StartbahnhofSetzen(bahnhoefe.BahnhofMitIndexGeben(nummer));
    }

    /**
     * Setzt den Zielbahnhof der Route.
     *
     * @param nummer Index des Zielbahnhofs
     */
    void ZielbahnhofSetzen(int nummer)
    {
        plan.ZielbahnhofSetzen(bahnhoefe.BahnhofMitIndexGeben(nummer));
    }

    /**
     * Veranlasst das Berechnen des Fahrwegs.
     *
     * @param nummer1 Nummer des Startbahnhofs
     * @param nummer2 Nummer des Zielbahnhofs
     */
    void RouteBerechnen(int nummer1, int nummer2)
    {
        g.WegeSuche(bahnhoefe.BahnhofMitIndexGeben(nummer1),
                bahnhoefe.BahnhofMitIndexGeben(nummer2));
        oberflaeche.FahrtstreckeSetzen(g.RoutenbeschreibungErstellen());
    }

    /**
     * Beendet das Programm.
     */
    void Beenden()
    {
        System.exit(1);
    }
}
