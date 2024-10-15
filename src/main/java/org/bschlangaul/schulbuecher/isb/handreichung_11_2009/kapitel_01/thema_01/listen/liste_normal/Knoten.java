package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_01.thema_01.listen.liste_normal;

class Knoten
{
    private Knoten nachfolger;

    private DatenElement daten;

    // Konstruktoren
    Knoten()
    {
        nachfolger = null;
        daten = null;
    }

    Knoten(Knoten naechsterKnoten, DatenElement datenObjekt)
    {
        nachfolger = naechsterKnoten;
        daten = datenObjekt;
    }

    // Getter- und Setter-Methoden
    void NachfolgerSetzen(Knoten neuerNachfolger)
    {
        nachfolger = neuerNachfolger;
    }

    Knoten NachfolgerGeben()
    {
        return nachfolger;
    }

    void DatenSetzen(DatenElement datenObjekt)
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
        if (nachfolger == null)
            return daten;
        else
            return nachfolger.EndeGeben();
    }

    void EndeEinfuegen(DatenElement datenObjekt)
    {
        if (nachfolger == null)
            nachfolger = new Knoten(null, datenObjekt);
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
