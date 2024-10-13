package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_02.softwaretechnik.fahrradroutenplaner;

/**
 * Das Interface für einen Beobachter von Statusmeldungen.
 *
 * @author
 *
 * @version 1.0
 */
interface STATUSBEOBACHTER
{
    /**
     * Empfängt Statusmeldungen
     *
     * @param text Text der Statusmeldungen
     */
    void StatusSetzen(String text);

    /**
     * Empfängt die Vorgängerinformation, Start und Ziel
     *
     * @param vorgaenger Liste mit der Vorgängerinformation
     * @param start Name des Startortes
     * @param ziel Name des Zielortes
     */
    void WegSetzen(LISTE vorgaenger, String start, String ziel);
}
