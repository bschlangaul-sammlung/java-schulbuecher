package org.bschlangaul.schulbuecher.isb.handreichung_11.softwaretechnik.fahrradroutenplaner;

/**
 * Das Interface für einen Erzeuger von Statusinformation.
 *
 * @author
 * @version 1.0
 */

interface STATUSERZEUGER
{
    /**
     * Registrieren des Stautsbeobachters
     *
     * @param wer der neue Statusbeobachter
     */
    void Registrieren(STATUSBEOBACHTER wer);
}
