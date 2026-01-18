package schulbuecher.isb.abitur.pruefung_2024.inf1.aufgabe_ii.teilaufgabe_01;

public class Warenkorb
{

    private Listenelement anfang;

    float gesamtbruttopreisGeben()
    {
        return anfang.bruttopreisAbHierGeben();
    }

    Warenkorbeintrag artikelSuchen(int nummer)
    {
        return anfang.artikelSuchen(nummer);
    }

}
