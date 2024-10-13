package org.bschlangaul.schulbuecher.cornelsen.informatik_6.kapitel_01.thema_06.aufgabe_04.gueterbahnhof;

/**
 * Beschreibung des Stapels
 *
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Stapel
{
    /** die verwendete Liste */
    private Liste liste;

    /**
     * Konstruktor des Stapels
     */
    Stapel()
    {
        liste = new Liste();
    }

    /**
     * Fügt ein neues Datenelemen vorne im Stapel ein.
     *
     * @param dNeu neues Datenelement
     */
    void Einfügen(Datenelement dNeu)
    {
        liste.HintenEinfügen(dNeu);
    }

    /**
     * Entfernt das erste Element vom Stapel und gibt es zurück.
     *
     * @return bisheriges erstes Datenelement
     */
    Datenelement Entfernen()
    {
        return liste.AnfangEntfernen();
    }

    /**
     * Gibt Information über den Stapel aus.
     */
    void InformationAusgeben()
    {
        liste.InformationAusgeben();
    }
}
