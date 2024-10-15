package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.it_kompetent.grundaufgabe_ohne_kompositum;

class LISTE
{
    private KNOTEN anfang;

    // Konstruktor
    LISTE()
    {
        anfang = null;
    }

    // weitere Methoden
    boolean IstLeer()
    {
        return (anfang == null);
    }

    void EndeEinfuegen(DATENELEMENT neueDaten)
    {
        if (!IstLeer())
            anfang.EndeEinfuegen(neueDaten);
        else
            AnfangEinfuegen(neueDaten);
    }

    void AnfangEinfuegen(DATENELEMENT neueDaten)
    {
        KNOTEN n = new KNOTEN(anfang, neueDaten);
        anfang = n;
    }

    DATENELEMENT AnfangEntfernen()
    {
        DATENELEMENT entfernt;
        if (!IstLeer())
        {
            entfernt = anfang.DatenGeben();
            anfang = anfang.NachfolgerGeben();
        }
        else
        {
            entfernt = null;
        }
        return entfernt;
    }

    DATENELEMENT AnfangGeben()
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
