package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_07.kreuzung;

import schulbuecher.oldenbourg.informatik_oberstufe_1_2009.shared.*;

/**
 * Baut die Teile der Simulation zusammen und schafft die Rahmenbedingungen.
 *
 * @author Ali Chwarizmi, Heidrun Namweiden
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
        Kreuzung k;
        Adapter a;
        k = new Kreuzung();
        t = new TaktGeber(k);
        a = new Adapter(k, t);
        Oberfaeche.AdapterSetzen(a);
    }

    /**
     * Startpunkt
     */
    public static void main(String[] args)
    {
        new Simulation();
    }
}
