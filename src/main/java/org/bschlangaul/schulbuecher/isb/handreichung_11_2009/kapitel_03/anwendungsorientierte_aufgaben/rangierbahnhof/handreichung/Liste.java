package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.rangierbahnhof.handreichung;

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
        entfernt = anfang.DatenGeben();
        anfang = anfang.NachfolgerGeben();
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

    boolean Suchen(DatenElement datenObjekt)
    {
        return anfang.Suchen(datenObjekt);
    }

    boolean Anzahl(DatenElement datenObjekt)
    {
        return anfang.Suchen(datenObjekt);
    }

    // Aufgabe 1ciii
    // Zusatzmethode: Anzahl der Elemente mit bestimmter Eigenschaft
    int AnzahlMitEigenschaftGeben(DatenElement datenObjekt)
    {
        return anfang.AnzahlMitEigenschaftAbHierGeben(datenObjekt);
    }
}
