package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_12.snake;

/**
 * Klasse zur Verwaltung des Autos
 *
 * @author Klaus van Dijkstran
 * @version 1.0
 */
class AUTO extends HINDERNIS
{
    /**
     * Konstruktor des Autos Ruft den Konstruktor der Oberklasse auf.
     */
    AUTO()
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
            s.FeldBelegen(x, y, 'a');
        }
        else
        {
            snake.RestEntfernen(x + "," + y);
            if (snake.IstAnfang(x, y))
            {
                s.BeendetSetzen(true);
            }
            s.FeldBelegen(x, y, 'a');
        }
    }
}
