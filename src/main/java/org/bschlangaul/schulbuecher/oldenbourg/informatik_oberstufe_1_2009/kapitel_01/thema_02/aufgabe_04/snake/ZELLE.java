package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_02.aufgabe_04.snake;

/**
 * Klasse zur Verwaltung der Schlangenglieder.
 *
 * @author Klaus van Dijkstran
 *
 * @version 1.0
 */
class ZELLE implements DATENELEMENT
{
    /** x-Koordinate der Zelle */
    private int x;

    /** y-Koordinate der Zelle */
    private int y;

    /**
     * Konstruktor für die Objekte der Klasse ZELLE
     *
     * @param xneu x-Koordinate
     * @param yneu y-Koordinate
     */
    ZELLE(int xneu, int yneu)
    {
        x = xneu;
        y = yneu;
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

    /**
     * Ohne Funktion in diesem Projekt
     */
    public void InformationAusgeben()
    {
    }
}
