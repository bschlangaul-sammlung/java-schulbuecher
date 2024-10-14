package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_07.aufgabe_07.abiturparty;

import java.util.Random;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Figur;

/**
 * Steuerung der Leuchten auf dem Dancefloor
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class DancefloorSteuerung extends Figur
{
    Dancefloor d;

    Random zufallszahlgenerator;

    /**
     * Legt den Tanzboden und den Zufallsgenerator an.
     */
    DancefloorSteuerung()
    {
        d = new Dancefloor();
        zufallszahlgenerator = new Random();
    }

    /**
     * Lässt die Farben laufen
     */
    @Override
    public void AktionAusführen()
    {
        for (int spalte = d.SpaltenanzahlGeben()
                - 1; spalte > 0; spalte = spalte - 1)
        {
            for (int zeile = 0; zeile < d.ZeilenanzahlGeben(); zeile = zeile
                    + 1)
            {
                d.FarbeSetzen(spalte, zeile, d.FarbeGeben(spalte - 1, zeile));
            }
        }
        for (int zeile = 0; zeile < d.ZeilenanzahlGeben(); zeile = zeile + 1)
        {
            d.FarbeSetzen(0, zeile, ZufälligeFarbeGeben());
        }
    }

    /**
     * Bestimmt eine zufällige Farbe
     *
     * @return zufällige Farbe
     */
    String ZufälligeFarbeGeben()
    {
        int zufallszahl = zufallszahlgenerator.nextInt(12);
        switch (zufallszahl)
        {
        case 1:
            return "weiß";

        case 2:
            return "rot";

        case 3:
            return "grün";

        case 4:
            return "blau";

        case 5:
            return "gelb";

        case 6:
            return "magenta";

        case 7:
            return "cyan";

        case 8:
            return "hellgelb";

        case 9:
            return "hellgrün";

        case 10:
            return "orange";

        case 11:
            return "braun";

        case 12:
            return "grau";

        default:
            return "schwarz";
        }
    }

    public static void main(String[] args)
    {
        new DancefloorSteuerung().AktionAusführen();
    }
}
