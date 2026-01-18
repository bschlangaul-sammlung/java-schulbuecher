package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.fahrplan_auskunft;

/**
 * Verwaltet eine Liste von Knoten des Verbindungsgraphen.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class GKLISTE extends LISTE
{
    /**
     * Legt eine leere Liste an.
     */
    GKLISTE()
    {
        super();
    }

    /**
     * Sucht den Knoten mit den angegebenen Daten. Nutzt die Sortierung der
     * Liste aus.
     *
     * @param bahnhof der zu suchenden Bahnhof
     * @param linie Nummer der relevanten Linie
     *
     * @return Referenz auf den Knoten oder null
     */
    GKNOTEN Suchen(BAHNHOF bahnhof, int linie)
    {
        return (GKNOTEN) Suchen(new GKNOTEN(bahnhof, linie));
    }
}
