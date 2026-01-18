package schulbuecher.isb.abitur.muster_2011.inf1.aufgabe_i.teilaufgabe_09;

public class KnotenListe
{
    // Referenzattribute
    private Komponente erstesKonto;

    // Konstruktor - erzeugt Baum aus Aufgabe 9b
    KnotenListe()
    {
        // Aus Einfachheitsgruenden werden nur Jobkontos verwendet
        JobKonto ko1 = new JobKonto(5, 3440);
        JobKonto ko2 = new JobKonto(4, 123.5);
        JobKonto ko3 = new JobKonto(7, 231);
        JobKonto ko4 = new JobKonto(3, 24);
        JobKonto ko5 = new JobKonto(6, 413.02);
        JobKonto ko6 = new JobKonto(34, 2000);
        JobKonto ko7 = new JobKonto(2, 19.99);
        Knoten kn1 = new Knoten(new Abschluss(), new Abschluss(), ko7);
        Knoten kn2 = new Knoten(new Abschluss(), new Abschluss(), ko5);
        Knoten kn3 = new Knoten(new Abschluss(), new Abschluss(), ko6);
        Knoten kn4 = new Knoten(kn1, new Abschluss(), ko4);
        Knoten kn5 = new Knoten(kn2, kn3, ko3);
        Knoten kn6 = new Knoten(kn4, new Abschluss(), ko2);
        Knoten kn7 = new Knoten(kn6, kn5, ko1);
        erstesKonto = kn7;

    }

    // Methoden
    void kontolisteAufKonsoleAusgeben()
    {
        erstesKonto.kontolisteAbHierAusgeben();
    }

}
