package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.fahrplan_auskunft;

/**
 * Knoten einer Liste
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class KNOTEN extends LISTENELEMENT
{
    private DATENELEMENT daten;

    private LISTENELEMENT nachfolger;

    /**
     * Baut die Referenzen auf.
     *
     * @param d Datenelement
     * @param nf Nachfolgeelement der Liste
     */
    KNOTEN(DATENELEMENT d, LISTENELEMENT nf)
    {
        super();
        daten = d;
        nachfolger = nf;
    }

    /**
     * Fügt ein Datenelement sortiert in die Liste ein.
     *
     * @param d Referenz auf das einzufügende Datenelement
     *
     * @return (neues) Nachfolgeelement des Aufrufers
     */
    LISTENELEMENT Einfuegen(DATENELEMENT d)
    {
        if (daten.Vergleichen(d) < 0)
        {
            nachfolger = nachfolger.Einfuegen(d);
            return this;
        }
        else
        {
            return new KNOTEN(d, this);
        }
    }

    /**
     * Löscht das angegebene Element aus der Liste.
     *
     * @param welches Referenz auf das zu löschende Element
     *
     * @return (neues) Nachfolgeelement des Aufrufers
     */
    LISTENELEMENT Loeschen(DATENELEMENT welches)
    {
        if (welches == daten)
        {
            return nachfolger;
        }
        else
        {
            nachfolger = nachfolger.Loeschen(welches);
            return this;
        }
    }

    /**
     * Sucht das Datenelement mit dem in test angegebenen Schlüssel. Nutzt die
     * Sortierung der Liste aus.
     *
     * @param test Schlüssel des zu suchenden Datenelements
     *
     * @return Referenz auf das gefundene Datenelement oder null
     */
    DATENELEMENT Suchen(DATENELEMENT test)
    {
        int vergleich;
        vergleich = daten.Vergleichen(test);
        if (vergleich == 0)
        {
            return daten;
        }
        else if (vergleich < 0)
        {
            return nachfolger.Suchen(test);
        }
        else
        {
            return null;
        }
    }

    /**
     * Meldet das nächste Datenelement für den Listendurchlauf.
     *
     * @return nächstes Element
     */
    LISTENELEMENT Naechstes()
    {
        return nachfolger;
    }

    /**
     * Gibt die Datenreferenz dieses Elements.
     *
     * @return Datenreferenz
     */
    DATENELEMENT DatenGeben()
    {
        return daten;
    }
}
