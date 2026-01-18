package schulbuecher.isb.abitur.muster_2011.inf1.aufgabe_i.teilaufgabe_09;

public class Knoten extends Komponente
{

    // Referenzattribute
    private Komponente linkerTeilbaum, rechterTeilbaum;

    private Konto daten;

    // Konstruktor
    Knoten(Komponente links, Komponente rechts, Konto konto)
    {
        super();
        linkerTeilbaum = links;
        rechterTeilbaum = rechts;
        daten = konto;
    }

    // Methoden
    // Methode KontoAbHierSuchen(int ktnr) wird nur in Aufgabe 7 (Liste)
    // notwendig!

    void kontolisteAbHierAusgeben()
    {
        linkerTeilbaum.kontolisteAbHierAusgeben();
        daten.datenAusgeben();
        rechterTeilbaum.kontolisteAbHierAusgeben();
    }

}
