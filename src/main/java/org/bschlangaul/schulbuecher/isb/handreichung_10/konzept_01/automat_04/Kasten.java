package org.bschlangaul.schulbuecher.isb.handreichung_10.konzept_01.automat_04;

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

    public void setzeRechts(int rechtsNeu)
    {
        links = rechtsNeu - breite;
    }

    public void setzeGroesse(int breiteNeu, int hoeheNeu)
    {
        breite = breiteNeu;
        hoehe = hoeheNeu;
    }

    public int gibUmfang()
    {
        return 2 * (breite + hoehe);
    }

    public int gibInhalt()
    {
        return breite * hoehe;
    }

    public void verschiebe(int nachRechts, int nachUnten)
    {
        links = links + nachRechts;
        oben = oben + nachUnten;
    }
}
