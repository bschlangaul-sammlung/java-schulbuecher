package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_03.anwendungsorientierte_aufgaben.it_kompetent.jetzt_effektiver_speichern;

class LISTE
{
    private LISTENELEMENT anfang;

    // Konstruktor
    LISTE()
    {
        anfang = new ABSCHLUSS_LISTE();
    }

    // weitere Methoden
    void EndeEinfuegen(DATENELEMENT neueDaten)
    {
        anfang = anfang.EndeEinfuegen(neueDaten);
    }

    void AnfangEinfuegen(DATENELEMENT neueDaten)
    {
        KNOTEN_LISTE n = new KNOTEN_LISTE(anfang, neueDaten);
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
