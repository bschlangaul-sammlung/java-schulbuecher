package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_02.softwaretechnik.aktienhandel;

/**
 * Das Interface für einen Beobachter von Statusmeldungen.
 *
 * @version 1.0
 */
interface STATUSBEOBACHTER
{
    /**
     * Empfängt Fehlermeldungen
     *
     * @param text Text der Fehlermeldung
     */
    void FehlerSetzen(String text);
}
