package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_03.aufgabe_03.arzt;

/**
 * Beschreibung der Warteschlange
 *
 * @author Klaus Reinold
 *
 * @version 0.9
 */
class Warteschlange
{
    /**
     * erster Patient der Warteschlange
     */
    private Knoten anfang;

    /**
     * letzter Patient der Warteschlange
     */
    private Knoten ende;

    /**
     * Konstruktor der Warteschlange
     */
    Warteschlange()
    {
        anfang = null;
        ende = null;
    }

    /**
     * Fügt ein neues Datenelement am Ende der Warteschlange ein.
     *
     * @param dNeu neues Datenelement
     *
     */
    void Einfügen(Datenelement dNeu)
    {
        Knoten k;
        k = new Knoten(dNeu);
        if (anfang == null)
        {
            anfang = k;
        }
        else
        {
            ende.NachfolgerSetzen(k);
        }
        ende = k;
    }

    /**
     * Entfernt den ersten Patient aus der Warteschlange und gibt ihn zurück.
     *
     * @return bisheriger erster Patient
     */
    Datenelement Entfernen()
    {
        Knoten k = anfang;
        if (anfang != null)
        {
            if (anfang == ende)
            {
                anfang = null;
                ende = null;
            }
            else
            {
                anfang = anfang.NachfolgerGeben();
            }
            return k.DatenelementGeben();
        }
        else
        {
            return null;
        }
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
