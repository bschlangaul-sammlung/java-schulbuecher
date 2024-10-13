package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.fahrplan_auskunft;

/**
 * Verwaltet eine Liste der Umsteigeinformationen.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class UMSTEIGELISTE extends LISTE
{
    /**
     * Legt eine leere Liste an.
     */
    UMSTEIGELISTE()
    {
        super();
    }

    /**
     * Sucht die Umsteigeinformation mit den angegebenen Daten. Nutzt die
     * Sortierung der Liste aus.
     *
     * @param nummer Nummer des Bahnhofs
     * @param l1 von-Linie
     * @param l2 nach-Linie
     *
     * @return Referenz auf den Bahnhof oder null
     */
    UMSTEIGEINFO Suchen(int nummer, int l1, int l2)
    {
        return (UMSTEIGEINFO) Suchen(new UMSTEIGEINFO(nummer, l1, l2));
    }
}
