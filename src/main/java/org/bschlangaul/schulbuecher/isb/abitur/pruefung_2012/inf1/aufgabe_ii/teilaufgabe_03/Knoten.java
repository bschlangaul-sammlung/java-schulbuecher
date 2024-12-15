package org.bschlangaul.schulbuecher.isb.abitur.pruefung_2012.inf1.aufgabe_ii.teilaufgabe_03;

public class Knoten extends BaumElement
{
    BaumElement linkerNachfolger;

    BaumElement rechterNachfolger;

    Kunde daten;

    Kunde kundeSuchen(int kdnr)
    {

        if (daten.kundennummerGeben() == kdnr)
        {
            return daten;
        }

        if (daten.kundennummerGeben() > kdnr)
        {
            return linkerNachfolger.kundeSuchen(kdnr);
        }
        else
        {
            return rechterNachfolger.kundeSuchen(kdnr);

        }
    }

}
