package schulbuecher.isb.abitur.pruefung_2021.inf1.aufgabe_i.teilaufgabe_02;

/**
 * Heißt in der Musterlösung {@code ABSCHLUSS}
 */
public class Abschluss extends ListenElement
{
    ListenElement sortiertEinfuegen(Veranstaltung v)
    {
        return new Knoten(v, this);
    }

    int anzahlGeben(int tag, int zeitfenster)
    {
        return 0;
    }
}
