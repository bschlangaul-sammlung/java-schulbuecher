package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_06.beste_mannschaften_vorlage;

/**
 * Projekt 5-6_BesteMannschaften
 *
 * @author Julia Kronawitter
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
