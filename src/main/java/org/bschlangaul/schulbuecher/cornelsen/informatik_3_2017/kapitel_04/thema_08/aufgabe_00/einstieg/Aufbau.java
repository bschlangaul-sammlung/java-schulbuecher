package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_08.aufgabe_00.einstieg;

/**
 * Baut im Konstruktor das Szenarium auf
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Aufbau
{
    /**
     * Legt die benötigten Objekte an.
     */
    Aufbau()
    {
        new KreisBesser(150, 150, 50, "rot");
        new DreieckBesser(200, 50, 60, 50, 0, "grün");
        new RechteckBesser(100, 220, 200, 50, "grün");
        new RechteckBesser(270, 60, 130, 70, "blau");
        new DreieckBesser(350, 190, 70, 80, 180, "rot");
    }
}
