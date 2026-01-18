package schulbuecher.isb.handreichung_10_2008.konzept_01.automat_01;

import schulbuecher.isb.handreichung_10_2008.konzept_01.ZeichenFenster;

public class Kasten
{
    private int links;

    private int oben;

    public Kasten()
    {
        links = 50;
        oben = 100;
    }

    public void zeichne()
    {
        ZeichenFenster.gibFenster().zeichneRechteck(links, oben, 200, 40);
    }

    public void setzeLinks(int linksNeu)
    {
        links = linksNeu;
    }

    public static void main(String[] args)
    {
        new Kasten().zeichne();
    }
}
