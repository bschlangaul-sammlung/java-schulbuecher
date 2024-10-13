package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_02.aufgabe_04.kreuzung;

/**
 * Baut die Teile der Simulation zusammen und schafft die Rahmenbedingungen.
 *
 * @author Ali Chwarizmi, Heidrun Namweiden
 *
 * @version 1.0
 */
class SIMULATION
{
    /**
     * Aufbau der Bestandteile der Simultion.
     */
    SIMULATION()
    {
        TAKTGEBER t;
        KREUZUNG k;
        ADAPTER a;
        k = new KREUZUNG();
        t = new TAKTGEBER(k);
        a = new ADAPTER(k, t);
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
