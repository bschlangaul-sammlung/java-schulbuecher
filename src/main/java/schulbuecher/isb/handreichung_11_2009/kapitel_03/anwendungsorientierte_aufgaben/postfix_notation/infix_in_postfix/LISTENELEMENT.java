package schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.postfix_notation.infix_in_postfix;

abstract class LISTENELEMENT
{
    LISTENELEMENT()
    {
    }

    abstract LISTENELEMENT NachfolgerGeben();

    abstract DATENELEMENT DatenGeben();

    abstract DATENELEMENT EndeGeben();

    abstract LISTENELEMENT EndeEinfuegen(DATENELEMENT datenObjekt);

    abstract LISTENELEMENT Entfernen(DATENELEMENT datenObjekt);

    abstract int AnzahlGeben();

    abstract void AlleAusgeben();
}
