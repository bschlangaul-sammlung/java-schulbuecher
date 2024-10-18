package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_07.supermarkt;

import org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.shared.TaktGeber;

/**
 * Baut den Supermarkt zusammen und schafft die Rahmenbedingungen.
 *
 * @author Klaus Reinold und Barbara Leidorn
 *
 * @version 1.0
 */
class Simulation
{
    /**
     * Aufbau der Bestandteile der Simultion.
     */
    Simulation()
    {
        TaktGeber t;
        Supermarkt s;
        Adapter a;
        s = new Supermarkt();
        t = new TaktGeber(s);
        a = new Adapter(s, t);
        Oberflaeche.AdapterSetzen(a);
    }

    /**
     * Startpunkt
     */
    public static void main(String[] args)
    {
        new Simulation();
    }
}
