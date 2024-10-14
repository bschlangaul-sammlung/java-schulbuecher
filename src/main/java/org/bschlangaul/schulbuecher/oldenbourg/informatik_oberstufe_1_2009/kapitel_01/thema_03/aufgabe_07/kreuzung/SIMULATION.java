package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_07.kreuzung;

import org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.shared.*;

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
        TaktGeber t;
        KREUZUNG k;
        ADAPTER a;
        k = new KREUZUNG();
        t = new TaktGeber(k);
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
