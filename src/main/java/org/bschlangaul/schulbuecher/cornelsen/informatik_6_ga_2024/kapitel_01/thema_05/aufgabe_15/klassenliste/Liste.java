package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_05.aufgabe_15.klassenliste;

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
    void VorneEinfügen(Datenelement dNeu)
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
    Datenelement EndeEntfernen()
    {
        Datenelement d_letzter = anfang.EndeGeben(null);
        anfang = anfang.KnotenEntfernen(d_letzter);
        return d_letzter;
    }

    /**
     * Entfernt den Anfang aus der Liste und gibt das zugehörige Datenelement
     * zurück.
     *
     * @return Datenelement des Anfangsknotens
     */
    Datenelement AnfangEntfernen()
    {
        Datenelement d = anfang.DatenelementGeben();
        anfang = anfang.NachfolgerGeben();
        return d;
    }

    /**
     * Fügt das Datenelement am Ende ein.
     *
     * @param dNeu neues Datenelement
     */
    void HintenEinfügen(Datenelement dNeu)
    {
        anfang = anfang.HintenEinfügen(dNeu);
    }

    /**
     * Fügt ein neues Datenelement vor einem bestimmten Datenelement ein.
     *
     * @param dNeu neues Datenelement
     * @param dVergleich Datenelement, vor dem eingefügt werden soll
     */
    void EinfügenVor(Datenelement dNeu, Datenelement dVergleich)
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
    Datenelement Suchen(String schlüssel)
    {
        return anfang.Suchen(schlüssel);
    }

    /**
     * Sortiertes Einfügen in die Liste
     *
     * @param dNeu neues Datenelement
     */
    void SortiertEinfügen(Datenelement dNeu)
    {
        anfang = anfang.SortiertEinfügen(dNeu);
    }

    void KnotenEntfernen(Datenelement d)
    {
        anfang = anfang.KnotenEntfernen(d);
    }

    /**
     * Entfernt eine Person aus der Liste
     *
     * @param name Name der Person
     */
    void Entfernen(String name)
    {
        anfang = anfang.Entfernen(name);
    }

    /**
     * Gibt die Liste aller Namen zurück
     *
     * @return Namensliste
     */
    String NamenslisteGeben()
    {
        return anfang.NamenslisteGeben();
    }
}
