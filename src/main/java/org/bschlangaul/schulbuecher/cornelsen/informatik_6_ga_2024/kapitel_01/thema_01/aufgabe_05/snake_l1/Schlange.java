package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_01.aufgabe_05.snake_l1;

/**
 * Die Verwaltungsklasse der Schlange.
 *
 * @author Albert Wiedemann/Klaus Reinold
 *
 * @version 1.0
 */
class Schlange
{
    /**
     * Darstellung des Kopfs.
     */
    private KopfSymbol kopf;

    /**
     * Darstellung des Rumpfs
     */
    private Warteschlange rumpf;

    /**
     * Legt die Schlange an und stellt Anfangsposition und -bewgungsrichtung
     * ein.
     *
     * @param x: x-Koordinate der Startposition des Schlangenkopfs
     * @param y: y-Koordinate der Startposition des Schlangenkopfs
     * @param richtung: Startrichtung des Schlangenkopfs
     */
    Schlange(int x, int y, char richtung)
    {
        kopf = new KopfSymbol();
        kopf.AusrichtungSetzen(richtung);
        kopf.PositionSetzen(x, y);
        rumpf = new Warteschlange();
        for (int i = 0; i < 5; i++)
        {
            RumpfSymbol r = new RumpfSymbol();
            switch (richtung)
            {
            case 'O':
                r.PositionSetzen(x - (5 - i), y);
                break;

            case 'N':
                r.PositionSetzen(x, y + (5 - i));
                break;

            case 'W':
                r.PositionSetzen(x + (5 - i), y);
                break;

            case 'S':
                r.PositionSetzen(x, y - (5 - i));
                break;
            }
            rumpf.Einfügen(r);
        }
    }

    /**
     * Bewegt die Schlange ein Feld in der eingestellten Richtung.
     *
     * @param verlängern wenn wahr, wird das letzte Rumpfelement nicht entfernt.
     */
    void Bewegen(boolean verlängern)
    {
        int x, xalt;
        int y, yalt;
        x = kopf.XPositionGeben();
        y = kopf.YPositionGeben();
        xalt = x;
        yalt = y;
        switch (kopf.AusrichtungGeben())
        {
        case 'O':
            x += 1;
            break;

        case 'N':
            y -= 1;
            break;

        case 'W':
            x -= 1;
            break;

        case 'S':
            y += 1;
            break;
        }
        kopf.PositionSetzen(x, y);
        if (!verlängern)
        {
            RumpfSymbol r = rumpf.Entfernen();
            r.Entfernen();
        }
        RumpfSymbol r = new RumpfSymbol();
        r.PositionSetzen(xalt, yalt);
        rumpf.Einfügen(r);
    }

    /**
     * Setzt die Bewegunsrichtung der Schlange.
     *
     * @param richtungNeu (neue) Bewegungsrichtung
     */
    void RichtungSetzen(char richtungNeu)
    {
        kopf.AusrichtungSetzen(richtungNeu);
    }

    /**
     * Gibt die x-Position des Schlangenkopfs zurück.
     *
     * @return x-Position des Schlangenkopfs
     */
    int XPositionGeben()
    {
        return kopf.XPositionGeben();
    }

    /**
     * Gibt die y-Position des Schlangenkopfs zurück.
     *
     * @return y-Position des Schlangenkopfs
     */
    int YPositionGeben()
    {
        return kopf.YPositionGeben();
    }

    /**
     * Prüft ob der Schlangenkopf auf der Position eines Rumpfsymbols ist,
     * d.h.sich die Schlange selbst gebissen hat. return wahr, wenn der Kopf im
     * Rumpf liegt.
     */
    boolean KopfInRumpf()
    {
        return PunktInRumpf(kopf.XPositionGeben(), kopf.YPositionGeben());
    }

    /**
     * Prueft ob der angegebene Punkt auf der Position eines Rumpfsymbols ist.
     *
     * @return wahr, wenn der Punkt zu einem Rumpfelement gehört.
     */
    boolean PunktInRumpf(int x, int y)
    {
        RumpfSymbol r;
        r = rumpf.AnfangGeben();
        while (r != null)
        {
            if ((x == r.XPositionGeben()) && (y == r.YPositionGeben()))
            {
                return true;
            }
            r = r.NachfolgerGeben();
        }

        // for (RumpfSymbol r: rumpf)
        // {
        // if ((x == r.XPositionGeben()) && (y == r.YPositionGeben()))
        // {
        // return true;
        // }
        // }
        return false;
    }
}
