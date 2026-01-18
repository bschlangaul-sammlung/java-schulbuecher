package schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_05.sportarten_vorlage;

/**
 * Projekt 5-4_Sportarten
 *
 * @author Andre Greubel
 *
 * @version 2022-09-12
 */
public class Spieler
{
    private String name;

    private int trikotnummer;

    private String[] sportarten;

    public Spieler(String name, int trikotnummer)
    {
        this.name = name;
        this.trikotnummer = trikotnummer;
        sportarten = new String[2];
        sportarten[0] = "Tennis";
        sportarten[1] = "Schwimmen";
    }

    public void nenneSportarten()
    {
        int i = 0;
        while (i < sportarten.length)
        {
            System.out.println("Der Spieler" + this.name + " übt die Sportart "
                    + sportarten[i] + " aus.");
            i = i + 1;
        }
    }

    public void ersetzeSportartTennis()
    {
        // Kapitel 5-5, Aufgabe 2b
    }
    // Kapitel 5-5, Aufgabe 2c
    // public ...
}
