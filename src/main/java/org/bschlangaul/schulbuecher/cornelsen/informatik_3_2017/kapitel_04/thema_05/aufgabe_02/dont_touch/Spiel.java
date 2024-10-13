package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_05.aufgabe_02.dont_touch;

import java.util.Random;

/**
 * Legt das Spielszenario fest
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Spiel extends Ereignisbehandlung
{
    /** Zufallsgenerator */
    Random zzgenerator;

    /** Taktzähler */
    int zähler;

    /**
     * Legt die Spielfigur und den Zufallsgenertor an
     */
    Spiel()
    {
        new Spielfigur();
        zähler = 8;
        zzgenerator = new Random();
        TaktdauerSetzen(400);
    }

    /**
     * Legt neue Hindernisse an
     */
    @Override
    void TaktImpulsAusführen()
    {
        if (zähler < 3)
        {
            zähler++;
        }
        else
        {
            HindernisErzeugen();
            zähler = 0;
        }
    }

    /**
     * Tasten werden ignoriert
     *
     * @param taste die gedrückte Taste
     */
    @Override
    void TasteGedrückt(char taste)
    {
    }

    /**
     * Sonderasten werden ignoriert
     *
     * @param taste die gedrückte Taste
     */
    @Override
    void SonderTasteGedrückt(int taste)
    {
    }

    /**
     * Erzeugt ein Hindernis mit zufälliger Position und Richtung
     */
    void HindernisErzeugen()
    {
        int zufall = zzgenerator.nextInt(4);
        if (zufall == 0)
        {
            HindernisErzeugen(0, zzgenerator.nextInt(600), 'O');
        }
        else
        {
            if (zufall == 1)
            {
                HindernisErzeugen(800, zzgenerator.nextInt(600), 'W');
            }
            else
            {
                if (zufall == 2)
                {
                    HindernisErzeugen(zzgenerator.nextInt(800), 0, 'S');
                }
                else
                {
                    if (zufall == 3)
                    {
                        HindernisErzeugen(zzgenerator.nextInt(800), 600, 'N');
                    }
                    else
                    {
                        System.out.println(
                                "Fehler in Spiel, HindernisErzeugen()");
                    }
                }
            }
        }
    }

    /**
     * Erzeugt ein zufälliges Hindernis
     *
     * @param x x-Koordinate des Hindernisses
     * @param y y-Koordinate des Hindernisses
     * @param richtung Blickrichtung des Hindernisses
     */
    void HindernisErzeugen(int x, int y, char richtung)
    {
        // Für eine neue Art von Hindernis musst du Obergrenze der Zufallszahl
        // um eins erhöhen.
        // Füge dann einen neuen Fall für deine Klasse hinzu.
        int zufall = zzgenerator.nextInt(7);
        if (zufall == 0)
        {
            new Zickezacke(x, y, richtung);
        }
        else
        {
            if (zufall == 1)
            {
                new Quadrat(x, y, richtung);
            }
            else
            {
                if (zufall == 2)
                {
                    new Schlagbaum(x, y, richtung);
                }
                else
                {
                    if (zufall == 3)
                    {
                        new Rotor(x, y, richtung);
                    }
                    else
                    {
                        if (zufall == 4)
                        {
                            new Stern(x, y, richtung);
                        }
                        else
                        {
                            if (zufall == 5)
                            {
                                new LoeschQuadrat(x, y, richtung);
                            }
                            else
                            {
                                if (zufall == 6)
                                {
                                    new VerdopplerQuadrat(x, y, richtung);
                                }
                                else
                                {
                                    System.out.println(
                                            "Fehler in Spiel, HindernisErzeugen()");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
