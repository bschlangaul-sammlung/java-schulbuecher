package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_05.aufgabe_02.dont_touch;

/**
 * Klasse Löschquadrat
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class LoeschQuadrat extends Quadrat
{
    /**
     * Legt das Aussehen und die Startposition fest
     *
     * @param x x-Koordinate des Hindernisses
     * @param y y-Koordinate des Hindernisses
     * @param richtungNeu Blickrichtung des Hindernisses
     */
    LoeschQuadrat(int x, int y, char richtungNeu)
    {
        super(x, y, richtungNeu);
    }

    /**
     * Entfernt das Quadrat bei Berührung
     */
    @Override
    void Bewegen()
    {
        if (Berührt())
        {
            Entfernen();
        }
        else
        {
            super.Bewegen();
        }
    }
}
