package org.bschlangaul.schulbuecher.buchner.informatik_11_2023.kapitel_03.thema_02.aufgabe1;

public class KNOTEN
{
    private String bezeichner;

    public KNOTEN(String eNeu)
    {
        // Instanzvariable initialisieren
        this.bezeichner = eNeu;
    }

    public void bezeichnerSetzen(String eNeu)
    {
        this.bezeichner = eNeu;
    }

    public String bezeichnerGeben()
    {
        return bezeichner;
    }

    public boolean bezeichnerIstGleich(String wert)
    {
        return (bezeichner.compareTo(wert) == 0);
    }
}
