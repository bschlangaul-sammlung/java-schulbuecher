package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_01.aufgabe_00.warteschlange_ohne_feld;

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
    private Patient anfang;

    /**
     * letzter Patient der Warteschlange
     */
    private Patient ende;

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
     *
     */
    void Einfügen(Patient patientNeu)
    {
        if (anfang == null)
        {
            anfang = patientNeu;
        }
        else
        {
            ende.NachfolgerSetzen(patientNeu);
        }
        ende = patientNeu;
    }

    /**
     * Entfernt den ersten Patient aus der Warteschlange und gibt ihn zurück.
     *
     * @return bisheriger erster Patient
     */
    Patient Entfernen()
    {
        Patient p = anfang;
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
        }
        return p;
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
