package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.fahrplan_wartung;

/**
 * Abschluss einer Liste
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class ABSCHLUSS extends LISTENELEMENT
{
    /**
     * Keine eigene Aktion.
     */
    ABSCHLUSS()
    {
        super();
    }

    /**
     * Fügt ein Datenelement sortiert in die Liste ein.
     *
     * @param daten Referenz auf das einzufügende Datenelement.
     *
     * @return (neues) Nachfolgeelement des Aufrufers.
     */
    LISTENELEMENT Einfuegen(DATENELEMENT daten)
    {
        return new KNOTEN(daten, this);
    }

    /**
     * Löscht das angegebene Element aus der Liste. Wenn wir hier ankommen,
     * wurde das Element nicht gefunden.
     *
     * @param welches Referenz auf das zu löschende Element.
     *
     * @return (neues) Nachfolgeelement des Aufrufers.
     */
    LISTENELEMENT Loeschen(DATENELEMENT welches)
    {
        return this;
    }

    /**
     * Sucht das Datenelement mit dem in test angegebenen Schlüssel. Nutzt die
     * Sortierung der Liste aus.
     *
     * @param test Schlüssel des zu suchenden Datenelements.
     *
     * @return Referenz auf das gefundene Datenelement oder null.
     */
    DATENELEMENT Suchen(DATENELEMENT test)
    {
        return null;
    }

    /**
     * Meldet das nächste Datenelement für den Listendurchlauf. Am Ende der
     * Liste wird hier &quot;angehalten&quot;.
     *
     * @return nächstes Element
     */
    LISTENELEMENT Naechstes()
    {
        return this;
    }

    /**
     * Gibt die Datenreferenz dieses Elements.
     *
     * @return Datenreferenz
     */
    DATENELEMENT DatenGeben()
    {
        return null;
    }
}
