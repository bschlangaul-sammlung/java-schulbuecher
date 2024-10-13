package org.bschlangaul.schulbuecher.cornelsen.informatik_6.kapitel_01.thema_02.aufgabe_02.arzt_mit_visualisierung;

/**
 * Beschreibung der Warteschlange
 *
 * @author Klaus Reinold
 *
 * @version 0.9
 */
class Warteschlange
{
    /** erster Patient der Warteschlange */
    private Knoten anfang;

    /** letzter Patient der Warteschlange */
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
     * Fügt einen neuen Patienten am Ende der Warteschlange ein.
     *
     * @param patientNeu neuer Patient
     */
    void Einfügen(Patient patientNeu)
    {
        Knoten k;
        k = new Knoten(patientNeu);
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
    Patient Entfernen()
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

    /**
     * Gibt den ersten Knoten zurück. Wird in der Darstellung benötigt
     *
     * @return erster Knoten
     */
    Knoten AnfangGeben()
    {
        return anfang;
    }
}
