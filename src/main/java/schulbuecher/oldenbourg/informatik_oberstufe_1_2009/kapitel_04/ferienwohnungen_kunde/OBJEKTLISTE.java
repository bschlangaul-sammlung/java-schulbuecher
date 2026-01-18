package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.ferienwohnungen_kunde;

/**
 * Verwaltet eine Liste von Objekten.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class OBJEKTLISTE
{
    private LISTENELEMENT erstes;

    /**
     * Erzeugt eine leere Liste
     */
    OBJEKTLISTE()
    {
        erstes = new ABSCHLUSS();
    }

    /**
     * Fügt ein Objekt sortiert nach Objektnummern in die Liste ein.
     *
     * @param objekt Referenz auf das einzufügende Objekt.
     */
    void Einfuegen(OBJEKTINFO objekt)
    {
        erstes = erstes.Einfuegen(objekt);
    }

    /**
     * Sucht das angegebene Objekt. Nutzt die Sortierung der Liste aus.
     *
     * @param nummer Schlüssel des zu suchenden Objekts.
     *
     * @return Referenz auf das gefundene Objekt oder null.
     */
    OBJEKTINFO Suchen(int nummer)
    {
        return erstes.Suchen(nummer);
    }

    /**
     * Sucht alle Objekte mit den angegebenen Daten
     *
     * @param res in deiser Liste werden die Ergebnisse eingetragen
     * @param land Land, in dem das Objekt liegt
     * @param art Art des Objekts
     * @param persmin Platz für mindestens persmin Personen
     * @param persmax Platz für maximal persmax Personen
     * @param zimmin minimale Zimmeranzahl
     * @param zimmax maximale Zimmeranzahl
     * @param aus geforderte Ausstattung
     */
    void ObjekteSuchen(OBJEKTLISTE res, LANDINFO land, String art, int persmin,
            int persmax, int zimmin, int zimmax, boolean[] aus)
    {
        erstes.ObjekteSuchen(res, land, art, persmin, persmax, zimmin, zimmax,
                aus);
    }

    /**
     * überträgt die Liste in ein Feld
     *
     * @return Feld mit den Listenelementen
     */
    OBJEKTINFO[] AlsFeldAusgeben()
    {
        return erstes.AlsFeldAusgeben(0);
    }
}
