package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_05.aufgabe_00.einstieg;

/**
 * Klasse Zickezacke.
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Zickezacke extends Hindernis
{
    /**
     * Zählt die grmachten Zacks
     */
    int zackenzähler;

    /**
     * Der Drehwinkel
     */
    int winkel;

    /**
     * Legt das Aussehen und die Startposition fest
     *
     * @param x x-Koordinate des Hindernisses
     * @param y y-Koordinate des Hindernisses
     * @param richtungNeu Blickrichtung des Hindernisses
     */
    Zickezacke(int x, int y, char richtungNeu)
    {
        super(x, y, richtungNeu);
        Zeichnen();
        RichtungSetzen(richtungNeu);
        winkel = 45;
        Drehen(winkel);
        PositionSetzen(x, y);
        zackenzähler = 5;
    }

    /**
     * Führt dei Zickzackbewegung durch
     */
    @Override
    void Bewegen()
    {
        if (zackenzähler == 0)
        {
            if (winkel == 45)
            {
                winkel = -45;
                Drehen(-90);
            }
            else
            {
                winkel = 45;
                Drehen(90);
            }
            zackenzähler = 9;
        }
        else
        {
            Gehen(5);
            zackenzähler = zackenzähler - 1;
        }
        EntfernenWennAußerhalb();
    }

    /**
     * Legt Form und Größe des Hindernisses fest
     */
    @Override
    void Zeichnen()
    {
        EigeneFigurLöschen();
        FigurteilFestlegenDreieck(-50, -50, 50, 0, -50, 50, "magenta");
        GrößeSetzen(40);
    }
}
