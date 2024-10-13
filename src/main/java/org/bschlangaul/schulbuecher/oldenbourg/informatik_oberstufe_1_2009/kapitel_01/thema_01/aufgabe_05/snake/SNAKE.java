package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_01.aufgabe_05.snake;

/**
 * Klasse zur Verwaltung der Snake-Schlange Am Kopf des Snake-Objekts werden
 * Objekte eingefügt; er entspricht deshalb dem Ende einer Warteschlange!
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class SNAKE
{
    /** Referenz auf Anfangszelle (Schwanz der Snake) */
    private ZELLE anfang;

    /** Referenz auf Endzelle (Kopf der Snake) */
    private ZELLE ende;

    /** momentane Ausrichtung ('O';'W';'N';'S') der Snake */
    private char ausrichtung;

    /** Referenz auf das Spiel-Objekt */
    private SPIEL spiel;

    /**
     * Konstruktor für das Objekt der Klasse SNAKE. Schlange schaut zu Beginn
     * nach Osten und besteht aus drei Zellen.
     *
     */
    SNAKE(SPIEL s)
    {
        spiel = s;
        ZELLE zelle1, zelle2, zelle3;
        ausrichtung = 'O';
        zelle1 = new ZELLE(4, 0, null);
        zelle1.FeldBelegen(spiel);
        zelle2 = new ZELLE(3, 0, zelle1);
        zelle2.FeldBelegen(spiel);
        zelle3 = new ZELLE(2, 0, zelle2);
        zelle3.FeldBelegen(spiel);
        ende = zelle1;
        anfang = zelle3;
    }

    /**
     * Methode zum Einfügen einer Zelle. Achtung: Der Anfang (im Sinne der
     * Warteschlange) entspricht dem Schwanz der Schlange und umgekehrt. Legt
     * das neue Ende fest und informiert das bisherige Ende darüber. Das Spiel
     * muss informiert werden, dass das Feld nicht mehr belegt ist.
     *
     * @param z einzufügende Zelle am Ende der Datenstruktur (entspricht dem
     *     Kopf der Schlange!).
     */
    void Einfuegen(ZELLE z)
    {
        ende.NachfolgerSetzen(z);
        ende = z;
        ende.FeldBelegen(spiel);
    }

    /**
     * Methode zum Entfernen einer Zelle. Achtung: Der Anfang (im Sinne der
     * Warteschlange) entspricht dem Schwanz der Schlange und umgekehrt. Fordert
     * die anfang-Zelle auf, ihr Feld beim Spiel freizugeben. Setzt den Anfang
     * auf den bisherigen Nachfolger des Anfangs.
     */
    void Entfernen()
    {
        anfang.FeldFreigeben(spiel);
        anfang = anfang.NachfolgerGeben();
    }

    /**
     * Bewegt Schlange um einen Schritt nach vorne. Holt sich dazu die
     * Koordinaten des Kopfes (Ende!) Wenn auf der Nachbarzelle des Kopfes
     * (Ende!) ein Futter liegt, wir dieses gefressen (d.h. der Anfang
     * (Schwanz!) nicht entfernt), die Schlange wird um ein Glied länger.
     * Ansonsten wird der Schwanz entfernt. Die Nachbarzelle wird eingefügt.
     */
    void SchrittVor()
    {
        int xkopf, ykopf;
        xkopf = ende.XGeben();
        ykopf = ende.YGeben();
        if (!spiel.IstFutter(spiel.Nachbarzelle_XBerechnen(xkopf, ausrichtung),
                spiel.Nachbarzelle_YBerechnen(ykopf, ausrichtung)))
        {
            Entfernen();
        }
        Einfuegen(new ZELLE(spiel.Nachbarzelle_XBerechnen(xkopf, ausrichtung),
                spiel.Nachbarzelle_YBerechnen(ykopf, ausrichtung), null));
    }

    /**
     * Methode zur Richtungsänderung Je nach momentaner Ausrichtung
     * ('O';'W';'N';'S') und änderungsrichtung ('l';'r') wird die neue Richtung
     * ermittelt.
     *
     * @param richtung änderungsrichtung ('l';'r')
     */
    void RichtungAendern(char richtung)
    {
        if (richtung == 'l')
        {
            switch (ausrichtung)
            {
            case 'O':
                ausrichtung = 'N';
                break;

            case 'N':
                ausrichtung = 'W';
                break;

            case 'W':
                ausrichtung = 'S';
                break;

            default:
                ausrichtung = 'O';
            }
        }
        else
        {
            switch (ausrichtung)
            {
            case 'O':
                ausrichtung = 'S';
                break;

            case 'S':
                ausrichtung = 'W';
                break;

            case 'W':
                ausrichtung = 'N';
                break;

            default:
                ausrichtung = 'O';
            }
        }
    }
}
