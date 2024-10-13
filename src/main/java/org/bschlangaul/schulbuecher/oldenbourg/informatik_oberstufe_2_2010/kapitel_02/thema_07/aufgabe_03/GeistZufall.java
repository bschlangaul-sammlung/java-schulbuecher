package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_07.aufgabe_03;

import java.util.*;

/**
 * Ein Geist, der seinen Weg zufällig wählt.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class GeistZufall extends Figur
{
    private Random zufall;

    /**
     * Positioniert den Roboter in seiner Welt.
     *
     * @param startX X-Koordinate der Startposition
     * @param startY Y-Koordinate der Startposition
     * @param startBlickrichtung Blickrichtung beim Start
     * @param inWelt Welt, in der der Roboter lebt
     */
    GeistZufall(int startX, int startY, char startBlickrichtung,
            KarolWelt inWelt)
    {
        super(startX, startY, startBlickrichtung, inWelt);
        zufall = new Random();
    }

    /**
     * Bewegt den Roboter gemäß seiner Aufgabe.
     */
    void Bewegen()
    {
        int anzahl;
        if (IstRoboter() && (RoboterVorneKennungGeben() == 1))
        {
            for (Beobachter b : beobachter)
            {
                b.VerlorenMelden();
            }
            FigurenThread.EndeSetzen();
        }
        else if (!IstFrei())
        {
            anzahl = 0;
            for (int i = 1; i <= 4; i++)
            {
                RechtsDrehen();
                if (IstFrei())
                {
                    anzahl += 1;
                }
            }
            anzahl = zufall.nextInt(anzahl);
            while (!IstFrei() && (anzahl > 0))
            {
                RechtsDrehen();
                if (IstFrei())
                {
                    anzahl -= 1;
                }
            }
            if (IstFrei())
            {
                Schritt();
            }
        }
        else
        {
            Schritt();
        }
    }
}
