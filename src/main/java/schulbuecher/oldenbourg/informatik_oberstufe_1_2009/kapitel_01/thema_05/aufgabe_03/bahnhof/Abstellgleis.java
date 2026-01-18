package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_05.aufgabe_03.bahnhof;

/**
 * Klasse zur Verwaltung eines Abstellgleises
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Abstellgleis
{
    /**
     * zugehöriger Stapel
     */
    Stapel stapel;

    /**
     * Konstruktor erzeugt einen Stapel
     */
    Abstellgleis()
    {
        stapel = new Stapel();
    }

    /**
     * Einfügen eines Waggons
     *
     * @param w Waggon
     */
    void Einfuegen(Waggon w)
    {
        stapel.VorneEinfuegen(w);
    }

    /**
     * Entfernen eines Waggons
     *
     * @return Waggon
     */
    Waggon Entfernen()
    {
        return ((Waggon) stapel.AnfangEntfernen());
    }
}
