package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_01.thema_01.listen.liste_abschluss_erweiterung;

class Kunde extends DatenElement
{
    private String name;

    private String vorname;

    Kunde(String neuerName, String neuerVorname)
    {
        super();
        name = neuerName;
        vorname = neuerVorname;
    }

    int Vergleichen(DatenElement vergleichsObjekt)
    {
        Kunde vergleichsKunde = (Kunde) vergleichsObjekt;
        int ergebnis;
        ergebnis = name.compareTo(vergleichsKunde.name);
        if (ergebnis == 0)
            ergebnis = vorname.compareTo(vergleichsKunde.vorname);
        return ergebnis;
    }

    void Ausgeben()
    {
        System.out.println("Kunde: " + name + ", " + vorname);
    }
}
