package schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.it_kompetent.grundaufgabe_ohne_kompositum;

class KNOTEN
{
    private KNOTEN nachfolger;

    private DATENELEMENT daten;

    // Konstruktoren
    KNOTEN()
    {
        nachfolger = null;
        daten = null;
    }

    KNOTEN(KNOTEN naechsterKnoten, DATENELEMENT datenObjekt)
    {
        nachfolger = naechsterKnoten;
        daten = datenObjekt;
    }

    // Getter- und Setter-Methoden
    void NachfolgerSetzen(KNOTEN neuerNachfolger)
    {
        nachfolger = neuerNachfolger;
    }

    KNOTEN NachfolgerGeben()
    {
        return nachfolger;
    }

    void DatenSetzen(DATENELEMENT datenObjekt)
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
        if (nachfolger == null)
            return daten;
        else
            return nachfolger.EndeGeben();
    }

    void EndeEinfuegen(DATENELEMENT datenObjekt)
    {
        if (nachfolger == null)
            nachfolger = new KNOTEN(null, datenObjekt);
        else
            nachfolger.EndeEinfuegen(datenObjekt);
    }

    int AnzahlGeben()
    {
        if (nachfolger == null)
            return 1;
        else
            return nachfolger.AnzahlGeben() + 1;
    }

    void AlleAusgeben()
    {
        daten.Ausgeben();
        if (nachfolger != null)
            nachfolger.AlleAusgeben();
    }
}
