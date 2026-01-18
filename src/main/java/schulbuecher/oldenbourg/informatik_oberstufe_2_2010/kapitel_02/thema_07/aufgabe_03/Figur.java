package schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_07.aufgabe_03;

import java.util.ArrayList;

/**
 * Roboter mit den Zusatzeigenschaften für die Pacman-Figuren.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
abstract class Figur extends Karol implements Erzeuger
{
    protected ArrayList<Beobachter> beobachter;

    /**
     * Positioniert den Roboter in seiner Welt.
     *
     * @param startX X-Koordinate der Startposition
     * @param startY Y-Koordinate der Startposition
     * @param startBlickrichtung Blickrichtung beim Start
     * @param inWelt Welt, in der der Roboter lebt
     */
    Figur(int startX, int startY, char startBlickrichtung, KarolWelt inWelt)
    {
        super(startX, startY, startBlickrichtung, inWelt);
        beobachter = new ArrayList<Beobachter>();
        VerzoegerungSetzen(0);
    }

    /**
     * Registriert einen Beobachter
     */
    public void Registrieren(Beobachter b)
    {
        beobachter.add(b);
    }

    /**
     * Bewegt den Roboter gemäß seiner Aufgabe.
     */
    abstract void Bewegen();

    /**
     * Dreht die Figur in die angegebene Richtung.
     *
     * @param richtung Laufrichtung
     */
    protected void RichtungEinstellen(char richtung)
    {
        while (BlickrichtungGeben() != richtung)
        {
            RechtsDrehen();
        }
    }

    /**
     * Meldet, ob der Weg vor dem Roboter frei ist.
     *
     * @return wahr, wenn Schritt ausgeführt werden kann
     */
    protected boolean IstFrei()
    {
        return !(IstWand() || IstZiegel() || IstRoboter());
    }
}
