package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_02.softwaretechnik.fahrradroutenplaner;

/**
 * Allgemeines Element einer Liste von Datenelementen.
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
     * Fügt das Datenelement als letztes in die Liste ein.
     *
     * @param d Datenelement
     *
     * @return (neuer) Nachfolger des Vorgängers
     */
    abstract LISTENELEMENT Anfuegen(DATENELEMENT d);

    /**
     * Sucht das angegebene Datenelement.
     *
     * @param wert Schlüssel für das Element.
     *
     * @return Referenz auf das gefundene Element oder null.
     */
    abstract DATENELEMENT Suchen(String wert);

    /**
     * Sucht das Datenelement mit dem kleinsten Wert.
     *
     * @return Referenz auf das Datenelement oder null.
     */
    abstract DATENELEMENT MinimumSuchen();

    /**
     * Löscht den Eintrag mit dem Datenelement aus der Liste.
     *
     * @param d Datenelement
     *
     * @return (neuer) Nachfolger des Vorgängers
     */
    abstract LISTENELEMENT Loeschen(DATENELEMENT d);

    /**
     * Führt die Kopie in eine Feld durch.
     *
     * @param anzahl Anzahl der bisher gezählten Elemente.
     *
     * @return Feld mit den Datenreferenzen
     */
    abstract DATENELEMENT[] Kopieren(int anzahl);

    /**
     * Erzeugt eine Kopie des Listenelements und der Liste ab hier. Die
     * Datenelemente werden nicht kopiert. Auf Verwendung von Object. clone
     * wurde bewusst verzichtet.
     *
     * @return Kopie des Listenelements mit Referenz auf kopierte Nachfolger
     */
    abstract LISTENELEMENT Kopieren();
}
