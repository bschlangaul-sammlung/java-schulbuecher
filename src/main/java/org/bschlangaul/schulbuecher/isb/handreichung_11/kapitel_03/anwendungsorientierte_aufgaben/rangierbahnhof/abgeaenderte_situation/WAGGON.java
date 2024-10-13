package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_03.anwendungsorientierte_aufgaben.rangierbahnhof.abgeaenderte_situation;

class WAGGON extends DATENELEMENT
{
    // Reihenfolgennummer
    private int nummer;

    public WAGGON(int nummer)
    {
        this.nummer = nummer;
    }

    public void Ausgeben()
    {
        System.out.print(nummer + " ");
    }

    boolean SchluesselIstKleiner(DATENELEMENT vergleichsObjekt)
    {
        WAGGON vergleichswaggon = (WAGGON) vergleichsObjekt;
        return (nummer < vergleichswaggon.nummer);
    }
}
