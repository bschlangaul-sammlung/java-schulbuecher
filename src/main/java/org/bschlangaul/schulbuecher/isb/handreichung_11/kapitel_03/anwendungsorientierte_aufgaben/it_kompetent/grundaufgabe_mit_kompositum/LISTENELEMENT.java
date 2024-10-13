package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_03.anwendungsorientierte_aufgaben.it_kompetent.grundaufgabe_mit_kompositum;

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

    abstract int AnzahlAbHierGeben();

    abstract void AlleAusgeben();
}
