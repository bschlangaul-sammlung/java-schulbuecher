package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_04.aufgabe_04.suchen_mit_interface;

/**
 * Beschreibung der Liste
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Liste
{
    /**
     * erster Knoten der Liste
     */
    private Knoten anfang;

    /**
     * Konstruktor der Liste
     */
    Liste()
    {
        anfang = null;
    }

    /**
     * Fügt ein neues Datenelement am Ende der Liste ein.
     *
     * @param dneu neues Datenelement
     */
    void HintenEinfügen(Datenelement dneu)
    {
        if (anfang != null)
        {
            anfang.HintenEinfügen(dneu);
        }
        else
        {
            anfang = new Knoten(dneu);
        }
    }

    /**
     * Bestimmt die Länge der Liste
     *
     * @return Listenlänge
     */
    int LängeGeben()
    {
        if (anfang == null)
        {
            return 0;
        }
        else
        {
            return anfang.RestlängeGeben();
        }
    }

    /**
     * Sucht ein Datenelement mit einem bestimmten Schlüssel in der Liste
     *
     * @param gesuchterWert Zeichenkette, die als Schlüssel gefunden werden
     *     soll.
     *
     * @return das gesuchte Datenelement
     */
    Datenelement Suchen(String gesuchterWert)
    {
        if (anfang != null)
        {
            return anfang.Suchen(gesuchterWert);
        }
        else
        {
            return null;
        }
    }

    /**
     * Gibt Information über die Liste aus.
     */
    void InformationAusgeben()
    {
        if (anfang != null)
        {
            anfang.InformationAusgeben();
        }
    }
}
