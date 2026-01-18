package schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.it_kompetent.verwaltung_der_kundendaten;

class KNOTEN extends LISTENELEMENT
{
    private LISTENELEMENT nachfolger;

    private DATENELEMENT daten;

    // Konstruktoren
    KNOTEN()
    {
        super();
        nachfolger = null;
        daten = null;
    }

    KNOTEN(LISTENELEMENT naechsterKnoten, DATENELEMENT datenObjekt)
    {
        super();
        nachfolger = naechsterKnoten;
        daten = datenObjekt;
    }

    // Getter- und Setter-Methoden
    void NachfolgerSetzen(LISTENELEMENT neuerNachfolger)
    {
        nachfolger = neuerNachfolger;
    }

    LISTENELEMENT NachfolgerGeben()
    {
        return nachfolger;
    }

    void Datensetzen(DATENELEMENT datenObjekt)
    {
        daten = datenObjekt;
    }

    DATENELEMENT DatenGeben()
    {
        return daten;
    }

    // weitere Methoden
    DATENELEMENT EndeGeben()
    {
        DATENELEMENT wert;
        wert = nachfolger.EndeGeben();
        if (wert == null)
            return daten;
        else
            return wert;
    }

    LISTENELEMENT EndeEinfuegen(DATENELEMENT datenObjekt)
    {
        nachfolger = nachfolger.EndeEinfuegen(datenObjekt);
        return this;
    }

    LISTENELEMENT SortiertEinfuegen(DATENELEMENT datenObjekt)
    {
        // meine Daten sind kleiner
        if (daten.Vergleichen(datenObjekt) < 0)
        {
            nachfolger = nachfolger.SortiertEinfuegen(datenObjekt);
            return this;
        }
        // meine Daten sind größer oder gleich
        else
            return new KNOTEN(this, datenObjekt);
    }

    boolean Suchen(DATENELEMENT datenObjekt)
    {
        if (daten.Vergleichen(datenObjekt) == 0)
            return true;
        else
            return nachfolger.Suchen(datenObjekt);
    }

    LISTENELEMENT Entfernen(DATENELEMENT datenObjekt)
    {
        if (daten.Vergleichen(datenObjekt) == 0)
            return nachfolger;
        else
        {
            nachfolger = nachfolger.Entfernen(datenObjekt);
            return this;
        }
    }

    int AnzahlAbHierGeben()
    {
        return nachfolger.AnzahlAbHierGeben() + 1;
    }

    void AlleAusgeben()
    {
        daten.Ausgeben();
        nachfolger.AlleAusgeben();
    }

    // Erweiterung der Klasse um notwendige Suchmethoden
    DATENELEMENT DatenAbHierSuchen(DATENELEMENT vergleichsdaten)
    {
        if (daten.Vergleichen(vergleichsdaten) == 0)
        {
            return daten;
        }
        else
        {
            return nachfolger.DatenAbHierSuchen(vergleichsdaten);
        }
    }
}
