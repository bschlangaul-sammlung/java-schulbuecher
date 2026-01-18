package schulbuecher.isb.abitur.pruefung_2021.inf1.aufgabe_i.teilaufgabe_02;

/**
 * Heißt in der Musterlösung {@code LISTENELEMENT}
 */
public abstract class ListenElement
{
    abstract ListenElement sortiertEinfuegen(Veranstaltung v);

    abstract int anzahlGeben(int tag, int zeitfenster);
}
