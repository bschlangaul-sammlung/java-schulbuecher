package org.bschlangaul.schulbuecher.isb.k_means.loesung.Projekt;

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
        double kleinsteDistanz = Double.MAX_VALUE;
        int naechster = 0;
        for (int i = 0; i < punkte.length; i++)
        {
            PUNKT p = punkte[i];
            double distanz = berechneAbstand(p);
            if (distanz < kleinsteDistanz)
            {
                kleinsteDistanz = distanz;
                naechster = i;
            }
        }
        return naechster;
    }

    public double berechneAbstand(PUNKT punkt)
    {
        double summe = 0;
        if (punkt != null)
        {
            double deltaX = punkt.gibX() - x;
            double deltaY = punkt.gibY() - y;
            summe = deltaX * deltaX + deltaY * deltaY;
        }
        return Math.sqrt(summe);
    }

}
