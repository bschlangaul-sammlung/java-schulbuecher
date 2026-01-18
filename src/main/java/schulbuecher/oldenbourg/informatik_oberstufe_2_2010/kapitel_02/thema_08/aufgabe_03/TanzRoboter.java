package schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_08.aufgabe_03;

import java.util.Random;

/**
 * Ergänzt den Roboter um Tanzschritte.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class TanzRoboter extends Karol
{
    Random zufall;

    /**
     * Positioniert den Roboter in seiner Welt.
     *
     * @param startX X-Koordinate der Startposition
     * @param startY Y-Koordinate der Startposition
     * @param startBlickrichtung Blickrichtung beim Start
     * @param inWelt Welt, in der der Roboter lebt
     */
    TanzRoboter(int startX, int startY, char startBlickrichtung,
            KarolWelt inWelt)
    {
        super(startX, startY, startBlickrichtung, inWelt);
        zufall = new Random();
    }

    /**
     * Positioniert den Roboter in seiner Welt.
     *
     * @param inWelt Welt, in der der Roboter lebt
     */
    TanzRoboter(KarolWelt inWelt)
    {
        super(inWelt);
        zufall = new Random();
    }

    /**
     * Der Roboter dreht sich um 180 Grad.
     */
    void Umdrehen()
    {
        RechtsDrehen();
        RechtsDrehen();
    }

    /**
     * Der Roboter macht einen Schritt, wenn möglich.
     */
    void VorsichtigerSchritt()
    {
        if (IstWand())
        {
            Umdrehen();
        }
        else if (IstRoboter())
        {
            LinksDrehen();
        }
        else
        {
            Schritt();
        }
    }

    /**
     * Der Roboter macht einen Schritt nach rechts, wenn möglich.
     */
    void VorsichtigerRechtsSchritt()
    {
        RechtsDrehen();
        if (!(IstWand() || IstRoboter()))
        {
            Schritt();
        }
        LinksDrehen();
    }

    /**
     * Der Roboter tanzt zufällig.
     */
    void Tanzen()
    {
        switch (zufall.nextInt(4))
        {
        case 0:
            RechtsDrehen();
            break;

        case 1:
            LinksDrehen();
            break;

        case 2:
            VorsichtigerSchritt();
            break;

        case 3:
            VorsichtigerRechtsSchritt();
            break;
        }
    }
}
