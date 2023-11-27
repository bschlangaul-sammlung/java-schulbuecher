package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_01.thema_01.listen.liste_normal;

class Ganzzahl extends DatenElement
{
    private int zahl;

    Ganzzahl(int neueZahl)
    {
        zahl = neueZahl;
    }

    void Ausgeben()
    {
        System.out.println("Zahl: " + zahl);
    }
}
