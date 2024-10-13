package org.bschlangaul.schulbuecher.cornelsen.informatik_6.kapitel_01.thema_01.aufgabe_05.snake_l1;

/**
 * Beschreibung der Warteschlange
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Warteschlange
{
    /**
     * Verwaltung der Rumpfsymbole in der Warteschlange.
     */
    private RumpfSymbol anfang;

    private RumpfSymbol ende;

    /**
     * Konstruktor der Warteschlange
     */
    Warteschlange()
    {
        anfang = null;
        ende = null;
    }

    /**
     * Fügt eine neues Objekt am Ende der Warteschlange ein.
     *
     * @param rumpfSymbolNeu neues Rumpfsymbol
     */
    void Einfügen(RumpfSymbol rumpfSymbolNeu)
    {
        if (anfang == null)
        {
            anfang = rumpfSymbolNeu;
        }
        else
        {
            ende.NachfolgerSetzen(rumpfSymbolNeu);
        }
        ende = rumpfSymbolNeu;

    }

    /**
     * Entfernt das erste aus der Warteschlange und gibt es zurück.
     *
     * @return bisheriges erstes Objekt
     */
    RumpfSymbol Entfernen()
    {
        RumpfSymbol b = anfang;
        if (anfang != null)
        {
            anfang = anfang.NachfolgerGeben();
        }
        return b;
    }

    /**
     * Gibt den Anfgang der Warteschlange zurück (ohne Entfernen!)
     *
     * @return Anfang
     */
    RumpfSymbol AnfangGeben()
    {
        return anfang;
    }
}
