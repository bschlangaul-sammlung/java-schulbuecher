package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.adressverwaltung;

/**
 * Abschluss einer Personenliste
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class ABSCHLUSS extends LISTENELEMENT
{
    /**
     * Keine eigene Aktion
     */
    ABSCHLUSS()
    {
        super();
    }

    /**
     * Fügt ein Objekt sortiert in die Liste ein.
     *
     * @param d Referenz auf das einzufügende Objekt.
     *
     * @return (neues) Nachfolgeelement des Aufrufers.
     */
    LISTENELEMENT Einfuegen(DATENELEMENT d)
    {
        return new KNOTEN(d, this);
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
        return null;
    }

    /**
     * Löscht das angegebene Objekt. Nutzt die Sortierung der Liste aus.
     *
     * @param d Schlüssel des zu löschenden Objekts.
     *
     * @return (neues) Nachfolgeelement des Aufrufers.
     */
    LISTENELEMENT Loeschen(DATENELEMENT d)
    {
        return this;
    }

    /**
     * Meldet die Anzahl der ab hier in der Liste befindlichen Datenelemente.
     *
     * @return Anzahl
     */
    int AnzahlAbHierGeben()
    {
        return 0;
    }

    /**
     * überträgt die Datenreferenz in das Feld.
     *
     * @param feld Das Feld zur Aufnahme der Referenzen
     * @param index Feldindex für das Element dieses Listenelements
     */
    void Eintragen(DATENELEMENT[] feld, int index)
    {
        // fertig
    }
}
