package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.rangierbahnhof.abgeaenderte_situation;

class Liste
{
    private ListenElement anfang;

    // Konstruktor
    Liste()
    {
        anfang = new Abschluss();
    }

    // weitere Methoden
    boolean IstLeer()
    {
        return (anfang.AnzahlGeben() == 0);
    }

    void AnfangEinfuegen(DatenElement neueDaten)
    {
        Knoten n = new Knoten(anfang, neueDaten);
        anfang = n;
    }

    DatenElement AnfangGeben()
    {
        if (!IstLeer())
            return anfang.DatenGeben();
        else
            return null;
    }

    DatenElement AnfangEntfernen()
    {
        DatenElement entfernt;
        entfernt = anfang.DatenGeben();
        anfang = anfang.NachfolgerGeben();
        return entfernt;
    }

    void AlleAusgeben()
    {
        if (!IstLeer())
        {
            anfang.AlleAbHierAusgeben();
        }
    }
}
