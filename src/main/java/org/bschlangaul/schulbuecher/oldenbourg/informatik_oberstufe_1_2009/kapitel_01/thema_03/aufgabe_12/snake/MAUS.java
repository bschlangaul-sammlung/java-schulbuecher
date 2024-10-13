package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_12.snake;

/**
 * Klasse zur Verwaltung der Maus
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class MAUS extends HINDERNIS
{
    /**
     * Konstruktor der Maus Ruft den Konstruktor der Oberklasse auf.
     */
    MAUS()
    {
        super();
    }

    /**
     * Berechnung des nächsten Schrittes
     *
     * @param s Spiel
     */
    void SchrittVor(SPIEL s)
    {
        s.FeldFreigeben(x, y);
        int xneu, yneu;
        xneu = super.X_VorausBerechnen();
        yneu = super.Y_VorausBerechnen();
        if (s.IstInSpielfeld(xneu, yneu))
        {
            x = xneu;
            y = yneu;
        }
        else
        {
            RichtungUndOrtBestimmen(s);
        }
        SNAKE snake;
        snake = s.SnakeGeben();
        if (snake.Suchen(x + "," + y) == null)
        {
            s.FeldBelegen(x, y, 'm');
        }
        else
        {
            snake.MausFressen();
            s.FeldBelegen(x, y, 's');
            RichtungUndOrtBestimmen(s);
        }
    }
}
