package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.adressverwaltung;

/**
 * Beschreibt den Beobachter von Meldungen.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
interface MELDUNGSBEOBACHTER
{
    /**
     * Fehlermeldungen beim Ausführen von Aktionen.
     *
     * @param text die empfangene Fehlermeldung.
     */
    void FehlermeldungEmpfangen(String text);
}
