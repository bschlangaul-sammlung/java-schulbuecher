package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.fahrplan_auskunft;

/**
 * Beschreibt einen Bahnhof.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class BAHNHOF implements DATENELEMENT
{
    private int nummer;

    private String name;

    private int x, y;

    /**
     * Legt die Daten fest.
     *
     * @param nummer Nummer des Bahnhofs
     * @param name Name des Bahnhofs
     * @param x X-Koordinate
     * @param y Y-Koordinate
     */
    BAHNHOF(int nummer, String name, int x, int y)
    {
        this.nummer = nummer;
        this.name = name;
        this.x = x;
        this.y = y;
    }

    /**
     * Vergleicht das Datemelement mit dem Parameter.
     *
     * @param test Datenelement mit dem Testschlüssel
     *
     * @return true, wenn die Schlüssel übereinstimmen
     */
    public boolean IstGleich(DATENELEMENT test)
    {
        return ((BAHNHOF) test).nummer == nummer;
    }

    /**
     * Vergleicht das Datemelement mit dem Parameter. <br>
     * Hat das Datenelement einen kleineren Schlüssel als test, ist das Ergebnis
     * -1. <br>
     * Hat das Datenelement den gleichen Schlüssel wie test, ist das Ergebnis 0.
     * <br>
     * Hat das Datenelement einen größeren Schlüssel als test, ist das Ergebnis
     * 1.
     *
     * @param test Datenelement mit dem Testschlüssel
     *
     * @return Vergleichsergebnis
     */
    public int Vergleichen(DATENELEMENT test)
    {
        return (int) Math.signum(nummer - ((BAHNHOF) test).nummer);
    }

    /**
     * Meldet die Nummer des Bahnhofs.
     *
     * @return Bahnhofsnummer
     */
    int NummerGeben()
    {
        return nummer;
    }

    /**
     * Meldet den Namen des Bahnhofs.
     *
     * @return Bahnhofsname
     */
    String NameGeben()
    {
        return name;
    }

    /**
     * Meldet die X-Koordinate des Bahnhofs.
     *
     * @return X-Koordinate
     */
    int XGeben()
    {
        return x;
    }

    /**
     * Meldet die Y-Koordinate des Bahnhofs.
     *
     * @return Y-Koordinate
     */
    int YGeben()
    {
        return y;
    }
}
