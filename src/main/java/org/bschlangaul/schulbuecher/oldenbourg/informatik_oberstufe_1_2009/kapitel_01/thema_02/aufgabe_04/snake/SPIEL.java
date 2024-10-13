package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_02.aufgabe_04.snake;

import java.util.Random;

/**
 * Klasse zur Verwaltung des Spiels
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class SPIEL
{
    /**
     * Verwaltung der Darstellung
     */
    private DARSTELLUNG darstellung;

    /**
     * Verwaltung des Spielfeldes
     */
    private char[][] spielfeld;

    /**
     * Anzahl der Kästchen nach rechts
     */
    private int kaestchenzahl_rechts;

    /**
     * Anzahl der Kästchen nach unten
     */
    private int kaestchenzahl_unten;

    /**
     * Zufallsgenerator für das Futter
     */
    private Random zgenerator;

    /**
     * Spiel beendet oder nicht
     */
    private boolean beendet;

    /**
     * Verwaltung des Snake-Objekts
     */
    private SNAKE snake;

    /**
     * Konstruktor der Klasse SPIEL <br>
     * Spiel wird als nicht beendet gesetzt. <br>
     * Spielfeldgröße wird festgelegt. <br>
     * Erzeugt eine Darstellung. <br>
     * Erzeugt ein leeres Spielfeld <br>
     * Setzt ein erstes Futter <br>
     * Erzeugt eine Snake
     */
    SPIEL()
    {
        beendet = false;
        kaestchenzahl_rechts = 20;
        kaestchenzahl_unten = 20;
        darstellung = new DARSTELLUNG(this, kaestchenzahl_rechts,
                kaestchenzahl_unten);
        spielfeld = new char[kaestchenzahl_rechts][kaestchenzahl_unten];
        for (int i = 0; i < kaestchenzahl_rechts; i++)
        {
            for (int j = 0; j < kaestchenzahl_unten; j++)
            {
                spielfeld[i][j] = 'l'; // leeres Spielfeldelement
            }
        }
        // Erstes Futter (nicht als Teil der Schlange, deshalb erst ab zweiter
        // Zeile)
        zgenerator = new Random();
        spielfeld[zgenerator.nextInt(kaestchenzahl_rechts)][zgenerator
                .nextInt(kaestchenzahl_unten - 1) + 1] = 'f'; // f wie Futter
        snake = new SNAKE(this);
    }

    /**
     * Falls das Spiel nicht beendet ist, rückt die Schlange ein Feld vor und
     * die Darstellung wird neu gezeichnet.
     */
    void SpielSchritt()
    {
        if (!beendet)
        {
            snake.SchrittVor();
            darstellung.Zeichnen();
        }
    }

    /**
     * Berechnung der x-Koordinate der Zelle, die vor dem Kopf der Schlange
     * liegt, abhängig von der Ausrichtung der Schlange. Am Rand des Spielfeldes
     * wird über den gegenüberliegenden Rand geblickt.
     *
     * @param x x-Koordinate des Schlangenkopfes
     * @param ausrichtung Ausrichtung der Schlange
     *
     * @return x-Koordinate des Spielfeldelements, das vor dem Schlangenkopf
     *     liegt.
     */
    int Nachbarzelle_XBerechnen(int x, char ausrichtung)
    {
        if (ausrichtung == 'O')
        {
            if (x + 1 < kaestchenzahl_rechts)
            {
                x = x + 1;
            }
            else
            {
                x = 0;
            }
        }
        if (ausrichtung == 'W')
        {
            if (x - 1 >= 0)
            {
                x = x - 1;
            }
            else
            {
                x = kaestchenzahl_rechts - 1;
            }
        }
        return x;
    }

    /**
     * Berechnung der y-Koordinate der Zelle, die vor dem Kopf der Schlange
     * liegt, abhängig von der Ausrichtung der Schlange. Am Rand des Spielfeldes
     * wird über den gegenüberliegenden Rand geblickt.
     *
     * @param y y-Koordinate des Schlangenkopfes
     * @param ausrichtung Ausrichtung der Schlange
     *
     * @return y-Koordinate des Spielfeldelements, das vor dem Schlangenkopf
     *     liegt.
     */
    int Nachbarzelle_YBerechnen(int y, char ausrichtung)
    {
        if (ausrichtung == 'S')
        {
            if (y + 1 < kaestchenzahl_unten)
            {
                y = y + 1;
            }
            else
            {
                y = 0;
            }
        }
        if (ausrichtung == 'N')
        {
            if (y - 1 >= 0)
            {
                y = y - 1;
            }
            else
            {
                y = kaestchenzahl_unten - 1;
            }
        }
        return y;
    }

    /**
     * Prüft, ob auf einem bestimmten Feld Futter liegt.
     *
     * @param x x-Koordinate des Feldes
     * @param y y-Koordinate des Feldes
     *
     * @return liefert true, falls auf dem Feld Futter liegt.
     */
    boolean IstFutter(int x, int y)
    {
        if (spielfeld[x][y] == 'f')
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Belegt ein Feld als Teil der Schlange. <br>
     * Falls auf dem Feld Futter liegt, wird es gefressen und ein neues Futter
     * in einem Feld erzeugt, in dem sich keine Schlange befindet. <br>
     * Falls sich auf diesem Feld eine Schlange befindet, wird das Spiel
     * beendet.
     *
     * @param x x-Koordinate des Feldes
     * @param y y-Koordinate des Feldes
     */
    void FeldBelegen(int x, int y)
    {
        if (spielfeld[x][y] == 's')
        {
            beendet = true;
        }
        else
        {
            if (spielfeld[x][y] == 'f')
            {
                boolean neuesFutterFeldGefunden;
                neuesFutterFeldGefunden = false;
                while (!neuesFutterFeldGefunden)
                {
                    int xneu, yneu;
                    xneu = zgenerator.nextInt(kaestchenzahl_rechts);
                    yneu = zgenerator.nextInt(kaestchenzahl_unten);
                    if (!(spielfeld[xneu][yneu] == 's'
                            || spielfeld[xneu][yneu] == 'f'))
                    {
                        spielfeld[xneu][yneu] = 'f';
                        neuesFutterFeldGefunden = true;
                    }
                }
            }
            spielfeld[x][y] = 's';
        }
    }

    /**
     * Gibt ein belegtes Feld frei.
     *
     * @param x x-Koordinate des Feldes
     * @param y y-Koordinate des Feldes
     */
    void FeldFreigeben(int x, int y)
    {
        spielfeld[x][y] = 'l';
    }

    /**
     * Gibt das Spielfeld aus.
     *
     * @return Spielfeld
     */
    char[][] SpielfeldGeben()
    {
        return spielfeld;
    }

    /**
     * Meldet an die Snake eine Richtungsänderung weiter.
     *
     * @param w Weiterzuleitender Drehsinn (l/r)
     */
    void RichtungsAenderungWeiterleiten(char w)
    {
        snake.RichtungAendern(w);
    }
}
