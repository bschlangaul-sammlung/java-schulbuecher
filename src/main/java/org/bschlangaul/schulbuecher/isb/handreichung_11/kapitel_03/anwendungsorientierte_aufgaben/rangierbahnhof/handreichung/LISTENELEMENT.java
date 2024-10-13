package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_03.anwendungsorientierte_aufgaben.rangierbahnhof.handreichung;

abstract class LISTENELEMENT
{
    LISTENELEMENT()
    {
    }

    abstract LISTENELEMENT NachfolgerGeben();

    abstract DATENELEMENT DatenGeben();

    abstract DATENELEMENT EndeGeben();

    abstract LISTENELEMENT EndeEinfuegen(DATENELEMENT datenObjekt);

    // abstract LISTENELEMENT SortiertEinfuegen(DATENELEMENT datenObjekt);
    abstract boolean Suchen(DATENELEMENT datenObjekt);

    abstract LISTENELEMENT Entfernen(DATENELEMENT datenObjekt);

    abstract int AnzahlGeben();

    abstract void AlleAusgeben();

    // Anzahl mit Eigenschaft geben
    abstract int AnzahlMitEigenschaftAbHierGeben(DATENELEMENT datenObjekt);
}
