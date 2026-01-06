package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_02.softwaretechnik.fahrradroutenplaner;

/**
 * Abschlussknoten einer Liste von Datenelementen.
 *
 * @version 1.0
 */
class Abschluss extends ListenElement
{
    /**
     * Belegt die Attribute.
     */
    Abschluss()
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
    ListenElement Anfuegen(Datenelement d)
    {
        return new Knoten(this, d);
    }

    /**
     * Sucht das angegebene Datenelement.
     *
     * @param wert Schlüssel für das Element.
     *
     * @return Referenz auf das gefundene Element oder null.
     */
    Datenelement Suchen(String wert)
    {
        return null;
    }

    /**
     * Sucht das Datenelement mit dem kleinsten Wert.
     *
     * @return Referenz auf das Datenelement oder null.
     */
    Datenelement MinimumSuchen()
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
    ListenElement Loeschen(Datenelement d)
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
    Datenelement[] Kopieren(int anzahl)
    {
        return new Datenelement[anzahl];
    }

    /**
     * Erzeugt eine Kopie des Listenelements und der Liste ab hier. Die
     * Datenelemente werden nicht kopiert. Auf Verwendung von Object. clone
     * wurde bewusst verzichtet.
     *
     * @return Kopie des Listenelements mit Referenz auf kopierte Nachfolger
     */
    ListenElement Kopieren()
    {
        return new Abschluss();
    }
}
