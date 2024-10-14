package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_06.lieblingssportart_vorlage;

/**
 * Projekt 5-6_Lieblingssportart
 *
 * @author Julia Kronawitter
 *
 * @version 2022-09-12
 */
@SuppressWarnings("unused")
public class Spieler
{
    private String name;

    private int trikotnummer;

    private String[] sportarten;

    private String[] lieblingssport;

    public Spieler(String name, int trikotnummer)
    {
        this.name = name;
        this.trikotnummer = trikotnummer;
        sportarten = new String[6];
        sportarten[0] = "Tennis";
        sportarten[1] = "Schwimmen";
        sportarten[2] = "Fußball";
        sportarten[3] = "Handball";
        sportarten[4] = "Badminton";
        sportarten[5] = "Golf";
        lieblingssport = new String[3];
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

    public int bestimmePosition(String sportart)
    {
        int i = 0;
        while (i < lieblingssport.length)
        {
            if (lieblingssport[i].equals(sportart))
            {
                return i;
            }
            i = i + 1;
        }
        return -1;
    }

    public void tauschePlatz(int position1, int position2)
    {
        String hilfsvariable = lieblingssport[position1];
        lieblingssport[position1] = lieblingssport[position2];
        lieblingssport[position2] = hilfsvariable;
    }
    // Kapitel 5-6, Aufgabe A1
}
