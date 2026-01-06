package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.rangierbahnhof.abgeaenderte_situation;

class Abschluss extends ListenElement
{
    // KONSTRUKTOR
    Abschluss()
    {
        super();
    }

    // Getter- und Setter-Methoden
    ListenElement NachfolgerGeben()
    {
        return this;
    }

    DatenElement DatenGeben()
    {
        return null;
    }

    DatenElement EndeGeben()
    {
        return null;
    }

    ListenElement EndeEinfuegen(DatenElement datenObjekt)
    {
        return new Knoten(this, datenObjekt);
    }

    int AnzahlGeben()
    {
        return 0;
    }

    void AlleAbHierAusgeben()
    {
    }
}
