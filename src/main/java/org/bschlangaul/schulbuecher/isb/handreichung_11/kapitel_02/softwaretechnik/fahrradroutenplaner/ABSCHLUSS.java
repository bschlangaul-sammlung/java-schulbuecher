package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_02.softwaretechnik.fahrradroutenplaner;

/**
 * Abschlussknoten einer Liste von Datenelementen.
 *
 * @version 1.0
 */
class ABSCHLUSS extends LISTENELEMENT
{
    /**
     * Belegt die Attribute.
     */
    ABSCHLUSS()
    {
        super();
    }

    /**
     * Fügt das Datenelement als letztes in die Liste ein.
     *
     * @param d Datenelement
     *
     * @return (neuer) Nachfolger des Vorgängers
     */
    LISTENELEMENT Anfuegen(DATENELEMENT d)
    {
        return new KNOTEN(this, d);
    }

    /**
     * Sucht das angegebene Datenelement.
     *
     * @param wert Schlüssel für das Element.
     *
     * @return Referenz auf das gefundene Element oder null.
     */
    DATENELEMENT Suchen(String wert)
    {
        return null;
    }

    /**
     * Sucht das Datenelement mit dem kleinsten Wert.
     *
     * @return Referenz auf das Datenelement oder null.
     */
    DATENELEMENT MinimumSuchen()
    {
        return null;
    }

    /**
     * Löscht den Eintrag mit dem Datenelement aus der Liste.
     *
     * @param d Datenelement
     *
     * @return (neuer) Nachfolger des Vorgängers
     */
    LISTENELEMENT Loeschen(DATENELEMENT d)
    {
        return this;
    }

    /**
     * Führt die Kopie in eine Feld durch. Erzeugt das Feld.
     *
     * @param anzahl Anzahl der bisher gezählten Elemente.
     *
     * @return Feld mit den Datenreferenzen
     */
    DATENELEMENT[] Kopieren(int anzahl)
    {
        return new DATENELEMENT[anzahl];
    }

    /**
     * Erzeugt eine Kopie des Listenelements und der Liste ab hier. Die
     * Datenelemente werden nicht kopiert. Auf Verwendung von Object. clone
     * wurde bewusst verzichtet.
     *
     * @return Kopie des Listenelements mit Referenz auf kopierte Nachfolger
     */
    LISTENELEMENT Kopieren()
    {
        return new ABSCHLUSS();
    }
}
