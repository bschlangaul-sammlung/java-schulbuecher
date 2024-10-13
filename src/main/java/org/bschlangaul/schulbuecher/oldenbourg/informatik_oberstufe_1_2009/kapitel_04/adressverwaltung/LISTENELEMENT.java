package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.adressverwaltung;

/**
 * Abstraktes Element einer Personenliste
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
abstract class LISTENELEMENT
{
    /**
     * Der Konstruktor ist nur der Vollständigkeit halber angegeben.
     */
    LISTENELEMENT()
    {
        // (noch) nichts zu tun
    }

    /**
     * Fügt ein Objekt sortiert in die Liste ein.
     *
     * @param d Referenz auf das einzufügende Objekt.
     *
     * @return (neues) Nachfolgeelement des Aufrufers.
     */
    abstract LISTENELEMENT Einfuegen(DATENELEMENT d);

    /**
     * Sucht das angegebene Objekt. Nutzt die Sortierung der Liste aus.
     *
     * @param d Schlüssel des zu suchenden Objekts.
     *
     * @return Referenz auf das gefundene Objekt oder null.
     */
    abstract DATENELEMENT Suchen(DATENELEMENT d);

    /**
     * Löscht das angegebene Objekt. Nutzt die Sortierung der Liste aus.
     *
     * @param d Schlüssel des zu löschenden Objekts.
     *
     * @return (neues) Nachfolgeelement des Aufrufers.
     */
    abstract LISTENELEMENT Loeschen(DATENELEMENT d);

    /**
     * Meldet die Anzahl der ab hier in der Liste befindlichen Datenelemente.
     *
     * @return Anzahl
     */
    abstract int AnzahlAbHierGeben();

    /**
     * überträgt die Datenreferenz in das Feld.
     *
     * @param feld Das Feld zur Aufnahme der Referenzen
     * @param index Feldindex für das Element dieses Listenelements
     */
    abstract void Eintragen(DATENELEMENT[] feld, int index);
}
