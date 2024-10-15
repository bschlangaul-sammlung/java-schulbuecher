package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.majority_algorithmus.wahl;

class STIMMZETTEL extends DATENELEMENT
{
    // Reihenfolgennummer
    private String name;

    public STIMMZETTEL(String name)
    {
        this.name = name;
    }

    public void Ausgeben()
    {
        System.out.print(name + " ");
    }

    boolean Vergleichen(DATENELEMENT vergleichsObjekt)
    {
        STIMMZETTEL stimmzettel = (STIMMZETTEL) vergleichsObjekt;
        return (name == stimmzettel.name);
    }
}
