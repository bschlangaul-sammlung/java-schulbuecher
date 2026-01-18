package schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.rangierbahnhof.handreichung;

abstract class ListenElement
{
    ListenElement()
    {
    }

    abstract ListenElement NachfolgerGeben();

    abstract DatenElement DatenGeben();

    abstract DatenElement EndeGeben();

    abstract ListenElement EndeEinfuegen(DatenElement datenObjekt);

    // abstract LISTENELEMENT SortiertEinfuegen(DATENELEMENT datenObjekt);
    abstract boolean Suchen(DatenElement datenObjekt);

    abstract ListenElement Entfernen(DatenElement datenObjekt);

    abstract int AnzahlGeben();

    abstract void AlleAusgeben();

    // Anzahl mit Eigenschaft geben
    abstract int AnzahlMitEigenschaftAbHierGeben(DatenElement datenObjekt);
}
