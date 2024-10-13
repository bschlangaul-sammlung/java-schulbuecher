package org.bschlangaul.schulbuecher.cornelsen.informatik_6.kapitel_01.thema_06.aufgabe_00.warteschlange_mit_liste;

/**
 * Warteschlange unter Zuhilfenahme der Liste
 *
 * @author Klaus Reinold
 *
 * @version 0.9
 */
class Warteschlange
{
    /** genutzte Liste */
    private Liste liste;

    /**
     * Konstruktor der Warteschlange
     */
    Warteschlange()
    {
        liste = new Liste();
    }

    /**
     * Fügt einen neuen Patienten am Ende der Warteschlange ein.
     *
     * @param patientNeu neuer Patient
     */
    void Einfügen(Patient patientNeu)
    {
        liste.HintenEinfügen(patientNeu);
    }

    /**
     * Entfernt den ersten Patient aus der Warteschlange und gibt ihn zurück.
     *
     * @return bisheriger erster Patient
     */
    Patient Entfernen()
    {
        return liste.AnfangEntfernen();
    }

    /**
     * Gibt Information über die Warteschlange aus. Kann etwas mehr als die
     * Warteschlange, das stört aber auch nicht...
     */
    void InformationAusgeben()
    {
        liste.InformationAusgeben();
    }

    /**
     * Gibt den ersten Knoten zurück. Wird in der Darstellung benötigt
     *
     * @return erster Knoten
     */
    Knoten AnfangGeben()
    {
        return (Knoten) liste.AnfangGeben();
    }
}
