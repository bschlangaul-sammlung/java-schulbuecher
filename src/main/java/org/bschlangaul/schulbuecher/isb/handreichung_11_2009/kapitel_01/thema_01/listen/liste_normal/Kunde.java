package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_01.thema_01.listen.liste_normal;

class Kunde extends DatenElement
{
    private String name;

    private String vorname;

    Kunde(String neuerName, String neuerVorname)
    {
        name = neuerName;
        vorname = neuerVorname;
    }

    void Ausgeben()
    {
        System.out.println("Kunde: " + name + ", " + vorname);
    }
}
