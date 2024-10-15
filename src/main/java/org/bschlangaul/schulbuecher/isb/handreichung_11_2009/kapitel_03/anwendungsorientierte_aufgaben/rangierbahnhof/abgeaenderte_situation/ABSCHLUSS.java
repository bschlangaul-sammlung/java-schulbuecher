package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.rangierbahnhof.abgeaenderte_situation;

class ABSCHLUSS extends LISTENELEMENT
{
    // KONSTRUKTOR
    ABSCHLUSS()
    {
        super();
    }

    // Getter- und Setter-Methoden
    LISTENELEMENT NachfolgerGeben()
    {
        return this;
    }

    DATENELEMENT DatenGeben()
    {
        return null;
    }

    DATENELEMENT EndeGeben()
    {
        return null;
    }

    LISTENELEMENT EndeEinfuegen(DATENELEMENT datenObjekt)
    {
        return new KNOTEN(this, datenObjekt);
    }

    int AnzahlGeben()
    {
        return 0;
    }

    void AlleAbHierAusgeben()
    {
    }
}
