package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_03.aufgabe_00.einwohner;

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
     * erster Knoten der Warteschlange
     */
    private Knoten anfang;

    /**
     * letzter Knoten der Warteschlange
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
     * Fügt einen neuen Bürger am Ende der Warteschlange ein.
     *
     * @param bürgerNeu neuer Bürger
     *
     */
    void Einfügen(Buerger bürgerNeu)
    {
        Knoten k;
        k = new Knoten(bürgerNeu);
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
     * Entfernt den ersten Büger aus der Warteschlange und gibt es zurück.
     *
     * @return bisheriger erster Bürger
     */
    Buerger Entfernen()
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
