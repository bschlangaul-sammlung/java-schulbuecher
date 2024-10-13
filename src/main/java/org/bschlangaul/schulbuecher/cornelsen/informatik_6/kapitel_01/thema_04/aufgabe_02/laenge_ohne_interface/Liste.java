package org.bschlangaul.schulbuecher.cornelsen.informatik_6.kapitel_01.thema_04.aufgabe_02.laenge_ohne_interface;

/**
 * Beschreibung der Liste
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Liste
{
    /** erster Knoten der Liste */
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
    void HintenEinfügen(Patient dneu)
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
     * Entfernt den ersten Patient aus der Liste und gibt ihn zurück.
     *
     * @return bisheriger erster Patient
     */
    Patient Entfernen()
    {
        return null;
        // Diese Lösung muss überarbeitet werden, weil die Referenz auf das Ende
        // nicht mehr vorhanden ist.
        // Knoten k = anfang;
        // if (anfang != null)
        // {
        // if (anfang == ende)
        // {
        // anfang = null;
        // ende = null;
        // }
        // else
        // {
        // anfang=anfang.NachfolgerGeben();
        // }
        // return k.DatenelementGeben();
        // }
        // else
        // {
        // return null;
        // }
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
