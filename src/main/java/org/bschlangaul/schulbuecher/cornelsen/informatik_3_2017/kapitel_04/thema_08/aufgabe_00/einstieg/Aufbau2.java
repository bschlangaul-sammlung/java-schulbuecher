package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_08.aufgabe_00.einstieg;

import java.util.Random;

/**
 * Baut im Konstruktor das Szenarium auf
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Aufbau2
{
    /** der Zufallsgenerator */
    Random zufall;

    /**
     * Legt die benötigten Objekte an.
     */
    Aufbau2()
    {
        zufall = new Random();
        new RechteckBesser(zufall.nextInt(400), zufall.nextInt(200),
                100 + zufall.nextInt(200), 25 + zufall.nextInt(50), "grün");
        new RechteckBesser(zufall.nextInt(400), zufall.nextInt(200),
                65 + zufall.nextInt(130), 35 + zufall.nextInt(70), "blau");
        new DreieckBesser(zufall.nextInt(400) + 50, zufall.nextInt(200),
                30 + zufall.nextInt(60), 25 + zufall.nextInt(50), 0, "grün");
        new DreieckBesser(zufall.nextInt(400) + 50, zufall.nextInt(200),
                35 + zufall.nextInt(70), 40 + zufall.nextInt(80), 0, "rot");
        new KreisBesser(zufall.nextInt(400) + 50, zufall.nextInt(150) + 50,
                25 + zufall.nextInt(50), "rot");
    }
}
