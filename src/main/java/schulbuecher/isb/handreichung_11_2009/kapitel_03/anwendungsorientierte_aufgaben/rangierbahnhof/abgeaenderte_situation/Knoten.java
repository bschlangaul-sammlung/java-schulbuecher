package schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.rangierbahnhof.abgeaenderte_situation;

class Knoten extends ListenElement
{
    private ListenElement nachfolger;

    private DatenElement daten;

    // Konstruktoren
    Knoten()
    {
        super();
        nachfolger = null;
        daten = null;
    }

    Knoten(ListenElement naechsterKnoten, DatenElement datenObjekt)
    {
        super();
        nachfolger = naechsterKnoten;
        daten = datenObjekt;
    }

    // Getter- und Setter-Methoden
    void NachfolgerSetzen(ListenElement neuerNachfolger)
    {
        nachfolger = neuerNachfolger;
    }

    ListenElement NachfolgerGeben()
    {
        return nachfolger;
    }

    void Datensetzen(DatenElement datenObjekt)
    {
        daten = datenObjekt;
    }

    DatenElement DatenGeben()
    {
        return daten;
    }

    // weitere Methoden
    DatenElement EndeGeben()
    {
        DatenElement wert;
        wert = nachfolger.EndeGeben();
        if (wert == null)
            return daten;
        else
            return wert;
    }
    /*
     * LISTENELEMENT EndeEinfuegen(DATENELEMENT datenObjekt) { nachfolger =
     * nachfolger.EndeEinfuegen(datenObjekt); return this; }
     */
    /*
     * boolean Suchen(DATENELEMENT datenObjekt) { if
     * (daten.Vergleichen(datenObjekt)) return true; else return
     * nachfolger.Suchen(datenObjekt); }
     */
    /*
     * LISTENELEMENT Entfernen(DATENELEMENT datenObjekt) { if
     * (daten.Vergleichen(datenObjekt)) return nachfolger; else { nachfolger =
     * nachfolger.Entfernen(datenObjekt); return this; } }
     */

    int AnzahlGeben()
    {
        return nachfolger.AnzahlGeben() + 1;
    }

    void AlleAbHierAusgeben()
    {
        daten.Ausgeben();
        nachfolger.AlleAbHierAusgeben();
    }
}
