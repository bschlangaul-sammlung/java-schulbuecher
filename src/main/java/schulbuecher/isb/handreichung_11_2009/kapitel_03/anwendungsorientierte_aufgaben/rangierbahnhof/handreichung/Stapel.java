package schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.rangierbahnhof.handreichung;

class Stapel
{
    private Liste liste;

    // Konstruktor
    Stapel()
    {
        liste = new Liste();
    }

    // Methoden
    void Einfuegen(DatenElement neueDaten)
    {
        liste.AnfangEinfuegen(neueDaten);
    }

    DatenElement Entfernen()
    {
        return liste.AnfangEntfernen();
    }

    boolean IstLeer()
    {
        return liste.IstLeer();
    }

    void AlleAusgeben()
    {
        liste.AlleAusgeben();
    }

    int AnzahlGeben()
    {
        return liste.AnzahlGeben();
    }

    boolean Suchen(DatenElement daten)
    {
        return liste.Suchen(daten);
    }

    // Aufgabe 1ciii
    // Zusatzmethode: Anzahl der Elemente mit bestimmter Eigenschaft
    int AnzahlmitEigenschaftGeben(DatenElement datenObjekt)
    {
        return liste.AnzahlMitEigenschaftGeben(datenObjekt);
    }
}
