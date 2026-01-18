package schulbuecher.isb.abitur.muster_2011.inf1.aufgabe_i.teilaufgabe_07.konto;

public class Knoten extends Komponente
{

    // Referenzattribute
    private Komponente nachfolger;

    private Konto daten;

    // Konstruktor
    Knoten(Komponente nf, Konto konto)
    {
        super();
        nachfolger = nf;
        daten = konto;
    }

    // Methoden
    Konto kontoAbHierSuchen(int ktnr)
    {
        if (daten.kontonummerPruefen(ktnr))
        {
            return daten;
        }
        else
        {
            return nachfolger.kontoAbHierSuchen(ktnr);
        }
    }

    // Methode KontolisteAbHierAusgeben wird nur in Aufgabe 9 (Baum) ben�tigt

}
