package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_01.aufgabe_04.teilaufgabe_b.supermarkt;

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
        Taktgeber t;
        Supermarkt s;
        Adapter a;
        s = new Supermarkt();
        t = new Taktgeber(s);
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
