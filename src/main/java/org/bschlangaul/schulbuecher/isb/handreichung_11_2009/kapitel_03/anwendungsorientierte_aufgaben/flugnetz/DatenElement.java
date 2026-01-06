package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.flugnetz;

public class DatenElement
{
    // Attribute
    private String flughafenname;

    private String stadt;

    private boolean zuganbindung;

    // Konstruktor
    public DatenElement(String fh, String st, boolean zug)
    {
        flughafenname = fh;
        stadt = st;
        zuganbindung = zug;
    }

    // Methoden
    public void Ausgeben()
    {
        System.out
                .println("Flughafen der Stadt " + stadt + ": " + flughafenname);
    }

    public void FlughafennameAusgeben()
    {
        System.out.println(flughafenname);
    }

    public String FlughafennameGeben()
    {
        return flughafenname;
    }

    public boolean ZuganbindungGeben()
    {
        return zuganbindung;
    }

    public boolean FlughafennameVergleichen(String name)
    {
        return (flughafenname == name);
    }
}
