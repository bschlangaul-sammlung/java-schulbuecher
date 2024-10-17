package org.bschlangaul.schulbuecher.isb.abitur.muster_2011.inf1.aufgabe_i.teilaufgabe_02.konto;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class Konto
{
    // Atribute
    private int kontonummer;

    private double kontostand;

    private double ueberziehungsbetrag;

    private double sollzinssatz;

    private double habenzinssatz;

    // Referenzattribute
    private Kunde inhaber;

    private ArrayList<Transaktion> transaktionen;

    // Konstruktor
    Konto(int ktnr, float einzahlung, float zins, Kunde kunde)
    {
        kontonummer = ktnr;
        habenzinssatz = zins;
        sollzinssatz = 0.11;
        ueberziehungsbetrag = 500;
        inhaber = kunde;
        kontostand = einzahlung;
        transaktionen = new ArrayList<Transaktion>();
        Transaktion t1 = new Transaktion(einzahlung);
        transaktionen.add(t1);
    }

    // Methoden

}
