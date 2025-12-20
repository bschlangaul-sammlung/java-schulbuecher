package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_02.softwaretechnik.fahrradroutenplaner;

/**
 * Allgemeines Element einer Liste von Datenelementen.
 *
 * @version 1.0
 */
abstract class ListenElement
{
    /**
     * Der Konstruktor ist nur der Vollständigkeit halber angegeben.
     */
    ListenElement()
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
    abstract ListenElement Anfuegen(Datenelement d);

    /**
     * Sucht das angegebene Datenelement.
     *
     * @param wert Schlüssel für das Element.
     *
     * @return Referenz auf das gefundene Element oder null.
     */
    abstract Datenelement Suchen(String wert);

    /**
     * Sucht das Datenelement mit dem kleinsten Wert.
     *
     * @return Referenz auf das Datenelement oder null.
     */
    abstract Datenelement MinimumSuchen();

    /**
     * Löscht den Eintrag mit dem Datenelement aus der Liste.
     *
     * @param d Datenelement
     *
     * @return (neuer) Nachfolger des Vorgängers
     */
    abstract ListenElement Loeschen(Datenelement d);

    /**
     * Führt die Kopie in eine Feld durch.
     *
     * @param anzahl Anzahl der bisher gezählten Elemente.
     *
     * @return Feld mit den Datenreferenzen
     */
    abstract Datenelement[] Kopieren(int anzahl);

    /**
     * Erzeugt eine Kopie des Listenelements und der Liste ab hier. Die
     * Datenelemente werden nicht kopiert. Auf Verwendung von Object. clone
     * wurde bewusst verzichtet.
     *
     * @return Kopie des Listenelements mit Referenz auf kopierte Nachfolger
     */
    abstract ListenElement Kopieren();
}
