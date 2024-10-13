package org.bschlangaul.schulbuecher.cornelsen.informatik_6.kapitel_01.thema_06.aufgabe_04.gueterbahnhof;

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
    private Stapel stapel;

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
    void Einfügen(Waggon w)
    {
        stapel.Einfügen(w);
    }

    /**
     * Entfernen eines Waggons
     *
     * @return Waggon
     */
    Waggon Entfernen()
    {
        return ((Waggon) stapel.Entfernen());
    }
}
