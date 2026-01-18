package schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_07.aufgabe_02a;

/**
 * Bewegungen des Polizisten auf der Grenze.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Polizist extends Karol2
{
    /**
     * Positioniert den Roboter in seiner Welt.
     *
     * @param startX X-Koordinate der Startposition
     * @param startY Y-Koordinate der Startposition
     * @param startBlickrichtung Blickrichtung beim Start
     * @param inWelt Welt, in der der Roboter lebt
     */
    Polizist(int startX, int startY, char startBlickrichtung, KarolWelt inWelt)
    {
        super(startX, startY, startBlickrichtung, inWelt);
    }

    /**
     * Läuft die Grenze auf und ab. Kontrolliert dabei, ob der Schmuggler vor
     * ihm steht.
     */
    void Bewegen()
    {
        if (IstWand())
        {
            RechtsDrehen();
            RechtsDrehen();
        }
        else if (IstRoboter())
        {
            ende = true;
        }
        else
        {
            Schritt();
        }
    }
}
