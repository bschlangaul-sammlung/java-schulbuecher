package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.rangierbahnhof.handreichung;

abstract class DatenElement
{
    // abstract int Vergleichen(DATENELEMENT vergleichsObjekt);
    abstract void Ausgeben();

    abstract boolean Vergleichen(DatenElement vergleichsObjekt);

    // Aufgabe c iii
    abstract boolean EigenschaftVergleichen(DatenElement vergleichsObjekt);
}
