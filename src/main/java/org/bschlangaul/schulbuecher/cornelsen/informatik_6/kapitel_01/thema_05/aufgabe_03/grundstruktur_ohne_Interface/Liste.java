package org.bschlangaul.schulbuecher.cornelsen.informatik_6.kapitel_01.thema_05.aufgabe_03.grundstruktur_ohne_Interface;

/**
 * Beschreibung der Liste
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Liste
{
    /** erstes Element der Liste */
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

}
