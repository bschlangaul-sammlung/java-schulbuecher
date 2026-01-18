package schulbuecher.isb.handreichung_11_2009.kapitel_01.thema_01.listen.liste_normal;

class Liste
{
    private Knoten anfang;

    // Konstruktor
    Liste()
    {
        anfang = null;
    }

    // weitere Methoden
    boolean IstLeer()
    {
        return (anfang == null);
    }

    void EndeEinfuegen(DatenElement neueDaten)
    {
        if (!IstLeer())
            anfang.EndeEinfuegen(neueDaten);
        else
            AnfangEinfuegen(neueDaten);
    }

    void AnfangEinfuegen(DatenElement neueDaten)
    {
        Knoten n = new Knoten(anfang, neueDaten);
        anfang = n;
    }

    DatenElement AnfangEntfernen()
    {
        DatenElement entfernt;
        if (!IstLeer())
        {
            entfernt = anfang.DatenGeben();
            anfang = anfang.NachfolgerGeben();
        }
        else
            entfernt = null;
        return entfernt;
    }

    DatenElement AnfangGeben()
    {
        if (!IstLeer())
            return anfang.DatenGeben();
        else
            return null;
    }

    void AlleAusgeben()
    {
        if (!IstLeer())
            anfang.AlleAusgeben();
    }

    int AnzahlGeben()
    {
        if (!IstLeer())
            return anfang.AnzahlGeben();
        else
            return 0;
    }
}
