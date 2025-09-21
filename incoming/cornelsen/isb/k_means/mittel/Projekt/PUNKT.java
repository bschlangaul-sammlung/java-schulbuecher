package org.bschlangaul.schulbuecher.isb.k_means.mittel.Projekt;

public class PUNKT
{

    private double x;

    private double y;

    private String beschreibung;

    public PUNKT(String beschreibungNeu, double xNeu, double yNeu)
    {
        beschreibung = beschreibungNeu;
        x = xNeu;
        y = yNeu;
    }

    public String gibBeschriftung()
    {
        return beschreibung;
    }

    public double gibX()
    {
        return x;
    }

    public double gibY()
    {
        return y;
    }

    public void setzeBeschreibung(String beschreibungNeu)
    {
        beschreibung = beschreibungNeu;
    }

    public void setzeX(double xNeu)
    {
        x = xNeu;
    }

    public void setzeY(double yNeu)
    {
        y = yNeu;
    }

    public int gibIndexNaechstgelegenerPunkt(PUNKT[] punkte)
    {

    }

    public double berechneAbstand(PUNKT punkt)
    {

    }

}
