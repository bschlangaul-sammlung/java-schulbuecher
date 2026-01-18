package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.ferienwohnungen_kunde;

/**
 * Knoten einer Objektliste
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class KNOTEN extends LISTENELEMENT
{
    private OBJEKTINFO daten;

    private LISTENELEMENT nachfolger;

    /**
     * Baut die Referenzen auf
     *
     * @param d Datenelement
     * @param nf Nachfolgeelement der Liste
     */
    KNOTEN(OBJEKTINFO d, LISTENELEMENT nf)
    {
        super();
        daten = d;
        nachfolger = nf;
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
        if (daten.NummerGeben() < objekt.NummerGeben())
        {
            nachfolger = nachfolger.Einfuegen(objekt);
            return this;
        }
        else
        {
            return new KNOTEN(objekt, this);
        }
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
        if (daten.NummerGeben() == nummer)
        {
            return daten;
        }
        else
        {
            return nachfolger.Suchen(nummer);
        }
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
        boolean[] ausstattung;
        boolean ok;
        ausstattung = daten.AusstattungenGeben();
        ok = !daten.SperreGeben();
        for (int i = 0; i < aus.length; i++)
        {
            ok = ok && (!aus[i] || ausstattung[i]);
        }
        if (((land == null) || (land.IDGeben() == daten.LandNummerGeben()))
                && ((art == null) || (art.equals(daten.ArtGeben())))
                && ((persmin <= daten.PersonenAnzahlGeben())
                        && (daten.PersonenAnzahlGeben() <= persmax))
                && ((zimmin <= daten.ZimmerAnzahlGeben())
                        && (daten.ZimmerAnzahlGeben() <= zimmax))
                && ok)
        {
            res.Einfuegen(daten);
        }
        nachfolger.ObjekteSuchen(res, land, art, persmin, persmax, zimmin,
                zimmax, aus);
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
        OBJEKTINFO[] res;
        res = nachfolger.AlsFeldAusgeben(laenge + 1);
        res[laenge] = daten;
        return res;
    }
}
