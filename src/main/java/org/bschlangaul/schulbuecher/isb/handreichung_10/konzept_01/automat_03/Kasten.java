package org.bschlangaul.schulbuecher.isb.handreichung_10.konzept_01.automat_03;

import org.bschlangaul.schulbuecher.isb.handreichung_10.konzept_01.ZeichenFenster;

public class Kasten
{
    private int links;

    private int oben;

    private int breite;

    private int hoehe;

    public Kasten()
    {
        links = 50;
        oben = 100;
        breite = 200;
        hoehe = 40;
    }

    public void zeichne()
    {
        ZeichenFenster.gibFenster().zeichneRechteck(links, oben, breite, hoehe);
    }

    public void setzeLinks(int linksNeu)
    {
        links = linksNeu;
    }
}
