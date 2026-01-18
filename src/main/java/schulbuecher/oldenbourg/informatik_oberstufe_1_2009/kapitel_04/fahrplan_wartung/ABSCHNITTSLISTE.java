package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.fahrplan_wartung;

/**
 * Verwaltet eine Liste der Abschnitte.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class ABSCHNITTSLISTE extends LISTE
{
    /**
     * Legt eine leere Liste an.
     */
    ABSCHNITTSLISTE()
    {
        super();
    }

    /**
     * Sucht den Abschnitt mit den angegebenen Daten. Nutzt die Sortierung der
     * Liste aus.
     *
     * @return Referenz auf den Bahnhof oder null
     */
    ABSCHNITT Suchen(int linie, int b1, int b2)
    {
        return (ABSCHNITT) Suchen(new ABSCHNITT(linie, b1, b2, 0.0f));
    }

    /**
     * Testet, ob der angegebene Bahnhof Anfang oder Ende eines Abschnitts ist.
     *
     * @param nummer Nummer des Bahnhofs
     *
     * @return true, wenn Start oder Ziel
     */
    boolean BahnhofWirdErreicht(int nummer)
    {
        VorErstesPositionieren();
        while (AufNaechstesPositionieren())
        {
            if ((nummer == ((ABSCHNITT) DatenGeben()).Bahnhof1Geben())
                    || (nummer == ((ABSCHNITT) DatenGeben()).Bahnhof2Geben()))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Meldet alle Linien, die den angegebenen Bahnhof berühren.
     *
     * @param nummer Nummer des Bahnhofs
     *
     * @return Stringfeld mit den Liniennummern
     */
    String[] LinienFuerBahnhofGeben(int nummer)
    {
        int anzahl, pos, linie;
        String[] res;
        int[] linien, hilf;
        boolean gefunden;
        linien = new int[10];
        anzahl = 0;
        VorErstesPositionieren();
        while (AufNaechstesPositionieren())
        {
            if ((nummer == ((ABSCHNITT) DatenGeben()).Bahnhof1Geben())
                    || (nummer == ((ABSCHNITT) DatenGeben()).Bahnhof2Geben()))
            {
                linie = ((ABSCHNITT) DatenGeben()).LinieGeben();
                gefunden = false;
                for (int i = 0; i < anzahl; i++)
                {
                    if (linien[i] == linie)
                    {
                        gefunden = true;
                    }
                }
                if (!gefunden)
                {
                    if (anzahl >= linien.length)
                    {
                        hilf = new int[linien.length * 2];
                        for (int i = 0; i < linien.length; i++)
                        {
                            hilf[i] = linien[i];
                        }
                        linien = hilf;
                    }
                    pos = anzahl;
                    while ((pos > 0) && (linien[pos - 1] > linie))
                    {
                        linien[pos] = linien[pos - 1];
                        pos -= 1;
                    }
                    linien[pos] = linie;
                    anzahl += 1;
                }
            }
        }
        res = new String[anzahl];
        for (int i = 0; i < anzahl; i++)
        {
            res[i] = "" + linien[i];
        }
        return res;
    }
}
