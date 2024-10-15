package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.majority_algorithmus.wahl;

abstract class LISTENELEMENT
{
    LISTENELEMENT()
    {
    }

    abstract LISTENELEMENT NachfolgerGeben();

    abstract DATENELEMENT DatenGeben();

    abstract DATENELEMENT EndeGeben();

    abstract LISTENELEMENT EndeEinfuegen(DATENELEMENT datenObjekt);

    abstract LISTENELEMENT SortiertEinfuegen(DATENELEMENT datenObjekt);

    abstract boolean Suchen(DATENELEMENT datenObjekt);

    abstract LISTENELEMENT Entfernen(DATENELEMENT datenObjekt);

    abstract int AnzahlGeben();

    abstract void AlleAbHierAusgeben();

    // Aufgabe 3: Anzahl der Datenelemente mit bestimmter Eigenschaft geben
    abstract int AnzahlMitEigenschaftAbHierGeben(DATENELEMENT datenObjekt);
}
