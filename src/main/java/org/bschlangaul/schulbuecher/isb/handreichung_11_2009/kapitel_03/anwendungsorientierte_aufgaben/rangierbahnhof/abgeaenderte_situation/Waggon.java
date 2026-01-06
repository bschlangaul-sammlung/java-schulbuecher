package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.rangierbahnhof.abgeaenderte_situation;

class Waggon extends DatenElement
{
    // Reihenfolgennummer
    private int nummer;

    public Waggon(int nummer)
    {
        this.nummer = nummer;
    }

    public void Ausgeben()
    {
        System.out.print(nummer + " ");
    }

    boolean SchluesselIstKleiner(DatenElement vergleichsObjekt)
    {
        Waggon vergleichswaggon = (Waggon) vergleichsObjekt;
        return (nummer < vergleichswaggon.nummer);
    }
}
