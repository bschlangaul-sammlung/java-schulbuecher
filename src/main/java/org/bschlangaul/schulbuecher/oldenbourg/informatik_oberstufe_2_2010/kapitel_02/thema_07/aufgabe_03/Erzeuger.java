package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_07.aufgabe_03;

/**
 * Beschreibt einen Meldungserzeuger.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
interface Erzeuger
{
    /**
     * Registriert einen Meldungsbeobachter.
     *
     * @param beobachter der zu registrierende Beobachter
     */
    void Registrieren(Beobachter beobachter);
}
