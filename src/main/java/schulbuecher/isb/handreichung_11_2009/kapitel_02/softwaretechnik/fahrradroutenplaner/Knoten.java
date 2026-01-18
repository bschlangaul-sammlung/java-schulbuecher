package schulbuecher.isb.handreichung_11_2009.kapitel_02.softwaretechnik.fahrradroutenplaner;

/**
 * (Innerer) Knoten einer Liste von Datenelementen.
 *
 * @version 1.0
 */
class Knoten extends ListenElement
{
    private ListenElement nachfolger;

    private Datenelement daten;

    /**
     * Belegt die Attribute.
     *
     * @param nf Referenz auf den Nachfolger dieses Knotens
     * @param d Referenz auf das zu verwaltende Datenobjekt
     */
    Knoten(ListenElement nf, Datenelement d)
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
    ListenElement Anfuegen(Datenelement d)
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
    Datenelement Suchen(String wert)
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
    Datenelement MinimumSuchen()
    {
        Datenelement hilf;
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
    ListenElement Loeschen(Datenelement d)
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
    Datenelement[] Kopieren(int anzahl)
    {
        Datenelement[] res;
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
    ListenElement Kopieren()
    {
        return new Knoten(nachfolger.Kopieren(), daten);
    }
}
