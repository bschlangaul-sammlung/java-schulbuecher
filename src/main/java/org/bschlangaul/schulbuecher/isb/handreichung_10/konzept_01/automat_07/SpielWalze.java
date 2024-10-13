package org.bschlangaul.schulbuecher.isb.handreichung_10.konzept_01.automat_07;

public class SpielWalze
{
    private VollKreis lampe;

    private Kasten rahmen;

    private int farbnummer;

    public SpielWalze(int linksStart, int obenStart, int breite,
            int farbnrStart)
    {
        lampe = new VollKreis(linksStart + breite / 2, obenStart + breite / 2,
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
    /*
     * public void vergissLampe() { lampe = null; }
     */
}
