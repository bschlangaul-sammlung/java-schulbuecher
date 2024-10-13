package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_01.thema_01.listen.liste_abschluss_erweiterung;

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

    ListenElement SortiertEinfuegen(DatenElement datenObjekt)
    {
        // meine Daten sind kleiner
        if (daten.Vergleichen(datenObjekt) < 0)
        {
            nachfolger = nachfolger.SortiertEinfuegen(datenObjekt);
            return this;
        }
        // meine Daten sind größer oder gleich
        else
            return new Knoten(this, datenObjekt);
    }

    boolean Suchen(DatenElement datenObjekt)
    {
        if (daten.Vergleichen(datenObjekt) == 0)
            return true;
        else
            return nachfolger.Suchen(datenObjekt);
    }

    ListenElement Entfernen(DatenElement datenObjekt)
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
}
