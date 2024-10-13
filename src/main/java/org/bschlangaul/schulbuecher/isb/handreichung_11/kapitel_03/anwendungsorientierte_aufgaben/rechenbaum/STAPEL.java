package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_03.anwendungsorientierte_aufgaben.rechenbaum;

class STAPEL
{
    private LISTE liste;

    // Konstruktor
    STAPEL()
    {
        liste = new LISTE();
    }

    // Methoden
    void Einfuegen(BAUM baum)
    {
        liste.AnfangEinfuegen(baum);
    }

    BAUM Entfernen()
    {
        return liste.AnfangEntfernen();
    }
}
