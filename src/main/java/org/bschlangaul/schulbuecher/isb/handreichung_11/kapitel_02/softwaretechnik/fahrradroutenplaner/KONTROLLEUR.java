package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_02.softwaretechnik.fahrradroutenplaner;

/**
 * KONTROLLEUR nach MVC.
 *
 * @author
 *
 * @version 1.0
 */
class KONTROLLEUR
{
    private DIJKSTRA dijkstra;

    /**
     * Belegt die Attribute.
     *
     * @param d Wegesuchobjekt
     */
    KONTROLLEUR(DIJKSTRA d)
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
        dijkstra.StreckeSuchen((ORT) start, (ORT) ziel);
    }

    /**
     * Beendet das Programm
     */
    void Beenden()
    {
        System.exit(0);
    }
}
