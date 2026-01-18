package schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_07.aufgabe_02b;

/**
 * Ein Roboter mit Zusatzeigenschaften für die Grenzpatroullie.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
abstract class Karol2 extends Karol
{
    protected static boolean ende = false;

    /**
     * Positioniert den Roboter in seiner Welt.
     *
     * @param startX X-Koordinate der Startposition
     * @param startY Y-Koordinate der Startposition
     * @param startBlickrichtung Blickrichtung beim Start
     * @param inWelt Welt, in der der Roboter lebt
     */
    Karol2(int startX, int startY, char startBlickrichtung, KarolWelt inWelt)
    {
        super(startX, startY, startBlickrichtung, inWelt);
    }

    /**
     * Bewegt den Roboter gemäß seiner Aufgabe.
     */
    abstract void Bewegen();

    /**
     * Meldet, ob das Spielende erreicht ist.
     *
     * @return Spielende
     */
    static boolean IstEnde()
    {
        return ende;
    }
}
