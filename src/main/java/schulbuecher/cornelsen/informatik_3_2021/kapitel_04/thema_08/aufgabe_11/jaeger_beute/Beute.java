package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_08.aufgabe_11.jaeger_beute;

import java.util.Random;

import schulbuecher.cornelsen.shared.graphics_and_games.Figur;

/**
 * Die Beute wandert zufällig über das Spielfeld. Sie wechselt ihre Richtung
 * immer wahrscheinlicher, je länger sie gerade aus läuft. Als
 * Darstellungssymbol hat sie einen Kreis
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Beute extends Figur
{
    /**
     * Zähler für die Bewegungsschritte geradeaus.
     */
    int zähler;

    /**
     * Der Zufallsgenerator.
     */
    Random zufall;

    /**
     * Breite des Spielfeldes.
     */
    int breite;

    /**
     * Höhe des Spielfeldes.
     */
    int höhe;

    /**
     * Zähler für die Zeit nach der Berührung.
     */
    int berührtZähler;

    /**
     * Legt das Anzeigesymbol an und wählt eine zufällige Startposition.
     *
     * @param breite Breite des Spielfelds
     * @param höhe Höhe des Spielfelds
     */
    Beute(int breite, int höhe)
    {
        zufall = new Random();
        this.breite = breite;
        this.höhe = höhe;
        zähler = 0;
        berührtZähler = -1;
        PositionSetzen(zufall.nextInt(breite), zufall.nextInt(höhe));
        WinkelSetzen(zufall.nextInt(360));
        FigurteilFestlegenEllipse(-50, -50, 100, 100, "rot");
    }

    /**
     * Bewegt die Beute um 10 Einheiten in der eingestellten Richtung. Wir der
     * Rand erreicht, wird die Richtung nach dem Reflexionsgesetzt gedreht.
     * Außerdem wird sie spätestens nach 100 Schritten zufällig neu bestimmt; je
     * länger die Geradesausbewegung, desto wahrscheinlicher ist die zufällige
     * Änderung.
     */
    @Override
    public void AktionAusführen()
    {
        if (zufall.nextInt(100) < zähler)
        {
            WinkelSetzen(zufall.nextInt(360));
            zähler = 0;
        }
        Gehen(10);
        zähler = zähler + 1;
        if ((XPositionGeben() > breite) && (0 <= WinkelGeben())
                && (WinkelGeben() < 90))
        {
            WinkelSetzen(180 - WinkelGeben());
        }
        else if ((XPositionGeben() > breite) && (270 < WinkelGeben())
                && (WinkelGeben() < 360))
        {
            WinkelSetzen(540 - WinkelGeben());
        }
        else if ((XPositionGeben() < 0) && (90 < WinkelGeben())
                && (WinkelGeben() <= 180))
        {
            WinkelSetzen(180 - WinkelGeben());
        }
        else if ((XPositionGeben() < 0) && (180 < WinkelGeben())
                && (WinkelGeben() < 270))
        {
            WinkelSetzen(540 - WinkelGeben());
        }
        if ((YPositionGeben() < 0)
                && ((0 < WinkelGeben()) || (WinkelGeben() < 180)))
        {
            WinkelSetzen(360 - WinkelGeben());
        }
        else if ((YPositionGeben() > höhe) && (180 < WinkelGeben())
                && (WinkelGeben() < 360))
        {
            WinkelSetzen(360 - WinkelGeben());
        }
        berührtZähler = berührtZähler - 1;
        if (berührtZähler == 0)
        {
            Rückfärben();
        }
        if (Berührt())
        {
            Umfärben();
            berührtZähler = 10;
            PositionSetzen(zufall.nextInt(breite), zufall.nextInt(höhe));
            WinkelSetzen(zufall.nextInt(360));
        }
    }

    /**
     * Färbt die erreichte Beute um.
     */
    void Umfärben()
    {
        EigeneFigurLöschen();
        FigurteilFestlegenEllipse(-50, -50, 100, 100, "grün");
    }

    /**
     * Färbt die Beute zur Originalform um.
     */
    void Rückfärben()
    {
        EigeneFigurLöschen();
        FigurteilFestlegenEllipse(-50, -50, 100, 100, "rot");
    }
}
