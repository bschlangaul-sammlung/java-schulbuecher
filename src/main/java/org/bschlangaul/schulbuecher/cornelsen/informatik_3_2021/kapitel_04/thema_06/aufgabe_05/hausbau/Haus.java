package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_06.aufgabe_05.hausbau;

/**
 * Erstellt das Haus
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Haus
{
    /**
     * Baut das Haus auf
     */
    Haus()
    {
        new Wand();
        new Dach();
        // Hierher kommen noch die Fenster
        new Fenster(50, 140);
        new Fenster(100, 140);
        new Fenster(50, 190);
        new Fenster(100, 190);
    }
}
