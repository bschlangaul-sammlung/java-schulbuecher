package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_01.aufgabe_05.snake;

/**
 * Klasse zur Verwaltung der Schlangenglieder.
 *
 * @author Klaus van Dijkstran
 *
 * @version 1.0
 */
class ZELLE
{
    /** x-Koordinate der Zelle */
    private int x;

    /** y-Koordinate der Zelle */
    private int y;

    /** Referenz auf den Nachfolger */
    private ZELLE nachfolger;

    /**
     * Konstruktor für die Objekte der Klasse ZELLE
     *
     * @param xneu x-Koordinate
     * @param yneu y-Koordinate
     * @param nf Referenz auf die Nachfolger-Zelle.
     */
    ZELLE(int xneu, int yneu, ZELLE nf)
    {
        x = xneu;
        y = yneu;
        nachfolger = nf;
    }

    /**
     * Methode zum Setzen des Nachfolgers einer Zelle
     *
     * @param z Referenz auf neue Nachfolger-Zelle
     */
    void NachfolgerSetzen(ZELLE z)
    {
        nachfolger = z;
    }

    /**
     * Methode zum Geben des Nachfolgers einer Zelle
     *
     * @return Referenz auf Nachfolger-Zelle
     */
    ZELLE NachfolgerGeben()
    {
        return nachfolger;
    }

    /**
     * Belegt beim übergebenen Spiel das Feld mit den Koordinaten x und y
     *
     * @param s Spiel
     */
    void FeldBelegen(SPIEL s)
    {
        s.FeldBelegen(x, y);
    }

    /**
     * Gibt beim übergebenen Spiel das Feld mit den Koordinaten x und y frei
     *
     * @param s Spiel
     */
    void FeldFreigeben(SPIEL s)
    {
        s.FeldFreigeben(x, y);
    }

    /**
     * Gibt die x-Koordinate aus
     *
     * @return x-Koordinate
     */
    int XGeben()
    {
        return x;
    }

    /**
     * Gibt die y-Koordinate aus
     *
     * @return y-Koordinate
     */
    int YGeben()
    {
        return y;
    }
}
