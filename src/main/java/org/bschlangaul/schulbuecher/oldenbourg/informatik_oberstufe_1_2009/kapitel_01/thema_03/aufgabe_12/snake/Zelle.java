package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_12.snake;

/**
 * Klasse zur Verwaltung der Schlangenglieder.
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Zelle implements DatenElement
{
    /**
     * x-Koordinate der Zelle
     */
    private int x;

    /**
     * y-Koordinate der Zelle
     */
    private int y;

    /**
     * Spiel
     */
    Spiel spiel;

    /**
     * Konstruktor für die Objekte der Klasse ZELLE
     *
     * @param xneu x-Koordinate
     * @param yneu y-Koordinate
     */
    Zelle(int xneu, int yneu)
    {
        x = xneu;
        y = yneu;
    }

    /**
     * Belegt beim übergebenen Spiel das Feld mit den Koordinaten x und y
     *
     * @param s Spiel
     */
    void FeldBelegen(Spiel s)
    {
        s.FeldBelegen(x, y, 's');
        spiel = s;
    }

    /**
     * Gibt beim übergebenen Spiel das Feld mit den Koordinaten x und y frei
     */
    void FeldFreigeben()
    {
        spiel.FeldFreigeben(x, y);
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
     * Ausgabe von Information über ein Ausgabefenster nicht erforderlich
     */
    public void InformationAusgeben()
    {
    }

    /**
     * Identifikation einer Zelle aufgrund des Schlüssels
     *
     * @param s Schlüssel vom Typ String
     */
    public boolean SchluesselIstGleich(String s)
    {
        return (s.compareTo(x + "," + y) == 0);
    }

    /**
     * Vergleich zweier Datenelemente bezüglich einer Ordnungsrelation nicht
     * erforderlich
     *
     * @param d Datenelement zum Vergleich
     */
    public boolean IstKleinerAls(DatenElement d)
    {
        return true;
    }
}
