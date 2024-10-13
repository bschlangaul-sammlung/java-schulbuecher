package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_01.aufgabe_03.teilaufgabe_b.wartezimmer_oberflaeche;

/**
 * Beschreibung der Warteschlange
 *
 * @author Klaus Reinold
 *
 * @version 0.9
 */
class WARTESCHLANGE
{
    /** Verwaltung des ersten Patienten in der Warteschlange. */
    private PATIENT anfang;

    /** Verwaltung des letzten Patienten in der Warteschlange. */
    private PATIENT ende;

    /**
     * Konstruktor der WARTESCHLANGE
     *
     */
    WARTESCHLANGE()
    {
        anfang = null;
        ende = null;
    }

    /**
     * Fügt einen neuen Patienten am Ende der Warteschlange ein.
     *
     * @param patientNeu neuer Patient
     */
    void Einfuegen(PATIENT patientNeu)
    {
        if (ende != null)
        {
            ende.NachfolgerSetzen(patientNeu);
        }
        else
        {
            anfang = patientNeu;
        }
        ende = patientNeu;
    }

    /**
     * Entfernt den ersten Patient aus der Warteschlange und gibt ihn aus.
     *
     * @return bisheriger erster Patient
     */
    PATIENT Entfernen()
    {
        PATIENT p;
        p = anfang;
        if (anfang != null)
        {
            anfang = anfang.NachfolgerGeben();
            if (anfang == null)
            {
                ende = null;
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
