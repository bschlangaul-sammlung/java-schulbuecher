package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_04.aufgabe_03.teilaufgabe_b.supermarkt;

/**
 * Baut den Supermarkt zusammen und schafft die Rahmenbedingungen.
 *
 * @author Klaus Reinold und Barbara Leidorn
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
        SUPERMARKT s;
        ADAPTER a;
        s = new SUPERMARKT();
        t = new TAKTGEBER(s);
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
