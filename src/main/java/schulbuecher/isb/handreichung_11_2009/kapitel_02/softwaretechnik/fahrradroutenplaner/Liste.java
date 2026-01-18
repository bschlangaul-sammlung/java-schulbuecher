package schulbuecher.isb.handreichung_11_2009.kapitel_02.softwaretechnik.fahrradroutenplaner;

/**
 * Verwaltet eine Liste von Datenelementen.
 *
 * @version 1.0
 */
class Liste
{
    private ListenElement start;

    /**
     * Erzeugt eine leere Liste.
     */
    Liste()
    {
        start = new Abschluss();
    }

    /**
     * Fügt das angegebene Datenelement an das Ende der Liste an.
     *
     * @param d das anzufügende Datenelement.
     */
    void Anfuegen(Datenelement d)
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
    Datenelement Suchen(String wert)
    {
        return start.Suchen(wert);
    }

    /**
     * Sucht das Datenelement mit dem kleinsten Wert.
     *
     * @return Referenz auf das Datenelement oder null.
     */
    Datenelement MinimumSuchen()
    {
        return start.MinimumSuchen();
    }

    /**
     * Löscht den Eintrag mit dem Datenelement aus der Liste.
     *
     * @param d Datenelement
     */
    void Loeschen(Datenelement d)
    {
        start = start.Loeschen(d);
    }

    /**
     * Erzeugt aus der Liste ein Feld mit den Datenreferenzen.
     *
     * @return Feld mit den Datenreferenzen
     */
    Datenelement[] DatenelementeAlsFeldGeben()
    {
        return start.Kopieren(0);
    }

    /**
     * Erzeugt eine Kopie der Liste. Die Datenelemente werden nicht kopiert. Auf
     * Verwendung von Object. clone wurde bewusst verzichtet.
     *
     * @return Kopie der Liste
     */
    Liste Kopieren()
    {
        Liste res;
        res = new Liste();
        res.start = start.Kopieren();
        return res;
    }
}
