package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_05.aufgabe_02.dont_touch;

/**
 * Klasse Hindernis
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Hindernis extends Figur
{
    /**
     * Legt das Aussehen des Hindernisses an
     *
     * @param x x-Koordinate des Hindernisses
     * @param y y-Koordinate des Hindernisses
     * @param richtung Blickrichtung des Hindernisses
     */
    Hindernis(int x, int y, char richtung)
    {
        Zeichnen();
        PositionSetzen(x, y);
        RichtungSetzen(richtung);
    }

    /**
     * Bewegt das Hindernis
     */
    void AktionAusführen()
    {
        Bewegen();
    }

    /**
     * Tasten werden ignoriert
     *
     * @param taste die gedrückte Taste
     */
    @Override
    void TasteGedrückt(char taste)
    {
    }

    /**
     * Sondertasten werden ignoriert
     *
     * @param taste die gedrückte Taste
     */
    @Override
    void SonderTasteGedrückt(int taste)
    {
    }

    /**
     * Lässt das Hindernis um 5 Einheiten gehen
     */
    void Bewegen()
    {
        Gehen(5);
    }

    /**
     * Legt Form und Größe des Hindernisses fest
     */
    void Zeichnen()
    {
        FigurteilFestlegenRechteck(0, 0, 100, 500, "grün");
        GrößeSetzen(50);
        PositionSetzen(700, 200);
    }

    /**
     * Setzt die Blickrichtuing des Hindernisses
     */
    void RichtungSetzen(char richtung)
    {
        if (richtung == 'O')
        {
            // nichts
        }
        else
        {
            if (richtung == 'N')
            {
                Drehen(90);
            }
            else
            {
                if (richtung == 'W')
                {
                    Drehen(180);
                }
                else
                {
                    if (richtung == 'S')
                    {
                        Drehen(270);
                    }
                    else
                    {
                        System.out.println(
                                "Fehlerhafte Richtung in Konstruktor von Hindernis");
                    }
                }
            }
        }
    }

    /**
     * Entfernt das Hindernis, wenn es die Zeichenfläche verlässt
     */
    void EntfernenWennAußerhalb()
    {
        if ((XPositionGeben() < -100) || (XPositionGeben() > 900)
                || (YPositionGeben() < -100) || (YPositionGeben() > 700))
        {
            Entfernen();
        }
    }
}
