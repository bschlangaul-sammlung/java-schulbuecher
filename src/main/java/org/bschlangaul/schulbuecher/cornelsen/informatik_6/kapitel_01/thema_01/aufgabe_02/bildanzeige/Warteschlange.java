package org.bschlangaul.schulbuecher.cornelsen.informatik_6.kapitel_01.thema_01.aufgabe_02.bildanzeige;

/**
 * Beschreibung der Warteschlange
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Warteschlange
{
    /** Anfang der Warteschlange. */
    private Bild anfang;

    /** Ende der Warteschlange. */
    private Bild ende;

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
     * @param bildNeu neues Bild
     *
     */
    void Einfügen(Bild bildNeu)
    {
        if (anfang == null)
        {
            anfang = bildNeu;
        }
        else
        {
            ende.NachfolgerSetzen(bildNeu);
        }
        ende = bildNeu;

    }

    /**
     * Entfernt das erste aus der Warteschlange und gibt es zurück.
     *
     * @return bisheriges erstes Objekt
     */
    Bild Entfernen()
    {
        Bild b = anfang;
        if (anfang != null)
        {
            anfang = anfang.NachfolgerGeben();
        }
        return b;
    }

    /**
     * Gibt Information über die Warteschlange aus.
     */
    void InformationAusgeben()
    {
        if (anfang != null)
        {
            anfang.InformationAusgeben();
        }
    }
}
