package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_01.thema_01.listen.liste_abschluss;

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

    // weitere Methoden
    DatenElement EndeGeben()
    {
        return null;
    }

    ListenElement EndeEinfuegen(DatenElement datenObjekt)
    {
        return new Knoten(this, datenObjekt);
    }

    int AnzahlAbHierGeben()
    {
        return 0;
    }

    void AlleAusgeben()
    {
    }
}
