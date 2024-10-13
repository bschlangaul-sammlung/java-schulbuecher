package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_03.anwendungsorientierte_aufgaben.it_kompetent.grundaufgabe_mit_kompositum;

class LISTE
{
    private LISTENELEMENT anfang;

    // Konstruktor
    LISTE()
    {
        anfang = new ABSCHLUSS();
    }

    // weitere Methoden
    boolean IstLeer()
    {
        return (anfang == null);
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

    int AnzahlGeben()
    {
        return anfang.AnzahlAbHierGeben();
    }
}
