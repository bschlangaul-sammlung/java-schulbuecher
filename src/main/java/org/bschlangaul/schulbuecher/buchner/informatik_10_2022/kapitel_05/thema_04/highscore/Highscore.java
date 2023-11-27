package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_04.highscore;

public class Highscore
{
    private String spielname;

    private int[] punktestaende;

    public Highscore(String spielname, int anzahlPunktestaende)
    {
        this.spielname = spielname;
        this.punktestaende = new int[anzahlPunktestaende];
    }

    public void nennePunktestaende()
    {
        int i = 0;
        while (i < punktestaende.length)
        {
            System.out.println(punktestaende[i]);
            i = i + 1;
        }
    }
}
