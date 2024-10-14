package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_05.aufgabe_02.dont_touch;

/**
 * Klasse Verdopplerquadrat
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class VerdopplerQuadrat extends Quadrat
{
    /**
     * die aktuelle Blickrichtung
     */
    char richtung;

    /**
     * Legt das Aussehen und die Startposition fest
     *
     * @param x x-Koordinate des Hindernisses
     * @param y y-Koordinate des Hindernisses
     * @param richtungNeu Blickrichtung des Hindernisses
     */
    VerdopplerQuadrat(int x, int y, char richtungNeu)
    {
        super(x, y, richtungNeu);
        richtung = richtungNeu;
    }

    /**
     * Verdoppelt das Quadrat bei Berührung
     */
    @Override
    void Bewegen()
    {
        if (Berührt())
        {
            if (richtung == 'N')
            {
                new Quadrat(XPositionGeben(), YPositionGeben(), 'O');
            }
            else
            {
                if (richtung == 'S')
                {
                    new Quadrat(XPositionGeben(), YPositionGeben(), 'W');
                }
                else
                {
                    if (richtung == 'O')
                    {
                        new Quadrat(XPositionGeben(), YPositionGeben(), 'S');
                    }
                    else
                    {
                        if (richtung == 'W')
                        {
                            new Quadrat(XPositionGeben(), YPositionGeben(),
                                    'N');
                        }
                        else
                        {
                            System.out.println(
                                    "unbekannte Richtung in Methode Bewegen, Klasse VerdopplerQuadrat");
                        }
                    }
                }
            }
            new Quadrat(XPositionGeben(), YPositionGeben(), richtung);
            Entfernen();
        }
        else
        {
            super.Bewegen();
        }
    }
}
