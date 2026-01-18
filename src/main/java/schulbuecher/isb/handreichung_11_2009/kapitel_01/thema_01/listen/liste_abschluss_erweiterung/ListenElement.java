package schulbuecher.isb.handreichung_11_2009.kapitel_01.thema_01.listen.liste_abschluss_erweiterung;

abstract class ListenElement
{
    ListenElement()
    {
    }

    abstract ListenElement NachfolgerGeben();

    abstract DatenElement DatenGeben();

    abstract DatenElement EndeGeben();

    abstract ListenElement EndeEinfuegen(DatenElement datenObjekt);

    abstract ListenElement SortiertEinfuegen(DatenElement datenObjekt);

    abstract boolean Suchen(DatenElement datenObjekt);

    abstract ListenElement Entfernen(DatenElement datenObjekt);

    abstract int AnzahlAbHierGeben();

    abstract void AlleAusgeben();
}
