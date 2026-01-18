package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.fahrplan_wartung;

/**
 * Verwaltet eine Liste der Umsteigeinformationen.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class UMSTEIGELISTE extends LISTE
{
    /**
     * Legt eine leere Liste an.
     */
    UMSTEIGELISTE()
    {
        super();
    }

    /**
     * Sucht die Umsteigeinformation mit den angegebenen Daten. Nutzt die
     * Sortierung der Liste aus.
     *
     * @param nummer Nummer des Bahnhofs.
     * @param l1 von-Linie
     * @param l2 nach-Linie
     *
     * @return Referenz auf den Bahnhof oder null
     */
    UMSTEIGEINFO Suchen(int nummer, int l1, int l2)
    {
        return (UMSTEIGEINFO) Suchen(new UMSTEIGEINFO(nummer, l1, l2));
    }

    /**
     * Meldet das Element mit der angegebenen Nummer in der Liste.
     *
     * @param nummer Nummer des Bahnhofs
     *
     * @return Feld mit den Umsteigemöglichkeiten
     */
    String[] UmsteigenFuerBahnhofGeben(int nummer)
    {
        int anzahl;
        String[] res;
        VorErstesPositionieren();
        anzahl = 0;
        while (AufNaechstesPositionieren())
        {
            if (((UMSTEIGEINFO) DatenGeben()).BahnhofGeben() == nummer)
            {
                anzahl += 1;
            }
        }
        res = new String[anzahl];
        VorErstesPositionieren();
        anzahl = 0;
        while (AufNaechstesPositionieren())
        {
            if (((UMSTEIGEINFO) DatenGeben()).BahnhofGeben() == nummer)
            {
                res[anzahl] = "von "
                        + ((UMSTEIGEINFO) DatenGeben()).VonLinieGeben()
                        + " nach "
                        + +((UMSTEIGEINFO) DatenGeben()).AbLinieGeben();
                anzahl += 1;
            }
        }
        return res;
    }

    /**
     * Meldet das Element mit der angegebenen Nummer in der Liste.
     *
     * @param index Index des Elements (ab 0)
     * @param nummer Nummer des Bahnhofs
     *
     * @return der bezeichneten Umsteigeinformation
     */
    UMSTEIGEINFO UmsteigeinfoMitIndexGeben(int index, int nummer)
    {
        int pos;
        VorErstesPositionieren();
        pos = 0;
        while (AufNaechstesPositionieren())
        {
            if (((UMSTEIGEINFO) DatenGeben()).BahnhofGeben() == nummer)
            {
                if (pos == index)
                {
                    return (UMSTEIGEINFO) DatenGeben();
                }
                pos += 1;
            }
        }
        return null;
    }
}
