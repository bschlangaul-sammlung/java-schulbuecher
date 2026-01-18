package schulbuecher.isb.handreichung_10_2008.konzept_01.mastermind;

import schulbuecher.isb.handreichung_10_2008.konzept_01.ZeichenFenster;

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
        hoehe = 80;
    }

    public Kasten(int linksStart, int obenStart, int breiteStart,
            int hoeheStart)
    {
        links = linksStart;
        oben = obenStart;
        breite = breiteStart;
        hoehe = hoeheStart;
    }

    public void zeichne()
    {
        ZeichenFenster.gibFenster().zeichneRechteck(links, oben, breite, hoehe);
    }

    public void setzeLinks(int linksNeu)
    {
        links = linksNeu;
    }

    public void setzeGroesse(int breiteNeu, int hoeheNeu)
    {
        breite = breiteNeu;
        hoehe = hoeheNeu;
    }

    public int gibUmfang()
    {
        return (breite + hoehe) * 2;
    }

    public void verschiebe(int nachRechts, int nachUnten)
    {
        links = links + nachRechts;
        oben = oben + nachUnten;
    }
}
