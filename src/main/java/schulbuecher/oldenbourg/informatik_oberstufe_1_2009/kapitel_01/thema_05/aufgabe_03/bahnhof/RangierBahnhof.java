package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_05.aufgabe_03.bahnhof;

/**
 * Verwaltung des Rangierbahnhofs
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class RangierBahnhof
{
    /**
     * Feld der Abstellgleise
     */
    private Abstellgleis[] gleise;

    /**
     * Erzeugt die drei Abstellgleise
     */
    RangierBahnhof()
    {
        gleise = new Abstellgleis[3];
        for (int i = 0; i < 3; i = i + 1)
        {
            gleise[i] = new Abstellgleis();
        }
    }

    /**
     * Einfügen eines Waggons auf ein bestimmtes Gleis
     *
     * @param w Waggon
     * @param gleisnummer Nummer von 0 bis 2
     */
    void WaggonEinfuegen(Waggon w, int gleisnummer)
    {
        gleise[gleisnummer].Einfuegen(w);
    }

    /**
     * Entfernen eines Waggons von einem bestimmten Gleis
     *
     * @param gleisnummer Nummer von 0 bis 2
     */
    Waggon WaggonEntfernen(int gleisnummer)
    {
        return gleise[gleisnummer].Entfernen();
    }

    /**
     * Verschieben eines Waggons zwischen zwei Gleisen
     *
     * @param vonGleis Nummer von 0 bis 2
     * @param nachGleis Nummer von 0 bis 2
     */
    void WaggonVerschieben(int vonGleis, int nachGleis)
    {
        gleise[nachGleis].Einfuegen(gleise[vonGleis].Entfernen());
    }
}
