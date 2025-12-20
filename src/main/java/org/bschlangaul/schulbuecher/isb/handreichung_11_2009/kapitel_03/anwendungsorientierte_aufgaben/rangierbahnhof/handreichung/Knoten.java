package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.rangierbahnhof.handreichung;

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
        nachfolger = nachfolger.EndeEinfuegen(datenObjekt);
        return this;
    }

    boolean Suchen(DatenElement datenObjekt)
    {
        if (daten.Vergleichen(datenObjekt))
            return true;
        else
            return nachfolger.Suchen(datenObjekt);
    }

    ListenElement Entfernen(DatenElement datenObjekt)
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

    // Aufgabe 1ciii
    int AnzahlMitEigenschaftAbHierGeben(DatenElement datenObjekt)
    {
        if (daten.EigenschaftVergleichen(datenObjekt))
        {
            return nachfolger.AnzahlMitEigenschaftAbHierGeben(datenObjekt) + 1;
        }
        else
        {
            return nachfolger.AnzahlMitEigenschaftAbHierGeben(datenObjekt);
        }
    }
}
