package schulbuecher.isb.abitur.muster_2011.inf1.aufgabe_i.teilaufgabe_02.konto;

import java.util.Date;

@SuppressWarnings("unused")

public class Transaktion
{
    // Attribute
    private double betrag;

    private Date datum;

    // Konstruktor
    public Transaktion(double betr)
    {
        betrag = betr;
        datum = new Date();
    }

    // Methoden

}
