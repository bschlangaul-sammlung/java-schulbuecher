package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_03.anwendungsorientierte_aufgaben.it_kompetent.verwaltung_der_kundendaten;

class LISTE
{
    private LISTENELEMENT anfang;

    // Konstruktor
    LISTE()
    {
        anfang = new ABSCHLUSS();
    }

    // weitere Methoden
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
        return anfang.AnzahlAbHierGeben();
    }

    void AlleAusgeben()
    {
        anfang.AlleAusgeben();
    }

    // Erweiterung der Klasse um notwendige Suchmethoden
    DATENELEMENT DatenSuchen(DATENELEMENT vergleichsdaten)
    {
        return anfang.DatenAbHierSuchen(vergleichsdaten);
    }
}
