package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.ferienwohnungen_kunde;

/**
 * Abschluss einer Objektliste
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class ABSCHLUSS extends LISTENELEMENT
{
    /**
     * Keine eigene Aktion
     */
    ABSCHLUSS()
    {
        super();
    }

    /**
     * Fügt ein Objekt sortiert nach Objektnummern in die Liste ein.
     *
     * @param objekt Referenz auf das einzufügende Objekt.
     *
     * @return (neues) Nachfolgeelement des Aufrufers.
     */
    LISTENELEMENT Einfuegen(OBJEKTINFO objekt)
    {
        return new KNOTEN(objekt, this);
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
        return null;
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
        return;
    }

    /**
     * überträgt die Liste in ein Feld
     *
     * @param laenge aktuelle Länge der Liste
     *
     * @return Feld mit den Listenelementen
     */
    OBJEKTINFO[] AlsFeldAusgeben(int laenge)
    {
        if (laenge == 0)
        {
            return null;
        }
        else
        {
            return new OBJEKTINFO[laenge];
        }
    }
}
