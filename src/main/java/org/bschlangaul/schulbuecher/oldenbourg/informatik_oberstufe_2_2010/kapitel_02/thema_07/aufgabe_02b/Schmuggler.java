package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_07.aufgabe_02b;

import java.util.Random;

/**
 * Bewegungen des Schmugglers.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Schmuggler extends Karol2
{
    private final Random zufall;

    /**
     * Positioniert den Roboter in seiner Welt.
     *
     * @param startX X-Koordinate der Startposition
     * @param startY Y-Koordinate der Startposition
     * @param startBlickrichtung Blickrichtung beim Start
     * @param inWelt Welt, in der der Roboter lebt
     */
    Schmuggler(int startX, int startY, char startBlickrichtung,
            KarolWelt inWelt)
    {
        super(startX, startY, startBlickrichtung, inWelt);
        zufall = new Random();
    }

    /**
     * Bewegt den Schmuggler zufällig;
     */
    void Bewegen()
    {
        switch (zufall.nextInt(3))
        {
        case 0:
            if (IstRoboter())
            {
                if (RoboterVorneKennungGeben() <= 2)
                {
                    ende = true;
                }
            }
            else if (IstWand())
            {
                if (IstBlickSueden())
                {
                    RechtsDrehen();
                }
                else if (IstBlickNorden())
                {
                    LinksDrehen();
                }
                else
                {
                    LinksDrehen();
                    LinksDrehen();
                }
            }
            else
            {
                Schritt();
                if (PositionXGeben() == 1)
                {
                    ende = true;
                }
            }
            break;

        case 1:
            LinksDrehen();
            break;

        case 2:
            RechtsDrehen();
            break;
        }
    }
}
