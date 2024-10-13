package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.ferienwohnungen_kunde;

/**
 * Beschreibt die Produzenten von Meldungen.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
interface MELDUNGSERZEUGER
{
    /**
     * Registriert einen Beobachter beim Produzenten.
     */
    void Registrieren(MELDUNGSBEOBACHTER beobachter);

    /**
     * Meldet einen Beobachter beim Produzenten ab.
     */
    void Abmelden(MELDUNGSBEOBACHTER beobachter);
}
