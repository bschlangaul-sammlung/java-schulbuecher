package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_12.snake;

/**
 * Klasse zur Verwaltung der Hindernisse
 *
 * @author Klaus Reinold
 * @version 1.0
 */
import java.util.Random;

class HINDERNIS
{
    /** x-Position des Hindernisses */
    protected int x;

    /** y-Position des Hindernisses */
    protected int y;

    /** Bewegungsrichtung */
    protected char ausrichtung;

    /** Zufallsgenerator für das Futter */
    protected Random zgenerator;

    /**
     * Konstruktor legt einen geeigneten Startort fest.
     */
    HINDERNIS()
    {
        x = 0;
        y = 0;
        ausrichtung = 'N';
        zgenerator = new Random();
    }

    /**
     * Legt einen neuen Startort fest.
     */
    void RichtungUndOrtBestimmen(SPIEL s)
    {
        int richtung_neu;
        richtung_neu = zgenerator.nextInt(4);
        switch (richtung_neu)
        {
        case 0:
            ausrichtung = 'N';
            break;

        case 1:
            ausrichtung = 'O';
            break;

        case 2:
            ausrichtung = 'S';
            break;

        default:
            ausrichtung = 'W';
        }
        switch (ausrichtung)
        {
        case 'S':
            y = 0;
            x = zgenerator.nextInt(s.Kaestchenzahl_rechtsGeben());
            break;

        case 'O':
            x = 0;
            y = zgenerator.nextInt(s.Kaestchenzahl_untenGeben());
            break;

        case 'N':
            y = s.Kaestchenzahl_untenGeben() - 1;
            x = zgenerator.nextInt(s.Kaestchenzahl_rechtsGeben());
            break;

        default:
            x = s.Kaestchenzahl_rechtsGeben() - 1;
            y = zgenerator.nextInt(s.Kaestchenzahl_untenGeben());
        }
    }

    /**
     * Gibt den x-Wert des vorausliegenden Feldes aus
     *
     * @return x-Wert des vorausliegenden Feldes
     */
    protected int X_VorausBerechnen()
    {
        int xneu;
        switch (ausrichtung)
        {
        case 'S':
            xneu = x;
            break;

        case 'O':
            xneu = x + 1;
            break;

        case 'N':
            xneu = x;
            break;

        default:
            xneu = x - 1;
        }
        return xneu;
    }

    /**
     * Gibt den x-Wert des vorausliegenden Feldes aus
     *
     * @return x-Wert des vorausliegenden Feldes
     */
    protected int Y_VorausBerechnen()
    {
        int yneu;
        switch (ausrichtung)
        {
        case 'S':
            yneu = y + 1;
            break;

        case 'O':
            yneu = y;
            break;

        case 'N':
            yneu = y - 1;
            break;

        default:
            yneu = y;
        }
        return yneu;
    }
}
