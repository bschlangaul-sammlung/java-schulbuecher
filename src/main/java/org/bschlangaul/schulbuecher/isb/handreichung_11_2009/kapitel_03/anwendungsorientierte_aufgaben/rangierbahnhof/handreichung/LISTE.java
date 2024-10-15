package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.rangierbahnhof.handreichung;

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
        entfernt = anfang.DatenGeben();
        anfang = anfang.NachfolgerGeben();
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

    boolean Suchen(DATENELEMENT datenObjekt)
    {
        return anfang.Suchen(datenObjekt);
    }

    boolean Anzahl(DATENELEMENT datenObjekt)
    {
        return anfang.Suchen(datenObjekt);
    }

    // Aufgabe 1ciii
    // Zusatzmethode: Anzahl der Elemente mit bestimmter Eigenschaft
    int AnzahlMitEigenschaftGeben(DATENELEMENT datenObjekt)
    {
        return anfang.AnzahlMitEigenschaftAbHierGeben(datenObjekt);
    }
}
