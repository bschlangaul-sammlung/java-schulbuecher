package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_08.aufgabe_06.verrueckte_reise;

import schulbuecher.cornelsen.shared.graphics_and_games.Figur;

/**
 * Die Spielfigur der verückten Reise
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class SpielFigur extends Figur
{
    /**
     * Der Startpunkt ist die Mitte des Feldes.
     *
     * @param winkel die Blickrichtung beim Start
     */
    SpielFigur(int winkel)
    {
        PositionSetzen(400, 250);
        WinkelSetzen(winkel);
    }

    /**
     * Bewegt die Figur
     */
    @Override
    public void AktionAusführen()
    {
        if (Berührt("schwarz"))
        {
            Drehen(180);
            Gehen(40);
        }
        else if (Berührt("rot"))
        {
            Drehen(5);
            Gehen(5);
        }
        else if (Berührt("grün"))
        {
            Drehen(-10);
            Gehen(5);
        }
        else if (Berührt("blau"))
        {
            Drehen(15);
            Gehen(10);
        }
        else if (Berührt("gelb"))
        {
            Drehen(-5);
            Gehen(10);
        }
        else
        {
            Gehen(15);
        }
    }

    /**
     * Steuert die Richtung der Spielfigur.
     *
     * @param taste KeyCode der gedrückten Taste
     */
    public void SonderTasteGedrückt(int taste)
    {
        if (taste == 37)
        {
            Drehen(5);
        }
        else if (taste == 39)
        {
            Drehen(-5);
        }
    }
}
