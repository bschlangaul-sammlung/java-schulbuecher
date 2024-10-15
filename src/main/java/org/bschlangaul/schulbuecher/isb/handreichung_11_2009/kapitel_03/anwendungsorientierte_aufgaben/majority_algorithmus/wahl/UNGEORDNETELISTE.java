package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.majority_algorithmus.wahl;

class UNGEORDNETELISTE
{
    private LISTE liste;

    // Konstruktor
    UNGEORDNETELISTE()
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

    int AnzahlGeben()
    {
        return liste.AnzahlGeben();
    }

    int AnzahlMitEigenschaftGeben(DATENELEMENT daten)
    {
        return liste.AnzahlmitEigenschaftGeben(daten);
    }
}
