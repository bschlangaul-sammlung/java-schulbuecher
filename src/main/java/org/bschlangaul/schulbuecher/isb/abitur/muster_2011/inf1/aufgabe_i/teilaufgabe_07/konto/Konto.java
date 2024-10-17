package org.bschlangaul.schulbuecher.isb.abitur.muster_2011.inf1.aufgabe_i.teilaufgabe_07.konto;

public class Konto
{

    // Attribute
    private int kontonummer;

    private double kontostand;

    // Konstruktor
    Konto(int ktnr, double ks)
    {
        kontonummer = ktnr;
        kontostand = ks;
    }

    // Methoden
    void datenAusgeben()
    {
        System.out.println(
                "Kontonummer: " + kontonummer + ", Kontostand: " + kontostand);
    }

    boolean kontonummerPruefen(int ktnr)
    {
        return (kontonummer == ktnr);
    }

}
