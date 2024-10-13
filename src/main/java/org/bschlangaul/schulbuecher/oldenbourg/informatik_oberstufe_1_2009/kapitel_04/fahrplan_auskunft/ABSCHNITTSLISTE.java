package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.fahrplan_auskunft;

/**
 * Verwaltet eine Liste der Abschnitte.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class ABSCHNITTSLISTE extends LISTE
{
    /**
     * Legt eine leere Liste an.
     */
    ABSCHNITTSLISTE()
    {
        super();
    }

    /**
     * Sucht den Abschnitt mit den angegebenen Daten. Nutzt die Sortierung der
     * Liste aus.
     *
     * @param linie Nummer der Linie des Abschnitts
     * @param b1 Nummer des ersten Bahnhofs des Abschnitts
     * @param b2 Nummer des zweiten Bahnhofs des Abschnitts
     *
     * @return Referenz auf den Bahnhof oder null
     */
    ABSCHNITT Suchen(int linie, int b1, int b2)
    {
        return (ABSCHNITT) Suchen(new ABSCHNITT(linie, b1, b2, 0.0f));
    }
}
