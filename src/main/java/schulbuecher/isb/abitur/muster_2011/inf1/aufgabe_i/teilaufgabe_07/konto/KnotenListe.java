package schulbuecher.isb.abitur.muster_2011.inf1.aufgabe_i.teilaufgabe_07.konto;

public class KnotenListe
{
    // Referenzattribute
    private Komponente erstesKonto;

    // Konstruktor
    KnotenListe(Konto konto)
    {
        erstesKonto = new Knoten(new Abschluss(), konto);
    }

    // Testkonstruktor - erzeugt Liste aus Aufgabe 6
    KnotenListe()
    {
        JobKonto ko4 = new JobKonto(5, 340.52);
        SchuelerKonto ko1 = new SchuelerKonto(15, 123.50);
        SchuelerKonto koNeu = new SchuelerKonto(12, 10);
        Knoten k2 = new Knoten(new Abschluss(), ko1);
        erstesKonto = k2;
        Knoten knotenNeu = new Knoten(erstesKonto, koNeu);
        erstesKonto = knotenNeu;
        Knoten k1 = new Knoten(erstesKonto, ko4);
        erstesKonto = k1;
    }

    // Methoden
    Konto kontoSuchen(int ktnr)
    {
        return erstesKonto.kontoAbHierSuchen(ktnr);
    }

}
