package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_01.aufgabe_02.lagerarbeit;

/**
 * Lagerarbeit
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
public class Lagerarbeit
{
    /** zwei Lageristen */
    Lagerist l1, l2;

    /**
     * Konstruktor für Objekte der Klasse Lagerarbeit
     */
    public Lagerarbeit()
    {
        l1 = new Lagerist("blau", 1);
        l2 = new Lagerist("rot", 2);

        l1.start();
        l2.start();
    }
}
