package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_02.softwaretechnik.fahrradroutenplaner;

/**
 * Das Interface für einen Erzeuger von Statusinformation.
 *
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
