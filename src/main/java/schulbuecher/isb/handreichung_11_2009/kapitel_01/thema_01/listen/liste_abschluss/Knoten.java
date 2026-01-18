package schulbuecher.isb.handreichung_11_2009.kapitel_01.thema_01.listen.liste_abschluss;

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

    ListenElement EndeEinfuegen(DatenElement datenObjekt)
    {
        nachfolger.EndeEinfuegen(datenObjekt);
        return this;
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
}
