package org.bschlangaul.schulbuecher.isb.abitur.pruefung_2024.inf1.aufgabe_ii.teilaufgabe_01;

public class Knoten extends Listenelement
{

    Warenkorbeintrag daten;

    float bruttopreisAbHierGeben()
    {
        return nachfolger.bruttopreisAbHierGeben()
                + daten.artikelGeben().bruttopreisGeben() * daten.anzahlGeben();
    }

    Warenkorbeintrag artikelSuchen(int nummer)
    {
        if (daten.artikelGeben().artikelnummerGeben() == nummer)
        {
            return daten;
        }
        else
        {
            return nachfolger.artikelSuchen(nummer);
        }
    }

}
