package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.rangierbahnhof.abgeaenderte_situation;

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
        return (anfang.AnzahlGeben() == 0);
    }

    void AnfangEinfuegen(DATENELEMENT neueDaten)
    {
        KNOTEN n = new KNOTEN(anfang, neueDaten);
        anfang = n;
    }

    DATENELEMENT AnfangGeben()
    {
        if (!IstLeer())
            return anfang.DatenGeben();
        else
            return null;
    }

    DATENELEMENT AnfangEntfernen()
    {
        DATENELEMENT entfernt;
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
