package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_05.aufgabe_02.dont_touch;

/**
 * Klasse Stern
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Stern extends Hindernis
{
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
    Stern(int x, int y, char richtungNeu)
    {
        super(x, y, richtungNeu);
        if (richtungNeu == 'N')
        {
            winkel = 10;
        }
        else
        {
            if (richtungNeu == 'S')
            {
                winkel = 190;
            }
            else
            {
                if (richtungNeu == 'O')
                {
                    winkel = 80;
                }
                else
                {
                    if (richtungNeu == 'W')
                    {
                        winkel = 260;
                    }
                    else
                    {
                        System.out.println(
                                "unbekannte Richtung in Methode Bewegen, Klasse Hindernis");
                    }
                }
            }
        }
        WinkelSetzen(winkel);
        Zeichnen();
    }

    /**
     * Reflektiert das Hindernis
     */
    @Override
    void Bewegen()
    {
        if (winkel == 10)
        {
            if (XPositionGeben() > 890)
            {
                winkel = 170;
            }
        }
        else
        {
            if (winkel == 170)
            {
                if (XPositionGeben() < 10)
                {
                    winkel = 10;
                }
            }
            else
            {
                if (winkel == 350)
                {
                    if (XPositionGeben() > 890)
                    {
                        winkel = 190;
                    }
                }
                else
                {
                    if (winkel == 190)
                    {
                        if (XPositionGeben() < 10)
                        {
                            winkel = 350;
                        }
                    }
                    else
                    {
                        if (winkel == 80)
                        {
                            if (YPositionGeben() < 10)
                            {
                                winkel = 280;
                            }
                        }
                        else
                        {
                            if (winkel == 280)
                            {
                                if (YPositionGeben() > 690)
                                {
                                    winkel = 80;
                                }
                            }
                            else
                            {
                                if (winkel == 100)
                                {
                                    if (YPositionGeben() < 10)
                                    {
                                        winkel = 260;
                                    }
                                }
                                else
                                {
                                    if (winkel == 260)
                                    {
                                        if (YPositionGeben() > 690)
                                        {
                                            winkel = 100;
                                        }
                                    }
                                    else
                                    {
                                        System.out.println(
                                                "unbekannte Richtung in Methode Bewegen, Klasse Hindernis");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        WinkelSetzen(winkel);
        Gehen(5);
        EntfernenWennAußerhalb();
    }

    /**
     * Legt Form und Größe des Hindernisses fest
     */
    @Override
    void Zeichnen()
    {
        EigeneFigurLöschen();
        FigurteilFestlegenDreieck(-25, -50, 50, 0, -25, 50, "grün");
        FigurteilFestlegenDreieck(25, -50, -50, 0, 25, 50, "grün");
        GrößeSetzen(60);
    }
}
