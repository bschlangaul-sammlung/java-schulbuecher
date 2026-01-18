package schulbuecher.isb.abitur.pruefung_2024.inf1.aufgabe_ii.teilaufgabe_01;

public abstract class Listenelement
{

    Listenelement nachfolger;

    abstract float bruttopreisAbHierGeben();

    abstract Warenkorbeintrag artikelSuchen(int nummer);
}
