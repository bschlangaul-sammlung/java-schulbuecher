package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_03.anwendungsorientierte_aufgaben.rangierbahnhof.handreichung;

abstract class DATENELEMENT
{
    // abstract int Vergleichen(DATENELEMENT vergleichsObjekt);
    abstract void Ausgeben();

    abstract boolean Vergleichen(DATENELEMENT vergleichsObjekt);

    // Aufgabe c iii
    abstract boolean EigenschaftVergleichen(DATENELEMENT vergleichsObjekt);
}
