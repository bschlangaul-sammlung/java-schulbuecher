package schulbuecher.isb.abitur.pruefung_2021.inf1.aufgabe_i.teilaufgabe_02;

/**
 * Heißt in der Musterlösung {@code KNOTEN}
 */
public class Knoten extends ListenElement
{
    Veranstaltung inhalt;

    ListenElement nachfolger;

    Knoten(Veranstaltung v, ListenElement n)
    {
        inhalt = v;
        nachfolger = n;
    }

    ListenElement sortiertEinfuegen(Veranstaltung v)
    {
        if (inhalt.tagGeben() > v.tagGeben()
                || (inhalt.tagGeben() == v.tagGeben()
                        && inhalt.zeitfensterGeben() > v.zeitfensterGeben()))
        {
            return new Knoten(v, this);
        }
        else
        {
            nachfolger = nachfolger.sortiertEinfuegen(v);
            return this;
        }
    }

    int anzahlGeben(int tag, int zeitfenster)
    {
        if (tag == inhalt.tagGeben()
                && zeitfenster == inhalt.zeitfensterGeben())
        {
            return nachfolger.anzahlGeben(tag, zeitfenster) + 1;
        }
        else
        {
            return nachfolger.anzahlGeben(tag, zeitfenster);
        }
    }
}
