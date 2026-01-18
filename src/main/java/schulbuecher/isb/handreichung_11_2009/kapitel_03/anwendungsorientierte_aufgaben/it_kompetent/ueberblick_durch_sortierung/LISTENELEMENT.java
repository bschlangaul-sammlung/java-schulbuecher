package schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.it_kompetent.ueberblick_durch_sortierung;

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

    // Erweiterung der Klasse um notwendige Suchmethoden
    abstract DATENELEMENT DatenAbHierSuchen(DATENELEMENT vergleichsdaten);
}
