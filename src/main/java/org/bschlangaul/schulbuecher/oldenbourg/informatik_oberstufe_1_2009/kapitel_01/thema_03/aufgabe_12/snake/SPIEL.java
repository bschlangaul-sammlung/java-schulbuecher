package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_12.snake;

/**
 * Klasse zur Verwaltung des Spiels
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class SPIEL
{
    /** Verwaltung der Darstellung */
    private DARSTELLUNG darstellung;

    /** Verwaltung des Spielfeldes */
    private char[][] spielfeld;

    /** Anzahl der Kästchen nach rechts */
    private int kaestchenzahl_rechts;

    /** Anzahl der Kästchen nach unten */
    private int kaestchenzahl_unten;

    /** Spiel beendet oder nicht */
    private boolean beendet;

    /** Verwaltung des Snake-Objekts */
    private SNAKE snake;

    /** Verwaltung des Maus-Objekts */
    private MAUS maus;

    /** Verwaltung des Auto-Objekts */
    private AUTO auto;

    /**
     * Konstruktor der Klasse SPIEL <br>
     * Spiel wird als nicht beendet gesetzt. <br>
     * Spielfeldgröße wird festgelegt. <br>
     * Erzeugt eine Darstellung. <br>
     * Erzeugt ein leeres Spielfeld <br>
     * Setzt ein erstes Futter <br>
     * Erzeugt eine Snake, eines Autos und einer Maus
     */
    SPIEL()
    {
        beendet = false;
        kaestchenzahl_rechts = 20;
        kaestchenzahl_unten = 20;
        spielfeld = new char[kaestchenzahl_rechts][kaestchenzahl_unten];
        for (int i = 0; i < kaestchenzahl_rechts; i++)
        {
            for (int j = 0; j < kaestchenzahl_unten; j++)
            {
                spielfeld[i][j] = 'l'; // leeres Spielfeldelement
            }
        }
        snake = new SNAKE(this);
        auto = new AUTO();
        maus = new MAUS();
        darstellung = new DARSTELLUNG(this, kaestchenzahl_rechts,
                kaestchenzahl_unten);
    }

    /**
     * Falls das Spiel nicht beendet ist, rücken Schlange, Maus und Auto ein
     * Feld vor und die Darstellung wird neu gezeichnet.
     */
    void SpielSchritt()
    {
        if (!beendet)
        {
            maus.SchrittVor(this);
            snake.SchrittVor();
            darstellung.Zeichnen();
            auto.SchrittVor(this);
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
     * Prüft, ob auf einem bestimmten Feld eine Maus liegt.
     *
     * @param x x-Koordinate des Feldes
     * @param y y-Koordinate des Feldes
     *
     * @return liefert true, falls auf dem Feld Maus liegt.
     */
    boolean IstMaus(int x, int y)
    {
        if (spielfeld[x][y] == 'm')
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Prüft, ob auf einem bestimmten Feld ein Auto liegt.
     *
     * @param x x-Koordinate des Feldes
     * @param y y-Koordinate des Feldes
     *
     * @return liefert true, falls auf dem Feld ein Auto liegt.
     */
    boolean IstAuto(int x, int y)
    {
        if (spielfeld[x][y] == 'a')
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Belegt ein Feld als Teil der Schlange, bzw. als Auto oder Maus.
     *
     * @param x x-Koordinate des Feldes
     * @param y y-Koordinate des Feldes
     * @param art Art der Belegung ('s', 'm' oder 'a')
     */
    void FeldBelegen(int x, int y, char art)
    {
        spielfeld[x][y] = art;
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

    /**
     * Prüft, ob (x;y) im Spielfeld liegt.
     *
     * @param x x-Koordinate
     * @param y y-Koordinate
     *
     * @return Wahrheitswert
     */
    boolean IstInSpielfeld(int x, int y)
    {
        return ((x >= 0) && (x < kaestchenzahl_rechts) && (y >= 0)
                && (y < kaestchenzahl_unten));
    }

    /**
     * Liefert die Anzahl der Kästchen nach rechts
     *
     * @return kaestchenzahl_rechts
     */
    int Kaestchenzahl_rechtsGeben()
    {
        return kaestchenzahl_rechts;
    }

    /**
     * Liefert die Anzahl der Kästchen nach unten
     *
     * @return kaestchenzahl_unten
     */
    int Kaestchenzahl_untenGeben()
    {
        return kaestchenzahl_unten;
    }

    /**
     * Liefert die Snake
     *
     * @return Snake
     */
    SNAKE SnakeGeben()
    {
        return snake;
    }

    /**
     * Setzt das Spiel auf beendet
     *
     * @param b neuer Wert von beendet
     */
    void BeendetSetzen(boolean b)
    {
        beendet = b;
    }

    /**
     * Positioniert die Maus neu am Rand.
     */
    void MausFressen()
    {
        maus.RichtungUndOrtBestimmen(this);
    }
}
