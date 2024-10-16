package org.bschlangaul.schulbuecher.isb.abitur.pruefung_2024.inf1.aufgabe_i.teilaufgabe_04.schwerionen_zerfall;

public class Zerfall
{
    private double zerfallszeit;

    private double energie;

    @SuppressWarnings("unused")
    private int anzahlGammaquanten;

    Zerfall(double z, double e, int aq)
    {
        zerfallszeit = z;
        energie = e;
        anzahlGammaquanten = aq;
    }

    double zerfallszeitGeben()
    {
        return zerfallszeit;
    }

    double energieGeben()
    {
        return energie;
    }
}
