package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.adressverwaltung;

/**
 * Verwaltet eine Liste von Objekten.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class LISTE
{
    private LISTENELEMENT erstes;

    /**
     * Erzeugt eine leere Liste
     */
    LISTE()
    {
        erstes = new ABSCHLUSS();
    }

    /**
     * Fügt ein Objekt sortiert in die Liste ein.
     *
     * @param d Referenz auf das einzufügende Objekt.
     */
    void Einfuegen(DATENELEMENT d)
    {
        erstes = erstes.Einfuegen(d);
    }

    /**
     * Sucht das angegebene Objekt. Nutzt die Sortierung der Liste aus.
     *
     * @param d Schlüssel des zu suchenden Objekts.
     *
     * @return Referenz auf das gefundene Objekt oder null.
     */
    DATENELEMENT Suchen(DATENELEMENT d)
    {
        return erstes.Suchen(d);
    }

    /**
     * Löscht das angegebene Objekt. Nutzt die Sortierung der Liste aus.
     *
     * @param d Schlüssel des zu löschenden Objekts.
     */
    void Loeschen(DATENELEMENT d)
    {
        erstes = erstes.Loeschen(d);
    }

    /**
     * Kopiert alle Datenreferenzen in ein passend angelegtes Feld.
     *
     * @return Feld mit den Datenreferenzen.
     */
    DATENELEMENT[] ReferenzenAlsFeldGeben()
    {
        DATENELEMENT[] res;
        res = new DATENELEMENT[erstes.AnzahlAbHierGeben()];
        erstes.Eintragen(res, 0);
        return res;
    }
}
