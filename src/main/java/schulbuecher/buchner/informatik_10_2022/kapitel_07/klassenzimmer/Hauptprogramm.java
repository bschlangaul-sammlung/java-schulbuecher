package schulbuecher.buchner.informatik_10_2022.kapitel_07.klassenzimmer;

/**
 * Klasse Hauptprogramm, für Kapitel 4.4 Aufgabe 1
 *
 * @author Barbara Wieczorek
 *
 * @version 2022-06-03
 */
public class Hauptprogramm
{
    public static void main()
    {
        Tisch tisch1 = new Tisch("E14");
        Schueler s1 = new Schueler("Lotta", "Ludwig");
        Schueler s2 = new Schueler("Martin", "Meier");
        tisch1.setzeSchueler1(s1);
        tisch1.setzeSchueler2(s2);
        tisch1.zeigeSchueler();
    }
}
