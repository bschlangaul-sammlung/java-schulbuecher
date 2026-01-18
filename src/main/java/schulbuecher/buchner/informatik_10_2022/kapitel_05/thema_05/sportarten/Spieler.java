package schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_05.sportarten;

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

    private String[] sportarten;

    public Spieler(String name)
    {
        this.name = name;
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

    // Kapitel 5-5, Aufgabe 2a
    public void ersetzeSportartTennisErstesElement()
    {
        if (sportarten[0].equals("Tennis"))
        {
            sportarten[0] = "Squash";
        }
    }

    // Kapitel 5-5, Aufgabe 2b
    public void ersetzeSportartTennis()
    {
        int i = 0;
        while (i < sportarten.length)
        {
            if (sportarten[i].equals("Tennis"))
            {
                sportarten[i] = "Squash";
            }
            i = i + 1;
        }
    }

    // Kapitel 5-5, Aufgabe 2c
    public boolean spieltSportart(String sportart)
    {
        boolean spieltSportart = false;
        int i = 0;
        while (i < sportarten.length)
        {
            if (sportarten[i].equals(sportart))
            {
                spieltSportart = true;
            }
            i = i + 1;
        }
        return spieltSportart;
    }
}
