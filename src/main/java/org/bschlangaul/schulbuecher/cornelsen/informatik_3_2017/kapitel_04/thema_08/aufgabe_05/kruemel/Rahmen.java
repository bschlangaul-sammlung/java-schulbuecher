package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_08.aufgabe_05.kruemel;

import java.util.Random;

/**
 * Schafft den Rahmen für das Spiel.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Rahmen extends Ereignisbehandlung
{
    /**
     * Der Zufallsgenerator
     */
    Random zufall;

    /**
     * Legt die Krümel und das Monster an
     */
    Rahmen()
    {
        zufall = new Random();
        for (int nummer = 0; nummer < 40; nummer = nummer + 1)
        {
            new Kruemel(5 + zufall.nextInt(790), 5 + zufall.nextInt(490));
        }
        new Monster();
        Starten();
    }

    /**
     * nichts
     */
    @Override
    void SonderTasteGedrückt(int taste)
    {
    }

    /**
     * nichts
     */
    @Override
    void TasteGedrückt(char taste)
    {
    }

    /**
     * nichts
     */
    @Override
    void TaktImpulsAusführen()
    {
    }
}
