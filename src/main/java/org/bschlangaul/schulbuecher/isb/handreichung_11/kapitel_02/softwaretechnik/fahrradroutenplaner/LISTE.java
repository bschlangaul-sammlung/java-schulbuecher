package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_02.softwaretechnik.fahrradroutenplaner;

/**
 * Verwaltet eine Liste von Datenelementen.
 *
 * @version 1.0
 */
class LISTE
{
    private LISTENELEMENT start;

    /**
     * Erzeugt eine leere Liste.
     */
    LISTE()
    {
        start = new ABSCHLUSS();
    }

    /**
     * Fügt das angegebene Datenelement an das Ende der Liste an.
     *
     * @param d das anzufügende Datenelement.
     */
    void Anfuegen(DATENELEMENT d)
    {
        start = start.Anfuegen(d);
    }

    /**
     * Sucht das Datenelement mit der angegebenen Vergleichswert.
     *
     * @param wert der Identifikator des zu suchenden Datenelments
     *
     * @return Referenz auf das Datenelement oder null.
     */
    DATENELEMENT Suchen(String wert)
    {
        return start.Suchen(wert);
    }

    /**
     * Sucht das Datenelement mit dem kleinsten Wert.
     *
     * @return Referenz auf das Datenelement oder null.
     */
    DATENELEMENT MinimumSuchen()
    {
        return start.MinimumSuchen();
    }

    /**
     * Löscht den Eintrag mit dem Datenelement aus der Liste.
     *
     * @param d Datenelement
     */
    void Loeschen(DATENELEMENT d)
    {
        start = start.Loeschen(d);
    }

    /**
     * Erzeugt aus der Liste ein Feld mit den Datenreferenzen.
     *
     * @return Feld mit den Datenreferenzen
     */
    DATENELEMENT[] DatenelementeAlsFeldGeben()
    {
        return start.Kopieren(0);
    }

    /**
     * Erzeugt eine Kopie der Liste. Die Datenelemente werden nicht kopiert. Auf
     * Verwendung von Object. clone wurde bewusst verzichtet.
     *
     * @return Kopie der Liste
     */
    LISTE Kopieren()
    {
        LISTE res;
        res = new LISTE();
        res.start = start.Kopieren();
        return res;
    }
}
