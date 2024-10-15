package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.rangierbahnhof.handreichung;

class WAGGON extends DATENELEMENT
{
    private int waggonnummer;

    private char waggontyp;

    private int zielgleis;

    WAGGON(int waggonnummer, char waggontyp, int zielgleis)
    {
        this.waggonnummer = waggonnummer;
        this.waggontyp = waggontyp;
        this.zielgleis = zielgleis;
    }

    // Vergleich des Schlüssels waggonnummer
    boolean Vergleichen(DATENELEMENT vergleichsObjekt)
    {
        WAGGON vergleichswaggon = (WAGGON) vergleichsObjekt;
        return (vergleichswaggon.waggonnummer == waggonnummer);
    }

    // Eigenschaft = bestimmter Typ..na ja...
    boolean EigenschaftVergleichen(DATENELEMENT vergleichsObjekt)
    {
        WAGGON vergleichswaggon = (WAGGON) vergleichsObjekt;
        return (vergleichswaggon.waggontyp == waggontyp);
    }

    void Ausgeben()
    {
        System.out.print(waggonnummer + " (Zielgl." + zielgleis + ", Typ: "
                + waggontyp + ")  ");
    }

    int ZielgleisGeben()
    {
        return zielgleis;
    }
}
