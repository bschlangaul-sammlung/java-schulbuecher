package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_03.anwendungsorientierte_aufgaben.rangierbahnhof.handreichung;

class STAPEL
{
    private LISTE liste;

    // Konstruktor
    STAPEL()
    {
        liste = new LISTE();
    }

    // Methoden
    void Einfuegen(DATENELEMENT neueDaten)
    {
        liste.AnfangEinfuegen(neueDaten);
    }

    DATENELEMENT Entfernen()
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

    boolean Suchen(DATENELEMENT daten)
    {
        return liste.Suchen(daten);
    }

    // Aufgabe 1ciii
    // Zusatzmethode: Anzahl der Elemente mit bestimmter Eigenschaft
    int AnzahlmitEigenschaftGeben(DATENELEMENT datenObjekt)
    {
        return liste.AnzahlMitEigenschaftGeben(datenObjekt);
    }
}
