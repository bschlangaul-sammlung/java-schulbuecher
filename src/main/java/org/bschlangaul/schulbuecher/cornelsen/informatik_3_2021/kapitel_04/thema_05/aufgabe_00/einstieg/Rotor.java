package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_05.aufgabe_00.einstieg;

/**
 * Klasse Rotor
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Rotor extends Hindernis
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
    Rotor(int x, int y, char richtungNeu)
    {
        super(x, y, richtungNeu);
        richtung = richtungNeu;
        Zeichnen();
        RichtungSetzen(richtung);
        PositionSetzen(x, y);
    }

    /**
     * Rotiert das Hindernis
     */
    @Override
    void Bewegen()
    {
        Drehen(5);
        if (richtung == 'N')
        {
            PositionSetzen(XPositionGeben(), YPositionGeben() - 5);
        }
        else
        {
            if (richtung == 'S')
            {
                PositionSetzen(XPositionGeben(), YPositionGeben() + 5);
            }
            else
            {
                if (richtung == 'O')
                {
                    PositionSetzen(XPositionGeben() + 5, YPositionGeben());
                }
                else
                {
                    if (richtung == 'W')
                    {
                        PositionSetzen(XPositionGeben() - 5, YPositionGeben());
                    }
                    else
                    {
                        System.out.println(
                                "unbekannte Richtung in Methode Bewegen, Klasse Hindernis");
                    }
                }
            }
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
        FigurteilFestlegenDreieck(0, 0, 0, 100, 100, 50, "gelb");
        FigurteilFestlegenEllipse(30, 30, 40, 40, "blau");
        GrößeSetzen(60);
    }
}
