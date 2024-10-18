package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_12.snake;

/**
 * Klasse zur Verwaltung des Autos
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Auto extends Hindernis
{
    /**
     * Konstruktor des Autos Ruft den Konstruktor der Oberklasse auf.
     */
    Auto()
    {
        super();
    }

    /**
     * Berechnung des nächsten Schrittes
     *
     * @param s Spiel
     */
    void SchrittVor(Spiel s)
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
        Snake snake;
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
