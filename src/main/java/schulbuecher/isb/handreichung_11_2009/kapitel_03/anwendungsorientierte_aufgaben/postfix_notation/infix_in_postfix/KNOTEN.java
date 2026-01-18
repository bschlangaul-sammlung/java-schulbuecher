package schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.postfix_notation.infix_in_postfix;

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

    LISTENELEMENT Entfernen(DATENELEMENT datenObjekt)
    {
        if (daten.Vergleichen(datenObjekt))
            return nachfolger;
        else
        {
            nachfolger = nachfolger.Entfernen(datenObjekt);
            return this;
        }
    }

    int AnzahlGeben()
    {
        return nachfolger.AnzahlGeben() + 1;
    }

    void AlleAusgeben()
    {
        daten.Ausgeben();
        nachfolger.AlleAusgeben();
    }
}
