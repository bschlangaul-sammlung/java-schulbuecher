package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.fahrplan_wartung;

/**
 * Verwaltet eine Liste der Bahnhöfe.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class BAHNHOFSLISTE extends LISTE
{
    /**
     * Legt eine leere Liste an.
     */
    BAHNHOFSLISTE()
    {
        super();
    }

    /**
     * Sucht den Bahnhof mit der angegebenen Nummer. Nutzt die Sortierung der
     * Liste aus.
     *
     * @param nummer Nummer des zu suchenden Bahnhofs.
     *
     * @return Referenz auf den Bahnhof oder null
     */
    BAHNHOF Suchen(int nummer)
    {
        return (BAHNHOF) Suchen(new BAHNHOF(nummer, "", 0, 0));
    }

    /**
     * Meldet die Namen aller Bahnhöfe in der Liste in korrekter Reihenfolge.
     *
     * @return Namensliste
     */
    String[] NamenslisteGeben()
    {
        VorErstesPositionieren();
        return NamenGeben(0);
    }

    /**
     * Baut die Namensliste Element für Element auf.
     *
     * @return bisher erstellter Teil der Namensliste
     */
    private String[] NamenGeben(int tiefe)
    {
        String[] res;
        String namen;
        if (AufNaechstesPositionieren())
        {
            namen = ((BAHNHOF) DatenGeben()).NameGeben();
            res = NamenGeben(tiefe + 1);
            res[tiefe] = namen;
        }
        else
        {
            res = new String[tiefe];
        }
        return res;
    }

    /**
     * Meldet das Element mit der angegebenen Nummer in der Liste.
     *
     * @param nummer Nummer des Elements (ab 0)
     *
     * @return der bezeichnete Bahnhof
     */
    BAHNHOF BahnhofMitIndexGeben(int nummer)
    {
        return (BAHNHOF) ElementMitIndexGeben(nummer);
    }
}
