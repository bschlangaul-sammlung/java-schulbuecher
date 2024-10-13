package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_08.aufgabe_06.verrueckte_reise;

/**
 * Erzeugt den Randstreifen
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Rand
{
    /**
     * Plaziert die vier Rand-Rechtecke
     */
    Rand()
    {
        new RechteckBesser(0, 0, 800, 20, "schwarz");
        new RechteckBesser(0, 20, 20, 460, "schwarz");
        new RechteckBesser(780, 20, 20, 460, "schwarz");
        new RechteckBesser(0, 480, 800, 20, "schwarz");
    }
}
