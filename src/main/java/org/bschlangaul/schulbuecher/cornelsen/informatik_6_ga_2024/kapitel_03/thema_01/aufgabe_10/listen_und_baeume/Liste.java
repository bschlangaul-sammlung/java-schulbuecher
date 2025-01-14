package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_03.thema_01.aufgabe_10.listen_und_baeume;

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
        anfang = new AbschlussListe();
    }

    /**
     * Einfügen am Anfang der Liste (nichtrekursiv!)
     *
     * @param dNeu neues Datenelement
     */
    void VorneEinfügen(Patient dNeu)
    {
        anfang = new KnotenListe(dNeu, anfang);
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
     * Bestimmung der Länge der Liste
     *
     * @return Länge der Liste
     */
    int LängeGeben2()
    {
        int res = 0;
        Listenelement akt = anfang;
        while (akt instanceof KnotenListe)
        {
            akt = akt.NachfolgerGeben();
            res += 1;
        }
        return res;
    }

    /**
     * Entfernt den letzten Knoten und gibt dessen Datenelement zurück.
     *
     * @return Datenelement des bisher letzten Knotens
     */
    Patient EndeEntfernen()
    {
        Patient dletzter = anfang.EndeGeben(null);
        anfang = anfang.KnotenEntfernen(dletzter);
        return dletzter;
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
}
