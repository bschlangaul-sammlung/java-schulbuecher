package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_03.anwendungsorientierte_aufgaben.majority_algorithmus.wahl;

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

    DATENELEMENT AnfangGeben()
    {
        return liste.AnfangGeben();
    }

    void AlleAusgeben()
    {
        liste.AlleAusgeben();
    }
}
