package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_05.aufgabe_03.bahnhof;

/**
 * Klasse zur Verwaltung eines Abstellgleises
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class ABSTELLGLEIS
{
    /** zugehöriger Stapel */
    STAPEL stapel;

    /**
     * Konstruktor erzeugt einen Stapel
     */
    ABSTELLGLEIS()
    {
        stapel = new STAPEL();
    }

    /**
     * Einfügen eines Waggons
     *
     * @param w Waggon
     */
    void Einfuegen(WAGGON w)
    {
        stapel.VorneEinfuegen(w);
    }

    /**
     * Entfernen eines Waggons
     *
     * @return Waggon
     */
    WAGGON Entfernen()
    {
        return ((WAGGON) stapel.AnfangEntfernen());
    }
}
