package org.bschlangaul.schulbuecher.cornelsen.informatik_6.kapitel_01.thema_06.aufgabe_03.e_patientenakte;

/**
 * Stapel unter Zuhilfenahme der Liste
 *
 * @author Klaus Reinold
 *
 * @version 0.9
 */
class Stapel
{
    /**
     * genutzte Liste
     */
    private Liste liste;

    /**
     * Konstruktor des Stapels
     */
    Stapel()
    {
        liste = new Liste();
    }

    /**
     * Fügt ein neues Datenelement am Anfang des Stapels ein.
     *
     * @param dNeu neues Datenelement
     */
    void Einfügen(Datenelement dNeu)
    {
        liste.VorneEinfügen(dNeu);
    }

    /**
     * Entfernt das erste Datenelement aus dem Stapel und gibt es zurück.
     *
     * @return bisheriger erstes Datenelement
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
