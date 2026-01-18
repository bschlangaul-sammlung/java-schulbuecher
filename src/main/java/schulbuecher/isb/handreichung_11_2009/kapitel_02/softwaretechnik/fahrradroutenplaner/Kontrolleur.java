package schulbuecher.isb.handreichung_11_2009.kapitel_02.softwaretechnik.fahrradroutenplaner;

/**
 * KONTROLLEUR nach MVC.
 *
 * @version 1.0
 */
class Kontrolleur
{
    private Dijkstra dijkstra;

    /**
     * Belegt die Attribute.
     *
     * @param d Wegesuchobjekt
     */
    Kontrolleur(Dijkstra d)
    {
        dijkstra = d;
    }

    /**
     * Sucht den Weg.
     *
     * @param start Startort
     * @param ziel Zielort
     */
    void WegBerechnen(Object start, Object ziel)
    {
        dijkstra.StreckeSuchen((Ort) start, (Ort) ziel);
    }

    /**
     * Beendet das Programm
     */
    void Beenden()
    {
        System.exit(0);
    }
}
