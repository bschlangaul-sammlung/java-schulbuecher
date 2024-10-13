package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_01.thema_01.listen.liste_abschluss_erweiterung;

class Liste
{
    private ListenElement anfang;

    // Konstruktor
    Liste()
    {
        anfang = new Abschluss();
    }

    // weitere Methoden
    void EndeEinfuegen(DatenElement neueDaten)
    {
        anfang = anfang.EndeEinfuegen(neueDaten);
    }

    void AnfangEinfuegen(DatenElement neueDaten)
    {
        Knoten n = new Knoten(anfang, neueDaten);
        anfang = n;
    }

    DatenElement AnfangEntfernen()
    {
        DatenElement entfernt;
        entfernt = anfang.DatenGeben();
        anfang = anfang.NachfolgerGeben();
        return entfernt;
    }

    DatenElement AnfangGeben()
    {
        return anfang.DatenGeben();
    }

    void SortiertEinfuegen(DatenElement neueDaten)
    {
        anfang = anfang.SortiertEinfuegen(neueDaten);
    }

    boolean Suchen(DatenElement datenObjekt)
    {
        return anfang.Suchen(datenObjekt);
    }

    void Entfernen(DatenElement datenObjekt)
    {
        anfang = anfang.Entfernen(datenObjekt);
    }

    int AnzahlGeben()
    {
        return anfang.AnzahlAbHierGeben();
    }

    boolean IstLeer()
    {
        return (anfang.AnzahlAbHierGeben() == 0);
    }

    void AlleAusgeben()
    {
        anfang.AlleAusgeben();
    }
}
