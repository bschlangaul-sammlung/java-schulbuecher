package schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_04.turnier;

/**
 * Klasse zur Darstellung eines Spielers mit Name und Trikotnummer
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
        sportarten = new String[3];
        sportarten[0] = "Handball";
        sportarten[1] = "Schwimmen";
        sportarten[2] = "Fußball";
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
}
