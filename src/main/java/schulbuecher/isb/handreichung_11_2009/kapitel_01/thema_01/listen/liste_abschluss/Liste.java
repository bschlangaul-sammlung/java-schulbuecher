package schulbuecher.isb.handreichung_11_2009.kapitel_01.thema_01.listen.liste_abschluss;

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
        anfang.EndeEinfuegen(neueDaten);
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

    void AlleAusgeben()
    {
        anfang.AlleAusgeben();
    }

    int AnzahlGeben()
    {
        return anfang.AnzahlAbHierGeben();
    }

    boolean IstLeer()
    {
        return (anfang.AnzahlAbHierGeben() == 0);
    }
}
