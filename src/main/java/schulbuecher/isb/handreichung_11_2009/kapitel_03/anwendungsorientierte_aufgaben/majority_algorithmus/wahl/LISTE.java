package schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.majority_algorithmus.wahl;

class LISTE
{
    private LISTENELEMENT anfang;

    // Konstruktor
    LISTE()
    {
        anfang = new ABSCHLUSS();
    }

    // Methoden
    boolean IstLeer()
    {
        return (AnzahlGeben() == 0);
    }

    void EndeEinfuegen(DATENELEMENT neueDaten)
    {
        anfang = anfang.EndeEinfuegen(neueDaten);
    }

    void AnfangEinfuegen(DATENELEMENT neueDaten)
    {
        KNOTEN n = new KNOTEN(anfang, neueDaten);
        anfang = n;
    }

    DATENELEMENT AnfangEntfernen()
    {
        DATENELEMENT entfernt;
        entfernt = anfang.DatenGeben();
        anfang = anfang.NachfolgerGeben();
        return entfernt;
    }

    DATENELEMENT AnfangGeben()
    {
        return anfang.DatenGeben();
    }

    void SortiertEinfuegen(DATENELEMENT neueDaten)
    {
        anfang = anfang.SortiertEinfuegen(neueDaten);
    }

    boolean Suchen(DATENELEMENT datenObjekt)
    {
        return anfang.Suchen(datenObjekt);
    }

    void Entfernen(DATENELEMENT datenObjekt)
    {
        anfang = anfang.Entfernen(datenObjekt);
    }

    int AnzahlGeben()
    {
        return anfang.AnzahlGeben();
    }

    void AlleAusgeben()
    {
        anfang.AlleAbHierAusgeben();
    }

    int AnzahlmitEigenschaftGeben(DATENELEMENT datenObjekt)
    {
        return anfang.AnzahlMitEigenschaftAbHierGeben(datenObjekt);
    }
}
