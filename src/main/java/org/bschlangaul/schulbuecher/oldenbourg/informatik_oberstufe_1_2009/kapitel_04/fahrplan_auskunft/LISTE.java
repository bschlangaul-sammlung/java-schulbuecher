package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.fahrplan_auskunft;

/**
 * Verwaltet eine Liste von Datenelementen.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class LISTE
{
    /** Referenz auf das erste Listenelement */
    private LISTENELEMENT erstes;

    /** Referenz auf das aktuelle Datenelement für Durchlauf */
    private LISTENELEMENT aktuelles;

    /** Referenz auf das aktuelle Datenelement */
    private DATENELEMENT daten;

    /**
     * Legt eine leere Liste an.
     */
    LISTE()
    {
        erstes = new ABSCHLUSS();
        aktuelles = null;
        daten = null;
    }

    /**
     * Fügt ein Datenelement sortiert in die Liste ein.
     *
     * @param daten Referenz auf das einzufügende Datenelement
     */
    void Einfuegen(DATENELEMENT daten)
    {
        erstes = erstes.Einfuegen(daten);
    }

    /**
     * Löscht das angegebene Element aus der Liste.
     *
     * @param welches Referenz auf das zu löschende Element
     */
    void Loeschen(DATENELEMENT welches)
    {
        erstes = erstes.Loeschen(welches);
    }

    /**
     * Sucht das Datenelement mit dem angegebenen Referenzschlüssel. Nutzt die
     * Sortierung der Liste aus.
     *
     * @param daten Referenzelement mit dem Schlüssel des zu suchenden Elements
     *
     * @return Referenz auf das Datenelement oder null
     */
    DATENELEMENT Suchen(DATENELEMENT daten)
    {
        return erstes.Suchen(daten);
    }

    /**
     * Positioniert den Cursor vor das erste Datenelement.
     */
    void VorErstesPositionieren()
    {
        aktuelles = null;
        daten = null;
    }

    /**
     * Setzt den Cursor auf das nächste Datenelement.
     *
     * @return wahr, wenn noch Daten verfügbar sind
     */
    boolean AufNaechstesPositionieren()
    {
        if (aktuelles == null)
        {
            aktuelles = erstes;
        }
        else
        {
            aktuelles = aktuelles.Naechstes();
        }
        daten = aktuelles.DatenGeben();
        return daten != null;
    }

    /**
     * Meldet das Datenelement des Cursors.
     *
     * @return aktuelles Datenelement
     */
    DATENELEMENT DatenGeben()
    {
        return daten;
    }
}
