package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.bank;

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
     * Fehlermeldungen beim Ausführen von Aktionen
     */
    void FehlermeldungEmpfangen(String text);

    /**
     * Aktionslog für den Ablauf
     */
    void LogeintragEmpfangen(String text);
}
