package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_02.softwaretechnik.fahrradroutenplaner;

/**
 * (Innerer) Knoten einer Liste von Datenelementen.
 *
 * @version 1.0
 */
class KNOTEN extends LISTENELEMENT
{
    private LISTENELEMENT nachfolger;

    private DATENELEMENT daten;

    /**
     * Belegt die Attribute.
     *
     * @param nf Referenz auf den Nachfolger dieses Knotens
     * @param d Referenz auf das zu verwaltende Datenobjekt
     */
    KNOTEN(LISTENELEMENT nf, DATENELEMENT d)
    {
        super();
        nachfolger = nf;
        daten = d;
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
        nachfolger = nachfolger.Anfuegen(d);
        return this;
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
        if (daten.IstGleich(wert))
        {
            return daten;
        }
        else
        {
            return nachfolger.Suchen(wert);
        }
    }

    /**
     * Sucht das Datenelement mit dem kleinsten Wert.
     *
     * @return Referenz auf das Datenelement oder null.
     */
    DATENELEMENT MinimumSuchen()
    {
        DATENELEMENT hilf;
        hilf = nachfolger.MinimumSuchen();
        return daten.IstKleiner(hilf) ? daten : hilf;
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
        if (daten == d)
        {
            return nachfolger;
        }
        else
        {
            nachfolger = nachfolger.Loeschen(d);
            return this;
        }
    }

    /**
     * Führt die Kopie in eine Feld durch. Zählt die Elemente und trägt das
     * eigene Element ein.
     *
     * @param anzahl Anzahl der bisher gezählten Elemente.
     *
     * @return Feld mit den Datenreferenzen
     */
    DATENELEMENT[] Kopieren(int anzahl)
    {
        DATENELEMENT[] res;
        res = nachfolger.Kopieren(anzahl + 1);
        res[anzahl] = daten;
        return res;
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
        return new KNOTEN(nachfolger.Kopieren(), daten);
    }
}
