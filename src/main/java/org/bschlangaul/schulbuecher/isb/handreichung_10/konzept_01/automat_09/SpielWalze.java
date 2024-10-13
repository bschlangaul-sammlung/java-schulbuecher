package org.bschlangaul.schulbuecher.isb.handreichung_10.konzept_01.automat_09;

public class SpielWalze
{
    private Vollkreis lampe;

    private Kasten rahmen;

    private int farbnummer;

    public SpielWalze(int linksStart, int obenStart, int breite,
            int farbnrStart)
    {
        lampe = new Vollkreis(linksStart + breite / 2, obenStart + breite / 2,
                breite / 3, farbnrStart);
        rahmen = new Kasten(linksStart, obenStart, breite, breite);
        farbnummer = farbnrStart;
    }

    public void zeichne()
    {
        lampe.zeichne();
        rahmen.zeichne();
    }

    public void faerbeUm(int neueFarbe)
    {
        farbnummer = neueFarbe;
        lampe.setzeFarbe(farbnummer);
        zeichne();
    }
}
