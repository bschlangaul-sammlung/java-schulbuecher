package org.bschlangaul.schulbuecher.isb.handreichung_10_2008.konzept_02.supermarkt.supermarkt_14;

/**
 * Baut den Supermarkt zusammen und schafft die Rahmenbedingungen.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class SIMULATION
{
    /**
     * Aufbau der Bestandteile
     */
    private SIMULATION()
    {
        TaktGeber t;
        SUPERMARKT s;
        ADAPTER a;
        t = new TaktGeber();
        s = new SUPERMARKT(t);
        a = new ADAPTER(s, t);
        OBERFLAECHE.AdapterSetzen(a);
    }

    /**
     * Startpunkt
     */
    public static void main(String[] args)
    {
        new SIMULATION();
    }
}
