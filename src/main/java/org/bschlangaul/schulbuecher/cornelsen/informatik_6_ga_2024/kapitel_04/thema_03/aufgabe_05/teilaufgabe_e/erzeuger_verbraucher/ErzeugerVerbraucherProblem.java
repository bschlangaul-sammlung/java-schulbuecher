package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_03.aufgabe_05.teilaufgabe_e.erzeuger_verbraucher;

/**
 * Erzeuger-Verbraucher-Problem
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
class ErzeugerVerbraucherProblem
{
    /** Speicher beim Erzeuger-Verbraucher-Problem */
    Speicher speicher;

    /** Erzeuger */
    Erzeuger erzeuger;

    /** Verbraucher */
    Verbraucher verbraucher;

    /**
     * Konstruktor für Objekte der Klasse ErzeugerVerbraucherProblem
     */
    ErzeugerVerbraucherProblem()
    {
        speicher = new Speicher();

        for (int zähler = 0; zähler < 5; zähler++)
        {
            erzeuger = new Erzeuger(500, speicher);
            verbraucher = new Verbraucher(2500, speicher);
            erzeuger.start();
            verbraucher.start();
        }
    }
}
