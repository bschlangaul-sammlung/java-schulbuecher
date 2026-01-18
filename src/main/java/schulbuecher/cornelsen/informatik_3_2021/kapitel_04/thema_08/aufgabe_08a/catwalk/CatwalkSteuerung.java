package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_08.aufgabe_08a.catwalk;

import java.util.Random;

import schulbuecher.cornelsen.shared.graphics_and_games.Figur;

/**
 * Steuerung der Leuchten auf dem Catwalk
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class CatwalkSteuerung extends Figur
{
    /**
     * Der Laufsteg
     */
    Catwalk laufsteg;

    /**
     * Der Zufallsgenerator
     */
    Random zufallszahlgenerator;

    /**
     * Legt den Laufsteg und den Zufallsgenerator an.
     */
    CatwalkSteuerung()
    {
        laufsteg = new Catwalk();
        SichtbarkeitSetzen(false);
        zufallszahlgenerator = new Random();
    }

    /**
     * Lässt die Farben eine Spalte weiter laufen
     */
    @Override
    public void AktionAusführen()
    {
        for (int spalte = 0; spalte < laufsteg.SpaltenanzahlGeben()
                - 1; spalte = spalte + 1)
        {
            laufsteg.FarbeSetzen(spalte, laufsteg.FarbeGeben(spalte + 1));
        }
        laufsteg.FarbeSetzen(laufsteg.SpaltenanzahlGeben() - 1,
                ZufälligeFarbeGeben());
    }

    /**
     * Bestimmt eine zufällige Farbe
     *
     * @return zufällige Farbe
     */
    String ZufälligeFarbeGeben()
    {
        switch (zufallszahlgenerator.nextInt(12))
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
}
