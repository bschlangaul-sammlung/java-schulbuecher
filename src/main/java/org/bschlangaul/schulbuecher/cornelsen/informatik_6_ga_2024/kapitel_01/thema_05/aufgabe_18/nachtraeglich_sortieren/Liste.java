package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_05.aufgabe_18.nachtraeglich_sortieren;

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
     * erstes Element der Liste
     */
    private Listenelement anfang;

    /**
     * Konstruktor der Liste
     */
    Liste()
    {
        anfang = new Abschluss();
    }

    /**
     * Einfügen am Anfang der Liste (nichtrekursiv!)
     *
     * @param dNeu neues Datenelement
     */
    void VorneEinfügen(Patient dNeu)
    {
        anfang = new Knoten(dNeu, anfang);
    }

    /**
     * Bestimmung der Länge der Liste
     *
     * @return Länge der Liste
     */
    int LängeGeben()
    {
        return anfang.RestlängeGeben();
    }

    /**
     * Entfernt den letzten Knoten und gibt dessen Datenelement zurück.
     *
     * @return Datenelement des bisher letzten Knotens
     */
    Patient EndeEntfernen()
    {
        Patient d_letzter = anfang.EndeGeben(null);
        anfang = anfang.KnotenEntfernen(d_letzter);
        return d_letzter;
    }

    /**
     * Entfernt den Anfang aus der Liste und gibt das zugehörige Datenelement
     * zurück.
     *
     * @return Datenelement des Anfangsknotens
     */
    Patient AnfangEntfernen()
    {
        Patient d = anfang.DatenelementGeben();
        anfang = anfang.NachfolgerGeben();
        return d;
    }

    /**
     * Gibt die Information zu den Datenelementen auf der Konsole aus.
     */
    void InformationAusgeben()
    {
        anfang.InformationAusgeben();
    }

    /**
     * Fügt das Datenelement am Ende ein.
     *
     * @param dNeu neues Datenelement
     */
    void HintenEinfügen(Patient dNeu)
    {
        anfang = anfang.HintenEinfügen(dNeu);
    }

    /**
     * Fügt ein neues Datenelement vor einem bestimmten Datenelement ein.
     *
     * @param dNeu neues Datenelement
     * @param dVergleich Datenelement, vor dem eingefügt werden soll
     */
    void EinfügenVor(Patient dNeu, Patient dVergleich)
    {
        anfang = anfang.EinfügenVor(dNeu, dVergleich);
    }

    /**
     * Sucht ein Datenelement mit einem bestimmten Schlüsselwert in der Liste
     * und gibt es zurück.
     *
     * @param schlüssel Wert, nach dem gesucht wird
     *
     * @return gesuchtes Datenelement
     */
    Patient Suchen(String schlüssel)
    {
        return anfang.Suchen(schlüssel);
    }

    /**
     * Sortiertes Einfügen in die Liste
     *
     * @param dNeu neues Datenelement
     */
    void SortiertEinfügen(Patient dNeu)
    {
        anfang = anfang.SortiertEinfügen(dNeu);
    }

    /**
     * Gibt den Anfang der Liste
     *
     * @return anfang
     */
    Listenelement AnfangGeben()
    {
        return anfang;
    }

    /**
     * Nachträgliches Sortieren der Liste
     */
    void NachträglichSortieren()
    {
        if (LängeGeben() > 1)
        {
            Patient p = AnfangEntfernen();
            NachträglichSortieren();
            SortiertEinfügen(p);
        }
    }
}
