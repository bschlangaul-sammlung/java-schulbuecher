package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_03.anwendungsorientierte_aufgaben.postfix_notation.infix_in_postfix;

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

    int AnzahlGeben()
    {
        return liste.AnzahlGeben();
    }
}