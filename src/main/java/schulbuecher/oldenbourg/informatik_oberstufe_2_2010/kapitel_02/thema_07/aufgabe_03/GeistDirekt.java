package schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_07.aufgabe_03;

/**
 * Ein Geist, der seinen Weg zufällig wählt.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class GeistDirekt extends Figur
{
    /**
     * Die Spielerfigur
     */
    Spieler pac;

    /**
     * Positioniert den Roboter in seiner Welt.
     *
     * @param startX X-Koordinate der Startposition
     * @param startY Y-Koordinate der Startposition
     * @param startBlickrichtung Blickrichtung beim Start
     * @param inWelt Welt, in der der Roboter lebt
     */
    GeistDirekt(int startX, int startY, char startBlickrichtung,
            KarolWelt inWelt, Spieler pac)
    {
        super(startX, startY, startBlickrichtung, inWelt);
        this.pac = pac;
    }

    /**
     * Bewegt den Roboter gemäß seiner Aufgabe.
     */
    void Bewegen()
    {
        int dx;
        int dy;
        char richtung;
        dx = pac.PositionXGeben() - PositionXGeben();
        dy = pac.PositionYGeben() - PositionYGeben();
        if ((dy >= 0) && (dy >= Math.abs(dx)))
        {
            richtung = 'S';
        }
        else if ((dy < 0) && (-dy >= Math.abs(dx)))
        {
            richtung = 'N';
        }
        else if (dx > 0)
        {
            richtung = 'O';
        }
        else
        {
            richtung = 'W';
        }
        RichtungEinstellen(richtung);
        if (IstZiegel())
        {
            LinksDrehen();
            if (IstZiegel())
            {
                RechtsDrehen();
                RechtsDrehen();
                if (IstZiegel())
                {
                    LinksDrehen();
                }
            }
        }
        if (IstRoboter() && (RoboterVorneKennungGeben() == 1))
        {
            for (Beobachter b : beobachter)
            {
                b.VerlorenMelden();
            }
            FigurenThread.EndeSetzen();
        }
        else if (IstFrei())
        {
            Schritt();
        }
    }
}
